package com.vikram.spring5recipeapp.controllers;

import com.vikram.spring5recipeapp.domain.Category;
import com.vikram.spring5recipeapp.domain.Recipe;
import com.vikram.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {

        Set<Recipe> recipeSet = recipeService.getRecipes();
        Set<Category> categorySet = new HashSet<>();

        for(Recipe recipe: recipeSet) {
            if(recipe.getId().toString().equalsIgnoreCase(id)) {
                categorySet = recipe.getCategories();

            }
        }

        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        model.addAttribute("categories", categorySet);

        return "recipe/show";
    }

}
