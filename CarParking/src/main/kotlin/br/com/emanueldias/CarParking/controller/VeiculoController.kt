package br.com.emanueldias.CarParking.controller

import br.com.emanueldias.CarParking.dto.VeiculoRequestDTO
import br.com.emanueldias.CarParking.dto.VeiculoResponseDTO
import br.com.emanueldias.CarParking.service.VeiculoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/veiculos")
class VeiculoController(
    private val  veiculoService: VeiculoService
) {

    @GetMapping
    fun getAllVeiculos() : ResponseEntity<List<VeiculoResponseDTO>> {
        return ResponseEntity.ok(veiculoService.getAllVeiculos())
    }

    @PostMapping
    fun createVeiculo(@RequestBody dto : VeiculoRequestDTO, uriComponentsBuilder: UriComponentsBuilder) : ResponseEntity<VeiculoResponseDTO>{
        val response = veiculoService.createVeiculo(dto)
        val uri = uriComponentsBuilder.path("/veiculos/${response.id}").build().toUri()
        return ResponseEntity.created(uri).body(response)
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteVeiculo(@PathVariable id : Long){
        veiculoService.deleteVeiculo(id)
    }
}