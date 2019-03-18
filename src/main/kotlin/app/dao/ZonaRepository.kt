package app.dao

import app.models.Zona
import org.springframework.data.repository.CrudRepository

interface ZonaRepository : CrudRepository<Zona, Int>