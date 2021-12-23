package FC.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario implements Serializable {

    String email;
    String password;
    boolean login;

    public Usuario(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    List<Alumno> alumnos = new ArrayList<>();

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean login(String email, String password) {
        this.email = email;
        this.password = password;
        for (Usuario usuario : usuarios
        ) {
            if (Objects.equals(email, usuario.getEmail()) && Objects.equals(password, usuario.getPassword())) {
                login = true;
                break;
            } else {
                login = false;
            }
        }
        return login;
    }
}