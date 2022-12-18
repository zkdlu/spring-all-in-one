package com.zkdlu.data.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun findByName(name: String): Member?
}