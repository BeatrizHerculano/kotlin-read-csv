package app.business

import app.dao.PartidoRepository
import app.models.Partido
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PartidoBusiness (){


    private fun isPartidoUnique (p:Partido, list: MutableList<Partido>):Boolean{
        var paux = list.filter { a -> a.sigla == p.sigla && a.nome == p.nome  }

        return (paux != null)
    }

    fun saveOrReturnPartido(partido: Partido?, partidoRepository: PartidoRepository, list: MutableList<Partido>):Partido{
        if (partido != null) {
            if(!isPartidoUnique(partido, list))
                return partidoRepository.save(partido)
            return partido
        }
        else
        {
            throw Exception("Error")
        }
    }

}