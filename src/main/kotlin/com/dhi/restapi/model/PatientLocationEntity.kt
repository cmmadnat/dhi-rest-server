package com.dhi.restapi.model

import javax.persistence.*

@Entity
@Table(name = "patient_location", schema = "dhi_db", catalog = "")
open class PatientLocationEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @get:Basic
    @get:Column(name = "date", nullable = true)
    var date: java.sql.Timestamp? = null
    @get:Basic
    @get:Column(name = "lat", nullable = true)
    var lat: Float? = null
    @get:Basic
    @get:Column(name = "lng", nullable = true)
    var lng: Float? = null
    @get:Basic
    @get:Column(name = "patientId", nullable = true)
    var patientId: Long? = null


    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "id = $id " +
                    "date = $date " +
                    "lat = $lat " +
                    "lng = $lng " +
                    "patientId = $patientId " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as PatientLocationEntity

        if (id != other.id) return false
        if (date != other.date) return false
        if (lat != other.lat) return false
        if (lng != other.lng) return false
        if (patientId != other.patientId) return false

        return true
    }

}

