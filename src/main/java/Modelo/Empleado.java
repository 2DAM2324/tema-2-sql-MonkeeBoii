package Modelo;

import java.io.Serializable;
import java.util.ArrayList;


public class Empleado implements Serializable {
    
    private int codigo;
    private String dni;
    private String nombre;
    private ArrayList<Integer> codigoProyecto;

    public Empleado() {
        codigoProyecto = new ArrayList<>();
    }

    public Empleado(int codigo, String id, String nombre) {
        this.codigo = codigo;
        this.dni = id;
        this.nombre = nombre;
        codigoProyecto = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getProyectosAsignados() {
        return codigoProyecto;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarProyecto(Integer a){
        this.codigoProyecto.add(a);
    }
}
