package br.com.emanueldias.CarParking.service

import br.com.emanueldias.CarParking.dto.VeiculoRequestDTO
import br.com.emanueldias.CarParking.dto.VeiculoResponseDTO
import br.com.emanueldias.CarParking.mapper.DonoRequestFromDonoMapper
import br.com.emanueldias.CarParking.mapper.VeiculoFromVeiculoResponseMapper
import br.com.emanueldias.CarParking.mapper.VeiculoRequestFromVeiculoMapper

import br.com.emanueldias.CarParking.repository.VeiculoRepository
import org.springframework.stereotype.Service

@Service
class VeiculoService(
    private val veiculoRepository: VeiculoRepository,
    private val requestToVeiculo : VeiculoRequestFromVeiculoMapper,
    private val requestToDono : DonoRequestFromDonoMapper,
    private val donoService: DonoService,
    private val veiculoFromVeiculoResponseMapper: VeiculoFromVeiculoResponseMapper
) {

    fun createVeiculo(veiculoRequestDTO: VeiculoRequestDTO){
        val veiculoSave = requestToVeiculo.map(veiculoRequestDTO)
        val donoSave = requestToDono.map(veiculoRequestDTO.donoRequestDTO)
        veiculoSave.dono = donoSave
        donoSave.veiculo = veiculoSave


        donoService.createDono(donoSave)
        veiculoRepository.save(veiculoSave)
    }

    fun getAllVeiculos() : List<VeiculoResponseDTO>{
        return veiculoRepository.findAll().stream().map { v -> veiculoFromVeiculoResponseMapper.map(v) }.toList()
    }

}