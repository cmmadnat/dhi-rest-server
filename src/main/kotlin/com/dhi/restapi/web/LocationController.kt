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
        return patientLocationRepository.findByPatientId(patientId).firstOrNull()
    }

    @PostMapping("{patientId}")
    fun patientLocationUpdate(@PathVariable patientId: Long, @RequestParam lat: Float, @RequestParam lng: Float): String {
        val findByPatientId = patientLocationRepository.findByPatientId(patientId)
        findByPatientId.forEach { patientLocationRepository.delete(it) }
        val patientLocationEntity = PatientLocationEntity()
        patientLocationEntity.lat = lat; patientLocationEntity.lng = lng; patientLocationEntity.patientId = patientId
        patientLocationRepository.save(patientLocationEntity)
        return "success"
    }
}
