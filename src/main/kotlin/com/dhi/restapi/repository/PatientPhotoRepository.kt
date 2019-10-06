package com.dhi.restapi.repository

import com.dhi.restapi.model.PatientPhoto
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface PatientPhotoRepository : PagingAndSortingRepository<PatientPhoto, Long> {
    fun findByPatientId(patientId: Long, of: Pageable): List<PatientPhoto>
}