package com.consulta.fichas.models

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "CONSULTA")
class Consulta (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "DATA_CONSULTA")
    var dataConsulta: Date,

    @Column(name = "VALOR_PAGO")
    var valorPago: BigDecimal,

    @Column(name = "OBSERVACOES")
    var obsevacao: String

)