
import Entidades.*;
import Gestiones.*;
import Persistencia.GestorJSON;
import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Gestor_Atletas gestor = new Gestor_Atletas();
    GestorEstadistica estadisticas = new GestorEstadistica();
    GestorJSON json = new GestorJSON();

    // cargar datos previos
        var atletascargados = json.cargar();
        if (atletascargados != null) {
            atletascargados.forEach(gestor :: agregar);
        }
        Scanner leer = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("\n---sistema de control de rendimiento de atletas---");
            System.out.println("1. registrar nuevo atleta");
            System.out.println("2. registrar entrenamiento");
            System.out.println("3. Mostrar historial de un atleta");
            System.out.println("4. Mostrar estadisticas de un atleta");
            System.out.println("5. Guardar y salir");
            System.out.print("seleccione una opcion: ");
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingresa el nombre del atleta: ");
                    String nombre = leer.nextLine();
                    System.out.println("ingrese la edad del atleta: ");
                    int edad = leer.nextInt();
                    System.out.println("ingrese departamento del atleta: ");
                    String depart = leer.nextLine();
                    System.out.println("ingrese disciplina del atleta: ");
                    String disc = leer.nextLine();
                    System.out.println("ingrese unidad de medida del entrenemiento de atleta: ");
                    String med = leer.nextLine();
                    atleta atleta1 = new atleta(nombre, edad,depart,new Disciplina(disc,med));
                    gestor.agregar(atleta1);
                    System.out.println("atleta registrado exitosamente");

                    break;
                case 2:
                    System.out.println("Ingresa el nombre del atleta: ");
                    String nombreatleta = leer.nextLine();
                    atleta a = gestor.buscar(nombreatleta);
                    if (nombreatleta != null) {
                        System.out.println("ingrese tipo de entrenamiento del atleta: ");
                        String tipo = leer.nextLine();
                        System.out.println("Ingrese valor del entrenamiento del atleta: ");
                        double datoentreno = leer.nextDouble();
                        leer.nextLine();
                        a.agregarEntrenamiento(new Entrenamientos(LocalDate.now(), tipo, datoentreno));
                        System.out.println("entrenamiento agregado exitosamente");
                    }else{
                        System.out.println("ateleta no existe");

                    }
                    break;
                case 3:

                    System.out.println("Ingresa el nombre del atleta: ");
                    String nombrehistorial = leer.nextLine();
                    atleta h = gestor.buscar(nombrehistorial);
                    if (h != null) {
                        estadisticas.mostrarHistorial(h);
                    }else {
                        System.out.println("atletea no existe");

                    }
                    
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del atleta: ");
                    String nombreestadistica = leer.nextLine();
                    atleta s = gestor.buscar(nombreestadistica);
                    if (s != null) {
                        System.out.println("Promedio: " + estadisticas.promedio(s));
                        System.out.println("Mejor Marca: " + estadisticas.mejormarca(s));
                    }else{
                        System.out.println("atleta no existe");

                    }
                    break;
                case 5:
                    json.guardar(gestor.getAtletas());
                    System.out.println("datos guardados exitosamente");
                    break;
                default:
                    System.out.println("opcion invalida");

            }

        }while(opcion!=5);

    }
}
