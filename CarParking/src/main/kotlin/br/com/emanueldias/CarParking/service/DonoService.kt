package br.com.emanueldias.CarParking.service

import br.com.emanueldias.CarParking.dto.DonoRequestDTO
import br.com.emanueldias.CarParking.model.Dono
import br.com.emanueldias.CarParking.model.Veiculo
import br.com.emanueldias.CarParking.repository.DonoRepository
import org.springframework.stereotype.Service

@Service
class DonoService(
    private val donoRepository: DonoRepository
) {

    fun createDono(dono : Dono){
        donoRepository.save(dono)
    }
}