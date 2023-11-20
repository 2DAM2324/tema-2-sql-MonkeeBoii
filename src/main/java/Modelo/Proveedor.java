package Modelo;

import java.io.Serializable;

public class Proveedor implements Serializable{
    
    private int codigoProveedor;
    private String nombreProveedor;
    private String codigoProducto;

    public Proveedor(){
    }

    public Proveedor(int codigoProveedor, String nombreProveedor){

        this.codigoProveedor = codigoProveedor;
        this.nombreProveedor = nombreProveedor;
    }
    
    //SET 

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    //GET
    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }
    
}
