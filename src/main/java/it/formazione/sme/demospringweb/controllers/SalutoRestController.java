package it.formazione.sme.demospringweb.controllers;

import it.formazione.sme.demospringweb.services.ISalutoService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("saluti")
public class SalutoRestController {

  private final ISalutoService salutoService;

  public SalutoRestController(ISalutoService salutoService) {
    this.salutoService = salutoService;
  }

  @GetMapping
  public Set<String> list() {
    return salutoService.list();
  }

  @PostMapping
  public Set<String> add(@RequestBody String message) {
    salutoService.addSaluto(message);
    return salutoService.list();
  }

}
