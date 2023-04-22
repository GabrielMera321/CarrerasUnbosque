package co.edu.unbosque.model;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase EstudianteDAO representa un objeto de acceso a datos (Data Access
 * Object) para estudiantes. Gestiona un ArrayList de objetos Estudiante y
 * permite agregar, eliminar, actualizar y listar estudiantes.
 */
public class EstudianteDAO {

	private ArrayList<Estudiante> list;

	public EstudianteDAO() {
		list = new ArrayList<>();
	}

	/**
	 * Agrega un nuevo estudiante a la lista.
	 *
	 * @param nombre           El nombre del estudiante.
	 * @param fecha_nacimiento La fecha de nacimiento del estudiante.
	 * @param colegio          El colegio del estudiante.
	 * @param carrera          La carrera del estudiante.
	 * @param estrato          El estrato socioeconómico del estudiante.
	 * @param homologacion     Indica si el estudiante ha recibido reconocimiento de
	 *                         créditos de cursos.
	 * @param foto             La ruta de la foto del estudiante.
	 */
	public void agregar(String nombre, LocalDate fecha_nacimiento, String colegio, String carrera, String estrato,
			boolean homologacion, Path foto) {
		Estudiante estudiante = new Estudiante(nombre, fecha_nacimiento, colegio, carrera, estrato, homologacion, foto);
		list.add(estudiante);
		System.out.println("Estudiante agregado: " + estudiante);
	}

	/**
	 * Elimina un estudiante de la lista por su nombre.
	 *
	 * @param nombre El nombre del estudiante a eliminar.
	 * @return true si el estudiante fue eliminado, false en caso contrario.
	 */
	public boolean eliminar(String nombre) {
		for (Estudiante estudiante : list) {
			if (estudiante.getNombre().equals(nombre)) {
				list.remove(estudiante);
				return true;
			}
		}
		return false;
	}

	/**
	 * Actualiza la información de un estudiante en la lista.
	 *
	 * @param nombreActual         El nombre actual del estudiante.
	 * @param nuevoNombre          El nuevo nombre del estudiante.
	 * @param nuevaFechaNacimiento La nueva fecha de nacimiento del estudiante.
	 * @param nuevoColegio         El nuevo colegio del estudiante.
	 * @param nuevaCarrera         La nueva carrera del estudiante.
	 * @param nuevoEstrato         El nuevo estrato socioeconómico del estudiante.
	 * @param nuevaHomologacion    Indica si el estudiante ha recibido
	 *                             reconocimiento de créditos de cursos.
	 * @return true si el estudiante fue actualizado, false en caso contrario.
	 */
	public boolean actualizar(String nombreActual, String nuevoNombre, LocalDate nuevaFechaNacimiento,
			String nuevoColegio, String nuevaCarrera, String nuevoEstrato, boolean nuevaHomologacion) {
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

	/**
	 * Devuelve una representación
	 *
	 * @return Una cadena que contiene la información de todos los estudiantes en la
	 *         lista.
	 */
	public String listar() {
		StringBuilder sb = new StringBuilder("");
		for (Estudiante estudiante : list) {
			sb.append(estudiante.toString());
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	/**
	 * Obtiene la lista de estudiantes.
	 *
	 * @return El ArrayList de estudiantes.
	 */
	ArrayList<Estudiante> getList() {
		return list;
	}

	/**
	 * Establece la lista de estudiantes.
	 *
	 * @param list El ArrayList de estudiantes.
	 */
	public void setList(ArrayList<Estudiante> list) {
		this.list = list;
	}
}