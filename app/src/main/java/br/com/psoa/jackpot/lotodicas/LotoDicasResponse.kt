package br.com.psoa.jackpot.lotodicas

class LotoDicasResponse {

    var lotoDicasEntity: LotoDicasEntity? = null
    var error: Throwable? = null

    constructor(lotoDicasEntity: LotoDicasEntity?) {
        this.lotoDicasEntity = lotoDicasEntity
    }

    constructor(error: Throwable) {
        this.error = error
    }


}