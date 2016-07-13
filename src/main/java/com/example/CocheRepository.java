package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by professor on 11/07/2016.
 */
public interface CocheRepository extends JpaRepository<Coche,Long> {


    List<Coche> findByAñoGreaterThanEqual (Integer año);
    List<Coche> findByAñoLessThanEqual (Integer año);
    List<Coche> findByAñoBetween (Integer año, Integer año2);
    List<Coche> findByPrecioGreaterThanEqual (Double precio);
    List<Coche> findByPrecioLessThanEqual (Double precio);
    List<Coche> findByPrecioBetween (Double precio, Double precio2);
    Coche findByMatriculaIs (String matricula);
    List<Coche>findByMarcaIs (String marca);
    List<Coche>findByMarcaAndModelo (String marca, String modelo);
    List<Coche>findByMarcaAndPrecioLessThanEqual(String marca, Double precio);
    List<Coche>findByMarcaAndModeloAndPrecioGreaterThanEqual(String marca, String modelo,  Double precio);

    //Al poner @Query, spring hara como método lo que tu le pidas, i no será como los metodos ya preestablecidos en la tabla 4 de Spring data reference.
    // La sentencia diu: Develveme la media de precios de todos los coches de marca especificada. (aunke asalga en rojo la clase coche, no dara error).
    @Query("SELECT AVG (c.precio) from Coche c where c.marca = :marca")
    Double obtenerMediaPorMarca (@Param("marca")String marca);
    //Que nos devuelva todos los coches que tiene una persona.
    @Query("SELECT(coche) from Coche coche where coche.propietario = :propietario")
    List<Coche>obtenerCochesDePropietario (@Param("propietario")Persona propietario);
    //resolt per coches i preu>=.
    List<Coche> findByPropietarioAndPrecioGreaterThanEqual(Persona persona, Double precio);

   @Query("SELECT(coche) from Coche coche where coche.propietario = :propietario and coche.precio>=:precio")
    List<Coche>obtenerCochesDePropietarioPrecioSuperior (@Param("propietario")Persona propietario, @Param("precio")Double precio);

    @Query("SELECT(coche) from Coche coche where coche.propietario = :propietario and coche.precio>=:precio and coche.año BETWEEN :año and :año2")
    List<Coche>cochesPropietarioPrecioAñoEntre (@Param("propietario")Persona propietario, @Param("precio")Double precio, @Param("año")Integer año, @Param("año2")Integer año2);

    @Query("SELECT(coche) from Coche coche  where coche.propietario.age>=:age")
    List<Coche>obtenerCochesPorEdadPropietario(@Param("age")Integer age);

    @Query("SELECT(coche) from Coche coche  where coche.propietario.age between :age and :age2")
    List<Coche>obtenerCochePorRangoEdadPropietarios(@Param("age")Integer age, @Param("age2") Integer age2);

    @Query ("SELECT (coche)FROM Coche coche WHERE coche.matricula LIKE(CONCAT('%',:fragmentoMatricula,'%'))")
    List<Coche> getCocheMatriculasQueContengan(@Param ("fragmentoMatricula") String fragmentoMatricula);

    @Query ("SELECT coche.marca, MAX (coche.precio), MIN (coche.precio), AVG (coche.precio) FROM Coche coche GROUP BY coche.marca")
    List<Object[]> getEstadisticaPorMarca();


}
