package com.zkdlu.logging.hibernate

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
class HibernateLogging(
    private val sampleRepository: SampleRepository,
    private val log: Logger = LoggerFactory.getLogger(HibernateLogging::class.java),
) {
    @Transactional(propagation = Propagation.REQUIRED)
    fun requiredLog() {
        log.trace(" --- required --- ")
        sampleRepository.save(SampleEntity("required"))
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun requiresNewLog() {
        log.trace(" --- requires new --- ")
        sampleRepository.save(SampleEntity("requires New"))
    }
}