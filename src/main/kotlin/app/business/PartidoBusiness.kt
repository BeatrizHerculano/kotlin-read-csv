package app.business

import app.dao.FiliadoRepository
import app.dao.PartidoRepository
import app.models.Filiacao
import app.models.Filiado
import app.models.Partido
import app.models.Zona
import com.opencsv.bean.CsvToBeanBuilder
import com.opencsv.enums.CSVReaderNullFieldIndicator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.FileReader

@Service
class PartidoBusiness {

    @Autowired
    lateinit var partidoRepository: PartidoRepository
    @Autowired
    lateinit var filiadoRepository: FiliadoRepository

    fun insereDadosDoCSV(){
        try {
            var partidos = CsvToBeanBuilder<Partido>(FileReader("filiados_pv_sc.csv")).withType(Partido::class.java)
               .withSeparator(';')
               .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
               .build().parse()

            var filiados = CsvToBeanBuilder<Filiado>(FileReader("filiados_pv_sc.csv")).withType(Filiado::class.java)
                .withSeparator(';')
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                .build().parse()

            var zonas = CsvToBeanBuilder<Zona>(FileReader("filiados_pv_sc.csv")).withType(Zona::class.java)
                .withSeparator(';')
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                .build().parse()
            var filiacoes = CsvToBeanBuilder<Filiacao>(FileReader("filiados_pv_sc.csv")).withType(Filiacao::class.java)
                .withSeparator(';')
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                .build().parse()
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




}