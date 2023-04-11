package com.example.DisfracesFront.models;

import java.util.Date;

public class Alquiler {

    private Long id_alquiler;
    private Cliente cliente;
    private Disfraz disfraz;

    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private String comentarios_alquiler;
    private Integer cantidad_disfraces;
    private double total_alquiler;

    public Alquiler(Long id_alquiler, Cliente cliente, Disfraz disfraz, Date fecha_prestamo, Date fecha_devolucion, String comentarios_alquiler, Integer cantidad_disfraces, double total_alquiler) {
        this.id_alquiler = id_alquiler;
        this.cliente = cliente;
        this.disfraz = disfraz;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.comentarios_alquiler = comentarios_alquiler;
        this.cantidad_disfraces = cantidad_disfraces;
        this.total_alquiler = total_alquiler;
    }

    public Alquiler() {
    }

    public Long getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(Long id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Disfraz getDisfraz() {
        return disfraz;
    }

    public void setDisfraz(Disfraz disfraz) {
        this.disfraz = disfraz;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getComentarios_alquiler() {
        return comentarios_alquiler;
    }

    public void setComentarios_alquiler(String comentarios_alquiler) {
        this.comentarios_alquiler = comentarios_alquiler;
    }

    public Integer getCantidad_disfraces() {
        return cantidad_disfraces;
    }

    public void setCantidad_disfraces(Integer cantidad_disfraces) {
        this.cantidad_disfraces = cantidad_disfraces;
    }

    public double getTotal_alquiler() {
        return total_alquiler;
    }

    public void setTotal_alquiler(double total_alquiler) {
        this.total_alquiler = total_alquiler;
    }
}
