package br.com.emanueldias.CarParking.mapper

import br.com.emanueldias.CarParking.dto.VeiculoResponseDTO
import br.com.emanueldias.CarParking.model.Veiculo
import br.com.emanueldias.CarParking.repository.DonoRepository
import org.springframework.stereotype.Component

@Component
class VeiculoFromVeiculoResponseMapper(
    private val donoFromDonoResponseDTO : donoFromDonoResponseDTO,
    private val donoRepository: DonoRepository
) : Mapper<Veiculo, VeiculoResponseDTO> {
    override fun map(t: Veiculo): VeiculoResponseDTO {
        return VeiculoResponseDTO(
            id = t.id!!,
            tipoVeiculo = t.tipoVeiculo,
            marca = t.marca,
            modelo = t.modelo,
            placa = t.placa,
            numeroEstacionamento = t.numeroEstacionamento,
            dono = donoFromDonoResponseDTO.map(t.dono!!)
        )
    }
}