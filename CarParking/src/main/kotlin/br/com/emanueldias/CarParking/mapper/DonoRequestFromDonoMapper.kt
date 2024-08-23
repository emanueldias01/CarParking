package br.com.emanueldias.CarParking.mapper

import br.com.emanueldias.CarParking.dto.DonoRequestDTO
import br.com.emanueldias.CarParking.model.Dono

class DonoRequestFromDonoMapper : Mapper<DonoRequestDTO, Dono> {
    override fun map(t: DonoRequestDTO): Dono {
        return Dono(
            nome = t.nome
        )
    }
}