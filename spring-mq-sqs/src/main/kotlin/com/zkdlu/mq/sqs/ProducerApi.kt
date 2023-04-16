package com.zkdlu.mq.sqs

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProducerApi(
    val sqsProducer: SqsProducer
) {

    @GetMapping("/{message}")
    fun send(@PathVariable message: String) {
        sqsProducer.sendMessage(message)
    }
}