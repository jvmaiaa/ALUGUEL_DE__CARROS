package com.jvmaiaa.aluguelcarros.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class computadorConfig {
  
  @Bean
  @Primary
  public Computador computadorIntel(){
    Computador computador = new Computador();
    computador.setCpu(4);
    computador.setRam(16);
    computador.setHd(500);
    computador.setPlacaMae("Asus");
    return computador;
  }

  @Bean
  public Computador computadorRyzen(){
    Computador computador = new Computador();
    computador.setCpu(12);
    computador.setRam(64);
    computador.setHd(2000);
    computador.setPlacaMae("MSI");
    return computador;
  }
}
