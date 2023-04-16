package com.zkdlu.data.domainEvent

import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class MyEventListener : ApplicationListener<MyEvent> {
    override fun onApplicationEvent(event: MyEvent) {
        println("Received spring custom event - ${event.message}")
    }
}