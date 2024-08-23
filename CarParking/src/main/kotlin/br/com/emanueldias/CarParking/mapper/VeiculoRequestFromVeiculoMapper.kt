package br.com.emanueldias.CarParking.mapper

import br.com.emanueldias.CarParking.dto.VeiculoRequestDTO
import br.com.emanueldias.CarParking.model.Veiculo

class VeiculoRequestFromVeiculoMapper : Mapper<VeiculoRequestDTO, Veiculo> {
    override fun map(t: VeiculoRequestDTO): Veiculo {
        return Veiculo(
            tipoVeiculo = t.tipoVeiculo,
            marca = t.marca,
            modelo = t.modelo,
            placa = t.placa,
            numeroEstacionamento = t.numeroEstacionamento)
    }
}