package com.jvmaiaa.aluguelcarros.api.domain.repository;

import com.jvmaiaa.aluguelcarros.api.domain.entity.LocadoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocadoraRepository extends JpaRepository<LocadoraEntity, Long> {
}
