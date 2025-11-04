import java.util.ArrayList;

public class DronRiego extends Dispositivo implements Accionable, Registrable {

    private double capacidadTanque;
    private double nivelActualTanque;
    private ArrayList<String> logVuelos;

    public DronRiego(String id, String nombre, double consumoElectrico, double capacidadTanque) {
        super(id, nombre, consumoElectrico);
        this.capacidadTanque = capacidadTanque;
        this.nivelActualTanque = capacidadTanque;
        this.logVuelos = new ArrayList<>();
    }

    @Override
    public String ejecutarAccion(String accion) {
        if (accion.equalsIgnoreCase("regar")) {
            if (nivelActualTanque > 0) {
                this.nivelActualTanque -= 5.0;
                if(this.nivelActualTanque < 0) this.nivelActualTanque = 0;
                String evento = "Ejecutando riego. Nivel restante: " + this.nivelActualTanque + "L";
                registrarEvento(evento);
                return evento;
            } else {
                return "Tanque vacío. No se puede regar.";
            }
        }
        return "Acción '" + accion + "' no reconocida.";
    }

    @Override
    public void registrarEvento(String evento) {
        this.logVuelos.add(evento);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Dron Riego (Tanque: %.1fL)", this.capacidadTanque);
    }
}