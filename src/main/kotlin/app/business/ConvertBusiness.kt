package app.business

import app.dao.FiliadoRepository
import app.dao.PartidoRepository
import app.models.Filiacao
import app.models.Filiado
import app.models.Partido
import app.models.Zona
import com.opencsv.bean.CsvToBeanBuilder
import com.opencsv.enums.CSVReaderNullFieldIndicator
import org.apache.commons.lang3.mutable.Mutable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.FileReader
import java.lang.reflect.Type

@Service
class ConvertBusiness {
    var partidos: MutableList<Partido>? = null
    var zonas: MutableList<Zona>? = null
    var filiacoes: MutableList<Filiacao>? = null
    var filiados: MutableList<Filiado>? = null

    @Autowired
    lateinit var filiadoBusiness: FiliadoBusiness
    @Autowired
    lateinit var filiadoRepository: FiliadoRepository
    @Autowired
    lateinit var partidoRepository: PartidoRepository
    @Autowired
    lateinit private var partidoBusiness: PartidoBusiness



    fun convert(){
        fillLists()
        composeAndSaveFiliadoList()
    }

    fun fillLists()
    {
         partidos = readFromCSVIntoLisOf<Partido>()

         filiados = readFromCSVIntoLisOf<Filiado>()

         zonas = readFromCSVIntoLisOf<Zona>()

         filiacoes = readFromCSVIntoLisOf<Filiacao>()

    }
    fun composeAndSaveFiliadoList (){
        try {
            if (filiados != null) {
                for ((index, filiado) in filiados!!.withIndex()){
                    var partido =  partidoBusiness.saveOrReturnPartido(partidos!![index], partidoRepository = partidoRepository)
                    filiadoRepository.save(filiadoBusiness.composeFiliados(filiado = filiado,
                                            partido = partido,
                                            zona = zonas!![index],
                                            filiacao =  filiacoes!![index]))
                }
            }
        }
        catch (e: java.lang.Exception)
        {
            throw java.lang.Exception("Error composing and saving filiado-> " + e.message)
        }

    }



    final inline fun <reified T> readFromCSVIntoLisOf() : MutableList<T> {
        val clazz = T::class.java
        try{
            return CsvToBeanBuilder<T>(FileReader("filiados_pv_sc.csv"))
                .withType(clazz)
                .withSeparator(';')
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                .build().parse()
        }catch (e :Exception){
            throw Exception("Error reading from csv -> "+ e.message)
        }

    }






}