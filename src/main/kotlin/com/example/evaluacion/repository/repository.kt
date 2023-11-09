package com.example.evaluacion.repository

import com.example.evaluacion.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ConferenceRepository : JpaRepository<Conference, Long?> {

    fun findById(idc: Long?): Conference?


}