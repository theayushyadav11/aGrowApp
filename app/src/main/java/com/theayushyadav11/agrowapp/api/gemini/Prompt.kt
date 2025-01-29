package com.theayushyadav11.agrowapp.api.gemini

data class Prompt(
    val contents: List<Map<String, Any>> = listOf(
        mapOf(
            "parts" to listOf(
                mapOf("text" to "")
            )
        )
    )
) {
    constructor(text: String) : this(
        listOf(
            mapOf(
                "parts" to listOf(
                    mapOf("text" to text)
                )
            )
        )
    )
}
