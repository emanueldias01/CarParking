package br.com.emanueldias.CarParking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarParkingApplication

fun main(args: Array<String>) {
	runApplication<CarParkingApplication>(*args)
}
