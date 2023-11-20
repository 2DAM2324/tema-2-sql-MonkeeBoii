package Modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Producto implements Serializable {
    
    private String codigoProductos;
    private String nombreProductos;
    private int precio;
    private String proveedorProducto;
    private ArrayList<String> proyectosProducto;

    public Producto(){
        this.proyectosProducto = new ArrayList<>();
    }

    // Constructor por parametro
    public Producto(String codigo, String nombre, int precio){

        this.nombreProductos = nombre;
        this.codigoProductos = codigo;
        this.precio = precio;
        this.proyectosProducto = new ArrayList<>();
    }

    //SET

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public void setCodigoProductos(String codigoProductos) {
        this.codigoProductos = codigoProductos;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setProveedorProducto(String proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    public void setProyectosProducto(ArrayList<String> proyectosProducto) {
        this.proyectosProducto = proyectosProducto;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public String getCodigoProductos() {
        return codigoProductos;
    }

    public int getPrecio() {
        return precio;
    }

    public String getProveedorProducto() {
        return proveedorProducto;
    }

    public ArrayList<String> getProyectosProducto() {
        return proyectosProducto;
    }
    
    public void agregarProyecto(String a){
        this.proyectosProducto.add(a);
    }

}
