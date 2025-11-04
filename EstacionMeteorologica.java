import java.util.ArrayList;

public class EstacionMeteorologica extends Dispositivo implements Medible, Registrable {

    private double ultimaTemp;
    private double ultimaHumedad;
    private ArrayList<String> historialReportes;

    public EstacionMeteorologica(String id, String nombre, double consumoElectrico) {
        super(id, nombre, consumoElectrico);
        this.historialReportes = new ArrayList<>();
    }

    @Override
    public String obtenerMedicion() {
        this.ultimaTemp = 18.0 + (Math.random() * 10.0);
        this.ultimaHumedad = 60.0 + (Math.random() * 15.0);
        String reporte = String.format("Temp: %.1f°C, Humedad: %.1f%%", this.ultimaTemp, this.ultimaHumedad);
        registrarEvento("Reporte generado: " + reporte);
        return reporte;
    }

    @Override
    public void registrarEvento(String evento) {
        this.historialReportes.add(evento);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Estación Meteorológica";
    }
}