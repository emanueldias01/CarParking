package br.com.emanueldias.CarParking.repository

import br.com.emanueldias.CarParking.model.Veiculo
import org.springframework.data.jpa.repository.JpaRepository

interface DonoRepository : JpaRepository<Veiculo, Long> {
}