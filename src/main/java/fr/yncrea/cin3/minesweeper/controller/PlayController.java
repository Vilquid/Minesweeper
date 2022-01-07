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
@RequestMapping("/play")
public class PlayController {
    @Autowired
    private MinefieldRepository game;

    @GetMapping({"", "/"})
    public String play(Model model)
    {
        return "play";
    }

    @GetMapping("/{gameId}")
    public String newGame(@PathVariable UUID gameId, Model model) {
        Minefield g = game.findById(gameId).orElseThrow(() -> new RuntimeException("game not found"));



        model.addAttribute("game", g);

        return "play";
    }
}
