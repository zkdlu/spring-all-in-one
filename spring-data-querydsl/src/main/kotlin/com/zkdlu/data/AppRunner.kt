package com.zkdlu.data

import com.zkdlu.data.querydsl.MemberGrade
import com.zkdlu.data.querydsl.MemberQuerydslRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AppRunner(
    private val memberQuerydslRepository: MemberQuerydslRepository
): ApplicationRunner {

    @Transactional
    override fun run(args: ApplicationArguments?) {
        val members = memberQuerydslRepository.getMemberBy(MemberGrade.DEFAULT)

        for (member in members) {
            println(member.name)
        }

        members[0].orders
            .forEach{ order -> println("${order.id} ${order.orderPrice}") }
    }
}