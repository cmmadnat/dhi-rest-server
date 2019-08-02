package com.dhi.restapi.model

import javax.persistence.*
import java.util.Objects

@Entity
@Table(name = "category")
class CategoryEntity {
    @get:Id
    @get:Column(name = "Cateid")
    var cateid: Int = 0
    @get:Basic
    @get:Column(name = "CateName")
    var cateName: String? = null

}
