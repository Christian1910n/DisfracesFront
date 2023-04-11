package com.example.DisfracesFront.models;

import com.example.DisfracesFront.validation.Requerido;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Cliente {
    private Long id_cliente;

    @NotEmpty
    @Size(min=10, max=10, message = "Cedula Invalida")
    @Pattern(regexp = "[0-9]{10}")
    private String cedula;

    @NotEmpty
    private String nombres_cliente;

    @NotEmpty
    private String apellidos_cliente;

    @NotEmpty
    private String direccion_cliente;

    @Email
    private String correo;

    @Requerido
    private int edad;


    private Boolean estado_cliente;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fecha_nacimiento;

    public Cliente(Long id_cliente, String cedula, String nombres_cliente, String apellidos_cliente, String direccion_cliente, String correo, int edad, Boolean estado_cliente, Date fecha_nacimiento) {
        this.id_cliente = id_cliente;
        this.cedula = cedula;
        this.nombres_cliente = nombres_cliente;
        this.apellidos_cliente = apellidos_cliente;
        this.direccion_cliente = direccion_cliente;
        this.correo = correo;
        this.edad = edad;
        this.estado_cliente = estado_cliente;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Cliente(Long id_cliente, String cedula, String nombres_cliente, String apellidos_cliente, String direccion_cliente, String correo, int edad, Boolean estado_cliente) {
        this.id_cliente = id_cliente;
        this.cedula = cedula;
        this.nombres_cliente = nombres_cliente;
        this.apellidos_cliente = apellidos_cliente;
        this.direccion_cliente = direccion_cliente;
        this.correo = correo;
        this.edad = edad;
        this.estado_cliente = estado_cliente;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cliente() {
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres_cliente() {
        return nombres_cliente;
    }

    public void setNombres_cliente(String nombres_cliente) {
        this.nombres_cliente = nombres_cliente;
    }

    public String getApellidos_cliente() {
        return apellidos_cliente;
    }

    public void setApellidos_cliente(String apellidos_cliente) {
        this.apellidos_cliente = apellidos_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public Boolean getEstado_cliente() {
        return estado_cliente;
    }

    public void setEstado_cliente(Boolean estado_cliente) {
        this.estado_cliente = estado_cliente;
    }
}
