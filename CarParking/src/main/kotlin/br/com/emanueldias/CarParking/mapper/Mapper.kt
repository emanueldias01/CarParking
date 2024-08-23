package br.com.emanueldias.CarParking.mapper

interface Mapper<T, D> {
    fun map(t : T) : D
}