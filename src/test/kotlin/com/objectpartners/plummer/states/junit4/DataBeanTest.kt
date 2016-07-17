package com.objectpartners.plummer.states.junit4

import com.objectpartners.plummer.states.ApplicationTest
import com.objectpartners.plummer.states.DataBean
import com.objectpartners.plummer.states.safeList
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.*

@RunWith(SpringJUnit4ClassRunner::class)
class DataBeanTest: ApplicationTest() {

    @Autowired var dataBean: DataBean? = null

    @Test
    fun retrievingAllStates() {
        val values: List<String> = safeList(dataBean?.getAllStates())

        assertEquals(values.size, 50)

        val sortedValues = ArrayList(values)
        sortedValues.sort()
        assertEquals(values, sortedValues)
    }

    @Test
    fun retrievingByMatchingCharacter() {
        val matches = safeList(dataBean?.getStatesStartingWith('A'))

        assertEquals(matches.size, 4)

        val sortedMatches = ArrayList(matches)
        sortedMatches.sort()
        assertEquals(sortedMatches, matches)
    }

    @Test
    fun retrievingByNonMatchingCharacter() {
        val matches: List<String> = safeList(dataBean?.getStatesStartingWith('!'))
        assertTrue(matches.isEmpty())
    }

    @Test(expected = IllegalArgumentException::class)
    fun retrievingInvalidValue() {
        dataBean?.getStatesStartingWith(null)
    }
}
