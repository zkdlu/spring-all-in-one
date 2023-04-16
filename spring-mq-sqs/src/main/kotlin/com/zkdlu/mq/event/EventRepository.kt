package com.zkdlu.mq.event

import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<Event, Long> {
    fun findByHeaderId(headerId: String): Event?
}