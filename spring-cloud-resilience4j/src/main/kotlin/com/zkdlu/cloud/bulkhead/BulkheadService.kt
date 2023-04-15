package com.zkdlu.cloud.bulkhead

import io.github.resilience4j.bulkhead.annotation.Bulkhead
import org.springframework.stereotype.Service

@Service
class BulkheadService {
    @Bulkhead(name = "bulkheadService")
    fun doSomething(): String {
        println("Boo!")
        Thread.sleep(5000L)
        return "Boo!"
    }

    fun fallbackMethod(err: Throwable): String {
        return "fallback" + err.message
    }
}