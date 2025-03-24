package proyectoskamilo.compuwork;

import java.time.LocalDate;

public class EmpleadoTemporal extends Empleado {
    private LocalDate fechaFinContrato;

    public EmpleadoTemporal(int idEmpleado, String nombreCompleto, String direccion, String telefono, float salario, Contrato contrato, LocalDate fechaFinContrato) {
        super(idEmpleado, nombreCompleto, direccion, telefono, salario, contrato);
        this.fechaFinContrato = fechaFinContrato;
    }

    @Override
    public int calcularAntiguedad() {
        return 0; // No aplica para empleados temporales
    }

    public void verificarFinContrato() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(fechaFinContrato)) {
            System.out.println("El contrato temporal de " + getNombreCompleto() + " ha expirado.");
        } else {
            System.out.println("El contrato temporal de " + getNombreCompleto() + " sigue vigente.");
        }
    }

    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }
}