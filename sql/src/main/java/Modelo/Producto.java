package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Producto implements Serializable {

    private Integer codigo;
    private String nombre;
    private Integer precio;
    private Integer codigoProveedor;
    private List<Integer> codigoProyectos;

    public Producto() {
        this.codigoProyectos = new ArrayList<>();
    }

    public Producto(Integer codigo, String nombre, Integer precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigoProyectos = new ArrayList<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public List<Integer> getCodigoProyectos() {
        return codigoProyectos;
    }

    public Integer getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public void setCodigoProveedor(Integer codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setCodigoProyectos(Integer codigoProyectos) {
        this.codigoProyectos.add(codigoProyectos);
    }

}
