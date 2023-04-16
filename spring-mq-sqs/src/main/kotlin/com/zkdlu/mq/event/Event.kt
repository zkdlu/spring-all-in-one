package com.zkdlu.mq.event

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Event(
    val name: String,
    val sequence: Long,
    val headerId: String,
    val timestamp: Long,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

}