package co.edu.unbosque.model;

import java.nio.file.Path;
import java.time.LocalDate;

public class Estudiante {

    private String nombre;
    private LocalDate fecha_nacimiento;
    private String colegio;
    private String carrera;
    private String estrato;
    private boolean homologacion;
    private Path foto;

    public Estudiante(String nombre, LocalDate fecha_nacimiento, String colegio, String carrera, String estrato,
            boolean homologacion, Path foto) {
        super();
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.colegio = colegio;
        this.carrera = carrera;
        this.estrato = estrato;
        this.homologacion = homologacion;
        this.foto = foto;
    }

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
                + ", carrera=" + carrera + ", estrato=" + estrato + ", homologacion=" + homologacion + ", foto=" + foto + "]";
    }
}

