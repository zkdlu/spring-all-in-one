package com.zkdlu.mq.sqs

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SqsProducerTest (
    @Autowired val sqsProducer: SqsProducer
) {

    @Test
    fun producerTest() {
        sqsProducer.sendMessage("안녕하세용")
    }
}