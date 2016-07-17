package com.objectpartners.plummer.states.junit4

import com.objectpartners.plummer.states.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestContextManager

@RunWith(Parameterized::class)
class TestAllValuesReturned(val state: String): ApplicationTest() {

    init {
        val testContextManager = TestContextManager(TestAllValuesReturned::class.java)
        testContextManager.prepareTestInstance(this)
    }

    @Autowired var dataBean: DataBean? = null

    companion object Parameters {
        @JvmStatic
        @Parameterized.Parameters(name = "{0}")
        fun parameters(): List<Array<Any>> = DATA.map { state -> arrayOf<Any>(state) }.toList()
    }

    @Test
    fun verifyStateReturned() {
        Assert.assertTrue(safeList(dataBean?.getAllStates()).contains(state))
    }
}
