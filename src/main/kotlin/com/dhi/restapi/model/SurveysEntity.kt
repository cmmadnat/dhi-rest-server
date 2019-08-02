package com.dhi.restapi.model

import javax.persistence.*
import java.sql.Timestamp
import java.util.Objects

@Entity
@Table(name = "surveys")
class SurveysEntity {
    @get:Id
    @get:Column(name = "id")
    var id: Int = 0
    @get:Basic
    @get:Column(name = "name")
    var name: String? = null
    @get:Basic
    @get:Column(name = "json", columnDefinition = "TEXT")
    var json: String? = null
    @get:Basic
    @get:Column(name = "createdate")
    var createdate: Timestamp? = null
    @get:Basic
    @get:Column(name = "Cateid")
    var cateid: Int? = null


}
