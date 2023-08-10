/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ipc1.ipc1_s22023_practica1_202202768;

import java.util.Scanner;

class Admin {
    
}
class Carros {
    String nombre;
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
        System.out.println("\n--- Bienvenid al programa ---");
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
        System.out.println(" +++ Bienvenido al menu de administrador +++\n");
        System.out.println("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.println("Contraseña: ");
        String contra = scanner.nextLine();
        
    /*Comprobar datos de admin*/    
        if(Usuario.equals(usuario)){
            if(Contra.equals(contra)){   
                System.out.println("\n+++ Bienvenido admin +++");
                System.out.println("a. Agregar nuevos vehiculos");
                System.out.println("b. Agregar descuentos especiales");
                System.out.println("c. Realizar reportes");
                System.out.println("d. Cerrar sesion");
            }else{
                System.out.println("Error: La contraseña o el usuario es incorrecta, porfavor verifique sus datos");
            }
        }else{
            System.out.println("Error: El usuario o contraseña es invalido, porfavor verifique sus datos");
        }
    }
    
    public static void MenuIngresarComoUser(){
        
    }
    
    public static void main(String[] args) {
       while (true) {
           menuPrincipal();
       }
    }

}
