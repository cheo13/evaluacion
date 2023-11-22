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
@RequestMapping("/client")   //endpoint
class assistancontroller {
    @Autowired
    lateinit var clientService: ClientService

    @GetMapping
    fun list(): List<Client> {
        return clientService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid client: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.save(client), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.update(client), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(clientService.updateName(client), HttpStatus.OK)
    }

    @GetMapping("/{idc}")
    fun listById(@PathVariable("idc") idc: Long): ResponseEntity<*> {
        return ResponseEntity(clientService.listById(idc), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{idc}")
    fun delete(@PathVariable("idc") idc: Long): Boolean? {
        return clientService.delete(idc)
    }
}


