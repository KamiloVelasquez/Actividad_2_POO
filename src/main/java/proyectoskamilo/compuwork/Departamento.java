package proyectoskamilo.compuwork;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private int idDpto;
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(int idDpto, String nombre) {
        this.idDpto = idDpto;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepartamento(this); // Asignar el departamento al empleado
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
        empleado.setDepartamento(null); // Quitar el departamento del empleado
    }

    public int getIdDpto() {
        return idDpto;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Departamento " + idDpto +
                ", nombre: " + nombre
                ;
    }
}