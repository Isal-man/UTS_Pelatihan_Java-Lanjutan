package com.pub.course.repository;

import com.pub.course.model.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KelasRepository extends JpaRepository<Kelas, Integer> {
}
