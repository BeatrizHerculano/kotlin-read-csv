package app.models

import java.sql.Date
import java.sql.Time
import javax.persistence.*
@Entity
@Table(name = "filiado")
class Filiado (@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id_filiado: Int? = null,
               @Column(nullable = false) var nome_filiado: String? = null,
               @Column(nullable = false) var data_extracao: Date? = null,
               @Column(nullable = false) var hora_extracao: Time? = null,
               @Column(nullable = false) var numero_inscricao: Long? = 0,
               @OneToOne(cascade = arrayOf(CascadeType.ALL)) @JoinColumn var partido: Partido? = null,
               @OneToOne(cascade = arrayOf(CascadeType.ALL)) @JoinColumn var zona: Zona? = null,
               @OneToOne(cascade = arrayOf(CascadeType.ALL)) @JoinColumn var filiacao: Filiacao? = null) {
    protected constructor(): this( nome_filiado = null, data_extracao =  null, hora_extracao = null,
        numero_inscricao = null, partido = null, zona = null, filiacao = null)
}