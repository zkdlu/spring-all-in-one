package com.zkdlu.data.redis

import org.springframework.data.repository.CrudRepository

interface RedisRepository: CrudRepository<RedisModel, String> {
}