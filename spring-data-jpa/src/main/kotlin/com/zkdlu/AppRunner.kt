package com.zkdlu

import com.zkdlu.data.Member
import com.zkdlu.data.MemberRepository
import com.zkdlu.data.Order
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AppRunner(
    private val memberRepository: MemberRepository,
): ApplicationRunner {

    @Transactional
    override fun run(args: ApplicationArguments?) {
        val member = Member("zkdlu", 25)
        member.orders.addAll(listOf(
            Order(member, 1000),
            Order(member, 2000),
            Order(member, 3000),
            Order(member, 4000),
            Order(member, 5000),
        ))
        memberRepository.save(member)

        val findMember = memberRepository.findByName("zkdlu") ?: throw IllegalArgumentException()
        for (order in findMember.orders) {
            println("${findMember.name} ${order.id} ${order.orderPrice}")
        }
    }
}