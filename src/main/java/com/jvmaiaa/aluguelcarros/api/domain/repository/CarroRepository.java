package com.jvmaiaa.aluguelcarros.api.domain.repository;

import com.jvmaiaa.aluguelcarros.api.domain.entity.CarroEntity;
import com.jvmaiaa.aluguelcarros.api.domain.entity.LocadoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Long> {

    @Query(nativeQuery = true, value = """
            SELECT
                c.locadora_id
            FROM
                tb_carro c
            WHERE
                c.id = :idCarro
            """)
    Long findIdLocadooraByIdCarro(@Param("idCarro") Long idCarro);


    @Query(nativeQuery = true, value = """
            SELECT
                l.*
            FROM
                tb_carro c
            INNER JOIN tb_locadora l ON c.locadora_id = l.id
            WHERE c.id = :idCarro
            """)
    LocadoraEntity findLocadoraByIdCarro(@Param("idCarro") Long idCarro);
}
