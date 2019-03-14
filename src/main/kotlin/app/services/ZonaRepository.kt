package app.services

import app.models.Zona
import org.springframework.data.repository.CrudRepository

interface ZonaRepository : CrudRepository<Zona, Int>