package com.zkdlu.logging.hibernate

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
class NestedHibernateLogging(
    private val inner: HibernateLogging,
    private val sampleRepository: SampleRepository,
    private val log: Logger = LoggerFactory.getLogger(NestedHibernateLogging::class.java),
) {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun nestedRequiresNewLog() {
        log.trace(" --- nested requires new --- ")
        sampleRepository.save(SampleEntity("nested requires new"))

        inner.requiresNewLog()
    }

    @Transactional(propagation = Propagation.REQUIRED)
    fun nestedRequiredLog() {
        log.trace(" --- nested required --- ")
        sampleRepository.save(SampleEntity("nested required"))

        inner.requiredLog()
    }
}