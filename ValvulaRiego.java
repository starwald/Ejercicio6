import java.util.ArrayList;

public class ValvulaRiego extends Dispositivo implements Accionable, Registrable {

    private boolean estadoAbierta;
    private ArrayList<String> logOperaciones;

    public ValvulaRiego(String id, String nombre, double consumoElectrico) {
        super(id, nombre, consumoElectrico);
        this.estadoAbierta = false;
        this.logOperaciones = new ArrayList<>();
    }

    @Override
    public String ejecutarAccion(String accion) {
        String evento = "";
        if (accion.equalsIgnoreCase("abrir")) {
            this.estadoAbierta = true;
            evento = "Válvula ABIERTA.";
        } else if (accion.equalsIgnoreCase("cerrar")) {
            this.estadoAbierta = false;
            evento = "Válvula CERRADA.";
        } else {
            return "Acción '" + accion + "' no reconocida.";
        }
        registrarEvento(evento);
        return evento;
    }

    @Override
    public void registrarEvento(String evento) {
        this.logOperaciones.add(evento);
    }

    @Override
    public String toString() {
        String estado = this.estadoAbierta ? "ABIERTA" : "CERRADA";
        return super.toString() + " | Tipo: Válvula Riego | Estado: " + estado;
    }
}