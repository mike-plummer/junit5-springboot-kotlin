package com.objectpartners.plummer.junit5

interface StatesService {
    /**
     * Return list of all 50 US states
     */
    fun getAllStates(): List<String>

    /**
     * Return a list of all US states that start with the specified character (case sensitive)
     */
    fun getStatesStartingWith(c: Char?) : List<String>
}
