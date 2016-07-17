package com.objectpartners.plummer.states.junit4

import org.junit.platform.runner.JUnitPlatform
import org.junit.platform.runner.SelectPackages
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
@SelectPackages("com.objectpartners.plummer.states.junit5")
class JUnit5TestsAsJUnit4 {

}