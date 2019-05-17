package it.formazione.sme.demospringweb.services;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Service
public class SalutoService implements ISalutoService {

  private static final Set<String> vecchiSaluti = new ConcurrentSkipListSet<>();

  @Override
  public Set<String> list() {
    return vecchiSaluti;
  }

  @Override
  public void addSaluto(String message) {
    if (message != null && !message.isBlank())
      vecchiSaluti.add(message);
  }

}
