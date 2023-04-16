package com.zkdlu.mq.sqs

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class SqsProducer(
    val queueMessagingTemplate: QueueMessagingTemplate,
) {

    @Value("\${cloud.aws.sqs.queue.name}")
    lateinit var queueName: String

    fun sendMessage(message: String) {
        val newMessage = MessageBuilder.withPayload(message).build()
        queueMessagingTemplate.convertAndSend(queueName, newMessage)
    }
}