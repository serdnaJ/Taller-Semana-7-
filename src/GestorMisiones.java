import java.util.ArrayList;
import java.util.List;

public class GestorMisiones {
    // usamos arraylist como estructura principal
    private List<Heroe> listaHeroes;
    private LogicaImpuestos calculadora; // para el informe final

    public GestorMisiones() {
        this.listaHeroes = new ArrayList<>();
        this.calculadora = new LogicaImpuestos();
    }

    // registrar héroe
    public String registrarHeroe(Heroe heroe) {
        if (buscarPorId(heroe.getId()) != null) {
            return "Error: El ID del héroe ya existe.";
        }
        if (heroe.getDificultad() < 1 || heroe.getDificultad() > 5) {
            return "Error: El nivel de dificultad debe ser entre 1 y 5.";
        }
        listaHeroes.add(heroe);
        return "Héroe registrado con éxito.";
    }

    // elimina heroe
    public boolean eliminar(String id) {
        Heroe h = buscarPorId(id);
        if (h != null) {
            listaHeroes.remove(h);
            return true;
        }
        return false;
    }

    // modificar héroe por id
    public boolean modificarHeroe(String id, Heroe datosNuevos) {
        for (int i = 0; i < listaHeroes.size(); i++) {
            if (listaHeroes.get(i).getId().equals(id)) {
                datosNuevos.setId(id); // protege el id original
                listaHeroes.set(i, datosNuevos);
                return true; // modificación exitosa
            }
        }
        return false; // héroe no encontrado
    }

    // listar héroes
    public List<Heroe> obtenerTodosLosHeroes() {
        return listaHeroes;
    }

    // metodo que busca heroe especifico por ID
    public Heroe buscarPorId(String id) {
        for (Heroe h : listaHeroes) {
            if (h.getId().equals(id)) {
                return h;
            }
        }
        return null;
    }

    //metodo genera el informe
    public String generarInforme(String id) {
        Heroe h = buscarPorId(id);
        if (h == null) {
            return "Héroe no encontrado.";
        }

        return "=== INFORME DEL HÉROE ===\n" +
                "Nombre: " + h.getNombre() + "\n" +
                "Superpoder: " + h.getSuperpoder() + "\n" +
                "Pago mensual: $" + String.format("%.2f", h.getPagoMensual()) + "\n" +
                "Aporte al Fondo (10%): $" + String.format("%.2f", calculadora.calcularAporteFondo(h)) + "\n" +
                "Impuesto del gobierno: $" + String.format("%.2f", calculadora.calcularImpuestoMensual(h)) + "\n" +
                "Pago neto a recibir: $" + String.format("%.2f", calculadora.calcularPagoNetoMensual(h));
    }
}