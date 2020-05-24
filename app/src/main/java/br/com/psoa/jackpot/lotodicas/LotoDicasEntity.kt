package br.com.psoa.jackpot.lotodicas

data class LotoDicasEntity(
    var code: Int = 0,
    var `data`: Data = Data(),
    var status: String = ""
)
/*
{
  "code": 200,
  "status": "success",
  "data": {
    "draw_number": 2248,
    "draw_date": "2020-04-01 20:00:00-03",
    "drawing": {
      "draw": [
        9,
        15,
        20,
        29,
        30,
        42
      ]
    },
    "prizes": [
      {
        "name": "Sena",
        "winners": 1,
        "prize": 4906932.9
      },
      {
        "name": "Quina",
        "winners": 29,
        "prize": 38798.69
      },
      {
        "name": "Quadra",
        "winners": 1618,
        "prize": 993.43
      }
    ],
    "cities": [
      {
        "city": "Canal Eletrônico",
        "state": "XX"
      }
    ],
    "has_winner": true,
    "next_draw_date": "2020-04-04 20:00:00-03",
    "next_draw_prize": 1800000
  }
}
 */