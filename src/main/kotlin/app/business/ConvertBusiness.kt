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

    @Autowired
    lateinit var partidoRepository: PartidoRepository
    @Autowired
    lateinit var filiadoRepository: FiliadoRepository

    fun insereDadosDoCSV(){
        try {
            var partidos = readFromCSVIntoLisOf<Partido>()

            var filiados = readFromCSVIntoLisOf<Filiado>()

            var zonas = readFromCSVIntoLisOf<Zona>()

            var filiacoes = readFromCSVIntoLisOf<Filiacao>()

            for ((index, filiado) in filiados.withIndex()){
                val partidoDb = partidoRepository.findByNomeAndSigla(nome = partidos[index].nome, sigla = partidos[index].sigla)
                if (partidoDb != null)
                    partidos[index] = partidoDb
                else
                    partidoRepository.save(partidos[index])

                filiado.partido = partidos[index]
                filiado.zona = zonas[index]
                filiado.filiacao = filiacoes[index]
                filiadoRepository.save(filiado)
            }


        }catch (e: Exception){
            throw e
        }

    }

    private inline fun <reified T> readFromCSVIntoLisOf() : MutableList<T> {
        val clazz = T::class.java
        return CsvToBeanBuilder<T>(FileReader("filiados_pv_sc.csv"))
            .withType(clazz)
            .withSeparator(';')
            .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
            .build().parse()
    }






}