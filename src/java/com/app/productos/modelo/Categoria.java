
package com.app.productos.modelo;

public class Categoria {
    private int idcat;
    private String categoria;
    private String estadocat;

    public Categoria() {
    }

    public Categoria(int idcat, String categoria, String estadocat) {
        this.idcat = idcat;
        this.categoria = categoria;
        this.estadocat = estadocat;
    }

    public Categoria(String categoria, String estadocat) {
        this.categoria = categoria;
        this.estadocat = estadocat;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

   
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstadocat() {
        return estadocat;
    }

    public void setEstadocat(String estadocat) {
        this.estadocat = estadocat;
    }

  
    
}
