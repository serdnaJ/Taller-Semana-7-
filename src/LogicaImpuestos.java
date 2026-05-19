public class LogicaImpuestos {


    public double calcularAporteFondo(Heroe heroe) {
        return heroe.getPagoMensual() * 0.10;
    }


    public double calcularImpuestoMensual(Heroe heroe) {
        double pagoAnual = heroe.getPagoMensual() * 12;
        double impuestoAnual = 0;

        // cálculo progresivo según la tabla del problema
        if (pagoAnual > 240000) {
            impuestoAnual = (pagoAnual - 240000) * 0.35 + (120000 * 0.25) + (60000 * 0.12);
        } else if (pagoAnual > 120000) {
            impuestoAnual = (pagoAnual - 120000) * 0.25 + (60000 * 0.12);
        } else if (pagoAnual > 60000) {
            impuestoAnual = (pagoAnual - 60000) * 0.12;
        } else {
            impuestoAnual = 0;
        }

        return impuestoAnual / 12; // convertimos el impuesto anual a mensual
    }

    public double calcularPagoNetoMensual(Heroe heroe) {
        double deducciones = calcularAporteFondo(heroe) + calcularImpuestoMensual(heroe);
        return heroe.getPagoMensual() - deducciones;
    }
}