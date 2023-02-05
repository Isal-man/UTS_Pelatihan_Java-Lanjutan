package com.pub.course.repository;

import com.pub.course.model.Kelas_MataPelajaran;
import com.pub.course.model.Mata_Pelajaran;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KelasMataPelajaranRepository extends JpaRepository<Kelas_MataPelajaran, Integer> {

    @Query("select km.mata_Pelajaran from Kelas_MataPelajaran km where km.kelas.id =:kelasId")
    public List<Mata_Pelajaran> findMata_PelajaranByKelas(Integer kelasId);

}
