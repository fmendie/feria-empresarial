package feriaempresarial;

import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StandNGTest {

    private Stand stand;
    private Empresa empresa;

    @BeforeMethod
    public void setUp() {
        empresa = new Empresa("Empresa X", "Tecnología", "contacto@empresa.com");
        stand = new Stand(1, "Zona A", "Grande");
    }

    @Test
    public void testAsignarEmpresa() {
        System.out.println("asignarEmpresa");
        stand.asignarEmpresa(empresa);
        assertEquals(stand.getEmpresa(), empresa);
    }

    @Test
    public void testAgregarComentario() {
        System.out.println("agregarComentario");
        Comentario comentario = new Comentario("Juan Pérez", "Excelente stand", 5);
        stand.agregarComentario(comentario);
        assertTrue(stand.getComentarios().contains(comentario));
    }

    @Test
    public void testObtenerCalificacionPromedio() {
        System.out.println("obtenerCalificacionPromedio");
        stand.agregarComentario(new Comentario("Juan", "Bueno", 4));
        stand.agregarComentario(new Comentario("Ana", "Regular", 2));
        double expResult = 3.0; // (4+2)/2 = 3.0
        assertEquals(stand.obtenerCalificacionPromedio(), expResult, 0.01);
    }

    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        assertEquals(stand.getNumero(), 1);
    }

    @Test
    public void testGetUbicacion() {
        System.out.println("getUbicacion");
        assertEquals(stand.getUbicacion(), "Zona A");
    }

    @Test
    public void testGetTamano() {
        System.out.println("getTamano");
        assertEquals(stand.getTamano(), "Grande");
    }

    @Test
    public void testEstaOcupado() {
        System.out.println("estaOcupado");
        assertFalse(stand.estaOcupado()); // Al inicio no hay empresa asignada
        stand.asignarEmpresa(empresa);
        assertTrue(stand.estaOcupado()); // Después de asignar, debe estar ocupado
    }
}
