package com.ces2.trabajo3.controlador;

import com.ces2.trabajo3.modelo.Libro;
import com.ces2.trabajo3.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.function.Function;

@Controller
public class LibroController {

    @Autowired
    private LibroRepository repository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/punto2")
    public String punto2(Model model) {
        model.addAttribute("listaStack", repository.iterarStack());
        model.addAttribute("listaDeque", repository.iterarDeque());
        return "punto2";
    }

    @GetMapping("/punto3")
    public String punto3(Model model) {
        model.addAttribute("listaFiltrada", repository.filtrarPorEnum());
        return "punto3";
    }

    @GetMapping("/punto4")
    public String punto4(Model model) {
        Function<Libro, Integer> funcionSuma = libro -> {
            int suma = 0;
            for (Integer valor : libro.getConteo()) {
                suma += valor;
            }
            return suma;
        };

        Libro libroPrueba = repository.getStackLibros().peek();

        libroPrueba.verTotales(funcionSuma);

        model.addAttribute("libro", libroPrueba);
        model.addAttribute("total", funcionSuma.apply(libroPrueba));

        return "punto4";
    }
}