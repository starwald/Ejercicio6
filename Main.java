/**
 * Clase principal (Driver Program) que inicia la aplicación.
 * Sigue el patrón MVC creando e inyectando las dependencias del
 * Modelo (Cooperativa) y la Vista (VistaConsola) en el Controlador.
 */
public class Main {
    public static void main(String[] args) {
        Cooperativa modelo = new Cooperativa();
        
        VistaConsola vista = new VistaConsola();

        Controlador controlador = new Controlador(modelo, vista);

        controlador.run();
    }
}
