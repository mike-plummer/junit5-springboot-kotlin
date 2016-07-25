package com.objectpartners.plummer.junit5.version5.tracking;

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver

class TestTrackerResolver: ParameterResolver {

    companion object {
        val tracker: TestTracker = TestTracker(0)
    }

    override fun supports(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Boolean {
        return parameterContext?.parameter?.type == TestTracker::class.java
    }

    override fun resolve(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Any? {
        return tracker
    }
}
