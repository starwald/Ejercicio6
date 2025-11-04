import java.util.ArrayList;

public class DronMonitoreo extends Dispositivo implements Accionable, Registrable {

    private String tipoCamara = "Multiespectral";
    private String ultimaCapturaRuta;
    private ArrayList<String> logCapturas;

    public DronMonitoreo(String id, String nombre, double consumoElectrico) {
        super(id, nombre, consumoElectrico);
        this.logCapturas = new ArrayList<>();
    }

    @Override
    public String ejecutarAccion(String accion) {
        if (accion.equalsIgnoreCase("escanear")) {
            this.ultimaCapturaRuta = "/img/captura_" + System.currentTimeMillis() + ".jpg";
            String evento = "Escaneo completado. Imagen guardada en: " + this.ultimaCapturaRuta;
            registrarEvento(evento);
            return evento;
        }
        return "Acción '" + accion + "' no reconocida.";
    }

    @Override
    public void registrarEvento(String evento) {
        this.logCapturas.add(evento);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Dron Monitoreo (Cámara: " + this.tipoCamara + ")";
    }
}