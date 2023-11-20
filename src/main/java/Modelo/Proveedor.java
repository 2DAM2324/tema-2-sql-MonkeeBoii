package Modelo;

import java.io.Serializable;

public class Proveedor implements Serializable{
    
    private String codigoProveedor;
    private String nombreProveedor;
    private String codigoProducto;

    public Proveedor(){
    }

    public Proveedor(String codigoProveedor, String nombreProveedor){

        this.codigoProveedor = codigoProveedor;
        this.nombreProveedor = nombreProveedor;
    }

    //SET 

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    //GET
    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }
    
}
