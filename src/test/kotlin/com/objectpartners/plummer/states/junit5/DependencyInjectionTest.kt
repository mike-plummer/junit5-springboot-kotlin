package com.objectpartners.plummer.states.junit5

import com.objectpartners.plummer.states.junit5.tracking.TestTracker
import com.objectpartners.plummer.states.junit5.tracking.TestTrackerResolver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestTrackerResolver::class)
class DependencyInjectionTest {

    @BeforeEach
    fun setup(tracker: TestTracker) {
        tracker.testCount++
    }

    @Test
    fun testTracker(tracker: TestTracker) {
        assertEquals(tracker.testCount, 1L)
    }
}