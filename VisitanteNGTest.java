package feriaempresarial;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisitanteNGTest {

    private Visitante visitante;
    private Stand stand;

    @BeforeMethod
    public void setUp() {
        visitante = new Visitante("Juan Pérez", "12345678", "juan@email.com");
        stand = new Stand(1, "Zona A", "Mediano");
    }

   @Test
public void testVisitarStand() {
    System.out.println("visitarStand");
    
    Visitante visitante = new Visitante("Carlos", "67890", "carlos@email.com");
    Stand stand = new Stand(2, "Ubicación B", "Grande"); 
    
    visitante.visitarStand(stand, "Excelente", 4);
    
    assertTrue(visitante.getStandsVisitados().contains(2)); 
}


    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        assertEquals(visitante.getNombre(), "Juan Pérez");
    }

    @Test
    public void testGetIdentificacion() {
        System.out.println("getIdentificacion");
        assertEquals(visitante.getIdentificacion(), "12345678");
    }

    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        assertEquals(visitante.getCorreo(), "juan@email.com");
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        visitante.setNombre("Carlos López");
        assertEquals(visitante.getNombre(), "Carlos López");
    }

    @Test
    public void testSetCorreo() {
        System.out.println("setCorreo");
        visitante.setCorreo("carlos@email.com");
        assertEquals(visitante.getCorreo(), "carlos@email.com");
    }

   @Test
public void testGetStandsVisitados() {
    System.out.println("getStandsVisitados");
    
    Visitante visitante = new Visitante("Juan", "12345", "juan@email.com");
    Stand stand = new Stand(1, "Ubicación A", "Mediano");  
    
    visitante.visitarStand(stand, "Buen stand", 5);
    
    List<Integer> expResult = List.of(1); 
    List<Integer> result = visitante.getStandsVisitados();
    
    assertEquals(result, expResult);
}

}
