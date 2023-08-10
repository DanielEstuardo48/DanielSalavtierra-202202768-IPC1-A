
import java.util.Scanner;

/**
 *
 * @author danis
 */

class Carros {
    String nombre;
    double precio;
    int numerodecompras = 0;
}

class list {
    
     public static Carros[] carros = new Carros[1000];
     public static Scanner scanner = new Scanner(System.in);
    
     /* opciones de menu */
    public static void menuPrincipal () {
        System.out.println("\n--- Bienvenido al Programa ---");
        System.out.println("1.Ingresar como administrador ");
        System.out.println("1. Registrar producto");
        System.out.println("2.Comprar producto");
        System.out.println("3. Top Carros mas comprados");
        System.out.println("4. Salir del programa");
        System.out.println("Ingrese el numero de opcion a elegir");
        int opcion = 0;
        opcion = scanner.nextInt();
        scanner.nextLine();
        
    /* opcion a ingresar */
        switch (opcion){
            case 1: MenuregistrarCarro(); break;
            case 2: MenucomprarCarro(); break;
            case 3: MostrarTopProductosComprados(); break;
            case 4: System.exit(0); break;
            default: System.out.println("Su opcion no se encuentra en el menu prube otra");
        }
    }
    
    /*ingresando a la opcion indicada y sus opciones*/
    public static void MenuregistrarCarro(){
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese precio del producto: ");
        double precio = scanner.nextDouble();
        
        for (int i=0; i < carros.length; i++) {
            if (carros[i] == null) {
                break;
            }
            
            if (carros[i].nombre.equals(nombre)){
                System.out.println("Error: El producto con el nombre " + nombre + " ya existia");
                return;
            }
        }
        
        Carros nuevoCarro = new Carros();
        nuevoCarro.nombre = nombre;
        nuevoCarro.precio = precio;
        
        for (int i = 0; i < carros.length; i++){
            if (carros[i] == null){
                carros[i] = nuevoCarro;
                return;
            }
        }
    }
    
    public static void MenucomprarCarro() {
        System.out.print("Nombre de carro a comprar: ");
        String nombre = scanner.nextLine();
        
        /* numero de compras que tiene el carro */
        for (int i = 0; i < carros.length; i++) {
            if (carros [i] == null) {
                System.out.println("El producto que usted busca no existe. ");
                return;
            }
            
            if (carros[i].nombre.equals(nombre)) {
                carros[i].numerodecompras++;
                return;
            }
        }
    }
    /* Ordenar Productos ates de mostrar Top*/
    public static void MostrarTopProductosComprados() {
        for (int i = 0; i < carros.length; i++) {
            for (int j = 0; j < carros.length - 1; j++) {
                Carros carroActual = carros[j];
                Carros carroSiguiente = carros[j+1];
                if (carroActual == null || carroSiguiente == null ) {
                    break;
                }
                
                if (carroActual.numerodecompras < carroSiguiente.numerodecompras) {
                    carros[j] = carroSiguiente;
                    carros[j+1] = carroActual;
                }
            }
        }
        
        /*imprimir top de carros*/
        for (int i = 0 ; i < 5; i++) {
            if (carros[i] == null) {
                return;
            }
            
            System.out.println("Nobre: " + carros[i].nombre + ", Veces Comprado: " + carros[i].numerodecompras);
        }
    }

    public static void main(String[] args) {
       while (true) {
           menuPrincipal();
       }
    }
}
