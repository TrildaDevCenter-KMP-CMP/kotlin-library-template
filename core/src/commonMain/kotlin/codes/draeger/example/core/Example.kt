package codes.draeger.example.core

class Example {
    fun foo() = "bar".also { logger.info { "foo called $it" } }
}
