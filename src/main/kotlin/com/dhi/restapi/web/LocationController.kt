package com.dhi.restapi.web

import com.dhi.restapi.model.PatientLocationEntity
import com.dhi.restapi.repository.PatientLocationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/location")
class LocationController {
    @Autowired
    private lateinit var patientLocationRepository: PatientLocationRepository

    @GetMapping("{patientId}")
    fun patientLocation(@PathVariable patientId: Long): PatientLocationEntity? {
        return patientLocationRepository.findByPatientId(patientId)
    }

    @PostMapping("{patientId}")
    fun patientLocationUpdate(@PathVariable patientId: Long, @RequestParam lat: Double, @RequestParam lng: Double): String {
        val findByPatientId = patientLocationRepository.findByPatientId(patientId)
        if (findByPatientId != null) patientLocationRepository.delete(findByPatientId)
        val patientLocationEntity = PatientLocationEntity()
        patientLocationEntity.lat = lat; patientLocationEntity.lng = lng; patientLocationEntity.patientId = patientId
        return "success"
    }
}
