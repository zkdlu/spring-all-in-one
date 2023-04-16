package com.zkdlu.mq.sqs

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary


@Configuration
class SqsConfig {
    @Value("\${cloud.aws.credentials.access-key}")
    lateinit var accessKey: String

    @Value("\${cloud.aws.credentials.secret-key}")
    lateinit var secretKey: String

    @Value("\${cloud.aws.region.static}")
    lateinit var region: String

    @Primary
    @Bean
    fun amazonSQSAsync(): AmazonSQSAsync {
        val awsCredentials = BasicAWSCredentials(accessKey, secretKey)
        return AmazonSQSAsyncClientBuilder.standard()
            .withRegion(region)
            .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
            .build()
    }

    @Bean
    fun queueMessagingTemplate(): QueueMessagingTemplate {
        return QueueMessagingTemplate(amazonSQSAsync())
    }

    @Bean
    fun simpleMessageListenerContainerFactory(): SimpleMessageListenerContainerFactory {
        val factory = SimpleMessageListenerContainerFactory()
        factory.setAmazonSqs(amazonSQSAsync())
        factory.setMaxNumberOfMessages(5)
        factory.setWaitTimeOut(5)
        return factory
    }
}