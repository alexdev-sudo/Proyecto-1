package Entidades;
import java.time.LocalDate;
import java.util.Scanner;


public class Entrenamientos {
    private LocalDate fecha;
    private String tipo;
    private double valor;
    private String unidad;
    private String Ubicacion;
    private String pais;

    public Entrenamientos(LocalDate fecha,String tipo,double valor,String unidad
            , String ubicacion, String pais) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
        this.unidad = unidad;
        this.Ubicacion = ubicacion;
        this.pais= pais;

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
    public String getUbicacion() {
        if (Ubicacion == null) {
            return "Nacional";
        }
        return Ubicacion;
    }
    public  String getPais() {
        if (pais == null) {
            return "Guatemala";
        }
        return pais;

    }

    public static String paisubicacion(Scanner sc){
        int input = Integer.parseInt(sc.nextLine());
        String ubicacionvalida = "";
        if ( input == 1) {
             return "Nacional";
        }else if (input == 2){
            return   "Internacional";

        }else{
            System.out.println("opcion no valida, se asignara nacional");
        }
        return "Nacional";
    }

}

