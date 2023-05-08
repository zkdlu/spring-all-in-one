package com.zkdlu.logging.hibernate

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
class HibernateLogging(
    private val sampleRepository: SampleRepository,
) : ApplicationRunner{
    override fun run(args: ApplicationArguments?) {
        requiredLog()
    }

    @Transactional(propagation = Propagation.REQUIRED)
    private fun requiredLog() {
        sampleRepository.save(SampleEntity("required"))
    }
}