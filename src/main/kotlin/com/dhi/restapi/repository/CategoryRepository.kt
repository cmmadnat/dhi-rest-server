package com.dhi.restapi.repository

import com.dhi.restapi.model.CategoryEntity
import org.springframework.data.repository.PagingAndSortingRepository

interface CategoryRepository:PagingAndSortingRepository<CategoryEntity,Long> {
}