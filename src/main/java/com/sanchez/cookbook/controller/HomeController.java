package com.sanchez.cookbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sanchez.cookbook.entity.Ingredient;
import com.sanchez.cookbook.entity.Receipe;
import com.sanchez.cookbook.repository.ReceipeRepository;

@Controller
public class HomeController {
	
	@Autowired
	ReceipeRepository repo;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		List<Receipe> receipes = repo.findAll();
		model.addAttribute("receipes", receipes);
		return "index";
	}
	
	@GetMapping("/receipe")
	public String receipeForm(Model model) {
		model.addAttribute("receipe", new Receipe());
		return "receipe-form";
	}
	
	
	@PostMapping("/receipe")
	public String submitReceipe(@ModelAttribute Receipe receipe) {
		List<Ingredient> ingrs = receipe.getIngredients();
		System.out.println(ingrs.size());
		receipe.getIngredients().forEach(ingr -> ingr.setReceipe(receipe));
		receipe.getIngredients().forEach(ingr -> System.out.println(ingr));
		receipe.getSteps().forEach(step -> step.setReceipe(receipe));
		
		repo.save(receipe);
		
		return "redirect:/";
	}

}
