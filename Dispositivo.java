/**
 * Clase base abstracta para todos los dispositivos de la cooperativa.
 * Define los atributos comunes y el comportamiento de comparación
 * (por consumo eléctrico) requerido por el sistema.
 */
public abstract class Dispositivo implements Comparable<Dispositivo> {

    private String id;
    private String nombre;
    private double consumoElectrico;

    public Dispositivo(String id, String nombre, double consumoElectrico) {
        this.id = id;
        this.nombre = nombre;
        this.consumoElectrico = consumoElectrico;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getConsumoElectrico() {
        return consumoElectrico;
    }

    /**
     * Implementación del método compareTo de la interfaz Comparable.
     * Permite ordenar la lista polimórfica por consumo eléctrico.
     */
    @Override
    public int compareTo(Dispositivo otro) {
        return Double.compare(this.consumoElectrico, otro.consumoElectrico);
    }

    /**
     * Override del método toString para mostrar información base.
     */
    @Override
    public String toString() {
        return String.format("ID: %-5s | Nombre: %-30s | Consumo: %.1fW", 
                             this.id, this.nombre, this.consumoElectrico);
    }
}