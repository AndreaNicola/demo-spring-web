package it.formazione.sme.demospringweb.controllers;

import it.formazione.sme.demospringweb.services.ISalutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class SalutoController {

  private final ISalutoService salutoService;

  public SalutoController(ISalutoService salutoService) {
    this.salutoService = salutoService;
  }

  @RequestMapping(path = "/saluto", method = RequestMethod.GET)
  public String index1(Model model) {
    Set<String> vecchiSaluti = salutoService.list();
    model.addAttribute("vecchiSaluti", vecchiSaluti);
    return "saluto";
  }

  @RequestMapping(path = "/saluto", method = RequestMethod.POST)
  public ModelAndView index2(String message) {
    salutoService.addSaluto(message);
    Set<String> vecchiSaluti = salutoService.list();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("vecchiSaluti", vecchiSaluti);
    modelAndView.addObject("message", message);
    modelAndView.setViewName("saluto");
    return modelAndView;
  }

}
