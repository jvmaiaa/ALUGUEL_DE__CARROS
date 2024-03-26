package com.jvmaiaa.aluguelcarros.api.domain.repository;

import com.jvmaiaa.aluguelcarros.api.domain.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
}
