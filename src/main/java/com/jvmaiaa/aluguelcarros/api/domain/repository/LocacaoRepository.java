package com.jvmaiaa.aluguelcarros.api.domain.repository;

import com.jvmaiaa.aluguelcarros.api.domain.entity.LocacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<LocacaoEntity, Long> {
}
