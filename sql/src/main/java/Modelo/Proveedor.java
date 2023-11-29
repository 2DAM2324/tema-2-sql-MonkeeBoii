package Modelo;

public class Proveedor{
    
    private Integer codigoProveedor;
    private String nombreProveedor;
    private Integer productoProveedor;

    public Proveedor(){
        productoProveedor = null;
    }

    public Proveedor(Integer codigoProveedor, String nombreProveedor){
        this.codigoProveedor = codigoProveedor;
        this.nombreProveedor = nombreProveedor;
        productoProveedor = null;
    }

    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setProductoProveedor(Integer productoProveedor) {
        this.productoProveedor = productoProveedor;
    }

    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public Integer getProductoProveedor() {
        return productoProveedor;
    }
    
}
