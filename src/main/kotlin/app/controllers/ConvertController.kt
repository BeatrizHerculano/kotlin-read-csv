package app.controllers

import app.business.PartidoBusiness
import app.models.Partido
import app.services.FiliadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import app.services.PartidoRepository

@RestController
class ConvertController()
{
    @Autowired
    lateinit var filiadoRepository: FiliadoRepository

    @Autowired
    lateinit var partidoRepository: PartidoRepository

    @GetMapping("/convert")
    @ResponseBody
    fun convert(){
        try {
            //var newPartido = Partido(sigla = "PT", nome = "Partido dos trabalhadores")
            //partidoRepo.save(newPartido)
            var partidos = PartidoBusiness().insertPartidos(filiadoRepository, partidoRepository)
        } catch(e: Exception) {
            return throw error("Error nich --> " + e.message.toString())
        }

    }

}