package com.pub.course.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Siswa {

    private String nim;
    private String nama;
    private String kelas;
    private String alamat;
    private Integer umur;



}
