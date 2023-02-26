
package com.app.productos.modelo;

public class Empleado extends Usuario{
    private int id;
    private String dni;
    private String nombres;
    private String correo;

    public Empleado() {
    }

    public Empleado(int id, String dni, String nombres, String correo, String user, String perfil) {
        super(user, perfil);
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
