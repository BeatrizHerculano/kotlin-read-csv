package app.models


import com.opencsv.bean.CsvBindByName
import javax.persistence.*

@Entity
@Table(name = "zona")
class Zona (@Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            var id_zona:Int? = 0,

            @CsvBindByName(column = "ZONA ELEITORAL")
            @Column(nullable = false)
            var zona_eleitoral: Int,


            @CsvBindByName(column = "SECAO ELEITORAL")
            @Column(nullable = false)
            var secao_eleitoral: Int,


            @CsvBindByName(column = "CODIGO DO MUNICIPIO")
            @Column(nullable = false)
            var codigo_municipio:Int,


            @CsvBindByName(column = "NOME DO MUNICIPIO")
            @Column(nullable = false)
            var nome_municipio: String? = null,


            @CsvBindByName(column = "UF")
            @Column(nullable = false)
            var uf : String? = null){
     constructor(): this(id_zona = 0, zona_eleitoral = 0, secao_eleitoral = 0, codigo_municipio = 0, nome_municipio = null, uf = null)
}