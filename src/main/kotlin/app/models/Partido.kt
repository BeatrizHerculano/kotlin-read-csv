package app.models

import com.opencsv.bean.CsvBindByName
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "partido")
data class Partido(@Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                   var id_partido: Int? = 0,

                   @CsvBindByName(column = "SIGLA DO PARTIDO")
                   @Column(nullable = false)
                   var sigla: String? = null,

                   @CsvBindByName(column = "NOME DO PARTIDO")
                   @Column(nullable = false)
                   var nome: String? = null) : Serializable {

 constructor() : this(id_partido = 0, sigla = null, nome = null) {
    }

}