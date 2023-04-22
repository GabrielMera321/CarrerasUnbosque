package co.edu.unbosque.model;

import java.nio.file.Path;
import java.time.LocalDate;

/**
 * La clase Estudiante representa un estudiante con varios atributos,
 * como nombre, fecha de nacimiento, colegio, carrera, estrato socioecon�mico,
 * reconocimiento de cr�ditos de cursos (homologaci�n) y una foto.
 */
public class Estudiante {

	private String nombre;
	private LocalDate fecha_nacimiento;
	private String colegio;
	private String carrera;
	private String estrato;
	private boolean homologacion;
	private Path foto;

	/**
	 * Constructor de la clase Estudiante.
	 *
	 * @param nombre           El nombre del estudiante.
	 * @param fecha_nacimiento La fecha de nacimiento del estudiante.
	 * @param colegio          El colegio del estudiante.
	 * @param carrera          La carrera del estudiante.
	 * @param estrato          El estrato socioecon�mico del estudiante.
	 * @param homologacion     Indica si el estudiante ha recibido reconocimiento de cr�ditos de cursos.
	 * @param foto             La ruta de la foto del estudiante.
	 */
	public Estudiante(String nombre, LocalDate fecha_nacimiento, String colegio, String carrera, String estrato,
			boolean homologacion, Path foto) {
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.colegio = colegio;
		this.carrera = carrera;
		this.estrato = estrato;
		this.homologacion = homologacion;
		this.foto = foto;
	}

	// Getters y setters para cada atributo

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getEstrato() {
		return estrato;
	}

	public void setEstrato(String estrato) {
		this.estrato = estrato;
	}

	public boolean isHomologacion() {
		return homologacion;
	}

	public void setHomologacion(boolean homologacion) {
		this.homologacion = homologacion;
	}

	public Path getFoto() {
		return foto;
	}

	public void setFoto(Path foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + ", colegio=" + colegio
				+ ", carrera=" + carrera + ", estrato=" + estrato + ", homologacion=" + homologacion + ", foto=" + foto
				+ "]";
	}
}

