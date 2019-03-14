package app.business

import app.models.Filiacao
import app.models.Filiado
import app.models.Partido
import app.models.Zona
import app.services.FiliadoRepository
import app.services.PartidoRepository
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import com.opencsv.CSVParserBuilder
import java.sql.Date
import java.sql.Time
import java.text.SimpleDateFormat


class PartidoBusiness {
    fun insertPartidos(filiadoRepository: FiliadoRepository, partidoRepo : PartidoRepository){
        var records = readCSVFile()
        var partidosDB = partidoRepo.findAll()
        var format = SimpleDateFormat("dd/mm/yyyy")
        var hformat = SimpleDateFormat("hh:mm:ss")
        if (records != null){
            for (_record in records) {
                //preencher todas as listas
                /*partidosCSV.add(Partido( sigla = if (_record[4].isEmpty()) null else _record[4], nome = if (_record[5].isEmpty()) null else _record[5]))
                filiacaoCSV.add(Filiacao(data_filiacao = if (_record[11].isEmpty()) null else Date(format.parse(_record[11]).time),
                    situacao_registro = if (_record[12].isEmpty()) null else _record[12],
                    tipo_registro = if (_record[13].isEmpty()) null else _record[13],
                    data_processamento = if (_record[14].isEmpty()) null else Date(format.parse(_record[14]).time),
                    data_desfiliacao = if (_record[15].isEmpty()) null else Date(format.parse(_record[15]).time),
                    data_cancelamento = if (_record[16].isEmpty()) null else Date(format.parse(_record[16]).time),
                    data_regularizacao = if (_record[17].isEmpty()) null else Date(format.parse(_record[17]).time),
                    motivo_cancelamento = if (_record[18].isEmpty()) null else _record[18]))*/
                var partido = Partido(sigla = if (_record[4].isEmpty()) null else _record[4], nome = if (_record[5].isEmpty()) null else _record[5])
                var  teste = partidosDB.find { a -> a.nome == partido.nome && a.sigla == partido.sigla}
                if (teste == null){
                    partidoRepo.save(partido)
                } else
                {
                    partido = teste
                }

                var filiacao = Filiacao(data_filiacao = if (_record[11].isEmpty()) null else Date(format.parse(_record[11]).time),
                    situacao_registro = if (_record[12].isEmpty()) null else _record[12],
                    tipo_registro = if (_record[13].isEmpty()) null else _record[13],
                    data_processamento = if (_record[14].isEmpty()) null else Date(format.parse(_record[14]).time),
                    data_desfiliacao = if (_record[15].isEmpty()) null else Date(format.parse(_record[15]).time),
                    data_cancelamento = if (_record[16].isEmpty()) null else Date(format.parse(_record[16]).time),
                    data_regularizacao = if (_record[17].isEmpty()) null else Date(format.parse(_record[17]).time),
                    motivo_cancelamento = if (_record[18].isEmpty()) null else _record[18])
                var zona = Zona(zona_eleitoral = if (_record[9].isEmpty()) 0 else Integer.parseInt(_record[9]),
                    uf =  if (_record[6].isEmpty()) null else _record[6],
                    codigo_municipio = if (_record[7].isEmpty()) 0 else Integer.parseInt(_record[7]),
                    nome_municipio = if (_record[8].isEmpty()) null else _record[8],
                    secao_eleitoral = if (_record[10].isEmpty()) 0 else Integer.parseInt(_record[10]))

                var filiado  = Filiado(data_extracao = if (_record[0].isEmpty()) null else Date(format.parse(_record[0]).time),
                    hora_extracao = if (_record[1].isEmpty()) null else Time(hformat.parse(_record[1]).time),
                    numero_inscricao = if (_record[2].isEmpty()) null else _record[2].toLong(),
                    nome_filiado = if (_record[3].isEmpty()) null else _record[3],
                    partido = partido,
                    filiacao = filiacao,
                    zona = zona
                )
                filiadoRepository.save(filiado)

            }
        }

        //if (partidosCSV != null) {
            //for (partidoCSV in lista.distinct()) {
                //var  teste = partidosDB.find { a -> a.nome == partidoCSV.nome && a.sigla == partidoCSV.sigla}
                //if (teste == null){
                    //partidoRepo.save(partidoCSV)
                //}

           //}
        //}
    }
    fun readCSVFile():MutableList<Array<String>>?{
        var lista = mutableListOf<Partido>()
        var records = listOf(String)
        var fileReader: BufferedReader? = null
        var csvReader: CSVReader? = null

        try {
            println("\n--- Read all at once ---")
            val parser = CSVParserBuilder().withSeparator(';').build()

            fileReader = BufferedReader(FileReader("filiados_pv_sc.csv"))
            csvReader = CSVReaderBuilder(fileReader).withCSVParser(parser).withSkipLines(1).build()

            val records = csvReader.readAll()
            //for (_record in records) {

                //lista.add(Partido(sigla = _record[4], nome = _record[5]))
            //}
            return records

        } catch (e: Exception) {
            println("Reading CSV Error!")
            e.printStackTrace()
            return null
        } finally {
            try {
                fileReader!!.close()
                csvReader!!.close()
            } catch (e: IOException) {
                println("Closing fileReader/csvParser Error!")
                e.printStackTrace()
            }

        }

    }



}