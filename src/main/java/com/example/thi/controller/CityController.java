package com.example.thi.controller;

import com.example.thi.model.City;
import com.example.thi.model.Country;
import com.example.thi.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired


    @ModelAttribute("countries")
    public List<Country> get() {
        return cityService.findAllCountry();
    }

    @GetMapping("/list")
    public ModelAndView show(@PageableDefault(5) Pageable pageable) {
        Page<City> cities = cityService.findAll(pageable);
        return new ModelAndView("list", "cities", cities);
    }

    @GetMapping("/create")
    public ModelAndView createNewCity() {

        return new ModelAndView("create", "city", new City());
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("city") City city, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("create");
            modelAndView.addObject("message", "Create fail!!!");
            return modelAndView;
        }
        cityService.save(city);
        modelAndView = new ModelAndView("redirect:/list");
        redirectAttributes.addFlashAttribute("message", "Created success!!!");
        return modelAndView;
    }

    @GetMapping("/viewInfo/{id}")
    public ModelAndView viewInfo(@PathVariable("id") Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isPresent()) {
            City city = cityOptional.get();
            return new ModelAndView("/info", "city", city);
        }
        return new ModelAndView("error-404");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isPresent()) {
            City city = cityOptional.get();
            return new ModelAndView("/edit", "city", city);
        }
        return new ModelAndView("error-404");
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute("city") City city, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("edit");
            modelAndView.addObject("message", "Edit fail!!!");
            return modelAndView;
        }
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Edit success!!!");
        modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isPresent()) {
            City city = cityOptional.get();
            return new ModelAndView("/delete", "city", city);
        }
        return new ModelAndView("error-404");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteDone(@PathVariable("id") Long id,RedirectAttributes redirectAttributes) {
        City city = cityService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        redirectAttributes.addFlashAttribute("message","Deleted success city: "+city.getName());
        return modelAndView;
    }
}
