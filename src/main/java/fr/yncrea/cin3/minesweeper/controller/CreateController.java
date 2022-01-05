package fr.yncrea.cin3.minesweeper.controller;

import fr.yncrea.cin3.minesweeper.domain.Minefield;
import fr.yncrea.cin3.minesweeper.form.CreateForm;
import fr.yncrea.cin3.minesweeper.repository.MinefieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;


@Controller
@RequestMapping("/minesweeper/create")
public class CreateController {
    @Autowired
    private MinefieldRepository minefield;


    @GetMapping({"", "/"})
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
}

