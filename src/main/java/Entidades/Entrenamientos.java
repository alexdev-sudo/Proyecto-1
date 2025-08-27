package Entidades;
import java.time.LocalDate;
public class Entrenamientos {
    private LocalDate fecha;
    private String tipo;
    private double valor;

    public Entrenamientos(LocalDate fecha,String tipo,double valor) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
    }

    public LocalDate getFecha() {return fecha;
    }
    public String getTipo() {return tipo;
    }

    public Double getValor() {
        return valor;
    }
}
