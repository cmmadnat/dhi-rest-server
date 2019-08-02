package com.dhi.restapi.repository

import com.dhi.restapi.model.StaffEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface StaffRepository : PagingAndSortingRepository<StaffEntity, Long> {
}