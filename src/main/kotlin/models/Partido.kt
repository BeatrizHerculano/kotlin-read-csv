package models

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user")
data class Partido(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id_partido: Int? = 0,
                   @Column(nullable = false) var sigla: String? = null,
                   @Column(nullable = false) var nome: String? = null) : Serializable {

    protected constructor() : this(id_partido = null, sigla = null, nome = null) {
    }
}