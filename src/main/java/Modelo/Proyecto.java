package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Proyecto implements Serializable{
    private String id;
    private String nombre;
    private String presupuesto;
    private String codigoProducto;
    private ArrayList<String> dnis;

    public Proyecto() {
    }

    public Proyecto(String id, String nombre, String presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;

    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getPresupuesto() {
        return presupuesto;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public ArrayList<String> getDnis() {
        return dnis;
    }

    public void setDnis(String dni) {
        this.dnis.add(dni);
    }
}

