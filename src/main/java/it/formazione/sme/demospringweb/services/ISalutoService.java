package it.formazione.sme.demospringweb.services;

import java.util.Set;

public interface ISalutoService {
  Set<String> list();
  void addSaluto(String message);
}
