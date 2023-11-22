package com.example.evaluacion.repository

import com.example.evaluacion.model.Client

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ClientRepository : JpaRepository<Client, Long?> {
    fun findById(idc: Long?): Client?
    // Otros métodos de consulta o personalizados si son necesarios
}