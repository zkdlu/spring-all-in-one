package com.zkdlu.mq.sqs

import com.fasterxml.jackson.annotation.JsonProperty

data class SqsMessage(
    @JsonProperty("payload") val payload: SqsPayload,
    @JsonProperty("headers") val headers: SqsHeaders,
)

data class SqsHeaders(
    @JsonProperty("id") val id: String,
    @JsonProperty("timestamp") val timestamp: Long,
)

data class SqsPayload(
    @JsonProperty("content") val content: String,
    @JsonProperty("sequence") val sequence: Long,
)
