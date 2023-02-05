package com.pub.course.repository;

import com.pub.course.model.Mata_Pelajaran;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MataPelajaranRepository extends JpaRepository<Mata_Pelajaran, Integer> {
}
