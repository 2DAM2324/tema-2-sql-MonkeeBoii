package Vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;
import org.xml.sax.SAXException;
import Modelo.Empleado;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Proyecto;
import Controlador.GeneratorAndRead;
import Modelo.Conector;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventana1 extends javax.swing.JFrame {

    GeneratorAndRead generador = new GeneratorAndRead();
    Conector conector = new Conector("BaseDeDatos.db3");
    boolean continuar = false;

    public Ventana1() throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException {
        initComponents();
        empleados = (ArrayList<Empleado>) conector.consultarBaseDatosEmpleado(conector.conectorBaseDatos());
        generador.cargarDatosEnJTableEmpleados(empleados, jTable_Empleado);

        proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
        generador.cargarDatosEnJTableProyectos(proyectos, jTable_Proyectos);

        productos = (ArrayList<Producto>) conector.consultarBaseDatosProducto(conector.conectorBaseDatos());
        generador.cargarDatosEnJTableProductos(productos, jTable_Productos);

        proveedor = (ArrayList<Proveedor>) conector.consultarBaseDatosProveedor(conector.conectorBaseDatos());
        generador.cargarDatosEnJTableProveedores(proveedor, jTable_Proveedores);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Proyectos1 = new javax.swing.JTable();
        jScrollBar1 = new javax.swing.JScrollBar();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel_ciudad = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Empleado = new javax.swing.JTable();
        jButton_anadir_empleados = new javax.swing.JButton();
        jButton_modificar_Empleado = new javax.swing.JButton();
        jButton_borrar_Empleados = new javax.swing.JButton();
        jLabel_nombre_ciudad = new javax.swing.JLabel();
        jLabel_pais = new javax.swing.JLabel();
        jTextField_dni_Empleado = new javax.swing.JTextField();
        jTextField_Nombre_Empleado = new javax.swing.JTextField();
        jButton_guardar_empleado = new javax.swing.JButton();
        jButton_cancelar_Empleado = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        texto_relacion_empleados = new javax.swing.JTextField();
        anadir_relacion_Empleado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Eliminar_relacion_empleados = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_Proyectos_Empleados_Relacion = new javax.swing.JTable();
        jPanel_biblioteca = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Proyectos = new javax.swing.JTable();
        jLabel_telefono = new javax.swing.JLabel();
        jLabel_direccion = new javax.swing.JLabel();
        jTextField_Nombre_Proyectos = new javax.swing.JTextField();
        jTextField_Presupuesto_Proyecto = new javax.swing.JTextField();
        jButton_guardar_biblioteca = new javax.swing.JButton();
        jButton_cancelar_biblioteca = new javax.swing.JButton();
        jButton_anadir_proyectos = new javax.swing.JButton();
        jButton_modificar_Proyectos = new javax.swing.JButton();
        jButton_borrar_Proyecto = new javax.swing.JButton();
        jLabel_ciudades_bibliotecas = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        texto_codigo_producto = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        texto_relacion_proyecto_empleado = new javax.swing.JTextField();
        boton_relacion_proyecto_empleado = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla_relacion_proyecto_empleado = new javax.swing.JTable();
        Eliminar_relacion_empleados1 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabla_producto_relacion = new javax.swing.JTable();
        Eliminar_relacion_empleados3 = new javax.swing.JButton();
        jPanel_libro = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Productos = new javax.swing.JTable();
        jLabel_autor = new javax.swing.JLabel();
        jLabel_edad_recomendada = new javax.swing.JLabel();
        jTextField_precio_productos = new javax.swing.JTextField();
        jTextField_nombre_productos = new javax.swing.JTextField();
        jButton_guardar_libro = new javax.swing.JButton();
        jButton_cancelar_libro = new javax.swing.JButton();
        jButton_borrar_productos = new javax.swing.JButton();
        jButton_modificar_Productos = new javax.swing.JButton();
        jButton_anadir_productos = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable_Proyectos2 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable_Proveedores1 = new javax.swing.JTable();
        jPanel_persona = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Proveedores = new javax.swing.JTable();
        jLabel_DNI = new javax.swing.JLabel();
        jTextField_Nombre_proveedor = new javax.swing.JTextField();
        jButton_guardar_persona = new javax.swing.JButton();
        jButton_cancelar_persona = new javax.swing.JButton();
        jButton_borrar_proveedor = new javax.swing.JButton();
        jButton_modificar_Proveedores = new javax.swing.JButton();
        jButton_anadir_proveedores = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable_Productos1 = new javax.swing.JTable();
        Eliminar_relacion_empleados2 = new javax.swing.JButton();

        jTable_Proyectos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Presupuesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Proyectos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Proyectos1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_Proyectos1);
        if (jTable_Proyectos1.getColumnModel().getColumnCount() > 0) {
            jTable_Proyectos1.getColumnModel().getColumn(0).setResizable(false);
            jTable_Proyectos1.getColumnModel().getColumn(1).setResizable(false);
            jTable_Proyectos1.getColumnModel().getColumn(2).setResizable(false);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable_Empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "codigo", "DNI", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_EmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Empleado);
        if (jTable_Empleado.getColumnModel().getColumnCount() > 0) {
            jTable_Empleado.getColumnModel().getColumn(0).setResizable(false);
            jTable_Empleado.getColumnModel().getColumn(1).setResizable(false);
            jTable_Empleado.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton_anadir_empleados.setText("Añadir");
        jButton_anadir_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_anadir_empleadosActionPerformed(evt);
            }
        });

        jButton_modificar_Empleado.setText("Modificar");
        jButton_modificar_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_EmpleadoActionPerformed(evt);
            }
        });

        jButton_borrar_Empleados.setText("Borrar");
        jButton_borrar_Empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_EmpleadosActionPerformed(evt);
            }
        });

        jLabel_nombre_ciudad.setText("DNI");

        jLabel_pais.setText("Nombre");

        jTextField_dni_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_dni_EmpleadoActionPerformed(evt);
            }
        });

        jButton_guardar_empleado.setText("Guardar");
        jButton_guardar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_empleadoActionPerformed(evt);
            }
        });

        jButton_cancelar_Empleado.setText("Cancelar");
        jButton_cancelar_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_EmpleadoActionPerformed(evt);
            }
        });

        texto_relacion_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_relacion_empleadosActionPerformed(evt);
            }
        });

        anadir_relacion_Empleado.setText("Añadir Relacion");
        anadir_relacion_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadir_relacion_EmpleadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo Proyecto");

        Eliminar_relacion_empleados.setText("Eliminar Relacion");
        Eliminar_relacion_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_relacion_empleadosActionPerformed(evt);
            }
        });

        jTable_Proyectos_Empleados_Relacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Presupuesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Proyectos_Empleados_Relacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Proyectos_Empleados_RelacionMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable_Proyectos_Empleados_Relacion);
        if (jTable_Proyectos_Empleados_Relacion.getColumnModel().getColumnCount() > 0) {
            jTable_Proyectos_Empleados_Relacion.getColumnModel().getColumn(0).setResizable(false);
            jTable_Proyectos_Empleados_Relacion.getColumnModel().getColumn(1).setResizable(false);
            jTable_Proyectos_Empleados_Relacion.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel_ciudadLayout = new javax.swing.GroupLayout(jPanel_ciudad);
        jPanel_ciudad.setLayout(jPanel_ciudadLayout);
        jPanel_ciudadLayout.setHorizontalGroup(
            jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_nombre_ciudad)
                            .addComponent(jLabel_pais))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_dni_Empleado, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                            .addComponent(jTextField_Nombre_Empleado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_cancelar_Empleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_guardar_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_Empleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_anadir_empleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_Empleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(texto_relacion_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(anadir_relacion_Empleado))
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eliminar_relacion_empleados)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel_ciudadLayout.setVerticalGroup(
            jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_anadir_empleados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_Empleados))
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_nombre_ciudad)
                            .addComponent(jTextField_dni_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_pais)
                            .addComponent(jTextField_Nombre_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_ciudadLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jButton_cancelar_Empleado))
                        .addComponent(jButton_guardar_empleado)))
                .addGap(54, 54, 54)
                .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ciudadLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel_ciudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto_relacion_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anadir_relacion_Empleado)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Eliminar_relacion_empleados, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Empleados", jPanel_ciudad);

        jTable_Proyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Presupuesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Proyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProyectosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Proyectos);
        if (jTable_Proyectos.getColumnModel().getColumnCount() > 0) {
            jTable_Proyectos.getColumnModel().getColumn(0).setResizable(false);
            jTable_Proyectos.getColumnModel().getColumn(1).setResizable(false);
            jTable_Proyectos.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel_telefono.setText("Nombre");

        jLabel_direccion.setText("Presupuesto");

        jButton_guardar_biblioteca.setText("Guardar");
        jButton_guardar_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_bibliotecaActionPerformed(evt);
            }
        });

        jButton_cancelar_biblioteca.setText("Cancelar");
        jButton_cancelar_biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_bibliotecaActionPerformed(evt);
            }
        });

        jButton_anadir_proyectos.setText("Añadir");
        jButton_anadir_proyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_anadir_proyectosActionPerformed(evt);
            }
        });

        jButton_modificar_Proyectos.setText("Modificar");
        jButton_modificar_Proyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_ProyectosActionPerformed(evt);
            }
        });

        jButton_borrar_Proyecto.setText("Borrar");
        jButton_borrar_Proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_ProyectoActionPerformed(evt);
            }
        });

        jButton6.setText("Añadir Relacion");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setText("Codigo Producto");

        jLabel7.setText("Codigo empleado");

        boton_relacion_proyecto_empleado.setText("Añadir Relacion");
        boton_relacion_proyecto_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_relacion_proyecto_empleadoActionPerformed(evt);
            }
        });

        tabla_relacion_proyecto_empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "DNI", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_relacion_proyecto_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_relacion_proyecto_empleadoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabla_relacion_proyecto_empleado);
        if (tabla_relacion_proyecto_empleado.getColumnModel().getColumnCount() > 0) {
            tabla_relacion_proyecto_empleado.getColumnModel().getColumn(1).setResizable(false);
            tabla_relacion_proyecto_empleado.getColumnModel().getColumn(2).setResizable(false);
        }

        Eliminar_relacion_empleados1.setText("Eliminar Relacion");
        Eliminar_relacion_empleados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_relacion_empleados1ActionPerformed(evt);
            }
        });

        tabla_producto_relacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_producto_relacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_producto_relacionMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabla_producto_relacion);
        if (tabla_producto_relacion.getColumnModel().getColumnCount() > 0) {
            tabla_producto_relacion.getColumnModel().getColumn(0).setResizable(false);
            tabla_producto_relacion.getColumnModel().getColumn(1).setResizable(false);
            tabla_producto_relacion.getColumnModel().getColumn(2).setResizable(false);
        }

        Eliminar_relacion_empleados3.setText("Eliminar Relacion");
        Eliminar_relacion_empleados3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_relacion_empleados3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_bibliotecaLayout = new javax.swing.GroupLayout(jPanel_biblioteca);
        jPanel_biblioteca.setLayout(jPanel_bibliotecaLayout);
        jPanel_bibliotecaLayout.setHorizontalGroup(
            jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_telefono)
                            .addComponent(jLabel_direccion)
                            .addComponent(jLabel_ciudades_bibliotecas))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Nombre_Proyectos)
                            .addComponent(jTextField_Presupuesto_Proyecto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_cancelar_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_guardar_biblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_modificar_Proyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_anadir_proyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_borrar_Proyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Eliminar_relacion_empleados1))
                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Eliminar_relacion_empleados3))
                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(texto_relacion_proyecto_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boton_relacion_proyecto_empleado))
                            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(24, 24, 24)
                                .addComponent(texto_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_bibliotecaLayout.setVerticalGroup(
            jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_anadir_proyectos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_Proyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_Proyecto))
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_telefono)
                    .addComponent(jTextField_Nombre_Proyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar_biblioteca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_direccion)
                    .addComponent(jTextField_Presupuesto_Proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar_biblioteca))
                .addGap(18, 18, 18)
                .addComponent(jLabel_ciudades_bibliotecas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Eliminar_relacion_empleados3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_relacion_proyecto_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(boton_relacion_proyecto_empleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_bibliotecaLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(Eliminar_relacion_empleados1)))
                .addContainerGap())
        );

        jTabbedPane.addTab("Proyectos", jPanel_biblioteca);

        jTable_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProductosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_Productos);
        if (jTable_Productos.getColumnModel().getColumnCount() > 0) {
            jTable_Productos.getColumnModel().getColumn(0).setResizable(false);
            jTable_Productos.getColumnModel().getColumn(1).setResizable(false);
            jTable_Productos.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel_autor.setText("Nombre");

        jLabel_edad_recomendada.setText("Precio");

        jButton_guardar_libro.setText("Guardar");
        jButton_guardar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_libroActionPerformed(evt);
            }
        });

        jButton_cancelar_libro.setText("Cancelar");
        jButton_cancelar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_libroActionPerformed(evt);
            }
        });

        jButton_borrar_productos.setText("Borrar");
        jButton_borrar_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_productosActionPerformed(evt);
            }
        });

        jButton_modificar_Productos.setText("Modificar");
        jButton_modificar_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_ProductosActionPerformed(evt);
            }
        });

        jButton_anadir_productos.setText("Añadir");
        jButton_anadir_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_anadir_productosActionPerformed(evt);
            }
        });

        jTable_Proyectos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Presupuesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Proyectos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Proyectos2MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTable_Proyectos2);
        if (jTable_Proyectos2.getColumnModel().getColumnCount() > 0) {
            jTable_Proyectos2.getColumnModel().getColumn(0).setResizable(false);
            jTable_Proyectos2.getColumnModel().getColumn(1).setResizable(false);
            jTable_Proyectos2.getColumnModel().getColumn(2).setResizable(false);
        }

        jTable_Proveedores1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodigoProveedor", "NombreProveedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Proveedores1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Proveedores1MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTable_Proveedores1);
        if (jTable_Proveedores1.getColumnModel().getColumnCount() > 0) {
            jTable_Proveedores1.getColumnModel().getColumn(0).setResizable(false);
            jTable_Proveedores1.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel_libroLayout = new javax.swing.GroupLayout(jPanel_libro);
        jPanel_libro.setLayout(jPanel_libroLayout);
        jPanel_libroLayout.setHorizontalGroup(
            jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libroLayout.createSequentialGroup()
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel_libroLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton_modificar_Productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_anadir_productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_borrar_productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel_libroLayout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_autor)
                                        .addComponent(jLabel_edad_recomendada))
                                    .addGap(39, 39, 39)
                                    .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField_nombre_productos)
                                        .addComponent(jTextField_precio_productos))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton_cancelar_libro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_guardar_libro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel_libroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_libroLayout.setVerticalGroup(
            jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libroLayout.createSequentialGroup()
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_anadir_productos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_productos))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_autor)
                            .addComponent(jTextField_nombre_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_edad_recomendada)
                            .addComponent(jTextField_precio_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addComponent(jButton_guardar_libro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_cancelar_libro)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Productos", jPanel_libro);

        jTable_Proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodigoProveedor", "NombreProveedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProveedoresMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_Proveedores);
        if (jTable_Proveedores.getColumnModel().getColumnCount() > 0) {
            jTable_Proveedores.getColumnModel().getColumn(0).setResizable(false);
            jTable_Proveedores.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel_DNI.setText("NombreProveedor");

        jButton_guardar_persona.setText("Guardar");
        jButton_guardar_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_personaActionPerformed(evt);
            }
        });

        jButton_cancelar_persona.setText("Cancelar");
        jButton_cancelar_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_personaActionPerformed(evt);
            }
        });

        jButton_borrar_proveedor.setText("Borrar");
        jButton_borrar_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_proveedorActionPerformed(evt);
            }
        });

        jButton_modificar_Proveedores.setText("Modificar");
        jButton_modificar_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_ProveedoresActionPerformed(evt);
            }
        });

        jButton_anadir_proveedores.setText("Añadir");
        jButton_anadir_proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_anadir_proveedoresActionPerformed(evt);
            }
        });

        jButton4.setText("Añadir Relacion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo Producto");

        jTable_Productos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Productos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Productos1MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable_Productos1);
        if (jTable_Productos1.getColumnModel().getColumnCount() > 0) {
            jTable_Productos1.getColumnModel().getColumn(0).setResizable(false);
            jTable_Productos1.getColumnModel().getColumn(1).setResizable(false);
            jTable_Productos1.getColumnModel().getColumn(2).setResizable(false);
        }

        Eliminar_relacion_empleados2.setText("Eliminar Relacion");
        Eliminar_relacion_empleados2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_relacion_empleados2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_personaLayout = new javax.swing.GroupLayout(jPanel_persona);
        jPanel_persona.setLayout(jPanel_personaLayout);
        jPanel_personaLayout.setHorizontalGroup(
            jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_personaLayout.createSequentialGroup()
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_personaLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_personaLayout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel_DNI)
                                    .addGap(24, 24, 24)
                                    .addComponent(jTextField_Nombre_proveedor)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton_cancelar_persona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_guardar_persona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_personaLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton_modificar_Proveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_anadir_proveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_borrar_proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel_personaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eliminar_relacion_empleados2)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel_personaLayout.setVerticalGroup(
            jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_personaLayout.createSequentialGroup()
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_anadir_proveedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_proveedor))
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_DNI)
                        .addComponent(jTextField_Nombre_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addComponent(jButton_guardar_persona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_cancelar_persona)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_personaLayout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Eliminar_relacion_empleados2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(124, 124, 124))
        );

        jTabbedPane.addTab("Proveedores", jPanel_persona);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("Ciudad");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_anadir_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_anadir_productosActionPerformed
        String col2;
        Integer col3;

        col2 = jTextField_nombre_productos.getText();
        col3 = Integer.valueOf(jTextField_precio_productos.getText());

        pasaFiltro2 = generador.tieneAlgunAtributoVacio(col2, col3.toString());

        if (pasaFiltro2) {
            try {
                conector.anadirProductoBaseDatos(col2, col3);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: Fallo al añadir un producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            productos = (ArrayList<Producto>) conector.consultarBaseDatosProducto(conector.conectorBaseDatos());
            generador.cargarDatosEnJTableProductos(productos, jTable_Productos);
            generador.resetearCamposProducto(jTextField_nombre_productos, jTextField_precio_productos);
        }
    }//GEN-LAST:event_jButton_anadir_productosActionPerformed

    private void jButton_modificar_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_ProductosActionPerformed
        boolean funcionamientoCorrecto;

        funcionamientoCorrecto = generador.generarCamposVistaProducto(jTextField_nombre_productos, jTextField_precio_productos, jTable_Productos);
        col1Antiguo = jTable_Productos.getValueAt(jTable_Productos.getSelectedRow(), 0).toString();
        if (funcionamientoCorrecto)
            continuar = true;
    }//GEN-LAST:event_jButton_modificar_ProductosActionPerformed

    private void jButton_borrar_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_productosActionPerformed
        if (jTable_Productos.getSelectedRow() != -1) {
            Producto productoBuscado = generador.buscarObjetoEnArrayProducto(Integer.valueOf(jTable_Productos.getValueAt(jTable_Productos.getSelectedRow(), 0).toString()), productos);
            pasaFiltroBorrar = generador.comprobarSiHayRelacionesEnELObjeto(productoBuscado);
            if (pasaFiltroBorrar) {
                generador.eliminarFilaSeleccionada(jTable_Productos);
                try {
                    conector.eliminarObjetoBaseDatos(productoBuscado.getCodigo(), "DELETE FROM producto WHERE Codigo = ?");
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                productos = (ArrayList<Producto>) conector.consultarBaseDatosProducto(conector.conectorBaseDatos());
                generador.cargarDatosEnJTableProductos(productos, jTable_Productos);
            }
        }
    }//GEN-LAST:event_jButton_borrar_productosActionPerformed

    private void jButton_cancelar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_libroActionPerformed
        generador.resetearCamposProducto(jTextField_nombre_productos, jTextField_precio_productos);
        continuar = false;
        jTable_Productos.clearSelection();
    }//GEN-LAST:event_jButton_cancelar_libroActionPerformed

    private void jButton_guardar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_libroActionPerformed

        if (continuar) {
            String col1 = jTable_Productos.getValueAt(jTable_Productos.getSelectedRow(), 0).toString();
            String col2 = jTextField_nombre_productos.getText();
            String col3 = jTextField_precio_productos.getText();

            if (!col1.equals(col1Antiguo)) {
                pasaFiltro1 = generador.comprobarSiElObjetoYaExisteProducto(productos, Integer.valueOf(col1));
            }
            if (col1.equals(col1Antiguo) || pasaFiltro1) {
                pasaFiltro2 = generador.tieneAlgunAtributoVacio(col2, col3);
                if (pasaFiltro2) {
                    try {
                        conector.modificarProductoBaseDatos(Integer.valueOf(col1), col2, Integer.valueOf(col3));
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    productos = (ArrayList<Producto>) conector.consultarBaseDatosProducto(conector.conectorBaseDatos());
                    generador.cargarDatosEnJTableProductos(productos, jTable_Productos);
                    generador.resetearCamposProducto(jTextField_nombre_productos, jTextField_precio_productos);
                }
            }
        }
    }//GEN-LAST:event_jButton_guardar_libroActionPerformed

    private void jTable_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProductosMouseClicked

        int filaSeleccionada = jTable_Productos.getSelectedRow();
        String codigo = jTable_Productos.getValueAt(filaSeleccionada, 0).toString();

        proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
        ArrayList<Integer> proyectosBuscados = new ArrayList<>();
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getCodigoProducto().equals(Integer.valueOf(codigo))) {
                proyectosBuscados.add(proyecto.getCodigo());
            }
        }
        ArrayList<Proyecto> proyectoTabla = new ArrayList<>();
        for (Integer n : proyectosBuscados) {
            proyectoTabla.add(generador.buscarObjetoEnArrayProyecto(n, proyectos));
        }
        generador.cargarDatosEnJTableProyectos(proyectoTabla, jTable_Proyectos2);

        Integer codigoProveedor = conector.buscarProducto(Integer.valueOf(codigo)).getCodigoProveedor();
        System.out.println(codigoProveedor);
        if (codigoProveedor != 0) {
            ArrayList<Proveedor> listaProveedores = new ArrayList<>();
            listaProveedores.add(conector.buscarProveedor(codigoProveedor));
            generador.cargarDatosEnJTableProveedores(listaProveedores, jTable_Proveedores1);
        } else {
            generador.cargarDatosEnJTableProductos(new ArrayList<>(), jTable_Proveedores1);
        }
    }//GEN-LAST:event_jTable_ProductosMouseClicked

    private void jButton_borrar_ProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_ProyectoActionPerformed
        if (jTable_Proyectos.getSelectedRow() != -1) {
            Proyecto proyectoBuscado = generador.buscarObjetoEnArrayProyecto(Integer.valueOf(jTable_Proyectos.getValueAt(jTable_Proyectos.getSelectedRow(), 0).toString()), proyectos);
            pasaFiltroBorrar = generador.comprobarSiHayRelacionesEnELObjeto(proyectoBuscado);
            if (pasaFiltroBorrar) {
                generador.eliminarFilaSeleccionada(jTable_Proyectos);
                try {
                    conector.eliminarObjetoBaseDatos(proyectoBuscado.getCodigo(), "DELETE FROM proyecto WHERE Codigo = ?");
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
                generador.cargarDatosEnJTableProyectos(proyectos, jTable_Proyectos);
            }
        }
    }//GEN-LAST:event_jButton_borrar_ProyectoActionPerformed

    private void jButton_modificar_ProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_ProyectosActionPerformed
        boolean funcionamientoCorrecto;
        funcionamientoCorrecto = generador.generarCamposVistaProyecto(jTextField_Nombre_Proyectos, jTextField_Presupuesto_Proyecto, jTable_Proyectos);
        col1Antiguo = jTable_Proyectos.getValueAt(jTable_Proyectos.getSelectedRow(), 0).toString();
        if (funcionamientoCorrecto)
            continuar = true;
    }//GEN-LAST:event_jButton_modificar_ProyectosActionPerformed

    private void jButton_anadir_proyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_anadir_proyectosActionPerformed
        String col2;
        Integer col3;

        col2 = jTextField_Nombre_Proyectos.getText();
        col3 = Integer.valueOf(jTextField_Presupuesto_Proyecto.getText());

        pasaFiltro2 = generador.tieneAlgunAtributoVacio(col2, col3.toString());

        if (pasaFiltro2) {
            try {
                conector.anadirProyectoBaseDatos(col2, col3);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: Fallo al añadir un proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
            generador.cargarDatosEnJTableProyectos(proyectos, jTable_Proyectos);
            generador.resetearCamposProyecto(jTextField_nombre_productos, jTextField_precio_productos);
        }
    }//GEN-LAST:event_jButton_anadir_proyectosActionPerformed

    private void jButton_cancelar_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_bibliotecaActionPerformed
        generador.resetearCamposProyecto(jTextField_Nombre_Proyectos, jTextField_Presupuesto_Proyecto);
        continuar = false;
        jTable_Proyectos.clearSelection();
    }//GEN-LAST:event_jButton_cancelar_bibliotecaActionPerformed

    private void jButton_guardar_bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_bibliotecaActionPerformed

        if (continuar) {
            Integer col1 = Integer.valueOf(jTable_Proyectos.getValueAt(jTable_Proyectos.getSelectedRow(), 0).toString());
            String col2 = jTextField_Nombre_Proyectos.getText();
            Integer col3 = Integer.valueOf(jTextField_Presupuesto_Proyecto.getText());

            if (!col1.toString().equals(col1Antiguo)) {
                pasaFiltro1 = generador.comprobarSiElObjetoYaExisteProyecto(proyectos, col1);
            }
            if (col1.toString().equals(col1Antiguo) || pasaFiltro1) {
                pasaFiltro2 = generador.tieneAlgunAtributoVacio(col2, col3.toString());

                if (pasaFiltro2) {
                    generador.eliminarFilaSeleccionada(jTable_Proyectos);
                    try {
                        conector.modificarProyectoBaseDatos(col1, col2, col3);
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
                    generador.cargarDatosEnJTableProyectos(proyectos, jTable_Proyectos);
                    generador.resetearCamposProyecto(jTextField_Nombre_Proyectos, jTextField_Presupuesto_Proyecto);
                }
            }
        }
    }//GEN-LAST:event_jButton_guardar_bibliotecaActionPerformed

    private void jTable_ProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProyectosMouseClicked

        int filaSeleccionada = jTable_Proyectos.getSelectedRow();
        String codigo = jTable_Proyectos.getValueAt(filaSeleccionada, 0).toString();

        lista = conector.buscarEmpleadoRelacionTrabajan(Integer.valueOf(codigo));
        if (!lista.isEmpty()) {
            ArrayList<Empleado> empleadosBuscados = new ArrayList<>();
            for (Integer n : lista) {
                empleadosBuscados.add(generador.buscarObjetoEnArrayEmpleado(n, empleados));
            }

            generador.cargarDatosEnJTableEmpleados(empleadosBuscados, tabla_relacion_proyecto_empleado);
        }else{
            generador.cargarDatosEnJTableEmpleados(new ArrayList<>(), tabla_relacion_proyecto_empleado);
        }
        Integer codigoProducto = conector.buscarProyecto(Integer.valueOf(codigo)).getCodigoProducto();
        if (codigoProducto != 0) {
            generador.cargarDatosEnJTableProductos(conector.buscarProducto(codigoProducto), tabla_producto_relacion);
        } else {
            generador.cargarDatosEnJTableProductos(new ArrayList<>(), tabla_producto_relacion);
        }

    }//GEN-LAST:event_jTable_ProyectosMouseClicked

    private void jTextField_dni_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_dni_EmpleadoActionPerformed

    }//GEN-LAST:event_jTextField_dni_EmpleadoActionPerformed

    private void jButton_borrar_EmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_EmpleadosActionPerformed
        if (jTable_Empleado.getSelectedRow() != -1) {
            Empleado empleadoBuscado = generador.buscarObjetoEnArrayEmpleado(Integer.valueOf(jTable_Empleado.getValueAt(jTable_Empleado.getSelectedRow(), 0).toString()), empleados);
            pasaFiltroBorrar = generador.comprobarSiHayRelacionesEnELObjeto(empleadoBuscado);
            if (pasaFiltroBorrar) {
                generador.eliminarFilaSeleccionada(jTable_Empleado);
                try {
                    conector.eliminarObjetoBaseDatos(empleadoBuscado.getCodigo(), "DELETE FROM empleado WHERE Codigo = ?");
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                empleados = (ArrayList<Empleado>) conector.consultarBaseDatosEmpleado(conector.conectorBaseDatos());
                generador.cargarDatosEnJTableEmpleados(empleados, jTable_Empleado);
            }
        }
    }//GEN-LAST:event_jButton_borrar_EmpleadosActionPerformed

    private void jButton_modificar_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_EmpleadoActionPerformed
        boolean funcionamientoCorrecto;
        funcionamientoCorrecto = generador.generarCamposVistaEmpleado(jTextField_dni_Empleado, jTextField_Nombre_Empleado, jTable_Empleado);
        col1Antiguo = jTable_Empleado.getValueAt(jTable_Empleado.getSelectedRow(), 0).toString();
        if (funcionamientoCorrecto)
            continuar = true;
    }//GEN-LAST:event_jButton_modificar_EmpleadoActionPerformed

    private void jTable_EmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_EmpleadoMouseClicked

        int filaSeleccionada = jTable_Empleado.getSelectedRow();
        String codigo = jTable_Empleado.getValueAt(filaSeleccionada, 0).toString();

        lista = conector.buscarProyectoRelacionTrabajan(Integer.valueOf(codigo));
        ArrayList<Proyecto> proyectosBuscados = new ArrayList<>();
        for (Integer n : lista) {
            proyectosBuscados.add(generador.buscarObjetoEnArrayProyecto(n, proyectos));
        }
        generador.cargarDatosEnJTableProyectos(proyectosBuscados, jTable_Proyectos_Empleados_Relacion);
    }//GEN-LAST:event_jTable_EmpleadoMouseClicked

    private void jButton_anadir_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_anadir_empleadosActionPerformed
        String col2;
        String col3;

        col2 = jTextField_Nombre_Empleado.getText();
        col3 = jTextField_dni_Empleado.getText();

        pasaFiltro2 = generador.tieneAlgunAtributoVacio(col2, col3);

        if (pasaFiltro2) {
            try {
                conector.anadirEmpleadoBaseDatos(col3, col2);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: Fallo al añadir un proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            empleados = (ArrayList<Empleado>) conector.consultarBaseDatosEmpleado(conector.conectorBaseDatos());
            generador.cargarDatosEnJTableEmpleados(empleados, jTable_Empleado);
            generador.resetearCamposEmpleado(jTextField_dni_Empleado, jTextField_Nombre_Empleado);
        }
    }//GEN-LAST:event_jButton_anadir_empleadosActionPerformed

    private void jButton_cancelar_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_EmpleadoActionPerformed

        generador.resetearCamposEmpleado(jTextField_dni_Empleado, jTextField_Nombre_Empleado);
        continuar = false;
        jTable_Empleado.clearSelection();
    }//GEN-LAST:event_jButton_cancelar_EmpleadoActionPerformed

    private void jButton_guardar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_empleadoActionPerformed

        if (continuar) {
            Integer col1 = Integer.valueOf(jTable_Empleado.getValueAt(jTable_Empleado.getSelectedRow(), 0).toString());
            String col2 = jTextField_dni_Empleado.getText();
            String col3 = jTextField_Nombre_Empleado.getText();

            if (!col1.toString().equals(col1Antiguo)) {
                pasaFiltro1 = generador.comprobarSiElObjetoYaExisteEmpleado(empleados, col1.toString());
            }
            if (col1.toString().equals(col1Antiguo) || pasaFiltro1) {
                pasaFiltro2 = generador.tieneAlgunAtributoVacio(col2, col3);

                if (pasaFiltro2) {

                    generador.eliminarFilaSeleccionada(jTable_Empleado);
                    try {
                        conector.modificarEmpleadoBaseDatos(col1, col2, col3);
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    empleados = (ArrayList<Empleado>) conector.consultarBaseDatosEmpleado(conector.conectorBaseDatos());
                    generador.cargarDatosEnJTableEmpleados(empleados, jTable_Empleado);
                    generador.resetearCamposEmpleado(jTextField_dni_Empleado, jTextField_Nombre_Empleado);
                }
            }
        }
    }//GEN-LAST:event_jButton_guardar_empleadoActionPerformed

    private void jButton_anadir_proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_anadir_proveedoresActionPerformed
        String col2;

        col2 = jTextField_Nombre_proveedor.getText();

        pasaFiltro2 = col2.isBlank();

        if (!pasaFiltro2) {
            try {
                conector.anadirProveedorBaseDatos(col2);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: Fallo al añadir un proveedores.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            proveedor = (ArrayList<Proveedor>) conector.consultarBaseDatosProveedor(conector.conectorBaseDatos());
            generador.cargarDatosEnJTableProveedores(proveedor, jTable_Proveedores);
            generador.resetearCamposProveedor(jTextField_Nombre_proveedor);
        }
    }//GEN-LAST:event_jButton_anadir_proveedoresActionPerformed

    private void jButton_modificar_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_ProveedoresActionPerformed
        boolean funcionamientoCorrecto;
        funcionamientoCorrecto = generador.generarCamposVistaProveedor(jTextField_Nombre_proveedor, jTable_Proveedores);
        col1Antiguo = jTable_Proveedores.getValueAt(jTable_Proveedores.getSelectedRow(), 0).toString();
        if (funcionamientoCorrecto)
            continuar = true;
    }//GEN-LAST:event_jButton_modificar_ProveedoresActionPerformed

    private void jButton_borrar_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_proveedorActionPerformed
        if (jTable_Proveedores.getSelectedRow() != -1) {
            Proveedor proveedorBuscado = generador.buscarObjetoEnArrayProveedor(Integer.valueOf(jTable_Proveedores.getValueAt(jTable_Proveedores.getSelectedRow(), 0).toString()), proveedor);
            pasaFiltroBorrar = generador.comprobarSiHayRelacionesEnELObjeto(proveedorBuscado);
            if (pasaFiltroBorrar) {
                generador.eliminarFilaSeleccionada(jTable_Proveedores);
                try {
                    conector.eliminarObjetoBaseDatos(proveedorBuscado.getCodigoProveedor(), "DELETE FROM proveedor WHERE Codigo = ?");
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                proveedor = (ArrayList<Proveedor>) conector.consultarBaseDatosProveedor(conector.conectorBaseDatos());
                generador.cargarDatosEnJTableProveedores(proveedor, jTable_Proveedores);
            }
        }
    }//GEN-LAST:event_jButton_borrar_proveedorActionPerformed

    private void jButton_guardar_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_personaActionPerformed
        if (continuar) {
            Integer col1 = Integer.valueOf(jTable_Proveedores.getValueAt(jTable_Proveedores.getSelectedRow(), 0).toString());
            String col2 = jTextField_Nombre_proveedor.getText();

            if (!col1.toString().equals(col1Antiguo)) {
                pasaFiltro1 = generador.comprobarSiElObjetoYaExisteProveedor(proveedor, col1.toString());
            }
            if (col1.toString().equals(col1Antiguo) || pasaFiltro1) {
                pasaFiltro2 = generador.tieneAlgunAtributoVacio(null, col2);
                if (pasaFiltro2) {
                    proveedor.add(generador.modificarProveedores(col1, col2, jTable_Proveedores, proveedor));
                    generador.eliminarFilaSeleccionada(jTable_Proveedores);
                    try {
                        conector.modificarProveedorBaseDatos(col1, col2);
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    proveedor = (ArrayList<Proveedor>) conector.consultarBaseDatosProveedor(conector.conectorBaseDatos());
                    generador.cargarDatosEnJTableProveedores(proveedor, jTable_Proveedores);
                    generador.resetearCamposProveedor(jTextField_Nombre_proveedor);

                }
            }
        }
    }//GEN-LAST:event_jButton_guardar_personaActionPerformed

    private void jTable_ProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProveedoresMouseClicked
        int filaSeleccionada = jTable_Proveedores.getSelectedRow();
        String codigo = jTable_Proveedores.getValueAt(filaSeleccionada, 0).toString();

        Integer codigoProducto = conector.buscarProveedor(Integer.valueOf(codigo)).getProductoProveedor();
        if (codigoProducto != 0) {
            generador.cargarDatosEnJTableProductos(conector.buscarProducto(codigoProducto), jTable_Productos1);
        } else {
            generador.cargarDatosEnJTableProductos(new ArrayList<>(), jTable_Productos1);
        }
    }//GEN-LAST:event_jTable_ProveedoresMouseClicked

    private void anadir_relacion_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadir_relacion_EmpleadoActionPerformed
        String codigo = texto_relacion_empleados.getText();
        int filaSeleccionada = jTable_Empleado.getSelectedRow();

        if (filaSeleccionada != -1) {

            //Crea y asigna la relacion al proyecto
            String id = jTable_Empleado.getValueAt(filaSeleccionada, 0).toString();
            if (!codigo.isBlank()) {
                if (conector.buscarEmpleado(Integer.valueOf(id)) != null && conector.buscarProyecto(Integer.valueOf(codigo)) != null) {
                    try {
                        conector.anadirRelacionProyectoEmpleado(Integer.valueOf(codigo), Integer.valueOf(id));
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    empleados = (ArrayList<Empleado>) conector.consultarBaseDatosEmpleado(conector.conectorBaseDatos());
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, Introduce un id valido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, Introduce un id.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jTable_Empleado.clearSelection();

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, Tienes que seleccionar en la tabla a quien quieres añadir la relacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        texto_relacion_empleados.setText("");
        DefaultTableModel modeloTabla = (DefaultTableModel) jTable_Proyectos_Empleados_Relacion.getModel();
        modeloTabla.setRowCount(0);
    }//GEN-LAST:event_anadir_relacion_EmpleadoActionPerformed

    private void Eliminar_relacion_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_relacion_empleadosActionPerformed

        int filaSeleccionada = jTable_Proyectos_Empleados_Relacion.getSelectedRow();
        if (filaSeleccionada != -1) {

            //Crea y asigna la relacion al proyecto
            String codigo = jTable_Empleado.getValueAt(jTable_Empleado.getSelectedRow(), 0).toString();
            String id = jTable_Proyectos_Empleados_Relacion.getValueAt(filaSeleccionada, 0).toString();
            if (conector.buscarProyecto(Integer.valueOf(id)) != null) {
                try {
                    conector.eliminarObjetoBaseDatos(Integer.parseInt(id), "DELETE FROM trabajan WHERE CodigoProyecto = ? AND CodigoEmpleado== " + codigo);
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                empleados = (ArrayList<Empleado>) conector.consultarBaseDatosEmpleado(conector.conectorBaseDatos());
            }
            jTable_Empleado.clearSelection();
            texto_relacion_empleados.setText("");
            DefaultTableModel modeloTabla = (DefaultTableModel) jTable_Proyectos_Empleados_Relacion.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, Tienes que seleccionar en la tabla a quien quieres añadir la relacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Eliminar_relacion_empleadosActionPerformed

    private void jTable_Proyectos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Proyectos1MouseClicked

    }//GEN-LAST:event_jTable_Proyectos1MouseClicked

    private void jTable_Proyectos_Empleados_RelacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Proyectos_Empleados_RelacionMouseClicked

    }//GEN-LAST:event_jTable_Proyectos_Empleados_RelacionMouseClicked

    private void texto_relacion_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_relacion_empleadosActionPerformed

    }//GEN-LAST:event_texto_relacion_empleadosActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String codigo = texto_codigo_producto.getText();
        int filaSeleccionada = jTable_Proyectos.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Crea y asigna la relacion al producto
            String id = jTable_Proyectos.getValueAt(filaSeleccionada, 0).toString();
            if (!codigo.isBlank()) {
                if (conector.buscarProducto(Integer.valueOf(codigo)) != null) {
                    try {
                        conector.insertarRelacionEnProyectoElProducto(Integer.valueOf(id), "UPDATE proyecto SET CodigoProducto = ? WHERE Codigo = ?", Integer.valueOf(codigo));
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, Introduce un producto existente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                Integer codigoProducto = conector.buscarProyecto(Integer.valueOf(codigo)).getCodigoProducto();
                if (codigoProducto != null) {
                    generador.cargarDatosEnJTableProductos(conector.buscarProducto(codigoProducto), tabla_producto_relacion);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, Introduce un id valido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, Introduce un id.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, Tienes que seleccionar en la tabla a quien quieres añadir la relacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void boton_relacion_proyecto_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_relacion_proyecto_empleadoActionPerformed
        String codigo = texto_relacion_proyecto_empleado.getText();
        int filaSeleccionada = jTable_Proyectos.getSelectedRow();

        if (filaSeleccionada != -1) {

            //Crea y asigna la relacion al proyecto
            String id = jTable_Proyectos.getValueAt(filaSeleccionada, 0).toString();
            if (!codigo.isBlank()) {
                if (conector.buscarProyecto(Integer.valueOf(id)) != null && conector.buscarEmpleado(Integer.valueOf(codigo)) != null) {
                    try {
                        conector.anadirRelacionProyectoEmpleado(Integer.valueOf(id), Integer.valueOf(codigo));
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, Introduce un id valido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                //carga los datos en la vista
                generador.cargarDatosEnJTableProyectos(proyectos, jTable_Proyectos);
                lista = conector.buscarEmpleadoRelacionTrabajan(Integer.valueOf(codigo));
                ArrayList<Empleado> empleadosBuscados = new ArrayList<>();
                for (Integer n : lista) {
                    empleadosBuscados.add(generador.buscarObjetoEnArrayEmpleado(n, empleados));
                }
                generador.cargarDatosEnJTableEmpleados(empleadosBuscados, tabla_relacion_proyecto_empleado);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, Introduce un id.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, Tienes que seleccionar en la tabla a quien quieres añadir la relacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_boton_relacion_proyecto_empleadoActionPerformed

    private void tabla_relacion_proyecto_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_relacion_proyecto_empleadoMouseClicked

    }//GEN-LAST:event_tabla_relacion_proyecto_empleadoMouseClicked

    private void Eliminar_relacion_empleados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_relacion_empleados1ActionPerformed
        int filaSeleccionada = tabla_relacion_proyecto_empleado.getSelectedRow();
        if (filaSeleccionada != -1) {

            //Crea y asigna la relacion al proyecto
            String id = tabla_relacion_proyecto_empleado.getValueAt(filaSeleccionada, 0).toString();
            String codigo = jTable_Proyectos.getValueAt(jTable_Proyectos.getSelectedRow(), 0).toString();
            if (conector.buscarEmpleado(Integer.valueOf(id)) != null) {
                try {
                    conector.eliminarObjetoBaseDatos(Integer.parseInt(id), "DELETE FROM trabajan WHERE CodigoEmpleado = ? AND CodigoProyecto== " + codigo);
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
            }
            jTable_Proyectos.clearSelection();
            proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
            DefaultTableModel modeloTabla = (DefaultTableModel) tabla_relacion_proyecto_empleado.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, Tienes que seleccionar en la tabla a quien quieres añadir la relacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Eliminar_relacion_empleados1ActionPerformed

    private void tabla_producto_relacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_producto_relacionMouseClicked

    }//GEN-LAST:event_tabla_producto_relacionMouseClicked

    private void Eliminar_relacion_empleados3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_relacion_empleados3ActionPerformed
        int filaSeleccionada = tabla_producto_relacion.getSelectedRow();
        if (filaSeleccionada != -1) {

            //Crea y asigna la relacion al proyecto
            String id = tabla_producto_relacion.getValueAt(filaSeleccionada, 0).toString();
            String codigo = jTable_Proyectos.getValueAt(jTable_Proyectos.getSelectedRow(), 0).toString();
            if (conector.buscarProducto(Integer.valueOf(id)) != null) {
                try {
                    conector.eliminarRelacion(codigo, "UPDATE Proyecto SET CodigoProducto = ? WHERE Codigo = ");
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
            }
            jTable_Proyectos.clearSelection();
            proyectos = (ArrayList<Proyecto>) conector.consultarBaseDatosProyecto(conector.conectorBaseDatos());
            DefaultTableModel modeloTabla = (DefaultTableModel) tabla_producto_relacion.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, Tienes que seleccionar en la tabla a quien quieres añadir la relacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Eliminar_relacion_empleados3ActionPerformed

    private void jTable_Productos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Productos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Productos1MouseClicked

    private void Eliminar_relacion_empleados2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_relacion_empleados2ActionPerformed
        int filaSeleccionada = jTable_Productos1.getSelectedRow();
        if (filaSeleccionada != -1) {

            //Crea y asigna la relacion al proyecto
            String id = jTable_Productos1.getValueAt(filaSeleccionada, 0).toString();
            String codigo = jTable_Proveedores.getValueAt(jTable_Proveedores.getSelectedRow(), 0).toString();
            if (conector.buscarProducto(Integer.valueOf(id)) != null) {
                try {
                    conector.eliminarRelacion(codigo, "UPDATE proveedor SET CodigoProducto = ? WHERE Codigo = ");
                    conector.eliminarRelacion(id, "UPDATE producto SET CodigoProveedor = ? WHERE Codigo = ");
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                }
                proveedor = (ArrayList<Proveedor>) conector.consultarBaseDatosProveedor(conector.conectorBaseDatos());
                productos = (ArrayList<Producto>) conector.consultarBaseDatosProducto(conector.conectorBaseDatos());
            }
            jTable_Proveedores.clearSelection();
            proveedor = (ArrayList<Proveedor>) conector.consultarBaseDatosProveedor(conector.conectorBaseDatos());
            DefaultTableModel modeloTabla = (DefaultTableModel) jTable_Productos1.getModel();
            modeloTabla.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, Tienes que seleccionar en la tabla a quien quieres añadir la relacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Eliminar_relacion_empleados2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String codigo = jTextField4.getText();
        int filaSeleccionada = jTable_Proveedores.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Crea y asigna la relacion al producto
            String id = jTable_Proveedores.getValueAt(filaSeleccionada, 0).toString();
            if (!codigo.isBlank()) {
                if (conector.buscarProducto(Integer.valueOf(codigo)) != null) {
                    try {
                        conector.insertarRelacionEnProveedorElProducto(Integer.valueOf(id), "UPDATE proveedor SET CodigoProducto = ? WHERE Codigo = ?", Integer.valueOf(codigo));
                        conector.insertarRelacionEnProveedorElProducto(Integer.valueOf(codigo), "UPDATE producto SET CodigoProveedor = ? WHERE Codigo = ?", Integer.valueOf(id));
                        productos = (ArrayList<Producto>) conector.consultarBaseDatosProducto(conector.conectorBaseDatos());
                        proveedor = (ArrayList<Proveedor>) conector.consultarBaseDatosProveedor(conector.conectorBaseDatos());
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, Introduce un producto existente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                Integer codigoProducto = conector.buscarProveedor(Integer.valueOf(id)).getProductoProveedor();
                if (codigoProducto != null) {
                    generador.cargarDatosEnJTableProductos(conector.buscarProducto(codigoProducto), jTable_Productos1);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, Introduce un id valido.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, Introduce un id.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, Tienes que seleccionar en la tabla a quien quieres añadir la relacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton_cancelar_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_personaActionPerformed
        generador.resetearCamposProveedor(jTextField_Nombre_proveedor);
        continuar = false;
        jTable_Proveedores.clearSelection();
    }//GEN-LAST:event_jButton_cancelar_personaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        conector.cerrarConexion(conector.conectorBaseDatos());
    }//GEN-LAST:event_formWindowClosing

    private void jTable_Proyectos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Proyectos2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Proyectos2MouseClicked

    private void jTable_Proveedores1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Proveedores1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Proveedores1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar_relacion_empleados;
    private javax.swing.JButton Eliminar_relacion_empleados1;
    private javax.swing.JButton Eliminar_relacion_empleados2;
    private javax.swing.JButton Eliminar_relacion_empleados3;
    private javax.swing.JButton anadir_relacion_Empleado;
    private javax.swing.JButton boton_relacion_proyecto_empleado;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_anadir_empleados;
    private javax.swing.JButton jButton_anadir_productos;
    public javax.swing.JButton jButton_anadir_proveedores;
    private javax.swing.JButton jButton_anadir_proyectos;
    private javax.swing.JButton jButton_borrar_Empleados;
    private javax.swing.JButton jButton_borrar_Proyecto;
    private javax.swing.JButton jButton_borrar_productos;
    public javax.swing.JButton jButton_borrar_proveedor;
    private javax.swing.JButton jButton_cancelar_Empleado;
    private javax.swing.JButton jButton_cancelar_biblioteca;
    public javax.swing.JButton jButton_cancelar_libro;
    private javax.swing.JButton jButton_cancelar_persona;
    private javax.swing.JButton jButton_guardar_biblioteca;
    private javax.swing.JButton jButton_guardar_empleado;
    public javax.swing.JButton jButton_guardar_libro;
    private javax.swing.JButton jButton_guardar_persona;
    private javax.swing.JButton jButton_modificar_Empleado;
    private javax.swing.JButton jButton_modificar_Productos;
    public javax.swing.JButton jButton_modificar_Proveedores;
    private javax.swing.JButton jButton_modificar_Proyectos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_DNI;
    private javax.swing.JLabel jLabel_autor;
    private javax.swing.JLabel jLabel_ciudades_bibliotecas;
    private javax.swing.JLabel jLabel_direccion;
    private javax.swing.JLabel jLabel_edad_recomendada;
    private javax.swing.JLabel jLabel_nombre_ciudad;
    private javax.swing.JLabel jLabel_pais;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JPanel jPanel_biblioteca;
    private javax.swing.JPanel jPanel_ciudad;
    private javax.swing.JPanel jPanel_libro;
    private javax.swing.JPanel jPanel_persona;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable_Empleado;
    private javax.swing.JTable jTable_Productos;
    private javax.swing.JTable jTable_Productos1;
    public javax.swing.JTable jTable_Proveedores;
    public javax.swing.JTable jTable_Proveedores1;
    private javax.swing.JTable jTable_Proyectos;
    private javax.swing.JTable jTable_Proyectos1;
    private javax.swing.JTable jTable_Proyectos2;
    private javax.swing.JTable jTable_Proyectos_Empleados_Relacion;
    private javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField_Nombre_Empleado;
    public javax.swing.JTextField jTextField_Nombre_Proyectos;
    private javax.swing.JTextField jTextField_Nombre_proveedor;
    public javax.swing.JTextField jTextField_Presupuesto_Proyecto;
    public javax.swing.JTextField jTextField_dni_Empleado;
    private javax.swing.JTextField jTextField_nombre_productos;
    private javax.swing.JTextField jTextField_precio_productos;
    private javax.swing.JTable tabla_producto_relacion;
    private javax.swing.JTable tabla_relacion_proyecto_empleado;
    private javax.swing.JTextField texto_codigo_producto;
    private javax.swing.JTextField texto_relacion_empleados;
    private javax.swing.JTextField texto_relacion_proyecto_empleado;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Proyecto> proyectos = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Proveedor> proveedor = new ArrayList<>();
    List<Integer> lista = new ArrayList<>();
    String col1Antiguo;
    boolean pasaFiltro1;
    boolean pasaFiltro2;
    boolean pasaFiltroBorrar;
    private Proyecto proyectoAntiguo;
    private Empleado empleadoAntiguo;
}
