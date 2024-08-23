package br.com.emanueldias.CarParking.mapper

import br.com.emanueldias.CarParking.dto.DonoResponseDTO
import br.com.emanueldias.CarParking.model.Dono
import org.springframework.stereotype.Component

@Component
class donoFromDonoResponseDTO : Mapper<Dono, DonoResponseDTO>{
    override fun map(t: Dono): DonoResponseDTO {
        return DonoResponseDTO(
            id = t.id,
            nome = t.nome
        )
    }

}