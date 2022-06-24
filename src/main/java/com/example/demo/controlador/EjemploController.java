package com.example.demo.controlador;


import com.example.demo.modelo.Clima;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class EjemploController {

    private int campo;

    // http://localhost:8080/if?num1=2&num2=2&num3=2
    @GetMapping("/if")
    public String ejemploIf(int num1,int num2,int num3) {

        // == igual
        // != distintos
        // <, >, <=, >= mayor, menor, mayor o igual, menor o igual.
        // && = si logico (es decir, ambas condiciones deben cumplirse)
        // || = ó logico (es decir, solo una condicion puede cumplirse)

        if(num1==num2 && num2==num3) {
            return "son iguales";
        } else {
            return "no son iguales";
        }
    } // fin ejemploIf

    @GetMapping("/if2/{num1}/{num2}/{num3}")
    public String ejemploIf2(@PathVariable int num1,@PathVariable int num2,@PathVariable int num3) {
        if(num1==num2 && num2==num3) {
            return "son iguales";
        } else {
            return "no son iguales";
        }
    } // fin ejemploIf

    @GetMapping("/convertir/{num}")
    public String convertirNumero(@PathVariable int num) {
        String resultado="";
        switch (num) {
            case 1:
                resultado="uno";
                break; // es salir del bloque de codigo.
            case 2:
                resultado="dos";
                break;
            case 3:
                resultado="tres";
                break;
            default:
                resultado="no definido";
        }
        return resultado;
    }
    @GetMapping("/paises")
    public List<String> paises() {
        List<String> paises=new ArrayList<>();
        paises.add("Chile");
        paises.add("Argentina");
        paises.add("Peru");

        return paises;
    }
    @GetMapping({"/climas/{ciudad}","/climas"})
    public List<Clima> climas(@PathVariable(required = false) String ciudad) {
        List<Clima> climas=new ArrayList<>();
        climas.add(new Clima("soleado",30,40,"santiago"));
        climas.add(new Clima("nublado",20,20,"santiago"));
        climas.add(new Clima("despejado",20,27,"arica"));
        climas.add(new Clima("despejado",20,28,"valparaiso"));
        climas.add(new Clima("neblina",20,29,"valparaiso"));
        if(ciudad!=null) {
            List<Clima> climasFiltrados = climas // lista de climas
                    .stream() // en una lista de stream de climas
                    .filter(clima -> clima.getCiudad().equals(ciudad)) // cada fila se va a llama clima -> (entonces)
                    .collect(Collectors.toList()); // devuelvo los datos como un listado

            return climasFiltrados; // fin de la funcion, y devuelve los valores.
        } else {
            return climas;
        }
    }
    @GetMapping("/climas/alto/{ciudad}")
    public Clima alta(@PathVariable(required = false) String ciudad) {
        Clima clima=new Clima();
        List<Clima> climas=new ArrayList<>();
        climas.add(new Clima("soleado",30,33,"santiago"));
        climas.add(new Clima("nublado",20,32,"santiago"));
        climas.add(new Clima("despejado",20,31,"arica"));
        climas.add(new Clima("despejado",20,30,"valparaiso"));
        climas.add(new Clima("neblina",20,30,"valparaiso"));

        clima=climas
                .stream()
                .sorted(Comparator.comparing(Clima::getMax).reversed())
                .filter( cl -> cl.getCiudad().equals(ciudad))
                .collect(Collectors.toList())
                .get(0);
        return clima;
    }

    @GetMapping("/climas/ordenada/{ciudad}")
    public List<Clima> ordenadaPorClima(@PathVariable(required = false) String ciudad) {
        List<Clima> climaOrdenado=new ArrayList<>();
        List<Clima> climas=new ArrayList<>();
        climas.add(new Clima("soleado",30,33,"santiago"));
        climas.add(new Clima("nublado",20,32,"santiago"));
        climas.add(new Clima("despejado",20,31,"arica"));
        climas.add(new Clima("despejado",20,30,"valparaiso"));
        climas.add(new Clima("neblina",20,30,"valparaiso"));

        climaOrdenado=climas
                .stream()
                .sorted(Comparator.comparing(Clima::getMax).reversed())
                .filter( cl -> cl.getCiudad().equals(ciudad))
                .collect(Collectors.toList());
        return climaOrdenado;
    }



}
