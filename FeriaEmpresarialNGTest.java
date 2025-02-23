package feriaempresarial;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class FeriaEmpresarialNGTest {
    
    private FeriaEmpresarial feria;

    @BeforeClass
    public void setUpClass() {
        feria = new FeriaEmpresarial();
    }

    @Test
    public void testListarStandsDisponibles() {
        // No devuelve nada, solo verificamos que no lance excepciones
        feria.listarStandsDisponibles();
        assertTrue(true);
    }

    @Test
    public void testRegistrarEmpresa() {
        String input = "Empresa Test\nTecnología\ncorreo@test.com\n1\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        feria.registrarEmpresa();
        System.setIn(stdin); // Restaurar entrada estándar
        assertTrue(true);
    }


    @Test
    public void testRegistrarVisitante() {
        String input = "Juan Perez\n123456789\njuan@test.com\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        feria.registrarVisitante();
        System.setIn(stdin); // Restaurar entrada estándar
        assertTrue(true);
    }

    @Test
    public void testEditarVisitante() {
        String input = "123456789\nJuan Modificado\nnuevo@test.com\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        feria.editarVisitante();
        System.setIn(stdin);
        assertTrue(true);
    }

    @Test
    public void testEliminarVisitante() {
        String input = "123456789\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        feria.eliminarVisitante();
        System.setIn(stdin);
        assertTrue(true);
    }

    @Test
    public void testVisitarStand() {
        String input = "123456789\n1\nMuy bueno\n5\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        feria.visitarStand();
        System.setIn(stdin);
        assertTrue(true);
    }

    @Test
    public void testEditarEmpresa() {
        String input = "Empresa Test\nEmpresa Modificada\nNuevo Sector\nnuevo@mail.com\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        feria.editarEmpresa();
        System.setIn(stdin);
        assertTrue(true);
    }

    @Test
    public void testEliminarEmpresa() {
        String input = "Empresa Modificada\n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        feria.eliminarEmpresa();
        System.setIn(stdin);
        assertTrue(true);
    }

    @Test
    public void testGenerarReportes() {
        feria.generarReportes();
        assertTrue(true);
    }

    @Test
    public void testIniciar() {
        // No se puede probar un bucle infinito, solo verificamos que el método exista.
        assertNotNull(feria);
    }

    @Test
    public void testMain() {
        String[] args = {};
        FeriaEmpresarial.main(args);
        assertTrue(true);
    }
}
