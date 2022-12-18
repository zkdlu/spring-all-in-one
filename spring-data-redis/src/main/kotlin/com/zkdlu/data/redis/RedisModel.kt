package com.zkdlu.data.redis

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash
class RedisModel(
    val data: String,
    @Id
    val id: String? = null,
)