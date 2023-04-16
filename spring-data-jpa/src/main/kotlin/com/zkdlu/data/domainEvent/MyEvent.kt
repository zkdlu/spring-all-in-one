package com.zkdlu.data.domainEvent

import org.springframework.context.ApplicationEvent

class MyEvent (
    source: Any,
    val message: String
) : ApplicationEvent(source)


