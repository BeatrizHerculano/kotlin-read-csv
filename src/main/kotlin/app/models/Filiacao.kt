package app.models

import java.io.Serializable
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "filiacao")
class Filiacao (@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id_filiacao: Int? = 0,
                @Column(nullable = false) var data_filiacao: Date? = null,
                @Column(nullable = false) var situacao_registro: String? = null,
                @Column(nullable = false) var tipo_registro: String? = null,
                @Column(nullable = true) var data_processamento: Date? = null,
                @Column(nullable = true) var data_desfiliacao: Date?= null,
                @Column(nullable = true) var data_cancelamento: Date? = null,
                @Column(nullable = true) var data_regularizacao: Date? = null,
                @Column(nullable = true) var motivo_cancelamento: String? = null): Serializable {
    protected constructor(): this(id_filiacao = 0,
                                    situacao_registro = null,
                                    tipo_registro = null,
                                    data_processamento = null,
                                    data_desfiliacao = null,
                                    data_cancelamento = null,
                                    data_filiacao = null,
                                    data_regularizacao = null)
}