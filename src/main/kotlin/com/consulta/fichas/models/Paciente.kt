package com.consulta.fichas.models

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "PACIENTE")
class Paciente (

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long,

    @Column(name = "NOME")
    var nome: String,

    @Column(name = "CPF")
    var cpf: String,

    @Column(name = "RELIGIAO")
    var religiao: String,

    @Column(name = "IDADE")
    var idade: Long,

    @Column(name = "PROFISSAO")
    var profissao: String,

    @Column(name = "EMAIL")
    var email: String,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CONSULTA")
    @Transient
    var consultas: List<Consulta>?

)
