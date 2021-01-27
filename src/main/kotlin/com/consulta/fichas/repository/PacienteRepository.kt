package com.consulta.fichas.repository

import com.consulta.fichas.models.Paciente
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PacienteRepository : CrudRepository<Paciente, Long> {

}