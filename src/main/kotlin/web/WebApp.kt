package web

import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.FileInputStream

@SpringBootApplication
class WebApp

fun main(args: Array<String>) {
    SpringApplication.run(WebApp::class.java, *args)
}

