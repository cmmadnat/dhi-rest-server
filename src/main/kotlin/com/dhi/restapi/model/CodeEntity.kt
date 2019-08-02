package com.dhi.restapi.model

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import java.util.Objects

@Entity
@Table(name = "code", schema = "dhi_db", catalog = "")
class CodeEntity {
    @get:Basic
    @get:Column(name = "codeValue")
    var codeValue: String? = null
    @get:Basic
    @get:Column(name = "codeMeaning")
    var codeMeaning: String? = null
    @get:Basic
    @get:Column(name = "codeDescription")
    var codeDescription: String? = null
    @get:Basic
    @get:Column(name = "codingSchemeDesignator")
    var codingSchemeDesignator: String? = null
    @get:Basic
    @get:Column(name = "parentCode")
    var parentCode: String? = null
    @get:Basic
    @get:Column(name = "codeVersion")
    var codeVersion: String? = null


}
