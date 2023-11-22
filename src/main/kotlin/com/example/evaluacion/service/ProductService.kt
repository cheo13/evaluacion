package com.example.evaluacion.service

import com.example.evaluacion.model.Assistan
import com.example.evaluacion.model.Client
import com.example.evaluacion.model.Conference
import com.example.evaluacion.repository.AssistanRepository
import com.example.evaluacion.repository.ClientRepository
import com.example.evaluacion.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional
import javax.xml.bind.ValidationException
import kotlin.math.asin

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    @Transactional
    fun list(): List<Client> {
        return clientRepository.findAll()
    }

    @Transactional
    fun save(client: Client): Client {
        validateClient(client)
        return clientRepository.save(client)
    }

    @Transactional
    fun update(client: Client): Client {
        if (client.idc == null) {
            throw ValidationException("ID no proporcionada para actualizar")
        }
        validateClient(client)
        return clientRepository.save(client)
    }

    @Transactional
    fun updateName(client: Client): Client {
        if (client.idc == null) {
            throw ValidationException("ID no proporcionada para actualizar el nombre")
        }
        val existingClient = clientRepository.findById(client.idc!!)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")

        existingClient.fulNamClient = client.fulNamClient // Actualizar solo el nombre

        return clientRepository.save(existingClient)
    }

    @Transactional
    fun listById(idc: Long): Client {
        return clientRepository.findById(idc)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")
    }

    @Transactional
    fun delete(idc: Long) {
        val existingClient = clientRepository.findById(idc)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")

        clientRepository.delete(existingClient)
    }

    private fun validateClient(client: Client) {
        // Realizar validaciones sobre el cliente aquí
        // Por ejemplo: asegurarse de que los campos obligatorios no estén vacíos
        if (client.nuiClient.isNullOrBlank() || client.fulNamClient.isNullOrBlank() || client.addressClient.isNullOrBlank()) {
            throw ValidationException("Campos obligatorios no pueden estar vacíos")
        }
    }
}

