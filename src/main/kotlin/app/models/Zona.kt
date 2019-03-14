package app.models


import javax.persistence.*

@Entity
@Table(name = "zona")
class Zona (@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id_zona:Int? = 0,
            @Column(nullable = false) var zona_eleitoral: Int,
            @Column(nullable = false) var secao_eleitoral: Int,
            @Column(nullable = false) var codigo_municipio:Int,
            @Column(nullable = false) var nome_municipio: String? = null,
            @Column(nullable = false)var uf : String? = null){
    protected constructor(): this(id_zona = 0, zona_eleitoral = 0, secao_eleitoral = 0, codigo_municipio = 0, nome_municipio = null, uf = null)
}