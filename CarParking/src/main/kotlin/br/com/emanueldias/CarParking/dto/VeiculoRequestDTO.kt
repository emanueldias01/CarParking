package br.com.emanueldias.CarParking.dto

import br.com.emanueldias.CarParking.model.TipoVeiculo

data class VeiculoRequestDTO(
    val tipoVeiculo: TipoVeiculo,
    val marca : String,
    val modelo : String,
    val placa : String,
    val numeroEstacionamento : Int,
    val donoRequestDTO : DonoRequestDTO
)
