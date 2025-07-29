package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        System.out.println("SUPERMERCADO LA MAYORIA");

        //Almacenar en variables la info de un producto
        String id;
        String nombre;
        Integer PrecioUnitario;
        Integer cantidadBodega;
        Boolean caducidad;
        LocalDate fechaVencimiento;
        String fotografia1;
        String fotografia2;
        String descripcion;
        String categoria;
        String nombreProveedor;


        //si el prodcuto se vence y han pasado mas de 3 dias desde la fecha de vencimiento
        //se debe restar la unidad vencida a la cantidad de bodega

        //se debe permitir registrar N productos en una base de datos simulada en java

        //se debe permitir modificar el precio unitario de cualquier
        // producto ingresado previamente

        //se debe permitir eliminar un producto de la bodega

        /*ArrayList<String> papelesDelux = new ArrayList<>();
        //agregando elementos a un arreglo
        papelesDelux.add("Papel Higienico Familia DELUX x6 UNIDADES");
        papelesDelux.add("Papel Higienico Familia DELUX x12 UNIDADES");
        papelesDelux.add("Papel Higienico Familia DELUX x24 UNIDADES");
        papelesDelux.add("Papel Higienico Familia DELUX x48 UNIDADES");
        System.out.println(papelesDelux.size());*/

        //Trabajando con diccionarios
        /*HashMap<String,Object> usuario=new HashMap<>();
        //agregando elementos a un diccionario
        usuario.put("nombres", "Leonor de la cruz");
        usuario.put("id", "AFG8780");
        usuario.put("edad",87 );
        usuario.put("telefono", "3226809742");
        System.out.println(usuario.get("id"));*/


        //Uniendo arreglos con diccionarios
        /*ArrayList<Object> estudiantes=new ArrayList<>();
        HashMap<String,Object>Estudiante=new HashMap<>();
        Estudiante.put("id", "af4545");
        Estudiante.put("nombre","andrea insignares");
        Estudiante.put("empresa","globbant");
        estudiantes.add(Estudiante);
        System.out.println(estudiantes);*/


        //jugando con fechas
        LocalDate fechaInicial=LocalDate.of(2002,10,24);
        LocalDate fechaFinal=LocalDate.now();

        Period diferencia=Period.between(fechaInicial,fechaFinal);

        System.out.println(diferencia.getYears());
        System.out.println(diferencia.getMonths());
        System.out.println(diferencia.getDays());
    }
}