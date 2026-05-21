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
    public boolean registrarHeroe(Heroe heroe) {
        if(listaHeroes.isEmpty()){//primer elemento
            listaHeroes.add(heroe);
            return true;
        }else{//desde el segundo elemento
            if(heroe.getId()>listaHeroes.getLast().getId()){
                listaHeroes.add(heroe);
                return true;
            }
            return false;//repetido o es menor
        }
    }

    // elimina heroe
    public boolean eliminar(int id) {
        Heroe h = buscarPorId(id);
        if (h != null) {
            listaHeroes.remove(h);
            return true;
        }
        return false;
    }

    // modificar héroe por id
    public boolean modificarHeroe(int id, Heroe datosNuevos) {
        for (int i = 0; i < listaHeroes.size(); i++) {
            if (listaHeroes.get(i).getId()==(id)) {
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
    public Heroe buscarPorId(int id) {
        for (Heroe h : listaHeroes) {
            if (h.getId()==(id)) {
                return h;
            }
        }
        return null;
    }

    //metodo genera el informe
    public String generarInforme(int id) {
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

    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(Heroe heroe:listaHeroes){
            sb.append(heroe.toString()).append("\n");
        }
        return sb.toString().length()!=0?sb.toString():"No hay elementos";
    }
}