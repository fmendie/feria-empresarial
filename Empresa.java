/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package feriaempresarial;

/**
 *
 * @author pipe7
 */
class Empresa {
    private String nombre;
    private String sector;
    private String correo;

    public Empresa(String nombre, String sector, String correo) {
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }
    public String getSector() { return sector; }
    public String getCorreo() { return correo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSector(String sector) { this.sector = sector; }
    public void setCorreo(String correo) { this.correo = correo; }
}
