/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package feriaempresarial;

import java.util.Date;

/**
 *
 * @author pipe7
 */
class Comentario {
    private String nombreVisitante;
    private String comentario;
    private int calificacion;
    private Date fecha;

    public Comentario(String nombreVisitante, String comentario, int calificacion) {
        this.nombreVisitante = nombreVisitante;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fecha = new Date();
    }

    public int getCalificacion() { return calificacion; }
}

