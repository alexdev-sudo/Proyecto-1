package Entidades;
import java.time.LocalDate;
public class Entrenamientos {
    private LocalDate fecha;
    private String tipo;
    private double valor;
    private String unidad;

    public Entrenamientos(LocalDate fecha,String tipo,double valor,String unidad) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
        this.unidad = unidad;

    }

    public LocalDate getFecha() {return fecha;
    }
    public String getTipo() {return tipo;
    }

    public Double getValor() {
        return valor;
    }
    public String getUnidad() {
        return unidad;
    }
}
