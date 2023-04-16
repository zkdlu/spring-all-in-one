package com.zkdlu.mq.sqs

import org.springframework.cloud.aws.messaging.listener.Acknowledgment
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service

@Service
class SqsConsumer {
    @SqsListener(value = ["\${cloud.aws.sqs.queue.name}"], deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    fun listen(message: String, @Header("SenderId") senderId: String, ack: Acknowledgment) {
        try {
            println("$senderId : $message")
        } finally {
            ack.acknowledge()
        }
    }
}