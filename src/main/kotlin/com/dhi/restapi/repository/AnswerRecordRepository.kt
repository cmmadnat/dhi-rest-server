package com.dhi.restapi.repository

import com.dhi.restapi.model.AnswerRecordEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface AnswerRecordRepository: PagingAndSortingRepository<AnswerRecordEntity, Long>{
}