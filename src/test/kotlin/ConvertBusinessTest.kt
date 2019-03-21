import app.business.ConvertBusiness
import org.junit.Test

class ConvertBusinessTest{
    @Test
    fun `fill lists actualy fill filiacoes list`(){
        var business = ConvertBusiness()
        business.fillLists()

        assert(business.filiacoes!= null)
    }
    @Test
    fun `fill lists actualy fill filiados list`(){
        var business = ConvertBusiness()
        business.fillLists()

        assert(business.filiados!= null)
    }
    @Test
    fun `fill lists actualy fill partidos list`(){
        var business = ConvertBusiness()
        business.fillLists()

        assert(business.partidos!= null)
    }

    @Test
    fun `fill lists actualy fill zonas list`(){
        var business = ConvertBusiness()
        business.fillLists()

        assert(business.zonas!= null)
    }

}