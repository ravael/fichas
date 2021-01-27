package com.consulta.fichas.service

import com.consulta.fichas.models.Paciente
import com.consulta.fichas.repository.PacienteRepository
import org.springframework.stereotype.Service

@Service
class PacienteService (private val pacienteRepository: PacienteRepository) {

    fun incluir(paciente: Paciente) {
            pacienteRepository.save(paciente)
    }

    fun listarTodos(): MutableIterable<Paciente> {
        return pacienteRepository.findAll();
    }

}