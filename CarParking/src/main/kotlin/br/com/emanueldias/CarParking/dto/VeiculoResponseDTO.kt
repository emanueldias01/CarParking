package br.com.emanueldias.CarParking.dto

import br.com.emanueldias.CarParking.model.Dono
import br.com.emanueldias.CarParking.model.TipoVeiculo
import jakarta.persistence.OneToOne

data class VeiculoResponseDTO(
    val id : Long,
    val tipoVeiculo : TipoVeiculo,
    val marca : String,
    val modelo : String,
    val placa : String,
    val numeroEstacionamento : Int,
    var dono : DonoResponseDTO
)
