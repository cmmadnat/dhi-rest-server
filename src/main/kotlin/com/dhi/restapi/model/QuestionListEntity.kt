package com.dhi.restapi.model

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import java.sql.Timestamp
import java.util.Objects

@Entity
@Table(name = "question_list", schema = "dhi_db", catalog = "")
class QuestionListEntity {
    @get:Basic
    @get:Column(name = "quesValue")
    var quesValue: String? = null
    @get:Basic
    @get:Column(name = "quesTitle")
    var quesTitle: String? = null
    @get:Basic
    @get:Column(name = "quesType")
    var quesType: String? = null
    @get:Basic
    @get:Column(name = "textType")
    var textType: String? = null
    @get:Basic
    @get:Column(name = "surveyID")
    var surveyId: Int? = null
    @get:Basic
    @get:Column(name = "quesDatetime")
    var quesDatetime: Timestamp? = null
    @get:Basic
    @get:Column(name = "questionCode")
    var questionCode: String? = null
    @get:Basic
    @get:Column(name = "questionCodeDescription")
    var questionCodeDescription: String? = null
    @get:Basic
    @get:Column(name = "questionCodeDesignator")
    var questionCodeDesignator: String? = null
    @get:Basic
    @get:Column(name = "questionCodeVersion")
    var questionCodeVersion: String? = null

}
