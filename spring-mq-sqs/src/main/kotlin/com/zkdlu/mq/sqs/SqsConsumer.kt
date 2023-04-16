package com.zkdlu.mq.sqs

import org.springframework.cloud.aws.messaging.listener.Acknowledgment
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class SqsConsumer {

    @SqsListener(value = ["\${cloud.aws.sqs.queue.name}"], deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    fun listen(@Payload message: SqsMessage, @Headers headers: Map<String, String>, ack: Acknowledgment) {
        try {
            println("$message")
        } finally {
            ack.acknowledge()
        }
    }
}
