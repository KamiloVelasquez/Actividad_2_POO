package proyectoskamilo.compuwork;

import java.time.LocalDate;

public class Contrato {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tipoContrato;

    public Contrato(LocalDate fechaInicio, LocalDate fechaFin, String tipoContrato) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoContrato = tipoContrato;
    }

    public int calcularDuracionContrato() {
        if (fechaFin == null) {
            return -1; // Retornar -1 o algún valor que indique que no hay fecha de fin
        }
        return (int) java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    @Override
    public String toString() {
        String duracion = (fechaFin == null) ? "Indefinido" : calcularDuracionContrato() + " dias";
        return tipoContrato +
                ", duracion: " + duracion 
                ;
    }
}