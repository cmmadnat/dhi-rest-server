package com.dhi.restapi.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PatientPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var lat: Float? = null
    var lng: Float? = null
    var patientId: Long? = null
    var path: String? = null
    var date = Date()
    var description: String = ""
}