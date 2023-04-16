package com.zkdlu.mq.sqs

import com.amazonaws.services.sqs.AmazonSQSAsync
import com.zkdlu.mq.event.Event
import com.zkdlu.mq.event.EventRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.listener.Acknowledgment
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronization
import org.springframework.transaction.support.TransactionSynchronizationManager

@Service
class SqsConsumer(
    val amazonSQSAsync: AmazonSQSAsync,
    val eventRepository: EventRepository,
    @Value("\${cloud.aws.sqs.queue.url}") val queueUrl: String,
) {

    fun doSomething(message: SqsMessage, ack: Acknowledgment) {
        eventRepository.save(
            Event(
                message.payload.content,
                message.payload.sequence,
                message.headers.id,
                message.headers.timestamp
            ))

        TransactionSynchronizationManager.registerSynchronization(object : TransactionSynchronization {
            override fun afterCommit() {
                ack.acknowledge()
            }
        })

    }

    @Transactional
    @SqsListener(value = ["\${cloud.aws.sqs.queue.name}"], deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    fun listen(@Payload message: SqsMessage, @Headers headers: Map<String, String>, ack: Acknowledgment) {
        doSomething(message, ack)
    }
}
