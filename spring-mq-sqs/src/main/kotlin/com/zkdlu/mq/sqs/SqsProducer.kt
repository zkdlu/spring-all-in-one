package com.zkdlu.mq.sqs

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class SqsProducer(
    val queueMessagingTemplate: QueueMessagingTemplate,
) {
    private val counter: AtomicLong = AtomicLong()

    @Value("\${cloud.aws.sqs.queue.name}")
    lateinit var queueName: String


    fun sendMessage(message: String) {
        val sqsMessage = SqsPayload(message, counter.getAndIncrement())
        val newMessage = MessageBuilder.withPayload(sqsMessage).build()
        queueMessagingTemplate.convertAndSend(queueName, newMessage)
    }
}