package com.zkdlu.cloud.circuitbreaker

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CircuitBreakerServiceTest constructor(
    @Autowired val circuitBreakerService: CircuitBreakerService
) {

    @Test
    fun circuitBreaker_success() {
        val success = circuitBreakerService.success()

        assertThat(success).isEqualTo("success")
    }

    @Test
    fun circuitBreaker_fail() {
        println(circuitBreakerService.fail())
        println(circuitBreakerService.fail())

        assertThat(circuitBreakerService.fail()).isEqualTo("Fallback Fail:CircuitBreaker 'myCircuitBreaker' is OPEN and does not permit further calls")
        assertThat(circuitBreakerService.success()).isEqualTo("Fallback Success:CircuitBreaker 'myCircuitBreaker' is OPEN and does not permit further calls")
    }
}