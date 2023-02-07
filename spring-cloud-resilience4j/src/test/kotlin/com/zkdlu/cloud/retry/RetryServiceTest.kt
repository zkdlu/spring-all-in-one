package com.zkdlu.cloud.retry

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RetryServiceTest constructor(
    @Autowired val retryService: RetryService,
    @Autowired val counter: RetryCounter,
){

    @BeforeEach
    fun setUp() {
        counter.reset()
    }

    @Test
    fun doSomething() {
        retryService.doSomething()

        assertThat(counter.count).isEqualTo(1)
    }

    @Test
    fun doSomething_retry() {
        counter.thrownException = true

        retryService.doSomething()

        assertThat(counter.count).isEqualTo(2)
    }

    @Test
    fun doSomething_ignoreException() {
        counter.thrownIgnoredException = true

        kotlin.runCatching { retryService.doSomething() }

        assertThat(counter.count).isEqualTo(1)
    }
}