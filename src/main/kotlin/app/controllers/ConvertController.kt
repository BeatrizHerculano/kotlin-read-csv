package app.controllers

import app.business.PartidoBusiness
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ConvertController()
{
    @Autowired
    lateinit var partidoBusiness: PartidoBusiness

    @GetMapping("/convert")
    @ResponseBody
    fun convert(){
        try {
            partidoBusiness.insereDadosDoCSV()
        } catch(e: Exception) {
            return throw error("Error --> " + e.message.toString())
        }

    }

}