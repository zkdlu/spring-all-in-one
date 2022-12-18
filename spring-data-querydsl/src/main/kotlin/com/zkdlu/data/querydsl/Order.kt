package com.zkdlu.data.querydsl

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "ORDERS")
class Order(
    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: Member,

    val orderPrice: Long,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    init {
        if (orderPrice <= 0) {
            throw IllegalArgumentException()
        }
    }
}