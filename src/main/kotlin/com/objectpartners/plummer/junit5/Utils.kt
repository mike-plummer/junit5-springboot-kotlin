package com.objectpartners.plummer.junit5

import java.util.*

fun <T> safeList(value: List<T>?): List<T> {
    if (value == null) {
        return Collections.emptyList()
    }
    return value
}
