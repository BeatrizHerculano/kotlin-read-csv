package app.services

import app.models.Filiado
import org.springframework.data.repository.CrudRepository

interface FiliadoRepository : CrudRepository<Filiado, Int>