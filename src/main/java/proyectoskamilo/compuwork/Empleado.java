package proyectoskamilo.compuwork;

public abstract class Empleado {
    private int idEmpleado;
    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private float salario;
    private Contrato contrato;
    private Departamento departamento; // Nuevo atributo para asignar departamento

    public Empleado(int idEmpleado, String nombreCompleto, String direccion, String telefono, float salario, Contrato contrato) {
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.salario = salario;
        this.contrato = contrato;
    }

    // Método abstracto para calcular la antigüedad (obligatorio para las clases hijas)
    public abstract int calcularAntiguedad();

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "ID: " + idEmpleado + ", Nombre: " + nombreCompleto + ", Direccion: " + direccion +
               ", Telefono: " + telefono + ", Salario: " + salario + ", Contrato: " + contrato +
               ", Departamento: " + (departamento != null ? departamento.getNombre() : "Sin asignar");
    }
}