/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import microsoft.sql.DateTimeOffset;

/**
 *
 * @author Felipe
 */
public class CRUDSqlServer {

    private List<Categoria> listaCategorias = new ArrayList<Categoria>();
    private List<Producto> listaProductos = new ArrayList<Producto>();
    private List<Persona> listaPersonas = new ArrayList<Persona>();
    private List<Mesa> listaMesas = new ArrayList<Mesa>();
    private List<Pedido> listaPedidos = new ArrayList<Pedido>();
    private List<TipoDNI> listaTiposDNI = new ArrayList<>();

    //-----CATEGORIAS ----
    public List<Categoria> obtenerCategorias(Connection conexion) {
        String sql = "SELECT * FROM categoria;";
        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                listaCategorias.add(
                        new Categoria(
                                rs.getInt("idCategoria"),
                                rs.getString("nombre")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaCategorias;
    }

    public Categoria buscarCategoria(Connection conexion, Categoria categoria) {
        Categoria c = new Categoria();
        String sql = "SELECT * FROM categoria WHERE idCategoria= (SELECT idCategoria FROM categoria WHERE nombre = ?);";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, categoria.getNombre());

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt("idCategoria"));
                c.setNombre(rs.getString("nombre"));
            } else {
                JOptionPane.showMessageDialog(null, "Categoria no encontrada");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public void insertarCategoria(Connection conexion, Categoria categoria) {
        String sql = "INSERT INTO categoria VALUES(?);";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, categoria.getNombre());
            int registroAdd = stm.executeUpdate();
            if (registroAdd > 0) {
                System.out.println("Registro exitoso");
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void eliminarCategoria(Connection conexion, Categoria categoria) {
        String sql = "DELETE FROM categoria WHERE idCategoria=?;";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setInt(1, categoria.getId());
            int paraBorrar = stm.executeUpdate();
            if (paraBorrar > 0) {
                JOptionPane.showMessageDialog(null, "Categoria eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la categoria");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void actualizarCategoria(Connection conexion, Categoria categoria) {

        String sql = "UPDATE categoria SET nombre=? WHERE idCategoria=?;";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);

            stm.setString(1, categoria.getNombre());
            stm.setInt(2, categoria.getId());

            int ok = stm.executeUpdate();
            conexion.commit();
            if (ok > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //------ FIN CATEGORIAS -------
    //------- PRODUCTOS -----------
    public List<Producto> obtenerProductos(Connection conexion) {
        listaProductos.clear();
        String sql = "SELECT * FROM producto;";
        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                listaProductos.add(
                        new Producto(
                                rs.getInt("idProducto"),
                                rs.getString("nombre"),
                                rs.getInt("precioActual"),
                                rs.getInt("unidadesDisponibles"),
                                rs.getString("idCategoria")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProductos;
    }

    public List<Producto> obtenerProductosPorCategoria(Connection conexion, String categoria) {
        listaProductos.clear();

        String sql = "SELECT * FROM producto WHERE idCategoria = (SELECT idCategoria FROM categoria WHERE nombre = ?);";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, categoria);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listaProductos.add(
                        new Producto(
                                rs.getInt("idProducto"),
                                rs.getString("nombre"),
                                rs.getInt("precioActual"),
                                rs.getInt("unidadesDisponibles"),
                                rs.getString("idCategoria")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProductos;
    }

    public void insertarProducto(Connection conexion, Producto producto) {

        String sql = "INSERT INTO producto VALUES (?, ?, ?, (SELECT DISTINCT idCategoria FROM categoria WHERE nombre = ?));";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, producto.getNombreProducto());
            stm.setInt(2, producto.getPrecioActual());
            stm.setInt(3, producto.getUnidadesDisponibles());
            stm.setString(4, producto.getCategoria());
            int registroAdd = stm.executeUpdate();
            if (registroAdd > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Producto buscarProducto(Connection conexion, Producto producto) {
        Producto p = new Producto();
        String sql = "SELECT * FROM producto WHERE idProducto= (SELECT idProducto FROM producto WHERE nombre = ?);";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, producto.getNombreProducto());

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombreProducto(rs.getString("nombre"));
                p.setPrecioActual(rs.getInt("precioActual"));
                p.setUnidadesDisponibles(rs.getInt("unidadesDisponibles"));

            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    public Producto editarProducto(Connection conexion, Producto producto) {

        Producto p = new Producto();

        String sql = "UPDATE producto SET nombre=?,precioActual = ? , unidadesDisponibles = ?, idCategoria =? WHERE idProducto=?;";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, producto.getNombreProducto());
            stm.setInt(2, producto.getPrecioActual());
            stm.setInt(3, producto.getUnidadesDisponibles());
            stm.setInt(4, saberIdCategoria(conexion, producto.getCategoria()));
            stm.setInt(5, producto.getIdProducto());

            int ok = stm.executeUpdate();
            conexion.commit();
            if (ok > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;

    }

    public int saberIdCategoria(Connection conexion, String nombreCategoria) {
        int idCategoria = 0;

        String sql = "SELECT idCategoria FROM categoria WHERE nombre = ?;";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, nombreCategoria);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                idCategoria = rs.getInt("idCategoria");

            } else {
                JOptionPane.showMessageDialog(null, "Algo sucedio buscando la categoria");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idCategoria;
    }

    public void eliminarProducto(Connection conexion, int id) {

        String sql = "DELETE FROM producto WHERE idProducto = ?;";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setInt(1, id);

            int paraBorrar = stm.executeUpdate();
            if (paraBorrar > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //-------PEDIDOS-------
    public List<Pedido> obtenerPedidos(Connection conexion, String fechaInicial, String fechaFinal) {
        String sql = """
                     SELECT pedido.idPedido, numeroMesa, grupo.idGrupo, CONCAT(nombre,' ' , apellido) AS 'Nombre', fechaPedido, estado, SUM(pedido_producto.precioFacturado) AS 'Total' 
                         FROM pedido
                         INNER JOIN persona_grupo ON pedido.idPersona_Grupo = persona_grupo.idGrupoPersona
                         INNER JOIN persona ON persona.idDNIPersona = persona_grupo.idPersona
                         INNER JOIN grupo ON  grupo.idGrupo = persona_grupo.idGrupo
                         INNER JOIN mesa ON mesa.idMesa = grupo.idMesa
                         INNER JOIN pedido_producto ON pedido_producto.idPedido = pedido.idPedido
                         WHERE fechaPedido BETWEEN ? AND ?
                         GROUP BY pedido.idPedido,
                             mesa.numeroMesa,
                             grupo.idGrupo,
                             nombre,
                             apellido,
                             fechaPedido,
                             estado;
                     """;
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, fechaInicial);
            stm.setString(2, fechaFinal);
            ResultSet rs = stm.executeQuery();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String fecha;

            while (rs.next()) {
                OffsetDateTime f = rs.getObject("fechaPedido", OffsetDateTime.class);
                fecha = f.format(formatter);
                listaPedidos.add(
                        new Pedido(
                                rs.getInt("idPedido"),
                                rs.getInt("numeroMesa"),
                                rs.getInt("idGrupo"),
                                rs.getString("Nombre"),
                                fecha,
                                rs.getInt("Total"),
                                rs.getInt("estado")
                        )
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPedidos;

    }

    public List<Producto> obtenerPedidoProductos(Connection conexion, String numeroPedido) {
        listaProductos.clear();

        String sql = """
                     SELECT pedido_producto.idProducto, nombre, precioFacturado, cantidad, (cantidad * precioFacturado) AS 'Subtotal' 
                     FROM pedido_producto
                     INNER JOIN producto ON pedido_producto.idProducto = producto.idProducto
                     WHERE idPedido = ?;
                     """;
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, numeroPedido);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listaProductos.add(
                        new Producto(
                                rs.getInt("idProducto"),
                                rs.getString("nombre"),
                                rs.getInt("precioFacturado"),
                                rs.getInt("cantidad")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProductos;
    }

    public void actualizarPedido(Connection conexion, String pedido) {

        String sql = "UPDATE pedido  SET estado  = 1 WHERE idPedido = ?;";
        System.out.println(sql);

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, pedido);

            int ok = stm.executeUpdate();
            conexion.commit();
            if (ok > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void pedirCuenta(Connection conexion, String idGrupo) {
        String sql = "UPDATE pedido  SET estado  = 1 FROM pedido INNER JOIN persona_grupo ON persona_grupo.idGrupoPersona = pedido.idPersona_Grupo  WHERE idGrupo = ?;";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, idGrupo);

            int ok = stm.executeUpdate();
            conexion.commit();
            if (ok > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
                conexion.commit();
            } else {
                JOptionPane.showMessageDialog(null, "No hay pedidos");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarGrupo(Connection conexion, String idGrupo) {
        String sql = "UPDATE grupo  SET horaSalida  = SYSDATETIMEOFFSET() WHERE idGrupo = ?;";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, idGrupo);

            int ok = stm.executeUpdate();
            conexion.commit();
            if (ok > 0) {
                JOptionPane.showMessageDialog(null, "Grupo cerrado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cerrar el grupo");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarProductoPedido(Connection conexion, Producto producto, String pedido){
        String sql = "INSERT INTO pedido_producto (idPedido,idProducto,precioFacturado, cantidad) VALUES (?, ?,?,?);";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, pedido);
            stm.setInt(2, producto.getIdProducto());
            stm.setInt(3, producto.getPrecioActual());
            stm.setInt(4, producto.getUnidadesDisponibles());
            int registroAdd = stm.executeUpdate();
            if (registroAdd > 0) {
                System.out.println("producto creado");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String registrarPedido(Connection conexion, Pedido pedido, String quienPide){
        String numeroPedido =null;
        String sql = """
                     INSERT INTO pedido (idPersona_Grupo, fechaPedido, estado)
                     VALUES ((
                     SELECT TOP 1 idGrupoPersona 
                                          FROM persona_grupo 
                                          INNER JOIN persona ON persona_grupo.idPersona = persona.idDNIPersona
                                          WHERE CONCAT(persona.nombre, ' ', persona.apellido) 
                     			  LIKE ?
                                          ORDER BY idGrupo DESC),
                     SYSDATETIMEOFFSET(),?);
                     """;
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, quienPide);
            stm.setInt(2, pedido.getEstado());
            int registroAdd = stm.executeUpdate();
            if (registroAdd > 0) {
                JOptionPane.showMessageDialog(null, "Pedido creado");
                numeroPedido = saberIdPedido(conexion, quienPide);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return numeroPedido;
        
        
    }
    
    public String saberIdPedido(Connection conexion, String persona ){
        String idPedido =null;
        String sql = """
                     SELECT TOP 1 idPedido
                     FROM pedido 
                     INNER JOIN persona_grupo ON persona_grupo.idGrupoPersona = pedido.idPersona_Grupo
                     WHERE idGrupoPersona = (
                     SELECT TOP 1 idGrupoPersona 
                     FROM persona_grupo 
                     INNER JOIN persona ON persona_grupo.idPersona = persona.idDNIPersona
                     WHERE CONCAT(persona.nombre, ' ', persona.apellido) LIKE ?
                     ORDER BY idGrupo DESC
                     )
                     ORDER BY idGrupo DESC;
                     """;
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, persona);
            
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                idPedido= rs.getString("idPedido");
            } else {
                JOptionPane.showMessageDialog(null, "algo peso");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return idPedido;
        
    }
    
    //------MESAS------
    public List<Mesa> obtenerMesas(Connection conexion) {
        listaMesas.clear();
        String sql = "SELECT numeroMesa FROM mesa WHERE mesa.idTienda = 1;";

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                listaMesas.add(
                        new Mesa(
                                rs.getInt("numeroMesa")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaMesas;
    }

    public List<Pedido> obtenerPedidosPorMesa(Connection conexion, int mesa, int grupo) {
        String sql = """
                     SELECT pedido.idPedido, numeroMesa, grupo.idGrupo, CONCAT(nombre,' ' , apellido) AS 'Nombre', fechaPedido, estado, SUM(pedido_producto.precioFacturado) AS 'Total' 
                                              FROM pedido
                                              INNER JOIN persona_grupo ON pedido.idPersona_Grupo = persona_grupo.idGrupoPersona
                                              INNER JOIN persona ON persona.idDNIPersona = persona_grupo.idPersona
                                              INNER JOIN grupo ON  grupo.idGrupo = persona_grupo.idGrupo
                                              INNER JOIN mesa ON mesa.idMesa = grupo.idMesa
                                              INNER JOIN pedido_producto ON pedido_producto.idPedido = pedido.idPedido
                                              WHERE Grupo.idGrupo = ?
                                              GROUP BY pedido.idPedido,
                                                  mesa.numeroMesa,
                                                  grupo.idGrupo,
                                                  nombre,
                                                  apellido,
                                                  fechaPedido,
                                                  estado;
                     """;
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, String.valueOf(grupo));

            ResultSet rs = stm.executeQuery();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String fecha;

            while (rs.next()) {
                OffsetDateTime f = rs.getObject("fechaPedido", OffsetDateTime.class);
                fecha = f.format(formatter);
                listaPedidos.add(
                        new Pedido(
                                rs.getInt("idPedido"),
                                rs.getInt("numeroMesa"),
                                rs.getInt("idGrupo"),
                                rs.getString("Nombre"),
                                fecha,
                                rs.getInt("Total"),
                                rs.getInt("estado")
                        )
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPedidos;
    }

    //buscar ultimo grupo de la mesa
    public Grupo buscarGrupo(Connection conexion, String numeroMesa) {
        Grupo grupo = new Grupo();

        // Consulta sin signo de interrogación
        String sql = "SELECT TOP 1 idGrupo, idMesa, horaLlegada, horaSalida FROM grupo WHERE idMesa = " + numeroMesa + " AND ISNULL(horaSalida, '') = '' ORDER BY horaLlegada DESC;";

        try {

            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                grupo.setIdGrupo(rs.getInt("idGrupo"));

                // Manejo de horaSalida como DateTimeOffset
                DateTimeOffset horaSalidaOffset = (DateTimeOffset) rs.getObject("horaSalida");

                if (horaSalidaOffset != null) {
                    // Convertir a java.sql.Timestamp si es necesario
                    Timestamp timestampSalida = horaSalidaOffset.getTimestamp();
                    grupo.setHoraSalida(new Date(timestampSalida.getTime()));
                } else {
                    grupo.setHoraSalida(null);
                }

                // Manejo de horaLlegada como DateTimeOffset
                DateTimeOffset horaLlegadaOffset = (DateTimeOffset) rs.getObject("horaLlegada");

                if (horaLlegadaOffset != null) {
                    // Convertir a java.sql.Timestamp si es necesario
                    Timestamp timestampLlegada = horaLlegadaOffset.getTimestamp();
                    grupo.setHoraLlegada(new Date(timestampLlegada.getTime()));
                } else {
                    grupo.setHoraLlegada(null);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Mesa disponible");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grupo;
    }

    public Grupo crearGrupo(Connection conexion, String numeroMesa) {
        Grupo grupo1 = new Grupo();
        String sql = "INSERT INTO grupo (idMesa, horaLlegada) VALUES (?,SYSDATETIMEOFFSET());";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, numeroMesa);
            int registroAdd = stm.executeUpdate();
            if (registroAdd > 0) {
                JOptionPane.showMessageDialog(null, "Grupo creado");
                grupo1 = buscarGrupo(conexion, numeroMesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grupo1;
    }

    public List<Persona> obtenerPersonasGrupo(Connection conexion, int mesa) {
        String sql = """
                     SELECT persona.idTipoDNI, persona.idDNIPersona, nombre, apellido FROM persona_grupo 
                                                  INNER JOIN persona ON persona.idDNIPersona = persona_grupo.idPersona
                                                  WHERE idGrupo = ?
                                                  ORDER BY horaLlegada DESC;
                     """;
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, String.valueOf(mesa));

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                listaPersonas.add(
                        new Persona(
                                rs.getString("idDNIPersona"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("idTipoDNI")
                        )
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPersonas;
    }

    //----DOCUMENTOS-----
    public List<TipoDNI> obtenerTiposDNI(Connection conexion) {
        String sql = "SELECT idTipoDNI FROM tipo_DNI;";

        listaTiposDNI.clear();

        try {
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                listaTiposDNI.add(
                        new TipoDNI(
                                rs.getString("idTipoDNI")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaTiposDNI;
    }

    //------PERSONAS------
    public void registrarPersona(Connection conexion, Persona persona, String idGrupo) {
        try {
            //busca a la persona con su id y cedula
            Persona p1 = buscarPersona(conexion, persona);
            
            //si el id es 0 quiere decir que no existe, por lo tanto lo registra en la tabla persona
            if (p1.getIdDNIPersona()==null) {
                String sql = "INSERT INTO persona (idDNIPersona,nombre,apellido,idTipoDNI) VALUES (?,?,?,?);";

                PreparedStatement stm = conexion.prepareStatement(sql);
                stm.setString(1, persona.getIdDNIPersona());
                stm.setString(2, persona.getNombre());
                stm.setString(3, persona.getApeliido());
                stm.setString(4, persona.getTipoDNI());

                int registroAdd = stm.executeUpdate();
                if (registroAdd > 0) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso en persona");
                }
                p1 = buscarPersona(conexion, persona);
                
                
            } 
            //ahora la registra en grupo_persona
            registrarPersonaEnGrupo(conexion, p1.getIdDNIPersona(), idGrupo);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No pudo registrarse");
        }

    }

    public void registrarPersonaEnGrupo(Connection conexion, String idPersona, String idGrupo){
        String sql ="""
                    INSERT INTO persona_grupo (idGrupo,idPersona, horaLlegada) 
                    VALUES (?,?,SYSDATETIMEOFFSET());
                    """;
        try{
        PreparedStatement stm = conexion.prepareStatement(sql);
                stm.setString(1, idGrupo);
                stm.setString(2, idPersona);
                

                int registroAdd = stm.executeUpdate();
                if (registroAdd > 0) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso en grupo");
                }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    public void editarPersona(Connection conexion, Persona p, String numeroOriginal) {

        String sql = "UPDATE persona SET nombre=?,apellido = ? , idDNIPersona = ?, idTipoDNI = ? WHERE idDNIPersona = ?;";

        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, p.getNombre());
            stm.setString(2, p.getApeliido());
            stm.setString(3, p.getIdDNIPersona());
            stm.setString(4, p.getTipoDNI());
            stm.setString(5, numeroOriginal);

            int ok = stm.executeUpdate();
            conexion.commit();
            if (ok > 0) {
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void eliminarPersona(Connection conexion, String numero) {
        String sql = "DELETE FROM producto WHERE idProducto = ?;";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, numero);

            int paraBorrar = stm.executeUpdate();
            if (paraBorrar > 0) {
                JOptionPane.showMessageDialog(null, "Persona eliminado eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la persona");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Persona buscarPersona(Connection conexion, Persona persona) {
        Persona p = new Persona();
        String sql = "SELECT * FROM persona WHERE idDNIPersona = ? AND idTipoDNI = ?;";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, persona.getIdDNIPersona());
            stm.setString(2, persona.getTipoDNI());

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                p.setIdDNIPersona(rs.getString("idDNIPersona"));
                p.setNombre(rs.getString("nombre"));
                p.setApeliido(rs.getString("apellido"));
                p.setTipoDNI(rs.getString("idTipoDNI"));
                

            } else {
                JOptionPane.showMessageDialog(null, "Persona no está en los registros");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return p;
    }
}
