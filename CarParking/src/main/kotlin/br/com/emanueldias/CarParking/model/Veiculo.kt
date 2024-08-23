package br.com.emanueldias.CarParking.model

import jakarta.persistence.*

@Entity
data class Veiculo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    @Enumerated(EnumType.STRING)
    val tipoVeiculo : TipoVeiculo,
    val marca : String,
    val modelo : String,
    val placa : String,
    val numeroEstacionamento : Int,
    @OneToOne(cascade = [CascadeType.REMOVE])
    var dono : Dono? = null
)
