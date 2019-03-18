package app.dao

import app.models.Partido
import org.springframework.data.repository.CrudRepository

interface PartidoRepository : CrudRepository<Partido, Long>{
     fun findByNomeAndSigla(nome:String?, sigla:String?): Partido?
}