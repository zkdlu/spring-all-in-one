package com.zkdlu.logging.hibernate

import org.springframework.data.jpa.repository.JpaRepository

interface SampleRepository: JpaRepository<SampleEntity, Long> {
}