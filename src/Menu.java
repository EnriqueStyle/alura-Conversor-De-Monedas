import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final String monedasDisponibles = """
            USD ===> Dólar Estadounidense
            ARS ===> Peso Argentino
            BRL ===> Real Brasileño
            COP ===> Peso Colombiano
            EUR ===> Euro
            MXN ===> Peso Méxicano""";

    public void mostrarMenuPrincipal(){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Digite el número de la opción que desee realizar: \n");
        String menuPrincipal = """
                1) Relaizar una conversión
                2) Consultar historial
                3) Salir""";
        System.out.println(menuPrincipal);
    }

    public int leerOpcionPrincipal(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("Elija una opcion valida");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        return lectura.nextInt();
    }

    public void mostrarMenuMonedas(String denominacion){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Selecciona la denominacion " + denominacion + ": \n");
        System.out.println(monedasDisponibles);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public String leerOpcionMoneda(){
        Scanner lectura = new Scanner(System.in);
        String opcion = lectura.nextLine().toLowerCase();
        while (!monedasDisponibles.toLowerCase().contains(opcion)){
            System.out.println("La opcion dijitada no esta disponible");
            System.out.println("Elija una opcion válida");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            opcion = lectura.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();
    }

    public Double leerCantidadACambiar(){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Seleccione la cantidad que desea cambiar: \n");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        Scanner lectura = new Scanner(System.in);
        double cantidad;
        while (!lectura.hasNextDouble()) {
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("La cantidad digitada no es un número válido");
            System.out.println("Ingrese una cantidad válida");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            lectura.nextLine();
        }
        cantidad = lectura.nextDouble();
        lectura.nextLine();
        return cantidad;
    }

    public Double cantidadObtenida(String monedaBase, Double cantidadCambiar, Double tasaDeConversion, String monedaFinal){
        Double resultado = cantidadCambiar * tasaDeConversion;
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(cantidadCambiar + " " + monedaBase + " equivalen a: " + resultado + " " + monedaFinal);
        return resultado;
    }

    public void imprimirConversiones(ArrayList<Cambio> listaDeConversiones) {
        if (listaDeConversiones.isEmpty()) {
            System.out.println("No se han realizado conversiones.");
        } else {
            System.out.println("Historial de conversiones:");
            for (int i = 0; i < listaDeConversiones.size(); i++) {
                Cambio cambio = listaDeConversiones.get(i);
                System.out.println("Conversión " + (i + 1) + ":");
                System.out.println("Moneda origen: " + cambio.getMonedaBase());
                System.out.println("Moneda objetivo: " + cambio.getMonedaObjetivo());
                System.out.println("Cantidad a cambiar: " + cambio.getCantidadAcambiar());
                System.out.println("Cantidad obtenida: " + cambio.getCantidadEnMonedaObjetiva());
            }
        }
    }
}
