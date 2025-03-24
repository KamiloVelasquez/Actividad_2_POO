package proyectoskamilo.compuwork;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompuWork {

    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        List<Departamento> departamentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Crear algunos departamentos de ejemplo
        departamentos.add(new Departamento(1, "Ventas"));
        departamentos.add(new Departamento(2, "Recursos Humanos"));
        departamentos.add(new Departamento(3, "Tecnologia"));

        System.out.println("\nGestion Empleados - Compuwork");

        while (true) {
            System.out.println("\n1. Ingresar Empleado Fijo");
            System.out.println("2. Ingresar Empleado Temporal");
            System.out.println("3. Generar Reporte");
            System.out.println("4. Listar Empleados");
            System.out.println("5. Eliminar Empleado");
            System.out.println("6. Actualizar Empleado");
            System.out.println("7. Asignar Departamento a Empleado");
            System.out.println("8. Salir");
            System.out.print("\nSeleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    empleados.add(crearEmpleadoFijo(scanner));
                    break;
                case 2:
                    empleados.add(crearEmpleadoTemporal(scanner));
                    break;
                case 3:
                    generarReporte(scanner, empleados);
                    break;
                case 4:
                    listarEmpleados(empleados);
                    break;
                case 5:
                    eliminarEmpleado(scanner, empleados);
                    break;
                case 6:
                    actualizarEmpleado(scanner, empleados);
                    break;
                case 7:
                    asignarDepartamento(scanner, empleados, departamentos);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    // Metodos para crear empleados, generar reportes, listar empleados, eliminar, actualizar y asignar departamento
    // (Ver codigo anterior para implementar estos metodos)

    // Metodo para crear un empleado fijo
    private static EmpleadoFijo crearEmpleadoFijo(Scanner scanner) {
        System.out.println("\nIngrese los datos para el empleado fijo:");
        System.out.print("ID Empleado: ");
        int idFijo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre Completo: ");
        String nombreFijo = scanner.nextLine();
        System.out.print("Direccion: ");
        String direccionFijo = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefonoFijo = scanner.nextLine();
        System.out.print("Salario: ");
        float salarioFijo = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Año de ingreso: ");
        int añoIngreso = scanner.nextInt();
        scanner.nextLine();

        Contrato contratoFijo = new Contrato(LocalDate.now(), null, "Fijo");

        return new EmpleadoFijo(idFijo, nombreFijo, direccionFijo, telefonoFijo, salarioFijo, contratoFijo, añoIngreso);
    }

    // Metodo para crear un empleado temporal
    private static EmpleadoTemporal crearEmpleadoTemporal(Scanner scanner) {
        System.out.println("\nIngrese los datos para el empleado temporal:");
        System.out.print("ID Empleado: ");
        int idTemporal = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre Completo: ");
        String nombreTemporal = scanner.nextLine();
        System.out.print("Direccion: ");
        String direccionTemporal = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefonoTemporal = scanner.nextLine();
        System.out.print("Salario: ");
        float salarioTemporal = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Fecha de fin de contrato (dias a partir de hoy): ");
        int diasFinContrato = scanner.nextInt();
        scanner.nextLine();

        LocalDate fechaFinContrato = LocalDate.now().plusDays(diasFinContrato);
        Contrato contratoTemporal = new Contrato(LocalDate.now(), fechaFinContrato, "Temporal");

        return new EmpleadoTemporal(idTemporal, nombreTemporal, direccionTemporal, telefonoTemporal, salarioTemporal, contratoTemporal, fechaFinContrato);
    }

    // Metodo para generar un reporte
    private static void generarReporte(Scanner scanner, List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para generar un reporte.");
            return;
        }

        System.out.println("\nGenerar Reporte:");
        System.out.print("Ingrese el numero del reporte: ");
        String metricas = scanner.nextLine();
        LocalDate fechaGeneracion = LocalDate.now();

        for (Empleado empleado : empleados) {
            System.out.println("\n=== Reporte de Empleado ===");
            System.out.println("Reporte #" + metricas );
            System.out.println("Fecha de Generacion: " + fechaGeneracion);
            System.out.println("\n=== Detalles del Empleado ===");
            System.out.println("ID Empleado: " + empleado.getIdEmpleado());
            System.out.println("Nombre Completo: " + empleado.getNombreCompleto());
            System.out.println("Direccion: " + empleado.getDireccion());
            System.out.println("Telefono: " + empleado.getTelefono());
            System.out.println("Salario: " + empleado.getSalario());
            System.out.println("Tipo de Contrato: " + empleado.getContrato().getTipoContrato());

            if (empleado instanceof EmpleadoTemporal) {
                EmpleadoTemporal temp = (EmpleadoTemporal) empleado;
                System.out.println("Fecha de Fin de Contrato: " + temp.getFechaFinContrato());
                temp.verificarFinContrato();
            } else if (empleado instanceof EmpleadoFijo) {
                EmpleadoFijo fijo = (EmpleadoFijo) empleado;
                System.out.println("Año de Ingreso: " + fijo.getAñoIngreso());
                System.out.println("Antigüedad: " + fijo.calcularAntiguedad() + " años");
            }

            System.out.println("============================");
        }
    }

    // Metodo para listar todos los empleados
    private static void listarEmpleados(List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.println("\nLista de Empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
    
   

    // Metodo para eliminar un empleado
    private static void eliminarEmpleado(Scanner scanner, List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.print("\nIngrese el ID del empleado a eliminar: ");
        int idEliminar = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (Empleado empleado : empleados) {
            if (empleado.getIdEmpleado() == idEliminar) {
                empleados.remove(empleado);
                System.out.println("Empleado con ID " + idEliminar + " eliminado exitosamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro un empleado con el ID " + idEliminar + ".");
        }
    }

    // Metodo para actualizar un empleado
    private static void actualizarEmpleado(Scanner scanner, List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.print("\nIngrese el ID del empleado a actualizar: ");
        int idActualizar = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (Empleado empleado : empleados) {
            if (empleado.getIdEmpleado() == idActualizar) {
                System.out.println("\nIngrese los nuevos datos para el empleado:");

                System.out.print("Nombre Completo: ");
                String nombre = scanner.nextLine();
                System.out.print("Direccion: ");
                String direccion = scanner.nextLine();
                System.out.print("Telefono: ");
                String telefono = scanner.nextLine();
                System.out.print("Salario: ");
                float salario = scanner.nextFloat();
                scanner.nextLine();

                empleado.setNombreCompleto(nombre);
                empleado.setDireccion(direccion);
                empleado.setTelefono(telefono);
                empleado.setSalario(salario);

                System.out.println("Empleado con ID " + idActualizar + " actualizado exitosamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro un empleado con el ID " + idActualizar + ".");
        }
    }

    // Metodo para asignar un empleado a un departamento
    private static void asignarDepartamento(Scanner scanner, List<Empleado> empleados, List<Departamento> departamentos) {
        if (empleados.isEmpty() || departamentos.isEmpty()) {
            System.out.println("No hay empleados o departamentos registrados.");
            return;
        }

        System.out.print("\nIngrese el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nLista de Departamentos:");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }

        System.out.print("Ingrese el ID del departamento: ");
        int idDepartamento = scanner.nextInt();
        scanner.nextLine();

        Empleado empleado = buscarEmpleadoPorId(empleados, idEmpleado);
        Departamento departamento = buscarDepartamentoPorId(departamentos, idDepartamento);

        if (empleado != null && departamento != null) {
            empleado.setDepartamento(departamento);
            System.out.println("Departamento asignado correctamente.");
        } else {
            System.out.println("No se encontro el empleado o el departamento.");
        }
    }

    // Metodo auxiliar para buscar un empleado por ID
    private static Empleado buscarEmpleadoPorId(List<Empleado> empleados, int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdEmpleado() == id) {
                return empleado;
            }
        }
        return null;
    }

    // Metodo auxiliar para buscar un departamento por ID
    private static Departamento buscarDepartamentoPorId(List<Departamento> departamentos, int id) {
        for (Departamento departamento : departamentos) {
            if (departamento.getIdDpto() == id) {
                return departamento;
            }
        }
        return null;
    }
}