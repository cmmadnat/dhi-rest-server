package com.dhi.restapi.repository

import com.dhi.restapi.model.PatientLocationEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface PatientLocationRepository : PagingAndSortingRepository<PatientLocationEntity, Long> {
}