package com.jvmaiaa.aluguelcarros.api.domain.repository;

import com.jvmaiaa.aluguelcarros.api.domain.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
}
