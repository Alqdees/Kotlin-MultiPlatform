package com.jetback.mypharm

class Greeting {
    private val platform: Platform = getPlatform()

    fun greeting(): String {
        return "Hello,${getPlatform().name}"
    }
}