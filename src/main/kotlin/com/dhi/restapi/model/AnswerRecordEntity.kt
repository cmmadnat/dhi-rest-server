package com.dhi.restapi.model

import javax.persistence.*
import java.sql.Timestamp
import java.util.Objects

@Entity
@Table(name = "answer_record", schema = "dhi_db", catalog = "")
class AnswerRecordEntity {
    @get:Id
    @get:Column(name = "ansID")
    var ansId: Long = 0
    @get:Basic
    @get:Column(name = "resultID")
    var resultId: Int? = null
    @get:Basic
    @get:Column(name = "question")
    var question: String? = null
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
    @get:Basic
    @get:Column(name = "answer")
    var answer: String? = null
    @get:Basic
    @get:Column(name = "answerCode")
    var answerCode: String? = null
    @get:Basic
    @get:Column(name = "answerCodeDescription")
    var answerCodeDescription: String? = null
    @get:Basic
    @get:Column(name = "answerCodeDesignator")
    var answerCodeDesignator: String? = null
    @get:Basic
    @get:Column(name = "answerCodeVersion")
    var answerCodeVersion: String? = null
    @get:Basic
    @get:Column(name = "surveyeeName")
    var surveyeeName: String? = null
    @get:Basic
    @get:Column(name = "ansDatetime")
    var ansDatetime: Timestamp? = null


}
