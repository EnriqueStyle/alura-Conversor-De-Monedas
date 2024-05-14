import java.awt.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        int opcionUsuario = 0;
        ConsultaAPIMoneda consulta = new ConsultaAPIMoneda();
        ArrayList<Cambio> listaDeConversiones = new ArrayList<>();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        System.out.println("^^^ Bienvenido al conversor de moneda ^^^\n");

        while (opcionUsuario != 3) {
            Menu menu = new Menu();
            menu.mostrarMenuPrincipal();
            opcionUsuario = menu.leerOpcionPrincipal();

            switch (opcionUsuario) {
                case 1:
                    menu.mostrarMenuMonedas("inicial");
                    String monedaBase = menu.leerOpcionMoneda();
                    menu.mostrarMenuMonedas("final");
                    String monedaFinal = menu.leerOpcionMoneda();
                    Double cantidadCambiar = menu.leerCantidadACambiar();
                    Conversor conversor = consulta.buscaMoneda(monedaBase);
                    Double tasaDeConversion = conversor.getCambioRate(monedaFinal.toUpperCase());
                    Double cantidadObtenida = menu.cantidadObtenida(monedaBase, cantidadCambiar, tasaDeConversion, monedaFinal);
                    Cambio nuevaConversion = new Cambio(monedaBase, monedaFinal, cantidadCambiar, cantidadObtenida);
                    listaDeConversiones.add(nuevaConversion);
                    break;
                case 2:
                    menu.imprimirConversiones(listaDeConversiones);
                    break;
                case 3:
                    System.out.println("Gracias por utilizar el conversor de moneda");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }
        }
    }
}