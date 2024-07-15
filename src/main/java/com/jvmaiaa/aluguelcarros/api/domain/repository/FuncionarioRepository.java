package com.jvmaiaa.aluguelcarros.api.domain.repository;

import com.jvmaiaa.aluguelcarros.api.domain.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

    @Query(nativeQuery = true, value = """
            SELECT
                locadora_id
            FROM
                tb_usuario
            WHERE
                id = :idFuncionario
            """)
    Long findIdLocadoraByIdFuncionario(@Param("idFuncionario") Long idFuncionario);
}
