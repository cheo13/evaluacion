package com.example.evaluacion.service

import com.example.evaluacion.model.Assistan
import com.example.evaluacion.model.Conference
import com.example.evaluacion.repository.AssistanRepository
import com.example.evaluacion.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import kotlin.math.asin

@Service
class AssistanService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository
    @Autowired
    lateinit var assistanRepository: AssistanRepository

    fun list ():List<Assistan>{
        return assistanRepository.findAll()
    }
    fun save(assistan: Assistan): Assistan {
        try{
            //El objeto debe estar verificado.
            assistan.nameassistant?.takeIf{it.trim().isNotEmpty()}
                ?:throw Exception("Nombres no debe ser vacio")
            assistan.roleassistant?.takeIf{it.trim().isNotEmpty()}
                ?:throw Exception("Nombres no debe ser vacio")
            assistan.ageassistant?.let {
                if (it <= 0) {
                    throw Exception("La edad debe ser un valor entero positivo")
                }
            } ?: throw Exception("La edad no debe ser nula")




            return assistanRepository.save(assistan)

        }
        catch (ex:Exception){  //LANZA UN ERROR para ser manejado por el programador el cual debe hacerlo de una manera mas descriptiva.
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,ex.message)
        }
    }


    fun update(assistan: Assistan): Assistan {
        try {                   //llama base de datos y devuelve un solo valor de la tabla o registro programado
            assistanRepository.findById(assistan.ida)
                ?: throw Exception("ID no existe")
            //'save' sirve para actualizar y guardar el dato ingresado.
            return assistanRepository.save(assistan)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(assistan: Assistan): Assistan {
        try{        //en caso de que exista el registro se va a posicionar.
            val response = assistanRepository.findById(assistan.ida)
                ?: throw Exception("ID no existe")    // nos permite editar el registro que recuperamos de la base de datos

            response.apply {
                //campo de la tabla
                nameassistant = assistan.nameassistant
            }
            return assistanRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //Se pide un solo registro de la tabla de base de datos.
    fun listById (ida:Long?):Assistan?{
        return assistanRepository.findById(ida)
    }

    fun delete (ida: Long?):Boolean?{
        try{
            val response = assistanRepository.findById(ida)
                ?: throw Exception("ID no existe")
            assistanRepository.deleteById(ida!!)
            return true
        }
        catch (ex:Exception){

            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}

