package com.dhi.restapi.repository

import com.dhi.restapi.model.PatientPhoto
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository

interface PatientPhotoRepository : CrudRepository<PatientPhoto, Long> {
    fun findByPatientId(patientId: Long, of: PageRequest): Set<PatientPhoto>
}