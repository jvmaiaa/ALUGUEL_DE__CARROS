package com.jvmaiaa.aluguelcarros.api.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Computador {
  private Integer cpu;
  private Integer ram;
  private Integer hd;
  private String placaMae;
}
