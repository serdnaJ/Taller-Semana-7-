public class Heroe {
    private String id;
    private String nombre;
    private String superpoder;
    private String mision;
    private int dificultad;
    private double pagoMensual;

    // constructor Heroe
    public Heroe(String id, String nombre, String superpoder, String mision, int dificultad, double pagoMensual) {
        this.id = id;
        this.nombre = nombre;
        this.superpoder = superpoder;
        this.mision = mision;
        this.dificultad = dificultad;
        this.pagoMensual = pagoMensual;
    }

    // getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getSuperpoder() { return superpoder; }
    public String getMision() { return mision; }
    public int getDificultad() { return dificultad; }
    public double getPagoMensual() { return pagoMensual; }

    // setters
    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSuperpoder(String superpoder) { this.superpoder = superpoder; }
    public void setMision(String mision) { this.mision = mision; }
    public void setDificultad(int dificultad) { this.dificultad = dificultad; }
    public void setPagoMensual(double pagoMensual) { this.pagoMensual = pagoMensual; }


    //metodo ToString
    @Override
    public String toString() {
        return "Heroe [" +
                "ID: " + id +
                " | Nombre: " + nombre +
                " | Poder: " + superpoder +
                " | Mision: " + mision +
                " | Dificultad: " + dificultad +
                " | Pago: $" + pagoMensual +
                "]";
    }
}