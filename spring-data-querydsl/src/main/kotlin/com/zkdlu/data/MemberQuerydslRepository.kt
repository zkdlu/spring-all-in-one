package com.zkdlu.data

import com.querydsl.jpa.impl.JPAQueryFactory
import com.zkdlu.data.QMember.member
import org.springframework.stereotype.Repository

@Repository
class MemberQuerydslRepository(
    private val queryFactory: JPAQueryFactory
) {
    fun getMemberBy(grade: MemberGrade): List<Member> {
        return queryFactory.select(member)
            .from(member)
            .where(
                grade?.let { member.grade.eq(grade) }
            )
            .fetch()
    }
}