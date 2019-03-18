package app.models

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvDate
import java.io.Serializable
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "filiacao")
class Filiacao (@Id
                @GeneratedValue
                (strategy = GenerationType.IDENTITY) var id_filiacao: Int? = 0,

                @CsvBindByName(column = "DATA DA FILIACAO", required = true)
                @CsvDate("dd/MM/yyyy")
                @Column(nullable = false)
                var data_filiacao: Date? = null,

                @CsvBindByName(column = "SITUACAO DO REGISTRO", required = true)
                @Column(nullable = false)
                var situacao_registro: String? = null,

                @CsvBindByName(column = "TIPO DO REGISTRO", required = true)
                @Column(nullable = false)
                var tipo_registro: String? = null,

                @CsvBindByName(column = "DATA DO PROCESSAMENTO", required = false)
                @CsvDate("dd/MM/yyyy")
                @Column(nullable = true)
                var data_processamento: Date? = null,

                @CsvBindByName(column = "DATA DA DESFILIACAO", required = false)
                @CsvDate("dd/MM/yyyy")
                @Column(nullable = true)
                var data_desfiliacao: Date?= null,

                @CsvBindByName(column = "DATA DO CANCELAMENTO", required = false)
                @CsvDate("dd/MM/yyyy")
                @Column(nullable = true)
                var data_cancelamento: Date? = null,

                @CsvBindByName(column = "DATA DA REGULARIZACAO", required = false)
                @CsvDate("dd/MM/yyyy")
                @Column(nullable = true)
                var data_regularizacao: Date? = null,

                @CsvBindByName(column = "MOTIVO DO CANCELAMENTO", required = false)
                @Column(nullable = true)
                var motivo_cancelamento: String? = null): Serializable {
     constructor(): this(id_filiacao = 0,
                                    situacao_registro = null,
                                    tipo_registro = null,
                                    data_processamento = null,
                                    data_desfiliacao = null,
                                    data_cancelamento = null,
                                    data_filiacao = null,
                                    data_regularizacao = null)
}