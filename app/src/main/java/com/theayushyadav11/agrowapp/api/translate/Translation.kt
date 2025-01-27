package com.theayushyadav11.agrowapp.api.translate

data class Translation(
    val source: String,
    val target: String,
    val text: String,
    val proxies: List<Any> = emptyList()
)