package com.pub.course.repository;

import com.pub.course.model.Eskul_Siswa;
import com.pub.course.model.Siswa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EskulSiswaRepository extends JpaRepository<Eskul_Siswa, Integer> {

    @Query("select es.siswa from Eskul_Siswa es where es.eskul.id =:eskulId")
    public List<Siswa> findSiswaByEskul(Integer eskulId);

}
