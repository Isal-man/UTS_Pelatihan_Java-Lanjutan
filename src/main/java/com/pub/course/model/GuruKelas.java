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
public class GuruKelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guru_id", referencedColumnName = "id")
    private Guru guru;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "siswa_id", referencedColumnName = "id")
    private Siswa siswa;


}
