package dgtic.core.inicio;

import dgtic.core.modelo.Descuento;
import dgtic.core.modelo.Rol;
import dgtic.core.modelo.Usuario;
import dgtic.core.modelo.UsuarioRol;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        try {

            // Cargar el contexto de Spring desde el archivo de configuración XML
            ApplicationContext context = new ClassPathXmlApplicationContext("bean-configuration.xml");

            // Obtiene los usuarios
            Usuario williams = context.getBean("williams", Usuario.class);
            Usuario maria = context.getBean("maria", Usuario.class);
            Usuario juan = context.getBean("juan", Usuario.class);
            System.out.println("===== LOS USUARIOS SON =====");
            System.out.println("1.- " + williams.obtenerNombreCompleto());
            System.out.println("2.- " + maria.obtenerNombreCompleto());
            System.out.println("3.- " + juan.obtenerNombreCompleto());

            // Obtiene los descuentos
            Descuento descuentoBienvenida = context.getBean("descuentoBienvenida", Descuento.class);
            Descuento descuentoEspecial = context.getBean("descuentoEspecial", Descuento.class);
            Descuento descuentoAniversario = context.getBean("descuentoAniversario", Descuento.class);
            System.out.println("\n===== LOS DESCUENTOS SON =====");
            System.out.println("1.- " + descuentoBienvenida.getNombre() + " del " + descuentoBienvenida.getPorcentaje() + "%" + " creado por: " + descuentoBienvenida.getUsuario().obtenerNombreCompleto());
            System.out.println("2.- " + descuentoEspecial.getNombre() + " del " + descuentoEspecial.getPorcentaje() + "%" +  " creado por: " + descuentoEspecial.getUsuario().obtenerNombreCompleto());
            System.out.println("3.- " + descuentoAniversario.getNombre() + " del " + descuentoAniversario.getPorcentaje() + "%" + " creado por: " + descuentoAniversario.getUsuario().obtenerNombreCompleto());

            // Obtiene los roles
            Rol rolCliente = context.getBean("rolCliente", Rol.class);
            Rol rolVendedor = context.getBean("rolVendedor", Rol.class);
            Rol rolAdministrador = context.getBean("rolAdministrador", Rol.class);
            System.out.println("\n===== LOS ROLES SON =====");
            System.out.println("1.- " + rolCliente.obtenerDescripcionCompleta());
            System.out.println("2.- " + rolVendedor.obtenerDescripcionCompleta());
            System.out.println("3.- " + rolAdministrador.obtenerDescripcionCompleta());

            // Obtiene los usuarios-roles
            UsuarioRol usuarioRolWilliamsCliente = context.getBean("usuarioRolWilliamsCliente", UsuarioRol.class);
            UsuarioRol usuarioRolMariaVendedor = context.getBean("usuarioRolMariaVendedor", UsuarioRol.class);
            UsuarioRol usuarioRolJuanAdministrador = context.getBean("usuarioRolJuanAdministrador", UsuarioRol.class);
            System.out.println("\n===== LOS ROLES ASIGNADOS SON =====");
            System.out.println("1.- " + usuarioRolWilliamsCliente.getUsuario().getNombre() + " tiene el rol de " + usuarioRolWilliamsCliente.getRol().getNombre());
            System.out.println("2.- " + usuarioRolMariaVendedor.getUsuario().getNombre() + " tiene el rol de " + usuarioRolMariaVendedor.getRol().getNombre());
            System.out.println("3.- " + usuarioRolJuanAdministrador.getUsuario().getNombre() + " tiene el rol de " + usuarioRolJuanAdministrador.getRol().getNombre());

            // Jugando con algunos métodos
            System.out.println("\n===== JUGANDO CON ALGUNOS MÉTODOS =====");

            System.out.println("\n===== Verificación de credenciales =====");
            String correoElectronico = "williams@gmail.com";
            String contrasenia = "williams123";
            System.out.println("Correo del usuario Williams: " + williams.getCorreoElectronico());
            System.out.println("Contraseña del usuario Williams: " + williams.getContrasenia());
            System.out.println("Correo electrónico a verificar: " + correoElectronico);
            System.out.println("Contraseña a verificar: " + contrasenia);
            System.out.println("Respuesta: " + (williams.verificarCredenciales(correoElectronico, contrasenia) ? "Verificación exitosa" : "Verificación fallida"));

            System.out.println("\n===== Cambio de correo electrónico =====");
            String correoElectronicoNuevo = "williams@gmail.com";
            System.out.println("Correo del usuario Williams: " + williams.getCorreoElectronico());
            System.out.println("Haciendo el cambio...");
            williams.setCorreoElectronico(correoElectronicoNuevo);
            System.out.println("Correo electrónico a actualizado: " + williams.getCorreoElectronico());

            System.out.println("\n===== Aplicando un descuento a un precio =====");
            Double precio = 135.99;
            System.out.println("Precio: $" + precio);
            System.out.println("Descuento a aplicar: " + descuentoAniversario.getNombre() + " del " + descuentoAniversario.getPorcentaje() + "%");
            System.out.println("Precio con descuento: $" + descuentoAniversario.aplicarDescuento(precio));

            System.out.println("\n===== Cambiando el rol a un usuario =====");
            System.out.println("Usuario: " + williams.obtenerNombreCompleto());
            System.out.println("Rol actual: " + usuarioRolWilliamsCliente.getRol().getNombre());
            System.out.println("Rol a asignar: " + rolAdministrador.getNombre());
            System.out.println("Haciendo el cambio...");
            usuarioRolWilliamsCliente.asignarRol(rolAdministrador);
            System.out.println("Rol nuevo: " + usuarioRolWilliamsCliente.getRol().getNombre());

            // Cerrar el contexto de Spring
            ((ClassPathXmlApplicationContext) context).close();

        } catch (UnsatisfiedDependencyException e) {
            System.out.println("Error de dependencia.");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de lógica de negocio");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
