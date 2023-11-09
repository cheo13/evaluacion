package com.example.evaluacion.controller

import com.example.evaluacion.model.Conference
import com.example.evaluacion.service.ConferenceService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController   //Define una responsabilidad a un componente
@RequestMapping("/conference")   //endpoint
class conferencecontroller {
    @Autowired
    lateinit var conferenceService: ConferenceService

    @GetMapping
    fun list ():List <Conference>{
        return conferenceService.list()
    }
    @PostMapping
    fun save (@RequestBody @Valid conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.save(conference), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.update(conference), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.updateName(conference), HttpStatus.OK)
    }
    //mapea unicamente el registro programado con diferente ruta http /codigorequerido....
    @GetMapping("/{idc}")
    fun listById (@PathVariable("idc") idc: Long): ResponseEntity<*> {
        return ResponseEntity(conferenceService.listById (idc), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{idc}")
    fun delete (@PathVariable("idc") idc: Long):Boolean?{
        return conferenceService.delete(idc)
    }

}


