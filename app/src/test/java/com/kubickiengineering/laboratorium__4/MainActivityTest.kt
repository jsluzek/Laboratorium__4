package com.kubickiengineering.laboratorium__4

import org.junit.Assert
import org.junit.Test


class Calc {

    fun addTwo(first: Int, second: Int) : Int {
        return first.plus(second)
    }
}

class MainActivityTest {

    @Test
    fun `Should pass no matter what checking that all the dependencies are hooked up`() {
        //given
        val sut = Calc()

        //when

        val result = sut.addTwo(2, 2)

        //then

        Assert.assertTrue(result == 4)
    }
}