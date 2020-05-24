package br.com.psoa.jackpot.lotodicas

data class Prize(
    var name: String = "",
    var prize: Double = 0.0,
    var winners: Int = 0
)