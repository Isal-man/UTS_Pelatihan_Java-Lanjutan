package com.pub.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(length = 10, nullable = false)
    private String nis;

    @Column(length = 50)
    private String nama;

    @Column(columnDefinition = "TEXT")
    private String alamat;

    @Column(name = "umur")
    private Integer umur;

    @ManyToOne
    @JoinColumn(name = "kelas_id", referencedColumnName = "id")
    private Kelas kelas;

}
