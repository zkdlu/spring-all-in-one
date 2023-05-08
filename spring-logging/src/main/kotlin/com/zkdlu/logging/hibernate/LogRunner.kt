package com.zkdlu.logging.hibernate

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class LogRunner(
    val inner: HibernateLogging,
    val nested: NestedHibernateLogging,
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        inner.requiredLog()
        inner.requiresNewLog()

        nested.nestedRequiredLog()
        nested.nestedRequiresNewLog()
    }
}