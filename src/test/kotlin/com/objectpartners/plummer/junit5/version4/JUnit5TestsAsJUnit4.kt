package com.objectpartners.plummer.junit5.version4

import org.junit.platform.runner.JUnitPlatform
import org.junit.platform.runner.SelectPackages
import org.junit.runner.RunWith

// Not currently working but it should, probably some small syntax error
@RunWith(JUnitPlatform::class)
@SelectPackages("com.objectpartners.plummer.junit5")
class JUnit5TestsAsJUnit4 {

}