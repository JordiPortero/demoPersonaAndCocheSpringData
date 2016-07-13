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
    //con esto en esta clase puedo usar los dos repositorios, de personas i de coches.
    @Autowired
    private PersonaRepository personaRepository;

    public void testCoches(){
        Coche coche = new Coche();
        coche.setId (1L);
        coche.setMarca("Seat");
        coche.setModelo("Panda");
        coche.setAño (2005);
        coche.setPrecio(20000.0);
        coche.setMatricula("4524BSG");
        //Añado una persona, de la clase personas (copy-paste), pero le pongo otro nombre.
        Persona persona = new Persona();
        persona.setNombre("Pedro");
        persona.setAge(23);
        personaRepository.save(persona);
        coche.setPropietario(persona);  // Aqui se vincula la persona Pedro a éste coche como propietario.


        cocheRepository.save(coche);
        //(Arriba)He añadido un propietario al coche1.

        Coche coche2 = new Coche();
        coche2.setId (2L);
        coche2.setMarca("Seat");
        coche2.setModelo("Panda");
        coche2.setAño (2004);
        coche2.setPrecio(25000.0);
        coche2.setMatricula("5624BNF");
        Persona dimple=personaRepository.findOne(2L);
        coche2.setPropietario(dimple);
        cocheRepository.save(coche2);

        Coche coche3 = new Coche();
        coche3.setId (3L);
        coche3.setMarca("Nissan");
        coche3.setModelo("Qashqay");
        coche3.setAño (2014);
        coche3.setPrecio(30000.0);
        coche3.setMatricula("5876HMH");
        //le asignamos ivan como propietario del coche3. buscamos la persona de id=1.
        Persona ivan = personaRepository.findOne(1L);
        coche3.setPropietario(ivan);
        cocheRepository.save(coche3);

        Coche coche4 = new Coche();
        coche4.setId (4L);
        coche4.setMarca("Volkswagen");
        coche4.setModelo("Escarabajo");
        coche4.setAño (2000);
        coche4.setPrecio(25000.0);
        coche4.setMatricula("5624BNF");

        coche4.setPropietario(ivan);
        cocheRepository.save(coche4);

        Coche coche5 = new Coche();
        coche5.setId (5L);
        coche5.setMarca("Nissan");
        coche5.setModelo("Juke");
        coche5.setAño (2010);
        coche5.setPrecio(35000.0);
        coche5.setMatricula("5876STA");
        coche5.setPropietario(ivan);
        cocheRepository.save(coche5);

        Coche coche6 = new Coche();
        coche6.setId (6L);
        coche6.setMarca("Ford");
        coche6.setModelo("Fiesta");
        coche6.setAño (2002);
        coche6.setPrecio(12500.0);
        coche6.setMatricula("2548BJL");
        Persona jordi = personaRepository.findOne(4L);
        coche6.setPropietario(jordi);
        cocheRepository.save(coche6);

        Coche coche7 = new Coche();
        coche7.setId(7L);
        coche7.setMarca("Renault");
        coche6.setModelo("Once");
        coche7.setAño (1990);
        coche7.setPrecio(6000.0);
        coche7.setMatricula("4863GTA");
        Persona noelia=personaRepository.findOne(3L);
        coche7.setPropietario(noelia);
        cocheRepository.save(coche7);

        Coche coche8 = new Coche();
        coche8.setId(8L);
        coche8.setMarca("Volkswagen");
        coche8.setModelo("Tiguan");
        coche8.setAño (2016);
        coche8.setPrecio(35000.0);
        coche8.setMatricula("6348JLP");
        Persona ricard=personaRepository.findOne(5L);
        coche8.setPropietario(ricard);
        cocheRepository.save(coche8);

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

        System.out.println("Los coches de Ivan son: ");
        System.out.println(cocheRepository.obtenerCochesDePropietario(ivan));

        System.out.println("Los coches de Ivan de precio >= 30.000e son: ");
        System.out.println(cocheRepository.findByPropietarioAndPrecioGreaterThanEqual(ivan, 30000.0));

        System.out.println("Los coches de Ivan de precio >= 30000.0e son(con @Query): ");
        System.out.println(cocheRepository.obtenerCochesDePropietarioPrecioSuperior(ivan, 30000.0));

        System.out.println("Los coches de Ivan de precio >= 30000.0e y de año entre 2011 y 2015 son(con Query): ");
        System.out.println(cocheRepository.cochesPropietarioPrecioAñoEntre(ivan, 30000.0, 2011, 2015));

        System.out.println("Los coches de las personas que tienen más de 24 años son: ");
        System.out.println(cocheRepository.obtenerCochesPorEdadPropietario(24));

        System.out.println("Los coches de los propietarios que tiene entre 23 y 24 años son: ");
        System.out.println(cocheRepository.obtenerCochePorRangoEdadPropietarios(23, 24));

        System.out.println("Muestra los coches cuya matricula contenga el fragmento: 76S");
        System.out.println(cocheRepository.getCocheMatriculasQueContengan("76S"));


    }


}
