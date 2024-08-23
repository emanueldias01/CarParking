package br.com.emanueldias.CarParking.service

import br.com.emanueldias.CarParking.dto.VeiculoRequestDTO
import br.com.emanueldias.CarParking.dto.VeiculoResponseDTO
import br.com.emanueldias.CarParking.mapper.DonoRequestFromDonoMapper
import br.com.emanueldias.CarParking.mapper.VeiculoFromVeiculoResponseMapper
import br.com.emanueldias.CarParking.mapper.VeiculoRequestFromVeiculoMapper
import br.com.emanueldias.CarParking.model.Veiculo

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

    fun createVeiculo(veiculoRequestDTO: VeiculoRequestDTO): VeiculoResponseDTO {
        val veiculoSave = requestToVeiculo.map(veiculoRequestDTO)
        val donoSave = requestToDono.map(veiculoRequestDTO.dono)


        donoService.saveDono(donoSave)
        veiculoRepository.save(veiculoSave)

        var donoPut = donoService.findByNome(donoSave.nome)
        var veiculoPut = veiculoRepository.findByPlaca(veiculoSave.placa)

        veiculoPut.dono = donoPut
        donoPut.veiculo = veiculoPut

        veiculoRepository.save(veiculoPut)
        donoService.saveDono(donoPut)

        return veiculoFromVeiculoResponseMapper.map(veiculoSave)
    }

    fun getAllVeiculos(): List<VeiculoResponseDTO> {
        return veiculoRepository.findAll().stream().map { v -> veiculoFromVeiculoResponseMapper.map(v) }.toList()
    }
}