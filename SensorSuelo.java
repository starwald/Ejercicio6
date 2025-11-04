import java.util.ArrayList;

public class SensorSuelo extends Dispositivo implements Medible, Registrable {

    private double ultimaMedicion;
    private ArrayList<String> logEventos;

    public SensorSuelo(String id, String nombre, double consumoElectrico) {
        super(id, nombre, consumoElectrico);
        this.logEventos = new ArrayList<>();
        this.ultimaMedicion = 50.0 + (Math.random() * 20.0);
    }

    @Override
    public String obtenerMedicion() {
        this.ultimaMedicion = 50.0 + (Math.random() * 20.0);
        registrarEvento("Medición realizada: " + this.ultimaMedicion);
        return String.format("Humedad: %.2f%%", this.ultimaMedicion);
    }

    @Override
    public void registrarEvento(String evento) {
        this.logEventos.add(evento);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Sensor de Suelo";
    }
}