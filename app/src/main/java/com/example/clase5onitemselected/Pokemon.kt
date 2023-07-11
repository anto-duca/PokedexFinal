package com.example.clase5onitemselected

data class Pokemon(
    val id: Int,
    val name: String,
    val life: String,
    val attack: String,
    val defense: String,
    val type: PokemonType,
    val url: String
)

enum class PokemonType {
    PLANT, WATER, FIRE, FIGHT, ELECTRIC
}
