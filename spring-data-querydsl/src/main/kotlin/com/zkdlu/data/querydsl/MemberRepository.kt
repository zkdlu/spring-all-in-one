package com.zkdlu.data.querydsl

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
    fun findByName(name: String): Member?
}