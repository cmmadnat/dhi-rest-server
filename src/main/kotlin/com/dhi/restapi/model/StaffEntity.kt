package com.dhi.restapi.model

import javax.persistence.*
import java.sql.Date
import java.sql.Timestamp
import java.util.Arrays
import java.util.Objects

@Entity
@Table(name = "staff", schema = "dhi_db", catalog = "")
class StaffEntity {
    @get:Id
    @get:Column(name = "staffID")
    var staffId: String? = null
    @get:Basic
    @get:Column(name = "staffName")
    var staffName: String? = null
    @get:Basic
    @get:Column(name = "DOB")
    var dob: Date? = null
    @get:Basic
    @get:Column(name = "gender")
    var gender: String? = null
    @get:Basic
    @get:Column(name = "phoneNumber")
    var phoneNumber: String? = null
    @get:Basic
    @get:Column(name = "uname")
    var uname: String? = null
    @get:Basic
    @get:Column(name = "pwd")
    var pwd: String? = null
    @get:Basic
    @get:Column(name = "role")
    var role: String? = null
    @get:Basic
    @get:Column(name = "staffImage")
    var staffImage: ByteArray? = null
    @get:Basic
    @get:Column(name = "createDate")
    var createDate: Timestamp? = null


}
