package com.zkdlu.data.querydsl

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Member(
    val name: String,
    val age: Int,
    @Enumerated(EnumType.STRING)
    var grade: MemberGrade = MemberGrade.DEFAULT,
    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orders: MutableList<Order> = mutableListOf(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("name is not blank")
        }
    }

    companion object {
        fun fixture(
            name: String = "zkdlu",
            age: Int = 25,
            id: Long? = null,
            orders: MutableList<Order> = mutableListOf(),
            grade: MemberGrade = MemberGrade.DEFAULT,
        ): Member {
            return Member(
                name,
                age,
                grade,
                orders,
                id,
            )
        }
    }
}