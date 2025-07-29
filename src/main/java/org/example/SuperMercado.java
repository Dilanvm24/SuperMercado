package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuperMercado {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, Object> productos = new HashMap<>();

        System.out.println("¿Cuántos productos desea registrar?: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Producto #" + (i + 1));

            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.println("Precio unitario: ");
            int precio = scanner.nextInt();

            System.out.println("Cantidad en bodega: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Fecha de vencimiento (YYYY-MM-DD): ");
            String fechastr = scanner.nextLine();
            LocalDate fechavencimiento = LocalDate.parse(fechastr);

            HashMap<String, Object> info = new HashMap<>();
            info.put("Precio", precio);
            info.put("Cantidad", cantidad); // quitado el espacio
            info.put("Vencimiento", fechavencimiento); // quitado el espacio

            productos.put(nombre, info);
        }

        int opcion;
        do {
            System.out.println("\n🛒 Menú 🛒");
            System.out.println("1. Modificar precio de un producto");
            System.out.println("2. Eliminar un producto");
            System.out.println("3. Descontar productos vencidos");
            System.out.println("4. Ver productos");
            System.out.println("5. Salir"); // corregido
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre del prodcuto a modificar");
                    String nombremod = scanner.nextLine();
                    if (productos.containsKey(nombremod)) {
                        System.out.println("Nuevo precio: ");
                        int nuevoPrecio = scanner.nextInt();
                        scanner.nextLine();
                        ((HashMap<String, Object>) productos.get(nombremod)).put("Precio", nuevoPrecio);
                        System.out.println("Precio actualizado");
                    } else {
                        System.out.println("Producto no encontrado");
                    }
                    break;

                case 2:
                    System.out.println("Nombre del producto a eliminar: ");
                    String nombreDel = scanner.nextLine();
                    if (productos.remove(nombreDel) != null) {
                        System.out.println("Producto eliminado");
                    } else {
                        System.out.println("Producto no encontrado");
                    }
                    break;

                case 3:
                    LocalDate hoy = LocalDate.now();
                    for (String key : productos.keySet()) {  // corregido: eliminado punto y coma
                        HashMap<String, Object> info = (HashMap<String, Object>) productos.get(key);
                        LocalDate fecha = (LocalDate) info.get("Vencimiento");
                        long dias = Duration.between(fecha.atStartOfDay(), hoy.atStartOfDay()).toDays();
                        if (dias > 3) {
                            int cant = (int) info.get("Cantidad");
                            if (cant > 0) {
                                info.put("Cantidad", cant - 1);
                                System.out.println("Se descontó 1 de: " + key);
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("---Productos---");
                    for (Map.Entry<String, Object> entry : productos.entrySet()) {
                        String nombreProd = entry.getKey();
                        HashMap<String, Object> datos = (HashMap<String, Object>) entry.getValue();
                        System.out.println("Nombre: " + nombreProd);
                        System.out.println("Precio: " + datos.get("Precio"));
                        System.out.println("Cantidad: " + datos.get("Cantidad"));
                        System.out.println("Vence: " + datos.get("Vencimiento"));
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}

