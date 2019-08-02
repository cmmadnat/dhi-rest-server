package com.dhi.restapi.model

import javax.persistence.*
import java.sql.Timestamp
import java.util.Objects

@Entity
@Table(name = "results")
class ResultsEntity {
    @get:Id
    @get:Column(name = "id")
    var id: Int = 0
    @get:Basic
    @get:Column(name = "postid")
    var postid: Int? = null
    @get:Basic
    @get:Column(name = "json", columnDefinition = "TEXT")
    var json: String? = null
    @get:Basic
    @get:Column(name = "resultDatetime")
    var resultDatetime: Timestamp? = null
    @get:Basic
    @get:Column(name = "patientid")
    var patientid: Int? = null


}
