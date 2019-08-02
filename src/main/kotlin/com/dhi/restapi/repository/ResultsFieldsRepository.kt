package com.dhi.restapi.repository

import com.dhi.restapi.model.ResultsFieldsEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface ResultsFieldsRepository:PagingAndSortingRepository<ResultsFieldsEntity,Long> {
}