package com.objectpartners.plummer.states.junit4

import com.objectpartners.plummer.states.ApplicationTest
import com.objectpartners.plummer.states.StatesService
import com.objectpartners.plummer.states.STATES
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestContextManager

@RunWith(Parameterized::class)
class TestAllValuesReturned(val state: String): ApplicationTest() {

    // Mark as 'lateinit' to keep compiler from complaining about nullability & lack of initialization
    @Autowired lateinit var dataBean: StatesService

    init {
        val testContextManager = TestContextManager(TestAllValuesReturned::class.java)
        testContextManager.prepareTestInstance(this)
    }

    companion object Parameters {
        @JvmStatic
        @Parameterized.Parameters(name = "{0}")
        fun parameters(): List<Array<Any>> = STATES.map { state -> arrayOf<Any>(state) }.toList()
    }

    @Test
    fun verifyStateReturned() {
        Assert.assertTrue(dataBean.getAllStates().contains(state))
    }
}
