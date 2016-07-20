package com.objectpartners.plummer.states.junit5

import com.objectpartners.plummer.states.STATES
import com.objectpartners.plummer.states.DataBean
import com.objectpartners.plummer.states.safeList
import com.objectpartners.plummer.states.ApplicationTest
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.junit.jupiter.api.Assertions.*
import java.util.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertThrows
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ExtendWith(SpringExtension::class)
class DataBeanTest : ApplicationTest() {

    @Autowired var dataBean: DataBean? = null

    @Test
    fun testAutowiring() {
        assertNotNull(dataBean)
    }

    @Nested
    inner class states() {
        @Nested
        inner class whenRetrievingAll() {

            var values: List<String> = Collections.emptyList()

            @BeforeEach
            fun init() {
                values = safeList(dataBean?.getAllStates()?.toList())
            }

            @Test
            fun shouldReturnFiftyValues() {
                assertEquals(values.size, 50)
            }

            @Test
            fun shouldReturnAlphabetizedValues() {
                val sortedValues = ArrayList(values)
                sortedValues.sort()
                assertEquals(values, sortedValues)
            }

            @TestFactory
            fun shouldReturnAllValuesFromDataset(): Collection<DynamicTest> {
                return STATES.map { state ->
                    dynamicTest(state) {
                        assertTrue(values.contains(state))
                    }
                }.toList()
            }
        }

        @Nested
        inner class whenRetrievingByStartingCharacter {
            @Nested
            inner class withMatchingValue() {
                var matches: List<String> = Collections.emptyList()

                @BeforeEach
                fun init() {
                    matches = safeList(dataBean?.getStatesStartingWith('A'))
                }

                @Test
                fun shouldReturnMatchingValues() {
                    assertEquals(matches.size, 4)
                }

                @Test
                fun shouldReturnSortedValues() {
                    val sortedMatches = ArrayList(matches)
                    sortedMatches.sort()
                    assertEquals(sortedMatches, matches)
                }
            }

            @Nested
            inner class withNonMatchingValue() {
                @Test
                fun shouldReturnEmptyList() {
                    val matches: List<String> = safeList(dataBean?.getStatesStartingWith('!'))
                    assertTrue(matches.isEmpty())
                }
            }

            @Nested
            inner class withInvalidValue() {
                @Test
                fun shouldThrowError() {
                    assertThrows(IllegalArgumentException::class.java, { dataBean?.getStatesStartingWith(null) })
                }
            }
        }
    }
}
