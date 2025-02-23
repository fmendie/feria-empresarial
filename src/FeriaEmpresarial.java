/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package feriaempresarial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pipe7
 */
public class FeriaEmpresarial {
    private List<Empresa> empresas;
    private List<Stand> stands;
    private List<Visitante> visitantes;
    private Scanner scanner;

    public FeriaEmpresarial() {
        this.empresas = new ArrayList<>();
        this.stands = new ArrayList<>();
        this.visitantes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        inicializarStands();
    }
 
    private void inicializarStands() {
        stands.add(new Stand(1, "Pabellón A, Stand 10", "Pequeño"));
        stands.add(new Stand(2, "Pabellón A, Stand 20", "Mediano"));
        stands.add(new Stand(3, "Pabellón B, Stand 5", "Grande"));

    }

   public void listarStandsDisponibles() {
    System.out.println("Stands disponibles:");
    boolean hayDisponibles = false;
    for (Stand stand : stands) {
        if (!stand.estaOcupado()) {
            System.out.println("Stand " + stand.getNumero() + " - " + stand.getUbicacion() + " (" + stand.getTamano() + ")");
            hayDisponibles = true;
        }
    }
    if (!hayDisponibles) {
        System.out.println("No hay stands disponibles.");
    }
}

    public void registrarEmpresa() {
    System.out.print("Ingrese el nombre de la empresa: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese el sector de la empresa: ");
    String sector = scanner.nextLine();
    System.out.print("Ingrese el correo de la empresa: ");
    String correo = scanner.nextLine();

    Empresa empresa = new Empresa(nombre, sector, correo);

    // Mostrar los stands disponibles
    listarStandsDisponibles();
    System.out.print("Ingrese el número del stand que desea asignar a la empresa: ");
    int numStand = scanner.nextInt();
    scanner.nextLine();

    // Buscar el stand seleccionado
    for (Stand stand : stands) {
        if (stand.getNumero() == numStand && !stand.estaOcupado()) {
            stand.asignarEmpresa(empresa);
            empresas.add(empresa);
            System.out.println("Empresa registrada y asignada al stand " + numStand);
            return;
        }
    }

    System.out.println("Número de stand no válido o ya ocupado.");
}

   public void registrarVisitante() {
        System.out.print("Ingrese el nombre del visitante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la identificación del visitante: ");
        String identificacion = scanner.nextLine();
        System.out.print("Ingrese el correo del visitante: ");
        String correo = scanner.nextLine();
        visitantes.add(new Visitante(nombre, identificacion, correo));
        System.out.println("Visitante registrado exitosamente.");
    }

    public void editarVisitante() {
        System.out.print("Ingrese la identificación del visitante a editar: ");
        String identificacion = scanner.nextLine();
        for (Visitante visitante : visitantes) {
            if (visitante.getIdentificacion().equalsIgnoreCase(identificacion)) {
                System.out.print("Nuevo nombre: ");
                visitante.setNombre(scanner.nextLine());
                System.out.print("Nuevo correo: ");
                visitante.setCorreo(scanner.nextLine());
                System.out.println("Visitante actualizado con éxito.");
                return;
            }
        }
        System.out.println("Visitante no encontrado.");
    }

    public void eliminarVisitante() {
        System.out.print("Ingrese la identificación del visitante a eliminar: ");
        String identificacion = scanner.nextLine();
        visitantes.removeIf(visitante -> visitante.getIdentificacion().equalsIgnoreCase(identificacion));
        System.out.println("Visitante eliminado si existía.");
    }

    public void visitarStand() {
        System.out.print("Ingrese la identificación del visitante: ");
        String identificacion = scanner.nextLine();
        Visitante visitante = visitantes.stream()
                .filter(v -> v.getIdentificacion().equalsIgnoreCase(identificacion))
                .findFirst().orElse(null);
        if (visitante == null) {
            System.out.println("Visitante no encontrado.");
            return;
        }

        System.out.print("Ingrese el número del stand que desea visitar: ");
        int numeroStand = scanner.nextInt();
        scanner.nextLine();
        Stand stand = stands.stream().filter(s -> s.getNumero() == numeroStand).findFirst().orElse(null);
        if (stand == null) {
            System.out.println("Stand no encontrado.");
            return;
        }

        System.out.print("Ingrese su comentario: ");
        String comentario = scanner.nextLine();
        System.out.print("Ingrese su calificación (1-5): ");
        int calificacion = scanner.nextInt();
        scanner.nextLine();
        visitante.visitarStand(stand, comentario, calificacion);
        System.out.println("Comentario y calificación registrados con éxito.");
    }
     public void editarEmpresa() {
        System.out.print("Ingrese el nombre de la empresa a editar: ");
        String nombre = scanner.nextLine();
        for (Empresa empresa : empresas) {
            if (empresa.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Nuevo nombre: ");
                empresa.setNombre(scanner.nextLine());
                System.out.print("Nuevo sector: ");
                empresa.setSector(scanner.nextLine());
                System.out.print("Nuevo correo: ");
                empresa.setCorreo(scanner.nextLine());
                System.out.println("Empresa actualizada con éxito.");
                return;
            }
        }
        System.out.println("Empresa no encontrada.");
    }

    public void eliminarEmpresa() {
        System.out.print("Ingrese el nombre de la empresa a eliminar: ");
        String nombre = scanner.nextLine();
        empresas.removeIf(empresa -> empresa.getNombre().equalsIgnoreCase(nombre));
        System.out.println("Empresa eliminada si existía.");
    }
    
   public void generarReportes() {
        System.out.println("\nReporte de Empresas y Stands Asignados:");
        for (Stand stand : stands) {
            if (stand.getEmpresa() != null) {
                System.out.println("Stand " + stand.getNumero() + " - " + stand.getUbicacion() + " | Empresa: " + stand.getEmpresa().getNombre());
            }
        }

        System.out.println("\nReporte de Visitantes y Stands Visitados:");
        for (Visitante visitante : visitantes) {
            System.out.println("Visitante: " + visitante.getNombre() + " - Stands Visitados: " + visitante.getStandsVisitados());
        }

        System.out.println("\nReporte de Calificación Promedio por Stand:");
        for (Stand stand : stands) {
            System.out.println("Stand " + stand.getNumero() + " - Calificación Promedio: " + stand.obtenerCalificacionPromedio());
        }
    }

     public void iniciar() {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar Empresa");
            System.out.println("2. Editar Empresa");
            System.out.println("3. Eliminar Empresa");
            System.out.println("4. Listar Stands Disponibles");
            System.out.println("5. Registrar Visitante");
            System.out.println("6. Editar Visitante");
            System.out.println("7. Eliminar Visitante");
            System.out.println("8. Visitar Stand");
            System.out.println("9. Generar Reportes");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarEmpresa();
                case 2 -> editarEmpresa();
                case 3 -> eliminarEmpresa();
                case 4 -> listarStandsDisponibles();
                case 5 -> registrarVisitante();
                case 6 -> editarVisitante();
                case 7 -> eliminarVisitante();
                case 8 -> visitarStand();
                case 9 -> generarReportes();
                case 10 -> { return; }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    public static void main(String[] args) {
        FeriaEmpresarial feria = new FeriaEmpresarial();
        feria.iniciar();
    }
}

