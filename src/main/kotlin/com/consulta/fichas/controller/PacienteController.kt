package com.consulta.fichas.controller

import com.consulta.fichas.models.Paciente
import com.consulta.fichas.service.PacienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/paciente")
//@CrossOrigin(origins = ["*"], allowedHeaders = ["*"], methods = [RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE])
class PacienteController (private val pacienteService: PacienteService) {

    @GetMapping
    fun home(): String {
        return "Bem Vindo Paciente";
    }

    @PostMapping("incluir")
    fun incluir(@RequestBody paciente: Paciente) : ResponseEntity<Paciente> {
        pacienteService.incluir(paciente);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("listar")
    fun getAllCategorias(): MutableIterable<Paciente> =
        pacienteService.listarTodos();
}