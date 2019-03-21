package app.business

import app.dao.PartidoRepository
import app.models.Partido
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PartidoBusiness (){
    //private var all = partidoRepository.findAll().toMutableList()


    private fun isPartidoUnique (p:Partido, list: MutableList<Partido>):Boolean{
        var paux = list.filter { a -> a.sigla == p.sigla && a.nome == p.nome  }

        return (paux != null)
    }

    fun saveOrReturnPartido(partido: Partido?, partidoRepository: PartidoRepository):Partido{
        if (partido != null) {
            if(!isPartidoUnique(partido, partidoRepository.findAll().toMutableList()))
                return partidoRepository.save(partido)
            return partido
        }
        else
        {
            throw Exception("Error")
        }
    }

}