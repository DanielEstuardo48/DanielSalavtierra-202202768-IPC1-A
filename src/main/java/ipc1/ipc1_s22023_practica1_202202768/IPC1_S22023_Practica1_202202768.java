
package ipc1.ipc1_s22023_practica1_202202768;

import java.util.Scanner;

class Descuentos {
    int dias;
    double descuento;
}
class Carros {
    String marca;
    String linea;
    String modelo;
    String placa;
    double precio;
    int numerodecompras = 0;
}

/**
 *
 * @author danis
 */
public class IPC1_S22023_Practica1_202202768 {
    public static Carros[] carros = new Carros[1000];
    public static Scanner scanner = new Scanner(System.in);
    public static String Usuario = "admin_202202768";
    public static String Contra = "202202768";

   
    /* Opciones de menu de inicio */
    public static void menuPrincipal () {
        System.out.println("\n+++ Bienvenid al programa +++");
        System.out.println("1. Ingresar como administrador");
        System.out.println("2. Ingresar como cliente");
        System.out.println("3. Salir del programa");
        System.out.println("Ingresar opcion: ");
        int opcion = 0;
        opcion = scanner.nextInt();
        scanner.nextLine();
        
    /* opcion ingresada */
        switch (opcion){
            case 1: MenuIngresarComoAdmin(); break;
            case 2: MenuIngresarComoUser(); break;
            case 3: System.exit(0); break;
            default: System.out.println("Su opcion no se encuentra en el menu prube otra");
        }
    }
    
    /* Menu de admin */
    public static void MenuIngresarComoAdmin(){
        System.out.println("\n +++ Bienvenido al menu de administrador +++");
        System.out.println("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.println("Contraseña: ");
        String contra = scanner.nextLine();
        
    /*Comprobar datos de admin*/    
        if(Usuario.equals(usuario)){
            if(Contra.equals(contra)){ 
                MenuDentroAdmin ();
            }else{
                System.out.println("Error: La contraseña o el usuario es incorrecta, porfavor verifique sus datos");
            }
        }else{
            System.out.println("Error: El usuario o contraseña es invalido, porfavor verifique sus datos");
        }        
    }
    
    public static void MenuDentroAdmin (){
        /* opciones de menu admin*/
                System.out.println("\n+++ Bienvenido admin +++");
                System.out.println("1. Agregar nuevos vehiculos");
                System.out.println("2. Agregar descuentos especiales");
                System.out.println("3. Realizar reportes");
                System.out.println("4. Mostrar usuarios");
                System.out.println("5. Regresar al menu princupal");
                int opcionadmin = 0;
                opcionadmin = scanner.nextInt();
                scanner.nextLine();
                
                /* Switch de opciones*/
                switch (opcionadmin){
                 case 1: MenuAgregarVehiculo(); break;
                 case 2: MenuAgregardescuentos(); break;
                 case 3: MenuReportes(); break;
                 case 4: MenuMostrarUsuarios(); break;
                 case 5: menuPrincipal (); break;
                }
    }
    
    /* Agregar nuevo vehiculo */
    public static void MenuAgregarVehiculo(){
        System.out.println("\n Ingrese la marca del vehiculo: ");
        String marca = scanner.nextLine();
        System.out.println("Ingrese la linea del vehiculo: ");
        String linea = scanner.nextLine();
        System.out.println("Ingrese el modelo del vehiculo: ");
        String modelo = scanner.nextLine();
        System.out.println("Ingrese la placa del vehiculo: ");
        String placa = scanner.nextLine();
        System.out.println("Ingrese el precio del coste de alquiler por dia: ");
        double precio = scanner.nextDouble();
        
        /* Ver si el precio es mayor a 0 */
        if (precio > 0){
        /* Agregar vehiculo a lista */    
             for (int i=0; i< carros.length; i++){
        if (carros[i] == null) {
            break;
        }
            
            if (carros[i].placa.equals(placa)){
                System.out.println("\nError: El vehiculo con la placa: " + placa + " Ya existe\n");
                return;
                }
            }
            
        Carros nuevoVehiculo = new Carros ();
        nuevoVehiculo.marca = marca;
        nuevoVehiculo.linea = linea;
        nuevoVehiculo.modelo = modelo;
        nuevoVehiculo.placa = placa;
        nuevoVehiculo.precio = precio;
        /* Opciones despues de agregar vehiculo */
        for (int i = 0; i < carros.length; i++) {
            if (carros[i] == null) {
                carros[i] = nuevoVehiculo;
                System.out.println("\nEl vehiculo se agrego exitosamente");
                System.out.println("1. Regresar menu de admin");
                System.out.println("2. Regresar al menu princupal");
                int opcionagregarvehiculo = 0;
                opcionagregarvehiculo = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcionagregarvehiculo){
                 case 1: MenuDentroAdmin(); break;
                 case 2: menuPrincipal(); break;
                }
            }
        } /* Precio <= 0 */
        } else {
            System.out.println("\nError: El precio de renta debe ser mayor de 0\n");
            System.out.println("1. Regresar a menu de ingresar vehiculo");
            System.out.println("2. Regresar a menu de admin");
            int opcionpreciomenor = 0;
            opcionpreciomenor = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcionpreciomenor) {
                case 1: MenuAgregarVehiculo(); break;
                case 2: MenuDentroAdmin(); break;
            }
        }  
    }

    public static void MenuAgregardescuentos(){
        
    }
    
    public static void MenuReportes(){
        
    }
    
    public static void MenuMostrarUsuarios() {
        
    }
    
    public static void MenuIngresarComoUser(){
        
    }
    
    public static void main(String[] args) {
       while (true) {
           menuPrincipal();
       }
    }

}
