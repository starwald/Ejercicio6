import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase principal del Modelo (MVC).
 * Contiene y gestiona la lista polimórfica única de dispositivos.
 */
public class Cooperativa {

    private ArrayList<Dispositivo> dispositivos;

    public Cooperativa() {
        this.dispositivos = new ArrayList<>();
        initCargaInicial();
    }

    /**
     * Carga el catálogo inicial con al menos 10 equipos diversos.
     */
    private void initCargaInicial() {
        dispositivos.add(new SensorSuelo("S-001", "Sensor Humedad Parcela A1", 5.5));
        dispositivos.add(new EstacionMeteorologica("EM-01", "Estación Central", 45.0));
        dispositivos.add(new DronRiego("DR-001", "DJI Agras T30", 1500.0, 30.0));
        dispositivos.add(new DronMonitoreo("DM-001", "DJI Mavic 3M (Multiespectral)", 650.0));
        dispositivos.add(new ValvulaRiego("V-A1", "Válvula Riego Sector A1", 12.0));
        dispositivos.add(new SensorSuelo("S-002", "Sensor pH Parcela B2", 6.0));
        dispositivos.add(new DronRiego("DR-002", "DJI Agras T10", 1200.0, 10.0));
        dispositivos.add(new ValvulaRiego("V-B2", "Válvula Riego Sector B2", 12.0));
        dispositivos.add(new EstacionMeteorologica("EM-02", "Estación Norte", 40.0));
        dispositivos.add(new SensorSuelo("S-003", "Sensor Temp. Invernadero", 5.0));
    }

    /**
     * Devuelve una copia de la lista de dispositivos.
     */
    public ArrayList<Dispositivo> getDispositivos() {
        return new ArrayList<>(this.dispositivos);
    }

    /**
     * Busca un dispositivo por su ID.
     * @param id ID a buscar (ignora mayúsculas/minúsculas)
     * @return El Dispositivo encontrado o null si no existe.
     */
    public Dispositivo buscarPorId(String id) {
        for (Dispositivo d : dispositivos) {
            if (d.getId().equalsIgnoreCase(id)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Busca un dispositivo por su Nombre.
     * @param nombre Texto a buscar en el nombre (ignora mayúsculas/minúsculas)
     * @return El Dispositivo encontrado o null si no existe.
     */
    public Dispositivo buscarPorNombre(String nombre) {
        for (Dispositivo d : dispositivos) {
            if (d.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return d;
            }
        }
        return null;
    }

    /**
     * Ordena la lista interna de dispositivos usando el método compareTo
     * implementado en la clase Dispositivo.
     */
    public void ordenarPorConsumo() {
        Collections.sort(this.dispositivos);
    }
}