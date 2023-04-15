package com.zkdlu.cloud.ratelimiter

import io.github.resilience4j.ratelimiter.RequestNotPermitted
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RateLimiterServiceTest(
    @Autowired val rateLimiterService: RateLimiterService
) {

    @Test
    fun try_3() {
        rateLimiterService.rateLimitAction()
        rateLimiterService.rateLimitAction()
        rateLimiterService.rateLimitAction()
    }

    @Test
    fun rateLimit_exceed_3() {
        rateLimiterService.rateLimitAction()
        rateLimiterService.rateLimitAction()
        rateLimiterService.rateLimitAction()

        Assertions.assertThatThrownBy { rateLimiterService.rateLimitAction() }
            .isInstanceOf(RequestNotPermitted::class.java)
    }

    @Test
    fun rateLimit_after_3s() {
        rateLimiterService.rateLimitAction()
        rateLimiterService.rateLimitAction()
        rateLimiterService.rateLimitAction()

        Thread.sleep(3000L)

        rateLimiterService.rateLimitAction()
    }
}