package fr.yncrea.cin3.minesweeper.controller;

import fr.yncrea.cin3.minesweeper.domain.GameStatus;
import fr.yncrea.cin3.minesweeper.repository.MinefieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController
{
	@Autowired
	private MinefieldRepository minefield;

	@GetMapping({"", "/"})
	public String index(Model model)
	{
		model.addAttribute("games", minefield.findAll());
		return "index";
	}
}
