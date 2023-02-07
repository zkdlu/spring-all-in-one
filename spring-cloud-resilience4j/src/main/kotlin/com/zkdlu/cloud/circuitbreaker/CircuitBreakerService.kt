package com.zkdlu.cloud.circuitbreaker

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service

@Service
class CircuitBreakerService {

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "successFallback")
    fun success(): String {
        return "success"
    }

    fun successFallback(err: Throwable): String {
        return "Fallback Success:" + err.message
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "failFallback")
    fun fail(): String {
        throw IllegalArgumentException("fail")
    }

    fun failFallback(err: Throwable): String {
        return "Fallback Fail:" + err.message
    }
}