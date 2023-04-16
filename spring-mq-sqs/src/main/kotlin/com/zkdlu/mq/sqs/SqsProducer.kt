package com.zkdlu.mq.sqs

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class SqsProducer(
    val queueMessagingTemplate: QueueMessagingTemplate,
    @Value("\${cloud.aws.sqs.fifo-queue.name}") val fifoName: String,
) {
    private val counter: AtomicLong = AtomicLong()

    @Value("\${cloud.aws.sqs.queue.name}")
    lateinit var queueName: String


    fun sendMessage(message: String) {
        val sqsMessage = SqsPayload(message, counter.getAndIncrement())
        val newMessage = MessageBuilder.withPayload(sqsMessage).build()
        queueMessagingTemplate.convertAndSend(queueName, newMessage)
    }

    fun sendFifoMessage(message: String, groupId: String, duplicationId: String) {
        val headers = mapOf(
            "message-group-id" to groupId,
            "message-deduplication-id" to duplicationId
        )

        val sqsMessage = SqsPayload("FIFO-$message", counter.getAndIncrement())
        val newMessage = MessageBuilder.withPayload(sqsMessage)
            .build()
        queueMessagingTemplate.convertAndSend(fifoName, newMessage, headers)
    }
}