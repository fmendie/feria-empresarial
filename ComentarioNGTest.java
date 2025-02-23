package feriaempresarial;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComentarioNGTest {
    
    private Comentario comentario; // Instancia de prueba

    @BeforeClass
    public void setUpClass() {
        comentario = new Comentario("Juan Pérez", "Buen servicio", 5);

    }

    @AfterClass
    public void tearDownClass() {
        comentario = null;
    }

    @Test
    public void testGetCalificacion() {
        System.out.println("getCalificacion");
        assertEquals(comentario.getCalificacion(), 5);
    }
}
