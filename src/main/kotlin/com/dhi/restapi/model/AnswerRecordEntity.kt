package com.dhi.restapi.model

import javax.persistence.*
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "answer_record")
class AnswerRecordEntity {
    @Id
    @Column(name = "ansID")
    var ansId: Long = 0
    @Basic
    @Column(name = "resultID")
    var resultId: Int? = null
    @Basic
    @Column(name = "question")
    var question: String? = null
    @Basic
    @Column(name = "questionCode")
    var questionCode: String? = null
    @Basic
    @Column(name = "questionCodeDescription")
    var questionCodeDescription: String? = null
    @Basic
    @Column(name = "questionCodeDesignator")
    var questionCodeDesignator: String? = null
    @Basic
    @Column(name = "questionCodeVersion")
    var questionCodeVersion: String? = null
    @Basic
    @Column(name = "answer")
    var answer: String? = null
    @Basic
    @Column(name = "answerCode")
    var answerCode: String? = null
    @Basic
    @Column(name = "answerCodeDescription")
    var answerCodeDescription: String? = null
    @Basic
    @Column(name = "answerCodeDesignator")
    var answerCodeDesignator: String? = null
    @Basic
    @Column(name = "answerCodeVersion")
    var answerCodeVersion: String? = null
    @Basic
    @Column(name = "surveyeeName")
    var surveyeeName: String? = null
    @Basic
    @Column(name = "ansDatetime")
    var ansDatetime: Date? = null


}
