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

        Thread.sleep(3000)
    }

    @Test
    fun fifoProducerTest() {
        sqsProducer.sendFifoMessage("hello", "a", "1")
        sqsProducer.sendFifoMessage("hello", "a", "2")
        sqsProducer.sendFifoMessage("hello", "a", "3")
        sqsProducer.sendFifoMessage("hello", "a", "4")
        sqsProducer.sendFifoMessage("hello", "a", "5")
        sqsProducer.sendFifoMessage("hello", "a", "6")
        sqsProducer.sendFifoMessage("hello", "a", "7")
        sqsProducer.sendFifoMessage("hello", "a", "8")
        sqsProducer.sendFifoMessage("hello", "a", "9")
        sqsProducer.sendFifoMessage("hello", "a", "10")
        sqsProducer.sendFifoMessage("hello", "a", "11")
        sqsProducer.sendFifoMessage("hello", "a", "12")
        sqsProducer.sendFifoMessage("hello", "a", "13")
        sqsProducer.sendFifoMessage("hello", "a", "14")

        Thread.sleep(30000)
    }
}