package com.dhi.restapi.web

import com.dhi.restapi.model.ResultsEntity
import com.dhi.restapi.repository.ResultsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/result")
class ResultController {

    @Autowired
    private lateinit var resultsRepository: ResultsRepository

    @RequestMapping("upload")
    fun upload(@RequestParam json: String, @RequestParam patientId: Int, @RequestParam surveyId: Int): String {
        val result = ResultsEntity()
        result.patientid = patientId
        result.json = json
        result.resultDatetime = Timestamp(Calendar.getInstance().timeInMillis)
        result.postid = surveyId
        resultsRepository.save(result)
        return "success"
    }
}