package app.services

import app.models.Partido
import org.springframework.data.repository.CrudRepository

interface PartidoRepository : CrudRepository<Partido, Long>