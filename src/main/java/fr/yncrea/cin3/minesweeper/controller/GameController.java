package fr.yncrea.cin3.minesweeper.controller;

import fr.yncrea.cin3.minesweeper.domain.GameStatus;
import fr.yncrea.cin3.minesweeper.domain.Minefield;
import fr.yncrea.cin3.minesweeper.form.CreateForm;
import fr.yncrea.cin3.minesweeper.repository.MinefieldRepository;
import fr.yncrea.cin3.minesweeper.service.MinesweeperEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@Controller
@RequestMapping("/minesweeper")
public class GameController {

    @Autowired
    private MinefieldRepository minefield;

    @Autowired
    private MinesweeperEngineService minefieldService;

    @GetMapping({"", "/list"})
    public String list(Model model) {
        model.addAttribute("games", minefield.findAll());
        return "list";
    }

    @GetMapping({"", "/create"})
    public String create(Model model) {

        var form = new CreateForm();
        model.addAttribute("form", form);

        return "create";
    }
    @PostMapping("/create")
    public String createPost(@ModelAttribute Minefield form) {

        //if (form.getId() != null) {
        //.orElseThrow(() -> new RuntimeException("game not create"));
        Minefield m = minefield.save(minefieldService.create(form.getWidth(), form.getHeight(), form.getCount(), GameStatus.STARTED));
        //}
        return "redirect:/minesweeper/game/" + m.getId();
    }

    @GetMapping("/game/{gameId}")
    public String newGame(@PathVariable UUID gameId, Model model) {
        Minefield m = minefield.findById(gameId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("game", m);

        return "play";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        minefield.deleteById(id);
        return "redirect:/";
    }
}

