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
public class Guru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @Column(length = 12, nullable = false)
    String nip;

    @Column(length = 50, nullable = false)
    String namaGuru;

    @Column(length = 15)
    String noTelepon;

}
