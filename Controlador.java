import java.util.ArrayList;

/**
 * Clase Controlador (MVC).
 * Orquesta la aplicación. Recibe entradas de la Vista,
 * procesa solicitudes a través del Modelo y envía los resultados
 * de vuelta a la Vista para mostrarlos.
 */
public class Controlador {

    private Cooperativa modelo;
    private VistaConsola vista;

    public Controlador(Cooperativa modelo, VistaConsola vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    /**
     * Inicia el bucle principal de la aplicación.
     * Se usa un flag booleano para evitar el while(true).
     */
    public void run() {
        boolean seguir = true;

        while (seguir) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    gestionarOpcionListar();
                    break;
                case 2:
                    gestionarOpcionBuscarId();
                    break;
                case 3:
                    gestionarOpcionBuscarNombre();
                    break;
                case 4:
                    gestionarOpcionOrdenar();
                    break;
                case 5:
                    seguir = false;
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no reconocida.");
                    break;
            }
        }
        vista.cerrarScanner();
    }

    /**
     * Orquesta el listado de todos los equipos.
     */
    private void gestionarOpcionListar() {
        ArrayList<Dispositivo> lista = modelo.getDispositivos();
        vista.mostrarListaDispositivos(lista);
    }

    /**
     * Orquesta la búsqueda por ID.
     */
    private void gestionarOpcionBuscarId() {
        String id = vista.solicitarString("Ingrese el ID del equipo a buscar: ");
        Dispositivo d = modelo.buscarPorId(id);
        vista.mostrarDispositivo(d);
    }

    /**
     * Orquesta la búsqueda por Nombre.
     */
    private void gestionarOpcionBuscarNombre() {
        String nombre = vista.solicitarString("Ingrese el Nombre (o parte) a buscar: ");
        Dispositivo d = modelo.buscarPorNombre(nombre);
        vista.mostrarDispositivo(d);
    }

    /**
     * Orquesta el ordenamiento por consumo y muestra el resultado.
     */
    private void gestionarOpcionOrdenar() {
        modelo.ordenarPorConsumo();
        vista.mostrarMensaje("\nEquipos ordenados por consumo eléctrico (ascendente):");
        gestionarOpcionListar();
    }
}