package com.pub.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Kelas_MataPelajaran {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mata_pelajaran_id", referencedColumnName = "id")
    private Mata_Pelajaran mata_Pelajaran;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kelas_id", referencedColumnName = "id")
    private Kelas kelas;

}
