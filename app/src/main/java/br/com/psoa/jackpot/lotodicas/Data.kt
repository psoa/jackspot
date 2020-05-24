package br.com.psoa.jackpot.lotodicas

data class Data(
    var cities: List<City> = listOf(),
    var draw_date: String = "",
    var draw_number: Int = 0,
    var drawing: Drawing = Drawing(),
    var has_winner: Boolean = false,
    var next_draw_date: String = "",
    var next_draw_prize: Double = 0.0,
    var prizes: List<Prize> = listOf()
)