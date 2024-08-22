package br.com.emanueldias.CarParking.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
data class Dono(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    val nome : String,
    @OneToOne
    val veiculo : Veiculo
)
