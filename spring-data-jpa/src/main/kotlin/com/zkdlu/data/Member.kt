package com.zkdlu.data

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    val name: String,
    var age: Int,
    @Enumerated(EnumType.STRING)
    var grade: MemberGrade = MemberGrade.DEFAULT,
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
            grade: MemberGrade = MemberGrade.DEFAULT,
        ): Member {
            return Member(
                name,
                age,
                grade,
                id,
            )
        }
    }
}