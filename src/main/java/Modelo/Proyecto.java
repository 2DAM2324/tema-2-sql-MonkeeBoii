package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Proyecto implements Serializable{
    private int id;
    private String nombre;
    private int presupuesto;
    private int codigoProducto;
    private ArrayList<String> dnis;

    public Proyecto() {
    }

    public Proyecto(int id, String nombre, int presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;

    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getPresupuesto() {
        return presupuesto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public ArrayList<String> getDnis() {
        return dnis;
    }

    public void setDnis(String dni) {
        this.dnis.add(dni);
    }
}

