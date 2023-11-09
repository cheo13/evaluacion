package com.example.evaluacion.repository

import com.example.evaluacion.model.Assistan
import com.example.evaluacion.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AssistanRepository : JpaRepository<Assistan, Long?> {

    fun findById(ida: Long?): Assistan?


}