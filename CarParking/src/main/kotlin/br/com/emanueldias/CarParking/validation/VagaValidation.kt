package br.com.emanueldias.CarParking.validation

import br.com.emanueldias.CarParking.mapper.VeiculoFromVeiculoResponseMapper
import br.com.emanueldias.CarParking.repository.VeiculoRepository
import org.springframework.stereotype.Service

@Service
class VagaValidation(
    private val veiculoRepository: VeiculoRepository,
    private val veiculoFromVeiculoResponseMapper: VeiculoFromVeiculoResponseMapper
) {

    fun validaVaga(numeroVagaEscolhida : Int) : Boolean{
        val listVagas = veiculoRepository.findAll().map { veiculoFromVeiculoResponseMapper.map(it) }.toList()
        var cont = 0

        for(veiculo in listVagas){
            if(veiculo.numeroEstacionamento == numeroVagaEscolhida)
                cont++
            break
        }

        return if(cont != 0){
            false
        }else{
            true
        }
    }
}