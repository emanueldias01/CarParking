package br.com.emanueldias.CarParking.service

import br.com.emanueldias.CarParking.model.Dono
import br.com.emanueldias.CarParking.repository.DonoRepository
import org.springframework.stereotype.Service

@Service
class DonoService(
    private val donoRepository: DonoRepository
) {

    fun saveDono(dono : Dono){
        donoRepository.save(dono)
    }

    fun findByNome(nome : String) : Dono{
        return donoRepository.findByNome(nome)
    }

    fun deleteById(id: Long?) {
        donoRepository.deleteById(id!!)
    }


}