package com.dhi.restapi.repository

import com.dhi.restapi.model.ResultsEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface ResultsRepository:PagingAndSortingRepository<ResultsEntity,Long> {
}