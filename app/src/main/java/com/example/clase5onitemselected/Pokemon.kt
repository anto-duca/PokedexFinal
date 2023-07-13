package com.example.clase5onitemselected

data class Pokemon(
    val id: Int,
    val name: String,
    val life: Int,
    val attack: Int,
    val defense: Int,
    val velocity: Int,
    val type: PokemonType,
    val url: String
)

enum class PokemonType {
    PLANT, WATER, FIRE, FIGHT, ELECTRIC
}
