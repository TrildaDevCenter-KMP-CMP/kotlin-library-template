package codes.draeger.example.core

import kotlin.test.Test

internal class PrinterTest {

    @Test
    fun testMessage() {
        logger.info { "dfd" }
    }
}
