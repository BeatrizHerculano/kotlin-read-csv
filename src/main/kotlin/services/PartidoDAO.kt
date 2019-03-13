package services

import models.Partido
import org.springframework.data.repository.CrudRepository


interface PartidoDAO : CrudRepository<Partido, Long> {
}