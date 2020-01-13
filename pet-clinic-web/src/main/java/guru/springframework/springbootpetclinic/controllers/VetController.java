package guru.springframework.springbootpetclinic.controllers;

import guru.springframework.springbootpetclinic.services.map.VetMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    private final VetMapService vetMapService;

    @Autowired
    public VetController(VetMapService vetMapService) {
        this.vetMapService = vetMapService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetMapService.findAll());
        return "vets/index";
    }
}
