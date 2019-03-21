package app.business

import app.models.Filiacao
import app.models.Filiado
import app.models.Partido
import app.models.Zona
import org.springframework.stereotype.Service

@Service
class FiliadoBusiness {
    fun composeFiliados(filiado: Filiado, partido: Partido, zona: Zona, filiacao: Filiacao):Filiado {
        filiado.filiacao = filiacao
        filiado.zona = zona
        filiado.partido = partido
        return filiado
    }
}