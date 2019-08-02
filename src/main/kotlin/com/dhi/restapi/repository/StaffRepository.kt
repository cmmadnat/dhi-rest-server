package com.dhi.restapi.repository

import com.dhi.restapi.model.StaffEntity
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface StaffRepository : PagingAndSortingRepository<StaffEntity, Long> {
    fun findByUname(username:String): Optional<StaffEntity?>
}