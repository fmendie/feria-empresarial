/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package feriaempresarial;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pipe7
 */
 class Visitante {
    private String nombre;
    private String identificacion;
    private String correo;
    private List<Integer> standsVisitados;

    public Visitante(String nombre, String identificacion, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.standsVisitados = new ArrayList<>();
    }

    public void visitarStand(Stand stand, String comentario, int calificacion) {
        stand.agregarComentario(new Comentario(this.nombre, comentario, calificacion));
        standsVisitados.add(stand.getNumero());
    }

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
    public String getCorreo() { return correo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public List<Integer> getStandsVisitados() { return standsVisitados; }
}



