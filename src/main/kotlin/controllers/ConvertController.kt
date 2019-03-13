package controllers

import models.Partido
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import services.PartidoDAO

@RestController
class ConvertController @Autowired constructor(val partidoDAO: PartidoDAO) {

    @GetMapping("/convert")

    @ResponseBody
    fun convert():String?{
        try {
            var newPartido = Partido(sigla = "PT", nome = "Partido dos trabalhadores")
            partidoDAO.save(newPartido)

            return "teste"
        } catch(e: Exception) {
            return throw error("Error nich --> " + e.message.toString())
        }

    }

}