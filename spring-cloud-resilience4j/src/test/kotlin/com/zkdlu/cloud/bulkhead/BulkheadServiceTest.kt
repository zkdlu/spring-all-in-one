package com.zkdlu.cloud.bulkhead

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@SpringBootTest
class BulkheadServiceTest(
    @Autowired val bulkheadService: BulkheadService
) {
    @Test
    fun bulkTest() {
        val newFixedThreadPool = Executors.newFixedThreadPool(5)

        (0..10).forEach { _ ->
            newFixedThreadPool.execute {
                bulkheadService.doSomething()
            }
        }
        newFixedThreadPool.shutdown()
        newFixedThreadPool.awaitTermination(10, TimeUnit.SECONDS)
    }
}
