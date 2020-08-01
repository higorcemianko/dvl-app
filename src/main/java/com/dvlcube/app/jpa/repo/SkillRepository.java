package com.dvlcube.app.jpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dvlcube.app.manager.data.SkillBean;
import com.dvlcube.app.jpa.BasicRepository;
import com.dvlcube.app.jpa.DvlRepository;

import java.util.List;
import java.util.Optional;

/**
 * @since 4 de jun de 2019
 * @author Ulisses Lima
 */
@Repository
public interface SkillRepository extends DvlRepository<SkillBean, Long>, BasicRepository<SkillBean, Long> {
    @Query(" SkillBean s WHERE s.name LIKE %:name%")
    List<SkillBean> searchLikeByName(@Param("name") String name);

    @Query("SkillBean s WHERE s.name LIKE %:name%")
    Optional<SkillBean> findByName(@Param("name") String name);

    @Query("select case when count(s) > 0 then true else false end from SkillBean s WHERE s.name = :name")
    boolean existsByName(@Param("name") String name);
}
