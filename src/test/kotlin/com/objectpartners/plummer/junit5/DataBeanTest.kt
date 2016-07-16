package com.objectpartners.plummer.junit5

import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.junit.jupiter.api.Assertions.*
import java.util.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Assertions.assertTrue

@ExtendWith(SpringExtension::class)
class DataBeanTest() : ApplicationTest() {

    @Autowired var dataBean: DataBean? = null;

    @Nested
    inner class states() {
        @Nested
        inner class whenRetreivingAll() {

            var values: List<String> = Collections.emptyList();

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
                return DATA.map { state ->
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
                @Test
                fun shouldReturnMatchingValues() {
                    val matches: List<String> = safeList(dataBean?.getStatesStartingWith('A'))
                    assertEquals(matches.size, 4);
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
        }
    }
}
