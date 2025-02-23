package feriaempresarial;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmpresaNGTest {
    
    private Empresa empresa; // Instancia de prueba

    @BeforeClass
    public void setUpClass() {
        empresa = new Empresa("TechCorp", "Tecnología", "contacto@techcorp.com");
    }

    @AfterClass
    public void tearDownClass() {
        empresa = null;
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        assertEquals(empresa.getNombre(), "TechCorp");
    }

    @Test
    public void testGetSector() {
        System.out.println("getSector");
        assertEquals(empresa.getSector(), "Tecnología");
    }

    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        assertEquals(empresa.getCorreo(), "contacto@techcorp.com");
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        empresa.setNombre("NewName");
        assertEquals(empresa.getNombre(), "NewName");
    }

    @Test
    public void testSetSector() {
        System.out.println("setSector");
        empresa.setSector("Salud");
        assertEquals(empresa.getSector(), "Salud");
    }

    @Test
    public void testSetCorreo() {
        System.out.println("setCorreo");
        empresa.setCorreo("newmail@empresa.com");
        assertEquals(empresa.getCorreo(), "newmail@empresa.com");
    }
}
