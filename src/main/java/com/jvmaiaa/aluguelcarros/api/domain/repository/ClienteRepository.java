package com.jvmaiaa.aluguelcarros.api.domain.repository;

import com.jvmaiaa.aluguelcarros.api.domain.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
