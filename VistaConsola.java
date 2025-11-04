import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Vista (MVC).
 * Responsable de TODA la interacción con el usuario (mostrar menús,
 * pedir datos, mostrar resultados).
 * Es la única clase que puede usar System.out.println.
 */
public class VistaConsola {

    private Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y solicita una opción al usuario.
     * Incluye validación de entrada.
     * @return La opción seleccionada (1-5).
     */
    public int mostrarMenu() {
        int opcion = 0;
        boolean entradaValida = false;

        System.out.println("\n--- SISTEMA DE GESTIÓN AGRO-TECNOLÓGICA ---");
        System.out.println("1. Listar todos los equipos");
        System.out.println("2. Buscar equipo por ID");
        System.out.println("3. Buscar equipo por Nombre");
        System.out.println("4. Ordenar equipos por consumo eléctrico");
        System.out.println("5. Salir");
        
        while (!entradaValida) {
            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    entradaValida = true;
                } else {
                    System.out.println("Error: Opción debe estar entre 1 y 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
            } finally {
                scanner.nextLine();
            }
        }
        return opcion;
    }

    /**
     * Muestra un mensaje al usuario (ej. "Ingrese ID: ") y captura un String.
     */
    public String solicitarString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    /**
     * Muestra un mensaje genérico al usuario.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Recibe la lista polimórfica y la muestra en consola.
     */
    public void mostrarListaDispositivos(ArrayList<Dispositivo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay dispositivos registrados en el catálogo.");
            return;
        }
        System.out.println("\n--- CATÁLOGO DE EQUIPOS ---");
        for (Dispositivo d : lista) {
            System.out.println(d.toString());
        }
    }

    /**
     * Muestra la información detallada de un único dispositivo.
     * También demuestra el uso de las interfaces (instanceof).
     */
    public void mostrarDispositivo(Dispositivo d) {
        if (d == null) {
            System.out.println("Resultado: Equipo no encontrado.");
            return;
        }

        System.out.println("\n--- DETALLE DEL EQUIPO ---");
        System.out.println(d.toString());
        
        System.out.println("Capacidades Adicionales:");
        if (d instanceof Medible) {
            System.out.println("  -> [Medible]: " + ((Medible) d).obtenerMedicion());
        }
        if (d instanceof Accionable) {
            System.out.println("  -> [Accionable]: Puede ejecutar acciones (ej. 'regar', 'escanear', 'abrir')");
        }
        if (!(d instanceof Medible) && !(d instanceof Accionable)) {
            System.out.println("  -> (Ninguna capacidad especial registrada)");
        }
    }

    /**
     * Cierra el scanner al finalizar el programa.
     */
    public void cerrarScanner() {
        this.scanner.close();
    }
}