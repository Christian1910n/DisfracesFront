package com.example.DisfracesFront.models;

public class Disfraz {

    private Long id_disfraz;
    private String codigo;
    private String descripcion_disfraz;
    private Double precio_alquiler;
    private String tipo_disfraz;

    public Disfraz(Long id_disfraz, String codigo, String descripcion_disfraz, Double precio_alquiler, String tipo_disfraz) {
        this.id_disfraz = id_disfraz;
        this.codigo = codigo;
        this.descripcion_disfraz = descripcion_disfraz;
        this.precio_alquiler = precio_alquiler;
        this.tipo_disfraz = tipo_disfraz;
    }

    public Disfraz() {
    }

    public Long getId_disfraz() {
        return id_disfraz;
    }

    public void setId_disfraz(Long id_disfraz) {
        this.id_disfraz = id_disfraz;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion_disfraz() {
        return descripcion_disfraz;
    }

    public void setDescripcion_disfraz(String descripcion_disfraz) {
        this.descripcion_disfraz = descripcion_disfraz;
    }

    public Double getPrecio_alquiler() {
        return precio_alquiler;
    }

    public void setPrecio_alquiler(Double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }

    public String getTipo_disfraz() {
        return tipo_disfraz;
    }

    public void setTipo_disfraz(String tipo_disfraz) {
        this.tipo_disfraz = tipo_disfraz;
    }
}
