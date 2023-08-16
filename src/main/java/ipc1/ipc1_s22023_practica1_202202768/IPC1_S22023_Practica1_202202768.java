
package ipc1.ipc1_s22023_practica1_202202768;

import java.util.Scanner;
import java.time.LocalDateTime;

class Diasrentado{
    int diasrentado;
}
class NuevosUsuarios {
    String Nit;
    String Nombre;
    String Apellido;
}
class Descuentos {
    int dias;
    int porciento;
}
class Carros {
    String marca;
    String linea;
    String modelo;
    String placa;
    int precio;
    int numerodecompras = 0;
}


public class IPC1_S22023_Practica1_202202768 {
    public static Diasrentado[] diasrentado = new Diasrentado[1000];
    public static LocalDateTime fechaHoraActual =LocalDateTime.now();
    public static Carros[] carros = new Carros[1000];
    public static Descuentos[] descuentos = new Descuentos[1000];
    public static NuevosUsuarios[] nusuarios = new NuevosUsuarios[1000];
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
                MenuIngresarComoAdmin();
            }
        }else{
            System.out.println("Error: El usuario o contraseña es invalido, porfavor verifique sus datos");
            MenuIngresarComoAdmin();
        }        
    }
    
    public static void MenuDentroAdmin (){
        /* opciones de menu admin*/
                System.out.println("\n+++ Bienvenido admin +++");
                System.out.println("1. Agregar nuevos vehiculos");
                System.out.println("2. Agregar descuentos especiales");
                System.out.println("3. Reportes");
                System.out.println("4. Mostrar usuarios");
                System.out.println("5. Cerrar cesion");
                System.out.println("Ingresar opcion: ");
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
        int precio = scanner.nextInt();
        
        /* Ver si el precio es mayor a 0 */
        if (precio > 0){
        /* Agregar vehiculo a lista */    
             for (int a=0; a< carros.length; a++){
                if (carros[a] == null) {
                break;
                }
            
                if (carros[a].placa.equals(placa)){
                System.out.println("\nError: El vehiculo con la placa: " + placa + " Ya existe\n");
                MenuDentroAdmin();
                }
               }
            
        Carros nuevoVehiculo = new Carros ();
        nuevoVehiculo.marca = marca;
        nuevoVehiculo.linea = linea;
        nuevoVehiculo.modelo = modelo;
        nuevoVehiculo.placa = placa;
        nuevoVehiculo.precio = precio;
        /* Opciones despues de agregar vehiculo */
        for (int a = 0; a < carros.length; a++) {
            if (carros[a] == null) {
                carros[a] = nuevoVehiculo;
                System.out.println("\nEl vehiculo se agrego exitosamente\n");
                System.out.println("1. Regresar menu de admin");
                System.out.println("2. Cerrar cesion");
                System.out.println("Ingrear opcion: ");
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
            System.out.println("Ingresar opcion: ");
            int opcionpreciomenor = 0;
            opcionpreciomenor = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcionpreciomenor) {
                case 1: MenuAgregarVehiculo(); break;
                case 2: MenuDentroAdmin(); break;
            }
        }  
    }
    
    /*Opciones de descuento*/
    public static void MenuAgregardescuentos(){
        System.out.println("\nIngrese el numero de dias minimo de alquiler");
        int dias = scanner.nextInt();
        
        /*Comprobar numero de dias*/
        if (dias > 0) {
            System.out.println("Ingrese el porcentaje de descuento");
            int descuento = scanner.nextInt();
            /*Comprobar numero de descuento mayor a 0*/
            if (0 < descuento){
                /*Comprobar numero de descuento menor a 100*/
                if(descuento < 100){
                    for (int b = 0; b < descuentos.length; b++){
                        if (descuentos[b] == null){
                        }
                    }
                    
                    Descuentos NuevoDescuento = new Descuentos ();
                    NuevoDescuento.dias = dias;
                    NuevoDescuento.porciento = descuento;
                    /*Agregar descuento*/
                    for (int b = 0; b < descuentos.length; b++){
                        if (descuentos[b] == null) {
                            descuentos[b] = NuevoDescuento;
                            System.out.println("\nEl descuento se ha guardado con exito\n");
                            System.out.println("1. Regresar a menu de descuento");
                            System.out.println("2. Regresar a menu de admin");
                            System.out.println("3. Cerrar cesion");
                            System.out.println("Ingresar opcion: ");
                            int opcionagregardescuento = 0;
                            opcionagregardescuento = scanner.nextInt();
                            scanner.nextLine();
        
                            switch (opcionagregardescuento) {
                                case 1: MenuAgregardescuentos(); break;
                                case 2: MenuDentroAdmin(); break;
                                case 3: menuPrincipal(); break;
                            }
                        }
                    }
                }else {
                    System.out.println("\nError: El numero de porcentaje de descuento es mayor o igual a 100");
                    System.out.println("1. Regresar a menu de descuentos");
                    System.out.println("2. Regreasr a menu de admin");
                    System.out.println("Ingresar opcion");
                    int opciondecuentomayor = 0;
                    opciondecuentomayor = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (opciondecuentomayor) {
                    case 1: MenuAgregardescuentos(); break;
                    case 2: MenuDentroAdmin(); break;
                    }
                }
                
            } else {
                System.out.println("\nError: El numero de porcentaje de descuento es menor o igual a 0");
                System.out.println("1. Regresar a menu de descuentos");
                System.out.println("2. Regreasr a menu de admin");
                System.out.println("Ingresar opcion: ");
                int opciondecuentomenor = 0;
                opciondecuentomenor = scanner.nextInt();
                scanner.nextLine();
                    
                switch (opciondecuentomenor) {
                case 1: MenuAgregardescuentos(); break;
                case 2: MenuDentroAdmin(); break;
                }
            }
        }else {
            System.out.println("\nError: El numero de dias de alquler es menor o igual a 0");
            System.out.println("1. Regresar a menu de descuentos");
            System.out.println("2. Regreasr a menu de admin");
            System.out.println("Ingresar opcion: ");
            int opciondiasmenor = 0;
            opciondiasmenor = scanner.nextInt();
            scanner.nextLine();
                    
            switch (opciondiasmenor) {
                case 1: MenuAgregardescuentos(); break;
                case 2: MenuDentroAdmin(); break;
                }
        }
        
    }
    
    public static void MenuReportes(){
        /*Ordenamiento de burbuja para reportes*/
        for (int i = 0; i < carros.length; i++) {
            for (int j = 0; j < carros.length - 1; j++) {
                Carros productoActual = carros[j];
                Carros productoSiguiente = carros[j + 1];
                if (productoActual == null || productoSiguiente == null) {
                    break;
                }
                
                if (productoActual.numerodecompras < productoSiguiente.numerodecompras) {
                    carros[j] = productoSiguiente;
                    carros[j + 1] = productoActual;
                }
            }
        }
        /*Mostrar reporte*/
         System.out.println("+++ Reporte de vehiculos rentados +++");
         System.out.println("Marca   " + "     Total de dias rentado");
        for (int i = 0; i < carros.length; i++) {
            if (carros[i] == null) {
                MenuDentroAdmin();
            }
            System.out.println( carros[i].placa + "       " + diasrentado);
        }
        
            System.out.println("1. Regresar a menu de admin");
            System.out.println("2. Cerrar cesion");
            System.out.println("Ingrese la opcion a elegir: ");
            int opcionreporte = 0;
            opcionreporte = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcionreporte){
                case 1: MenuDentroAdmin();break;
                case 2: menuPrincipal();break;
            }
    }
    
    /*MOSTRAR USUARIOS REGISTRADOS*/
    public static void MenuMostrarUsuarios() {
           System.out.println("\nLos usuarios registrados son los siguientes:");
           System.out.println("    NIT:      " + "Nombre:      " + "Apellido:        ");
       for(int i = 0; i < nusuarios.length;i ++){
           if (nusuarios[i] == null) {
               MenuDentroAdmin();
           }
           System.out.println("\t"+ nusuarios[i].Nit + "\t" + nusuarios[i].Nombre + "\t" + nusuarios[i].Apellido);
       }
    }
    
    /*opciones al ingresar como user*/
    public static void MenuIngresarComoUser(){
        System.out.println("\n+++ Bienvenido al programa +++");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesion");
        System.out.println("3. Regresar a menu princupal");
        System.out.println("Ingresar opcion: ");
        int opcionuser = 0;
        opcionuser = scanner.nextInt();
        scanner.nextLine();
        
        switch(opcionuser){
            case 1: MenuNuevoUser(); break; 
            case 2: MenuIniciarUser(); break;
            case 3: menuPrincipal(); break;
        }
    }
    
    /*Ingresar datos nuevo usuario*/
    public static void MenuNuevoUser(){
        System.out.println("\n+++ Bienvenido porfavor llenar lo siguiente +++");
        System.out.println("Ingrese su NIT");
        String Nit = scanner.nextLine();
        System.out.println("Ingrese su Nombre");
        String Nombre = scanner.nextLine();
        System.out.println("Ingrese su Apellido");
        String Apellido = scanner.nextLine();
        
        for (int i=0; i< nusuarios.length; i++){
            if (nusuarios[i] == null){
                break;
            }
            
            if (nusuarios[i].Nit.equals(Nit)){
                System.out.println("\nError: El nit: " + Nit + " Ya existe\n");
                MenuIngresarComoUser();
            }
        }
        
        NuevosUsuarios nuevouser = new NuevosUsuarios();
        nuevouser.Nit = Nit;
        nuevouser.Nombre = Nombre;
        nuevouser.Apellido = Apellido;
        
        for(int i = 0; i < nusuarios.length; i++) {
            if(nusuarios[i] == null){
                nusuarios[i] = nuevouser;
                MenuIngresarComoUser();
            }
        }   
    }

    public static void MenuIniciarUser(){
        System.out.println("\n+++ Bienvenido +++");
        System.out.println("Ingrese su NIT para ingresar: ");
        String Nit = scanner.nextLine();       
        
        for (int i=0; i < nusuarios.length; i++){
            if (nusuarios[i] == null){
            }
            if (nusuarios[i].Nit.equals(Nit)){
                MenuDentrodeUser();
            } else {
             System.out.println("\n ERROR: El NIT ingresado no esta registrado, porfavor revise sus datos");
             MenuIngresarComoUser();
         }
        }
    }
    
    public static void MenuDentrodeUser(){
        System.out.println("\n +++ Bienvenido Usuario +++");
        System.out.println("1. Realizar Orden de Renta de Vehiculo");
        System.out.println("2. Cerrar cesion");
        System.out.println("Ingrese una opcion: ");
        int opciondentrouser = 0;
        opciondentrouser = scanner.nextInt();
        scanner.nextLine();
             
        switch(opciondentrouser) {
        case 1: MenuRealizarOrdencarros(); break;
        case 2: menuPrincipal(); break;
        }
    }
        
    public static void MenuRealizarOrdencarros(){
        System.out.println("\n +++ Los vehiculos disponibles para rentar son los siguientes: +++\n");
        for(int a = 0; a < carros.length;a ++){
            if(carros[a] == null){
            MenuRealizarOrdenDescuento();
            }
            System.out.println(carros[a].marca + "\t" + carros[a].linea + "\t" + carros[a].precio + " Q\t" + carros[a].placa);
        } 
    }
    
    public static void MenuRealizarOrdenDescuento(){
        System.out.println("\n+++ Los descuentos por dia son: +++\n");
            for(int b = 0; b < descuentos.length;b++){
                if(descuentos[b] == null) {
                 MenuRealizarPedidoplaca();
                }
                System.out.println(descuentos[b].dias + " dias \t" + descuentos[b].porciento + " % de descuento");
            }
    }
    
    public static void MenuRealizarPedidoplaca(){
        System.out.println("\nIngresar placa del vehiculo a rentar");
        String placarentado = scanner.nextLine();
         
        for (int i = 0; i < carros.length; i++){
            if(carros[i] == null){
            } 
            if (carros[i].placa.equals(placarentado)){
                carros[i].numerodecompras++;
            }
            if (carros[i].placa.equals(placarentado)){
                MenuRealizarpedidodias();
            }else{
                System.out.println("\nError: La placa que usted ingreso no existe porfavor revise sus datos");
                MenuDentrodeUser();
            }
        }      
    }
    
    public static void MenuRealizarpedidodias(){
        System.out.println("\nIngresar dias a rentar");
        int diasrentados = scanner.nextInt();
        for (int d = 0; d < diasrentado.length; d++) {
            if (diasrentado[d] == null) {
                break;
            }
        }
        Diasrentado diasrenta = new Diasrentado();
        diasrenta.diasrentado = diasrentados;
         for(int d = 0; d < diasrentado.length; d++) {
            if(diasrentado[d] == null){
                diasrentado[d] = diasrenta;
            }
        }   
        
        System.out.println("\n1. Finalizar rentado");
        System.out.println("2. Cancelar rentado");
        int opcionfinrenta = 0;
        opcionfinrenta = scanner.nextInt();
        scanner.nextLine();
        
        switch(opcionfinrenta){
            case 1: MenudeFacturausuario(); break;
            case 2: MenuDentrodeUser(); break;
        }
    }
    
    public static void MenudeFacturausuario(){
        System.out.println("\n+++ ByteCar +++\n");
        for(int i = 0; i < nusuarios.length; i++){
            if(nusuarios[i] == null) {
                
            }
            System.out.println("Cliente: " +nusuarios[i].Nombre);
            System.out.println("Nit: " +nusuarios[i].Nit);
            System.out.println("Fecha y Hora de emision de factura: " +fechaHoraActual);
            MenudeFacturaCarro();
        }
    }
    
    public static void MenudeFacturaCarro(){

        for(int a = 0; a < 1;a ++){
           if(carros[a] == null){
           }
            System.out.println("Marca: "+carros[a].marca);
            System.out.println("Linea: " + carros[a].linea);
            System.out.println("Placa: " + carros[a].placa);
            MenuFacturaDias();
        }
    }
    
    public static void MenuFacturaDias(){
        for(int d = 0; d < 1;d++){
            if(diasrentado[d] == null){
            }
            System.out.println("Los dias a rentar son: "+diasrentado[d].diasrentado);
            MenuFacturaSubtotal();
        }
    }
    
    public static void MenuFacturaSubtotal(){
        
        for(int a = 0; a<1; a++){
           if(carros[a] == null){
           }
            System.out.println("El subtotal es: Q" + carros[a].precio * diasrentado[a].diasrentado);
            MenuFacturaPorcentaje();
        }
    }
    
    public static void MenuFacturaPorcentaje(){
        for (int i=0; i< 1; i++){
            if (diasrentado[i].diasrentado >= descuentos[i].dias){
                System.out.println("El descuento al que aplica es de: " + descuentos[i].porciento + "%");
                MenuFacturatotalDescuento();
            } else{
                System.out.println("No aplica ningun descuento");
                MenuFacturatotalsinDescuento();
            }
        }
    }
    
    public static void MenuFacturatotalDescuento(){
        for (int i=0; i<1; i++){
            System.out.println("El precio total es: Q" + ((carros[i].precio*diasrentado[i].diasrentado)-(((carros[i].precio * diasrentado[i].diasrentado)*descuentos[i].porciento/100))));
            System.out.println("-------------------------------------");
            System.out.println("1. Realizar otro pedido");
            System.out.println("2. Cerrar cesion");
            System.out.println("Ingrese la opcion a elegir: ");
            int opcionfactura = 0;
            opcionfactura = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcionfactura){
                case 1: MenuDentrodeUser();break;
                case 2: menuPrincipal();break;
            }
        }
    }
    
    public static void MenuFacturatotalsinDescuento(){
        for(int a = 0; a<1; a++){
           if(carros[a] == null){
           }
            System.out.println("El Total es: " + carros[a].precio * diasrentado[a].diasrentado + " Q");
            System.out.println("-------------------------------------");
            System.out.println("1. Realizar otro pedido");
            System.out.println("2. Cerrar cesion");
            System.out.println("Ingrese la opcion a elegir: ");
            int opcionfactura = 0;
            opcionfactura = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcionfactura){
                case 1: MenuDentrodeUser();break;
                case 2: menuPrincipal();break;
            }
        }
    }
    public static void main(String[] args) {
       while (true) {
           menuPrincipal();
       }
    }

}
