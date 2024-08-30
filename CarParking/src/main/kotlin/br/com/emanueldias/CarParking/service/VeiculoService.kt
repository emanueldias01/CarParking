package br.com.emanueldias.CarParking.service

import br.com.emanueldias.CarParking.dto.VeiculoRequestDTO
import br.com.emanueldias.CarParking.dto.VeiculoResponseDTO
import br.com.emanueldias.CarParking.handler.exceptions.VagaOcupadaException
import br.com.emanueldias.CarParking.mapper.DonoRequestFromDonoMapper
import br.com.emanueldias.CarParking.mapper.VeiculoFromVeiculoResponseMapper
import br.com.emanueldias.CarParking.mapper.VeiculoRequestFromVeiculoMapper

import br.com.emanueldias.CarParking.repository.VeiculoRepository
import br.com.emanueldias.CarParking.validation.VagaValidation
import org.springframework.stereotype.Service

@Service
class VeiculoService(
    private val veiculoRepository: VeiculoRepository,
    private val requestToVeiculo : VeiculoRequestFromVeiculoMapper,
    private val requestToDono : DonoRequestFromDonoMapper,
    private val donoService: DonoService,
    private val veiculoFromVeiculoResponseMapper: VeiculoFromVeiculoResponseMapper,
    private val vagaValidation: VagaValidation
) {

    fun createVeiculo(veiculoRequestDTO: VeiculoRequestDTO): VeiculoResponseDTO {
        val veiculoSave = requestToVeiculo.map(veiculoRequestDTO)
        val donoSave = requestToDono.map(veiculoRequestDTO.dono)

        if(vagaValidation.validaVaga(veiculoSave.numeroEstacionamento)){
            donoService.saveDono(donoSave)
            veiculoRepository.save(veiculoSave)

            val donoPut = donoService.findByNome(donoSave.nome)
            val veiculoPut = veiculoRepository.findByPlaca(veiculoSave.placa)

            veiculoPut.dono = donoPut
            donoPut.veiculo = veiculoPut

            veiculoRepository.save(veiculoPut)
            donoService.saveDono(donoPut)

            return veiculoFromVeiculoResponseMapper.map(veiculoSave)
        } else{
            throw VagaOcupadaException("Esta vaga já está sendo usada")
        }

    }

    fun getAllVeiculos(): List<VeiculoResponseDTO> {
        return veiculoRepository.findAll().stream().map { veiculoFromVeiculoResponseMapper.map(it) }.toList()
    }

    fun deleteVeiculo(id : Long){
        val donoRef = veiculoRepository.getReferenceById(id).dono
        veiculoRepository.deleteById(id)
        donoService.deleteById(donoRef?.id)
    }
}