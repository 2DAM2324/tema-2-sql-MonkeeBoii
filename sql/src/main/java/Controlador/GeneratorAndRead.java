package Controlador;

import Modelo.Empleado;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GeneratorAndRead {

    public GeneratorAndRead() {
    }

    public void conectarBaseDatosEmpleados() {

    }

    public void cargarDatosEnJTableEmpleados(List<Empleado> empleados, JTable tablaEmpleados) {
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
        modelo.setRowCount(0); // Limpia las filas existentes en el modelo

        for (Empleado empleado : empleados) {
            Integer codigo = empleado.getCodigo();
            String dni = empleado.getDni();
            String nombre = empleado.getNombre();

            modelo.addRow(new Object[]{codigo, dni, nombre});
        }

        // Asigna el modelo actualizado a la tabla
        tablaEmpleados.setModel(modelo);
    }

    public void cargarDatosEnJTableProyectos(List<Proyecto> proyectos, JTable tablaProyecto) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProyecto.getModel();
        modelo.setRowCount(0);

        for (Proyecto proyecto : proyectos) {
            Integer Codigo = proyecto.getCodigo();
            String nombre = proyecto.getNombre();
            Integer presupuesto = proyecto.getPresupuesto();

            modelo.addRow(new Object[]{Codigo, nombre, presupuesto});
        }

        tablaProyecto.setModel(modelo);
    }

    public void cargarDatosEnJTableProductos(List<Producto> productos, JTable tablaProducto) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProducto.getModel();
        modelo.setRowCount(0);
        if (productos != null) {
            for (Producto producto : productos) {
                Integer Codigo = producto.getCodigo();
                String nombre = producto.getNombre();
                Integer precio = producto.getPrecio();
                modelo.addRow(new Object[]{Codigo, nombre, precio});
            }
        }

        tablaProducto.setModel(modelo);
    }

    public void cargarDatosEnJTableProductos(Producto producto, JTable tablaProducto) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProducto.getModel();
        modelo.setRowCount(0);
        if (producto != null) {
            Integer Codigo = producto.getCodigo();
            String nombre = producto.getNombre();
            Integer precio = producto.getPrecio();
            modelo.addRow(new Object[]{Codigo, nombre, precio});

        }

        tablaProducto.setModel(modelo);
    }

    public void cargarDatosEnJTableProveedores(List<Proveedor> proveedores, JTable tablaProveedores) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();
        modelo.setRowCount(0);

        for (Proveedor proveedor : proveedores) {
            Integer codigoProveedor = proveedor.getCodigoProveedor();
            String nombreProveedor = proveedor.getNombreProveedor();

            modelo.addRow(new Object[]{codigoProveedor, nombreProveedor});
        }

        tablaProveedores.setModel(modelo);
    }

    public void eliminarFilaSeleccionada(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            modelo.removeRow(filaSeleccionada);

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Empleado modificarEmpleado(String Dni, String Nombre, JTable tabla, ArrayList<Empleado> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();

            for (Empleado empleado : lista) {
                if (empleado.getDni().equals(valor1)) {
                    empleado.setDni(Dni);
                    empleado.setNombre(Nombre);
                    return empleado;
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean generarCamposVistaEmpleado(JTextField dni, JTextField nombre, JTable tabla) {
        boolean a = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            String valor2 = modelo.getValueAt(filaSeleccionada, 1).toString();

            dni.setText(valor1);
            nombre.setText(valor2);
            a = true;
        }
        return a;
    }

    public void resetearCamposEmpleado(JTextField dni, JTextField nombre) {
        dni.setText("");
        nombre.setText("");
    }

    public Proyecto modificarProyecto(Integer id, String Nombre, Integer Presupuesto, JTable tabla, ArrayList<Proyecto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();

            for (Proyecto proyecto : lista) {
                if (proyecto.getCodigo().equals(valor1)) {
                    proyecto.setCodigo(id);
                    proyecto.setNombre(Nombre);
                    proyecto.setPresupuesto(Presupuesto);
                    return proyecto;
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean generarCamposVistaProyecto( JTextField nombre, JTextField presupuesto, JTable tabla) {
        boolean a = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {

            String valor2 = modelo.getValueAt(filaSeleccionada, 1).toString();
            String valor3 = modelo.getValueAt(filaSeleccionada, 2).toString();

            nombre.setText(valor2);
            presupuesto.setText(valor3);
            a = true;
        }
        return a;
    }

    public void resetearCamposProyecto(JTextField nombre, JTextField presupuesto) {
        nombre.setText("");
        presupuesto.setText("");
    }

    public Producto modificarProductos(Integer id, String Nombre, Integer Precio, JTable tabla, ArrayList<Producto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();

            for (Producto producto : lista) {
                if (producto.getCodigo().equals(valor1)) {
                    producto.setCodigo(id);
                    producto.setNombre(Nombre);
                    producto.setPrecio(Precio);
                    return producto;
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean generarCamposVistaProducto(JTextField nombre, JTextField precio, JTable tabla) {
        boolean a = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valor2 = modelo.getValueAt(filaSeleccionada, 1).toString();
            String valor3 = modelo.getValueAt(filaSeleccionada, 2).toString();

            nombre.setText(valor2);
            precio.setText(valor3);
            a = true;
        }
        return a;
    }

    public void resetearCamposProducto(JTextField nombre, JTextField presupuesto) {
        nombre.setText("");
        presupuesto.setText("");
    }

    public Proveedor modificarProveedores(Integer idProveedor, String Nombre, JTable tabla, ArrayList<Proveedor> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();

            for (Proveedor proveedor : lista) {
                if (proveedor.getCodigoProveedor().equals(valor1)) {
                    proveedor.setCodigoProveedor(idProveedor);
                    proveedor.setNombreProveedor(Nombre);
                    return proveedor;
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean generarCamposVistaProveedor(JTextField id, JTextField nombre, JTable tabla) {
        boolean a = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valor1 = modelo.getValueAt(filaSeleccionada, 0).toString();
            String valor2 = modelo.getValueAt(filaSeleccionada, 1).toString();

            id.setText(valor1);
            nombre.setText(valor2);
            a = true;
        }
        return a;
    }

    public void resetearCamposProveedor(JTextField nombre) {
        nombre.setText("");
    }

    public Proyecto buscarObjetoEnArrayProyecto(Integer id, ArrayList<Proyecto> proyectos) {
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el codigo del proyecto que quiere añadir", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        for (Proyecto proyecto : proyectos) {
            if (proyecto.getCodigo().equals(id)) {
                return proyecto;
            }
        }
        return null;
    }

    public Empleado buscarObjetoEnArrayEmpleado(Integer id, ArrayList<Empleado> empleados) {
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el codigo del empleado que quiere añadir", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        for (Empleado empleado : empleados) {
            if (empleado.getCodigo().equals(id)) {
                return empleado;
            }
        }
        return null;

    }

    public Producto buscarObjetoEnArrayProducto(Integer id, ArrayList<Producto> productos) {
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el id que quiere añadir", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(id)) {
                return producto;
            }
        }
        return null;

    }

    public Proveedor buscarObjetoEnArrayProveedor(Integer id, ArrayList<Proveedor> proveedores) {
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el id que quiere añadir", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCodigoProveedor().equals(id)) {
                return proveedor;
            }
        }
        return null;

    }

    public void anadirProyectoAEmpleado(ArrayList<Proyecto> proyectos, Proyecto proyecto) {
        boolean proyectoExistente = false;
        for (Proyecto proyecto1 : proyectos) {
            if (proyecto1.getCodigo().equals(proyecto.getCodigo())) {
                proyectoExistente = true;
                break;
            }
        }
        if (proyecto == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Introduce un proyecto existente.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (proyectoExistente) {
            JOptionPane.showMessageDialog(null, "Por favor, No puedes añadir un mismo proyecto al empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Añadir el proyecto a la lista
            proyectos.add(proyecto);
        }

    }

    public void anadirEmpleadoAProyecto(ArrayList<Empleado> empleados, Empleado empleado) {

        boolean empleadoExistente = false;
        for (Empleado empleado1 : empleados) {
            if (empleado1.getDni().equals(empleado.getDni())) {
                empleadoExistente = true;
                break;
            }
        }
        if (empleado == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Introduce un proyecto existente.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (empleadoExistente) {
            JOptionPane.showMessageDialog(null, "Por favor, No puedes añadir un mismo proyecto al empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Añadir el proyecto a la lista
            empleados.add(empleado);
        }

    }

    public void anadirProyectoAProducto(List<Proyecto> proyectos, Proyecto proyecto) {

        boolean empleadoExistente = false;
        for (Proyecto proyecto1 : proyectos) {
            if (proyecto1.getCodigo().equals(proyecto.getCodigo())) {
                empleadoExistente = true;
                break;
            }
        }
        if (proyecto == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Introduce un proyecto existente.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (empleadoExistente) {
            JOptionPane.showMessageDialog(null, "Por favor, No puedes añadir un mismo proyecto al empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Añadir el proyecto a la lista
            proyectos.add(proyecto);
        }
    }

    public void anadirProductoAProyecto(Proyecto productoDelProyecto, Producto producto) {
        if (productoDelProyecto == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un producto del proyecto existente.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (producto == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (productoDelProyecto.getCodigoProducto().equals(producto.getCodigo())) {
            JOptionPane.showMessageDialog(null, "No puedes añadir el mismo producto al proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            productoDelProyecto.setCodigoProducto(producto.getCodigo());

        }
    }

    public void eliminarProyecto(ArrayList<Proyecto> proyectos, Integer id) {
        if (proyectos != null) {
            Iterator<Proyecto> iterator = proyectos.iterator();
            while (iterator.hasNext()) {
                Proyecto proyecto = iterator.next();
                if (proyecto.getCodigo().equals(id)) {
                    iterator.remove(); // Removes the current element from the list
                }
            }
        }
    }

    public void eliminarEmpleadoEnProyecto(ArrayList<Empleado> empleados, String id) {
        if (empleados != null) {
            Iterator<Empleado> iterator = empleados.iterator();
            while (iterator.hasNext()) {
                Empleado empleado = iterator.next();
                if (empleado.getDni().equals(id)) {
                    iterator.remove(); // Removes the current element from the list
                }
            }
        }
    }

    public void eliminarProductoEnProveedor(Producto productos, Integer id) {
        if (productos != null) {
            if (productos.getCodigo().equals(id)) {
                productos.setCodigo(null);
                productos.setNombre("");
                productos.setPrecio(null);
            }

        }
    }

    public void eliminarProductoEnProveedor(Proveedor proveedor, Integer id) {
        if (proveedor != null) {
            if (proveedor.getCodigoProveedor().equals(id)) {
                proveedor.setCodigoProveedor(null);
                proveedor.setNombreProveedor("");
            }
        }
    }

    public void anadirProveedorAProducto(Proveedor b, Producto a) {
        if (b == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un proveedor valido", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (a == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (b.getProductoProveedor().equals(a.getCodigo())) {
            JOptionPane.showMessageDialog(null, "No puedes añadir el mismo producto al proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            b.setProductoProveedor(a.getCodigo());

        }
    }

    public void anadirProveedorAProducto(Producto a, Proveedor b) {
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un proveedor valido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (b == null) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (a.getCodigoProveedor().equals(b.getCodigoProveedor())) {
            JOptionPane.showMessageDialog(null, "No puedes añadir el mismo producto al proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            a.setCodigoProveedor(b.getCodigoProveedor());
        }
    }

    public boolean comprobarSiElObjetoYaExisteProducto(ArrayList<Producto> lista, Integer id) {
        for (Producto objeto : lista) {
            if (objeto.getCodigo().equals(id)) {
                JOptionPane.showMessageDialog(null, "Por favor, No puedes Introducir Producto con el mismo ID", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean comprobarSiElObjetoYaExisteEmpleado(ArrayList<Empleado> lista, String id) {
        for (Empleado objeto : lista) {
            if (objeto.getDni().equals(id)) {
                JOptionPane.showMessageDialog(null, "Por favor, No puedes Introducir Empleados con el mismo DNI.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean comprobarSiElObjetoYaExisteProyecto(ArrayList<Proyecto> lista, Integer id) {
        for (Proyecto objeto : lista) {
            if (objeto.getCodigo().equals(id)) {
                JOptionPane.showMessageDialog(null, "Por favor, No puedes Introducir Proyecto con el mismo ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean comprobarSiElObjetoYaExisteProveedor(ArrayList<Proveedor> lista, String id) {
        for (Proveedor objeto : lista) {
            if (objeto.getCodigoProveedor().equals(id)) {
                JOptionPane.showMessageDialog(null, "Por favor, No puedes Introducir Proveedor con el mismo ID", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean tieneAlgunAtributoVacio(String b, String c) {

        if (b != null && c != null) {
            if (b.isBlank() || c.isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !b.isBlank() && !c.isBlank();
        } else if (b != null && c == null) {
            if (b.isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !b.isBlank();
        } else if (b != null && c != null) {
            if (b.isBlank() || c.isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !b.isBlank() && !c.isBlank();
        } else if (b == null && c != null) {
            if (c.isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !c.isBlank();
        } else if (b == null && c != null) {
            if (c.isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !c.isBlank();
        } else if (b != null && c == null) {
            if (b.isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return !b.isBlank();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, No puede contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean comprobarSiHayRelacionesEnELObjeto(Empleado a) {
        if (a.getCodigoProyecto() == null) {
            return true;
        } else if (a.getCodigoProyecto().isEmpty()) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Por favor, No puedes eliminar un Empleado con relaciones.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean comprobarSiHayRelacionesEnELObjeto(Proyecto a) {
        if (a.getCodigoEmpleado() == null && a.getCodigoProducto() == null) {
            return true;
        } else if ((a.getCodigoEmpleado().isEmpty())) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Por favor, No puedes eliminar un Proyecto con relaciones.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean comprobarSiHayRelacionesEnELObjeto(Producto a) {
        if (a.getCodigoProyectos() == null && a.getCodigoProveedor() == null) {
            return true;
        } else if ((a.getCodigoProyectos().isEmpty())) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Por favor, No puedes eliminar un Producto con relaciones.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean comprobarSiHayRelacionesEnELObjeto(Proveedor a) {
        if (a.getProductoProveedor() == null) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Por favor, No puedes eliminar un Proveedor con relaciones." + a.getProductoProveedor(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
