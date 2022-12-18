package com.zkdlu

import com.zkdlu.data.Member
import com.zkdlu.data.MemberRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppRunner(
    private val memberRepository: MemberRepository
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val savedMember = memberRepository.save(Member("zkdlu", 25))
        print(savedMember)

        val findMember = memberRepository.findByName("zkdlu")

        print(findMember!!)
    }

    fun print(member: Member) {
        println(member.id)
        println(member.name)
        println(member.age)
        println(member.grade)
    }
}