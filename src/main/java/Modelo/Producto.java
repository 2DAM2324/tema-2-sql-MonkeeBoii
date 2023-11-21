package Modelo;
import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable {
    
    private int codigoProductos;
    private String nombreProductos;
    private int precio;
    private int proveedorProducto;
    private ArrayList<Integer> proyectosProducto;

    public Producto(){
        this.proyectosProducto = new ArrayList<>();
    }

    // Constructor por parametro
    public Producto(int codigo, String nombre, int precio){

        this.nombreProductos = nombre;
        this.codigoProductos = codigo;
        this.precio = precio;
        this.proyectosProducto = new ArrayList<>();
    }

    //SET

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public void setCodigoProductos(int codigoProductos) {
        this.codigoProductos = codigoProductos;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setProveedorProducto(int proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    public void setProyectosProducto(ArrayList<Integer> proyectosProducto) {
        this.proyectosProducto = proyectosProducto;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public int getCodigoProductos() {
        return codigoProductos;
    }

    public int getPrecio() {
        return precio;
    }

    public int getProveedorProducto() {
        return proveedorProducto;
    }

    public ArrayList<Integer> getProyectosProducto() {
        return proyectosProducto;
    }
    
    public void agregarProyecto(Integer a){
        this.proyectosProducto.add(a);
    }

}
