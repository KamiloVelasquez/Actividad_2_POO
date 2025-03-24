package proyectoskamilo.compuwork;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Reporte {
    private String metricas;
    private Date fechaGeneracion;
    private Empleado empleado;

    public Reporte(String metricas, Date fechaGeneracion, Empleado empleado) {
        this.metricas = metricas;
        this.fechaGeneracion = fechaGeneracion;
        this.empleado = empleado;
    }

    public void generarTXT() {
        //  generar reporte TXT
        System.out.println("Generando reporte...");
    }

   
//    private static void generarReporte(Scanner scanner, List<Empleado> empleados) {
//    if (empleados.isEmpty()) {
//        System.out.println("No hay empleados para generar un reporte.");
//        return;
//    }
//
//    System.out.println("\nGenerar Reporte:");
//    System.out.print("Ingrese las mtricas del reporte: ");
//    String metricas = scanner.nextLine();
//    LocalDate fechaGeneracion = LocalDate.now(); // Usar LocalDate para la fecha actual
//
//    for (Empleado empleado : empleados) {
//        System.out.println("\n=== Reporte de Empleado ===");
//        System.out.println("Numero de Reporte: " + metricas);
//        System.out.println("Fecha de Generacion: " + fechaGeneracion);
//        System.out.println("\n=== Detalles del Empleado ===");
//        System.out.println("ID Empleado: " + empleado.getIdEmpleado());
//        System.out.println("Nombre Completo: " + empleado.getNombreCompleto());
//        System.out.println("Direccion: " + empleado.getDireccion());
//        System.out.println("Telefono: " + empleado.getTelefono());
//        System.out.println("Salario: " + empleado.getSalario());
//        System.out.println("Tipo de Contrato: " + empleado.getContrato().getTipoContrato());
//
//        // Verificar si el empleado es temporal o fijo
//        if (empleado instanceof EmpleadoTemporal) {
//            EmpleadoTemporal temp = (EmpleadoTemporal) empleado;
//            System.out.println("Fecha de Fin de Contrato: " + temp.getFechaFinContrato());
//            temp.verificarFinContrato(); // Verificar si el contrato ha expirado
//        } else if (empleado instanceof EmpleadoFijo) {
//            EmpleadoFijo fijo = (EmpleadoFijo) empleado;
//            System.out.println("Año de Ingreso: " + fijo.getAñoIngreso());
//            System.out.println("Antiguedad: " + fijo.calcularAntiguedad() + " años");
//        }
//
//        System.out.println("============================");
    }
    
    
