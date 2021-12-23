package FC;

import FC.entities.Alumno;
import FC.entities.Etiqueta;
import FC.entities.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        List<Alumno> alumnoList = new ArrayList<>();

        List<Usuario> usuarioList = new ArrayList<>();

        Usuario usuario = new Usuario("a", "a");

        usuarioList.add(usuario);
        usuario.setUsuarios(usuarioList);

        byte option;

        boolean cicle = true;

        boolean login = true;

        boolean bEtiqueta = true;

        StringBuilder sb = new StringBuilder();

        while (cicle) {
            try {

                //----------MENU DE OPCIONES

                option = Byte.parseByte(JOptionPane.showInputDialog(
                        """
                                *** FC EJERCICIO 5 ***
                                                                
                                1. REGISTRAR USUARIO
                                2. LOGIN
                                3. LISTAR ALUMNOS
                                0. EXIT"""));

                switch (option) {
                    case 1 -> {
                        Usuario usuario1 = new Usuario();

                        String email = JOptionPane.showInputDialog("Escriba el email").toLowerCase(Locale.ROOT);
                        while (!email.contains("@") || !email.contains(".")) {
                            email = JOptionPane.showInputDialog("Formato invalido, reintente").toLowerCase(Locale.ROOT);
                        }
                        String password = JOptionPane.showInputDialog("Escriba su contraseña");
                        while (password.length() < 6) {
                            password = (JOptionPane.showInputDialog("Minimo 6 caracteres"));
                        }
                        usuario1.setEmail(email);
                        usuario1.setPassword(password);
                        usuarioList.add(usuario1);
                        usuario.setUsuarios(usuarioList);
                        JOptionPane.showMessageDialog(null, "Usuario: " + email + " almacenado correctamente");
                    }
                    case 2 -> {
                        if (usuario.getUsuarios().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay ningun usuario ingresado en el sistema");
                        } else {
                            String email = JOptionPane.showInputDialog("Escriba su email").toLowerCase(Locale.ROOT);
                            String password = JOptionPane.showInputDialog("Escriba su contraseña");
                            if (usuario.login(email, password)) {
                                while (login)

                                    try {

                                        option = Byte.parseByte(JOptionPane.showInputDialog(
                                                """
                                                        *** FC EJERCICIO 5 ***
                                                        BIENVENIDO:\040""" + email + """
                                                                                                                
                                                        1. REGISTRAR ALUMNO
                                                        2. LISTAR ALUMNOS
                                                        3. LOGOUT
                                                        ELIJA UNA OPCION :)"""));

                                        switch (option) {
                                            case 1 -> {
                                                Alumno alumno = new Alumno();
                                                String nombre = JOptionPane.showInputDialog("Ingrese nombre");
                                                String correo = JOptionPane.showInputDialog("Ingrese email");
                                                while (!correo.contains("@") || !correo.contains(".")) {
                                                    correo = JOptionPane.showInputDialog("Formato invalido, reintente").toLowerCase(Locale.ROOT);
                                                }
                                                String ciudad = JOptionPane.showInputDialog("Ingrese ciudad");
                                                String pais = JOptionPane.showInputDialog("Ingrese pais");
                                                String telefono = JOptionPane.showInputDialog("Ingrese telefono");
                                                String presencialidad = "";

                                                int respPresencialidad = JOptionPane.showOptionDialog(null, "Seleccione una opcion",
                                                        "PRESENCIALIDAD", JOptionPane.YES_NO_CANCEL_OPTION,
                                                        JOptionPane.QUESTION_MESSAGE, null,
                                                        new Object[]{"Remoto", "Presencial", "Mixto"}, "Remoto");
                                                if (respPresencialidad == 0) presencialidad = "Remoto";
                                                if (respPresencialidad == 1) presencialidad = "Presencial";
                                                if (respPresencialidad == 2) presencialidad = "Mixto";

                                                boolean traslado;
                                                int respTraslado = JOptionPane.showConfirmDialog(null, "¿Traslado disponible?");
                                                traslado = JOptionPane.OK_OPTION == respTraslado;

                                                List<Etiqueta> etiquetas = new ArrayList<>();

                                                while (bEtiqueta) {
                                                    Etiqueta etiqueta = new Etiqueta();

                                                    int respEtiqueta = JOptionPane.showConfirmDialog(null, "¿Desea asignar una nueva etiqueta?");
                                                    if (JOptionPane.OK_OPTION == respEtiqueta) {
                                                        etiqueta.setLanguage(JOptionPane.showInputDialog(null, "Digite el nombre de la etiqueta").toLowerCase(Locale.ROOT));
                                                        if (!etiqueta.getLanguage().isEmpty())
                                                        etiquetas.add(etiqueta);
                                                        else {
                                                            etiqueta.setLanguage(JOptionPane.showInputDialog(null, "El campo no puede estar vacio").toLowerCase(Locale.ROOT));
                                                        }
                                                    } else {
                                                        bEtiqueta = false;
                                                    }
                                                }
                                                alumno.setName(nombre);
                                                alumno.setCity(ciudad);
                                                alumno.setCountry(pais);
                                                alumno.setEmail(email);
                                                alumno.setTel(telefono);
                                                alumno.setPresenciality(presencialidad);
                                                alumno.setTraslate(traslado);
                                                alumno.setEtiquetas(etiquetas);
                                                alumnoList.add(alumno);
                                                usuario.setAlumnos(alumnoList);
                                                JOptionPane.showMessageDialog(null, "Se ha almacenado correctamente al alumno " + nombre);
                                                bEtiqueta = true;
                                            }


                                            case 2 -> {
                                                if (usuario.getAlumnos().isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "La base de datos se encuentra vacia");
                                                } else {
                                                    for (Alumno a : usuario.getAlumnos()
                                                    ) {
                                                        sb.append(a).append("\n");
                                                    }
                                                    JOptionPane.showMessageDialog(null, sb);
                                                }sb.setLength(0);
                                            }

                                            case 3 -> {
                                                JOptionPane.showMessageDialog(null, "Salida Exitosa");
                                                login = false;
                                            }

                                            default -> JOptionPane.showMessageDialog(null, "Elija una opcion valida");
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Elija una opcion valida");
                                    }
                            } else JOptionPane.showMessageDialog(null, "Usuario o contraseña erroneos");
                        }
                    }
                    case 3 -> JOptionPane.showMessageDialog(null, "Debe loguearse para listar los alumnos");

                    case 0 -> {

                        JOptionPane.showMessageDialog(null, "Closing ....");
                        cicle = false;
                        System.exit(0);


                    }

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Elija una opcion valida");
            }
        }
    }
}



