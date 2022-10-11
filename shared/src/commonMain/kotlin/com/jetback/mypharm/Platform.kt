package com.jetback.mypharm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform