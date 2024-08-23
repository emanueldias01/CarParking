package br.com.emanueldias.CarParking.repository

import br.com.emanueldias.CarParking.model.Veiculo
import org.springframework.data.jpa.repository.JpaRepository

interface VeiculoRepository : JpaRepository<Veiculo, Long> {
    fun findByPlaca(numeroPlaca : String) : Veiculo
}