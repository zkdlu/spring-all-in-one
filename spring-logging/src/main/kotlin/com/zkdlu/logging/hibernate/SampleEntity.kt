package com.zkdlu.logging.hibernate

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class SampleEntity(
    val name: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)