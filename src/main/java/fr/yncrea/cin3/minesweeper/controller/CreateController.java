package fr.yncrea.cin3.minesweeper.controller;

import fr.yncrea.cin3.minesweeper.domain.Minefield;
import fr.yncrea.cin3.minesweeper.form.CreateForm;
import fr.yncrea.cin3.minesweeper.repository.MinefieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("/game")
public class CreateController {
    @Autowired
    private MinefieldRepository minefield;

    @GetMapping({"", "/list"})
    public String list(Model model) {
        model.addAttribute("games", minefield.findAll());
        return "list";
    }

    @GetMapping({"", "/create"})
    public String create(@PathVariable(required = false) UUID id, Model model) {

        var form = new CreateForm();
        model.addAttribute("form", form);

        if (id != null) {
            Minefield m = minefield.findById(id).orElseThrow(() -> new RuntimeException("game not found"));
            form.setId(m.getId());
            form.setWidth(m.getWidth());
            form.setHeight(m.getHeight());
            form.setCount(m.getCount());
        }
        return "create";
    }
    @PostMapping("/create")
    public String createPost(@ModelAttribute Minefield form) {
        Minefield m = new Minefield();
        if (form.getId() != null) {
            m = minefield.findById(form.getId()).orElseThrow(() -> new RuntimeException("game not create"));
        }

        m.setWidth(form.getWidth());
        m.setHeight(form.getHeight());
        m.setCount(form.getCount());
        minefield.save(m);
        minefield.findAll();

        return "redirect:/play/{}";
    }
}

