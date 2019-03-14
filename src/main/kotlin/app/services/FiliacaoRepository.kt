package app.services

import app.models.Filiacao
import org.springframework.data.repository.CrudRepository

interface FiliacaoRepository: CrudRepository<Filiacao, Long>