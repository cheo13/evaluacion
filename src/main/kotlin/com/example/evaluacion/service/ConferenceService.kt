package com.example.evaluacion.service

import com.example.evaluacion.model.Conference
import com.example.evaluacion.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ConferenceService {

    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list ():List<Conference>{
        return conferenceRepository.findAll()
    }
    fun save(conference: Conference): Conference {
        try{
            //El objeto debe estar verificado.
            conference.titconference?.takeIf{it.trim().isNotEmpty()}
                ?:throw Exception("Nombres no debe ser vacio")
            conference.desconference?.takeIf{it.trim().isNotEmpty()}
                ?:throw Exception("Nombres no debe ser vacio")
            conference.citconference?.takeIf{it.trim().isNotEmpty()}
                ?:throw Exception("Nombres no debe ser vacio")
            conference.totassconference?.takeIf{it.trim().isNotEmpty()}
                ?:throw Exception("Nombres no debe ser vacio")


            return conferenceRepository.save(conference)

        }
        catch (ex:Exception){  //LANZA UN ERROR para ser manejado por el programador el cual debe hacerlo de una manera mas descriptiva.
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,ex.message)
        }
    }


    fun update(conference: Conference): Conference {
        try {                   //llama base de datos y devuelve un solo valor de la tabla o registro programado
            conferenceRepository.findById(conference.idc)
                ?: throw Exception("ID no existe")
            //'save' sirve para actualizar y guardar el dato ingresado.
            return conferenceRepository.save(conference)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(conference: Conference): Conference {
        try{        //en caso de que exista el registro se va a posicionar.
            val response = conferenceRepository.findById(conference.idc)
                ?: throw Exception("ID no existe")    // nos permite editar el registro que recuperamos de la base de datos

            response.apply {
                //campo de la tabla
                titconference = conference.titconference
            }
            return conferenceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //Se pide un solo registro de la tabla de base de datos.
    fun listById (idc:Long?):Conference?{
        return conferenceRepository.findById(idc)
    }

    fun delete (idc: Long?):Boolean?{
        try{
            val response = conferenceRepository.findById(idc)
                ?: throw Exception("ID no existe")
            conferenceRepository.deleteById(idc!!)
            return true
        }
        catch (ex:Exception){

            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}

