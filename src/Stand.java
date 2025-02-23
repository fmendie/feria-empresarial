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
class Stand {
    private int numero;
    private String ubicacion;
    private String tamano;
    private Empresa empresa;
    private List<Comentario> comentarios;

    public Stand(int numero, String ubicacion, String tamano) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tamano = tamano;
        this.comentarios = new ArrayList<>();
    }

    public void asignarEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void agregarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public double obtenerCalificacionPromedio() {
        if (comentarios.isEmpty()) return 0;
        return comentarios.stream().mapToInt(Comentario::getCalificacion).average().orElse(0);
    }

    public int getNumero() { return numero; }
    public String getUbicacion() { return ubicacion; }
    public String getTamano() { return tamano; }
    public Empresa getEmpresa() { return empresa; }
    public List<Comentario> getComentarios() { return comentarios; }
    public boolean estaOcupado() { return empresa != null; }
}
