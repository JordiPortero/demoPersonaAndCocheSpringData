package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by professor on 11/07/2016.
 */
@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;

    public void testCoches(){
        Coche coche = new Coche();
        coche.setId (1L);
        coche.setMarca("Seat");
        coche.setModelo("Panda");
        coche.setAño (2005);
        coche.setPrecio(20000.0);
        coche.setMatricula("4524BSG");
        cocheRepository.save(coche);


        Coche coche2 = new Coche();
        coche2.setId (2L);
        coche2.setMarca("Seat");
        coche2.setModelo("Panda");
        coche2.setAño (2004);
        coche2.setPrecio(25000.0);
        coche2.setMatricula("5624BNF");
        cocheRepository.save(coche2);

        Coche coche3 = new Coche();
        coche3.setId (3L);
        coche3.setMarca("Nissan");
        coche3.setModelo("Qashqay");
        coche3.setAño (2014);
        coche3.setPrecio(30000.0);
        coche3.setMatricula("5876HMH");
        cocheRepository.save(coche3);

        Coche coche4 = new Coche();
        coche4.setId (4L);
        coche4.setMarca("Volkswagen");
        coche4.setModelo("Escarabajo");
        coche4.setAño (2000);
        coche4.setPrecio(25000.0);
        coche4.setMatricula("5624BNF");
        cocheRepository.save(coche4);

        Coche coche5 = new Coche();
        coche5.setId (5L);
        coche5.setMarca("Nissan");
        coche5.setModelo("Juke");
        coche5.setAño (2010);
        coche5.setPrecio(35000.0);
        coche5.setMatricula("5876STA");
        cocheRepository.save(coche5);

        Coche coche6 = new Coche();
        coche6.setId (6L);
        coche6.setMarca("Ford");
        coche6.setModelo("Fiesta");
        coche6.setAño (2002);
        coche6.setPrecio(12500.0);
        coche6.setMatricula("2548BJL");
        cocheRepository.save(coche6);

        System.out.println("Los coches fabricados en los años >= 2010 son: ");
        System.out.println(cocheRepository.findByAñoGreaterThanEqual(2010));
        System.out.println("Los coches fabricados en los años <= 2002 son: ");
        System.out.println(cocheRepository.findByAñoLessThanEqual(2002));
        System.out.println("Los coches fabricados en entre los años 2002 y 2010 son: ");
        System.out.println(cocheRepository.findByAñoBetween(2002, 2010));

        System.out.println("Los coches de precio >= 30.000e son: ");
        System.out.println(cocheRepository.findByPrecioGreaterThanEqual(30000.0));
        System.out.println("Los coches de precio <= 20.000e son: ");
        System.out.println(cocheRepository.findByPrecioLessThanEqual(20000.0));
        System.out.println("Los coches de precios comprendidos entre 20.000 y 30.000e son: ");
        System.out.println(cocheRepository.findByPrecioBetween(20000.0, 30000.0));

        System.out.println("El coche de matricula 5876STA es: ");
        System.out.println(cocheRepository.findByMatriculaIs("5876STA"));

        System.out.println("los coches de la marca Nissan son: ");
        System.out.println(cocheRepository.findByMarcaIs("Nissan"));

        System.out.println("Los coches Seat Panda son: ");
        System.out.println(cocheRepository.findByMarcaAndModelo("Seat", "Panda"));

        System.out.println("Los coches Seat de precio <= 20.000e son: ");
        System.out.println(cocheRepository.findByMarcaAndPrecioLessThanEqual("Seat", 20000.0));

        System.out.println("Los coches Seat Panda de precio >= 21.000e son: ");
        System.out.println(cocheRepository.findByMarcaAndModeloAndPrecioGreaterThanEqual("Seat", "Panda", 21000.0));

       System.out.println("El precio medio de todos los coches Seat es: ");
       System.out.println(cocheRepository.obtenerMediaPorMarca("Seat"));



    }


}
