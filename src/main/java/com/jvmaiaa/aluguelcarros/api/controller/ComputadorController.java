package com.jvmaiaa.aluguelcarros.api.controller;

import com.jvmaiaa.aluguelcarros.api.config.ComputadorIntel;
import com.jvmaiaa.aluguelcarros.api.config.ComputadorRyzen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvmaiaa.aluguelcarros.api.config.Computador;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/computador")
public class ComputadorController {
  
  @Autowired
  @ComputadorIntel
  private Computador computador;


  @GetMapping
  public String getMethodName() {
      return computador.getPlacaMae();
  }

}
