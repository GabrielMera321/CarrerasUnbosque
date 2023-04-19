package co.edu.unbosque.model;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

public class EstudianteDAO {

    private ArrayList<Estudiante> list;

    public EstudianteDAO() {
        list = new ArrayList<>();
    }

    public void agregar(String nombre, LocalDate fecha_nacimiento, String colegio, String carrera, String estrato, boolean homologacion, Path foto) {
        Estudiante estudiante = new Estudiante(nombre, fecha_nacimiento, colegio, carrera, estrato, homologacion, foto);
        list.add(estudiante);
    }

    public boolean eliminar(String nombre) {
        for (Estudiante estudiante : list) {
            if (estudiante.getNombre().equals(nombre)) {
                list.remove(estudiante);
                return true;
            }
        }
        return false;
    }

    public boolean actualizar(String nombreActual, String nuevoNombre, LocalDate nuevaFechaNacimiento, String nuevoColegio, String nuevaCarrera, String nuevoEstrato, boolean nuevaHomologacion) {
        for (Estudiante estudiante : list) {
            if (estudiante.getNombre().equals(nombreActual)) {
                estudiante.setNombre(nuevoNombre);
                estudiante.setFecha_nacimiento(nuevaFechaNacimiento);
                estudiante.setColegio(nuevoColegio);
                estudiante.setCarrera(nuevaCarrera);
                estudiante.setEstrato(nuevoEstrato);
                estudiante.setHomologacion(nuevaHomologacion);
                return true;
            }
        }
        return false;
    }

    public String listar() {

        StringBuilder sb = new StringBuilder("");
        for (Estudiante estudiante : list) {
            sb.append(estudiante.toString());

        }

        return sb.toString();

    }

    ArrayList<Estudiante> getList() {
        return list;
    }

    public void setList(ArrayList<Estudiante> list) {
        this.list = list;
    }
}