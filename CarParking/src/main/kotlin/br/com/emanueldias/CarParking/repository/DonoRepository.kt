package br.com.emanueldias.CarParking.repository

import br.com.emanueldias.CarParking.model.Dono
import org.springframework.data.jpa.repository.JpaRepository

interface DonoRepository : JpaRepository<Dono, Long> {

    fun findByNome(nome : String) : Dono
}