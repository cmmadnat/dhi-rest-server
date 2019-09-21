package com.dhi.restapi.repository

import com.dhi.restapi.model.PatientPhoto
import org.springframework.data.repository.CrudRepository

interface PatientPhotoRepository : CrudRepository<PatientPhoto, Long> {
}