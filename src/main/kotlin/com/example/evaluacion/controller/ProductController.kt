package com.example.evaluacion.controller

import com.example.evaluacion.model.Assistan
import com.example.evaluacion.model.Conference
import com.example.evaluacion.service.AssistanService
import com.example.evaluacion.service.ConferenceService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController   //Define una responsabilidad a un componente
@RequestMapping("/assistan")   //endpoint
class assistancontroller {
    @Autowired
    lateinit var assistanService: AssistanService

    @GetMapping
    fun list ():List <Assistan>{
        return  assistanService.list()
    }
    @PostMapping
    fun save (@RequestBody @Valid assistan: Assistan): ResponseEntity<Assistan> {
        return ResponseEntity(assistanService.save(assistan), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody assistan: Assistan): ResponseEntity<Assistan> {
        return ResponseEntity(assistanService.update(assistan), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody assistan: Assistan): ResponseEntity<Assistan> {
        return ResponseEntity(assistanService.updateName(assistan), HttpStatus.OK)
    }
    //mapea unicamente el registro programado con diferente ruta http /codigorequerido....
    @GetMapping("/{ida}")
    fun listById (@PathVariable("ida") ida: Long): ResponseEntity<*> {
        return ResponseEntity(assistanService.listById (ida), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{ida}")
    fun delete (@PathVariable("ida") ida: Long):Boolean?{
        return assistanService.delete(ida)
    }

}


