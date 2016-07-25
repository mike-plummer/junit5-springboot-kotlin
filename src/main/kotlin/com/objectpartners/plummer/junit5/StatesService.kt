package com.objectpartners.plummer.junit5

interface StatesService {
    fun getAllStates(): List<String>
    fun getStatesStartingWith(c: Char?) : List<String>
}
