package app.models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "partido")
data class Partido(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id_partido: Int? = 0,
                   @Column(nullable = false) var sigla: String? = null,
                   @Column(nullable = false) var nome: String? = null) : Serializable {

    protected constructor() : this(id_partido = 0, sigla = null, nome = null) {
    }
}