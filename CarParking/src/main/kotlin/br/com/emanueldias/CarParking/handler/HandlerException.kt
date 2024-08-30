package br.com.emanueldias.CarParking.handler

import br.com.emanueldias.CarParking.handler.dto.ErrorDTO
import br.com.emanueldias.CarParking.handler.exceptions.VagaOcupadaException
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@Configuration
@RestControllerAdvice
class HandlerException {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    fun trataVagaOcupadaException(ex : VagaOcupadaException) : ErrorDTO{
        return ErrorDTO(mensagem = ex.message!!, lancamento = ex.lancamento)
    }
}