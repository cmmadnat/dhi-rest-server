package com.dhi.restapi.repository

import com.dhi.restapi.model.SurveysEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface SurveysRepository:PagingAndSortingRepository<SurveysEntity,Long> {
}