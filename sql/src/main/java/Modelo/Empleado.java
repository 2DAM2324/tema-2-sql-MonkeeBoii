package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empleado implements Serializable {

    private Integer Codigo;
    private String dni;
    private String nombre;
    private List<Integer> codigoProyecto;

    public Empleado() {
        this.codigoProyecto = new ArrayList<>();
    }

    public Empleado(Integer Codigo, String dni, String nombre) {
        this.Codigo = Codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.codigoProyecto = new ArrayList<>();
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        this.codigoProyecto.add(codigoProyecto);
    }

}
