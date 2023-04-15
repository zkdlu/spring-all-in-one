package com.zkdlu.cloud.ratelimiter

import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import org.springframework.stereotype.Service

@Service
class RateLimiterService {

    @RateLimiter(name = "foo")
    fun rateLimitAction() {
        println("Boo!")
    }

}