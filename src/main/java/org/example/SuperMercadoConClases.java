package org.example;


import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class SuperMercadoConClases {
    public static void main(String[] args) {

        //ALMACENAR EN VARIABLES LA INFORMACION DE UN PRODUCTO
        //ID,nombre,PrecioUnitario,CantidadBodega,caducidad,fechaVencimiento
        //fotografia1,fotografia2,descripcion,categoria,nombreProveedor
        //Si el producto se vence y han pasado mas de 3 dias desde la fecha de vencimiento

        //Se debe restar la unidad vencida a la cantidad de bodega
        //Se debe permitir registrar n Listaproductos en una BBDD simulada de JAVA
        //Se debe permitir modificar el precio unitario de cualquier producto ingresado previamente
        //Se debe permitir eliminar un producto de bodega

        String opcionMenu;
        String ID, nombre, descripcion, categoria, nombreProveedor, fotografia1, fotografia2;
        LocalDate fechaVencimiento;
        int PrecioUnitario, CantidadBodega;
        boolean caducidad = false;
        int año, mes, dia;
        int opcionEliminar,opcionEditar;



        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> Listaproductos = new ArrayList<>();

        do {

            System.out.println("\n\u001B[35m=== Bienvenido al Supermercado ===");
            System.out.print("\nQue quieres hacer: " +
                    "\n  1. Agregar producto" +
                    "\n  2. Eliminar producto" +
                    "\n  3. Mostrar lista de productos" +
                    "\n  4. Editar precio" +
                    "\n  5. Salir" +
                    "\nIngrese el numero de opcion: ");
            opcionMenu = scanner.nextLine();



            switch (opcionMenu){
                case "1":

                    System.out.println("\nEstas en el apartado para crear un producto:");
                    System.out.print("Ingresa un ID para el producto: ");
                    ID = scanner.nextLine();
                    System.out.print("Ingresa un nombre para el producto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingresa una descripcion para el producto: ");
                    descripcion = scanner.nextLine();
                    System.out.print("Ingresa una categoria para el producto: ");
                    categoria = scanner.nextLine();
                    System.out.print("Ingresa el nombre de proveedor: ");
                    nombreProveedor = scanner.nextLine();
                    System.out.print("Ingresa la primera fotografia: ");
                    fotografia1 = scanner.nextLine();
                    System.out.print("Ingresa la segunda fotografia: ");
                    fotografia2 = scanner.nextLine();
                    System.out.print("Ingresa el año de vencimiento: ");
                    año = scanner.nextInt();
                    System.out.print("Ingresa el mes de vencimiento: ");
                    mes = scanner.nextInt();
                    System.out.print("Ingresa el dia de vencimiento: ");
                    dia = scanner.nextInt();
                    LocalDate fechaInicial = LocalDate.of(año,mes,dia);
                    System.out.print("Ingresa el precio unitario: ");
                    PrecioUnitario = scanner.nextInt();
                    System.out.print("Ingresa la cantidad en bodega: ");
                    CantidadBodega = scanner.nextInt();
                    scanner.nextLine();

                    Producto productoNuevo = new Producto(ID,nombre,descripcion,categoria,nombreProveedor,fotografia1,fotografia2,fechaInicial,PrecioUnitario,CantidadBodega,caducidad);

                    Listaproductos.add(productoNuevo);

                    System.out.println("El producto se ha guardado con exito");


                    break;
                case "2":

                    System.out.println("Vamos a eliminar un producto");

                    int numeroProducto2 = 1;
                    for (Producto p : Listaproductos) {
                        System.out.println("Producto numero: " + numeroProducto2 + ": " + p.nombre);
                        numeroProducto2 = numeroProducto2 + 1 ;
                    }
                    System.out.print("Ingrese el numero de producto que desea eliminar: ");
                    opcionEliminar = scanner.nextInt();
                    scanner.nextLine();
                    Listaproductos.remove(opcionEliminar-1);
                    break;
                case "3":

                    System.out.println("Estamos en el apartado de mostrar productos: ");
                    int numeroProducto = 1;
                    for (Producto p : Listaproductos){
                        System.out.println("PRODUCTO NUMERO " + numeroProducto);
                        System.out.println(p);
                        numeroProducto = numeroProducto +1;
                    }
                    break;
                case "4":

                    System.out.println("Vamos a editar el valor de un producto: ");

                    int numeroProducto3 = 1;
                    for (Producto p : Listaproductos) {
                        System.out.println("Producto numero: " + numeroProducto3 + ": " + p.nombre + ", Precio: " + p.PrecioUnitario);
                        numeroProducto3 = numeroProducto3 + 1 ;
                    }

                    System.out.print("Ingrese el numero del producto que desea cambiar su precio: ");
                    opcionEditar = scanner.nextInt();

                    System.out.print("Ingrese el nuevo valor: ");
                    int nuevoValor;
                    nuevoValor = scanner.nextInt();
                    Listaproductos.get(opcionEditar-1).PrecioUnitario = nuevoValor;
                    break;
            }
        }while(opcionMenu != "5");
    }
}

class ValidadorEntrada {

    // Otros métodos (leerEntero, leerByte, etc.)

    public static LocalDate leerFecha(Scanner scanner) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.print("📅 Ingrese una fecha (YYYY-MM-DD): ");
            String entrada = scanner.nextLine();

            try {
                return LocalDate.parse(entrada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Fecha inválida. Use el formato correcto (YYYY-MM-DD)");
            }
        }
    }
}

class Producto {

    String ID, nombre, descripcion, categoria, nombreProveedor, fotografia1, fotografia2;
    LocalDate fechaVencimiento;
    int PrecioUnitario, CantidadBodega;
    boolean caducidad;

    public Producto(String ID, String nombre, String descripcion, String categoria, String nombreProveedor, String fotografia1, String fotografia2, LocalDate fechaVencimiento, int PrecioUnitario, int CantidadBodega, boolean caducidad) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.nombreProveedor = nombreProveedor;
        this.fotografia1 = fotografia1;
        this.fotografia2 = fotografia2;
        this.fechaVencimiento = fechaVencimiento;
        this.PrecioUnitario = PrecioUnitario;
        this.CantidadBodega = CantidadBodega;
        this.caducidad = caducidad;
    }

    @Override
    public String toString() {
        return "📦 Producto: " + nombre +
                "\n🔖 ID: " + ID +
                "\n📝 Descripción: " + descripcion +
                "\n🏷 Categoría: " + categoria +
                "\n🏢 Proveedor: " + nombreProveedor +
                "\n🖼 Foto 1: " + fotografia1 +
                "\n🖼 Foto 2: " + fotografia2 +
                "\n📅 Fecha de Vencimiento: " + fechaVencimiento +
                "\n💲 Precio Unitario: $" + PrecioUnitario +
                "\n📦 Cantidad en Bodega: " + CantidadBodega +
                "\n⏳ Tiene caducidad: " + (caducidad ? "✅ Sí" : "❌ No") +
                "\n---------------------------------------------";
    }

}
