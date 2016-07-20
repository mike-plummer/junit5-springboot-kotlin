package com.objectpartners.plummer.states.junit4

import com.objectpartners.plummer.states.ApplicationTest
import com.objectpartners.plummer.states.StatesService
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.*

@RunWith(SpringJUnit4ClassRunner::class)
class StatesServiceTest : ApplicationTest() {

    @Autowired lateinit var dataBean: StatesService

    @Test
    fun testAutowiring() {
        assertNotNull(dataBean)
    }

    @Test
    fun retrievingAllStates() {
        val values: List<String> = dataBean.getAllStates()

        assertEquals(values.size, 50)

        val sortedValues = ArrayList(values)
        sortedValues.sort()
        assertEquals(values, sortedValues)
    }

    @Test
    fun retrievingByMatchingCharacter() {
        val matches = dataBean.getStatesStartingWith('A')

        assertEquals(matches.size, 4)

        val sortedMatches = ArrayList(matches)
        sortedMatches.sort()
        assertEquals(sortedMatches, matches)
    }

    @Test
    fun retrievingByNonMatchingCharacter() {
        val matches: List<String> = dataBean.getStatesStartingWith('!')
        assertTrue(matches.isEmpty())
    }

    @Test(expected = IllegalArgumentException::class)
    fun retrievingInvalidValue() {
        dataBean.getStatesStartingWith(null)
    }
}
