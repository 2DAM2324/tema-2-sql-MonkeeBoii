package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    private Integer codigo;
    private String nombre;
    private Integer presupuesto;
    private Integer codigoProducto;
    private List<Integer> codigoEmpleado;

    public Proyecto() {
        this.codigoEmpleado = new ArrayList<>();
    }

    public Proyecto(Integer id, String nombre, Integer presupuesto) {
        this.codigo = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.codigoEmpleado = new ArrayList<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public List<Integer> getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setCodigoEmpleado(Integer codigoEmpleado) {
        this.codigoEmpleado.add(codigoEmpleado);
    }
}
