package br.com.emanueldias.CarParking.handler.exceptions

class VagaOcupadaException : RuntimeException {

    val lancamento = "Vaga ocupada"

    constructor(message: String?) : super(message)
}