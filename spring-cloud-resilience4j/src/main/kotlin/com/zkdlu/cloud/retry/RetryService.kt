package com.zkdlu.cloud.retry

import io.github.resilience4j.retry.annotation.Retry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class RetryService(
    private val counter: RetryCounter
) {

    @Retry(name = "myRetry")
    fun doSomething() {
        counter.tok()
    }
}

@Component
class RetryCounter(
    private val log: Logger = LoggerFactory.getLogger(RetryCounter::class.java)
) {
    var thrownIgnoredException: Boolean = false
    var thrownException: Boolean = false
    var count:Int = 0

    fun tok() {
        count++
        log.info("invoke do something")

        if (thrownIgnoredException) {
            thrownIgnoredException = false
            throw IllegalArgumentException()
        }

        if (thrownException) {
            thrownException = false
            throw IllegalStateException()
        }
    }

    fun reset() {
        count = 0
        thrownException = false
        thrownIgnoredException = false
    }
}