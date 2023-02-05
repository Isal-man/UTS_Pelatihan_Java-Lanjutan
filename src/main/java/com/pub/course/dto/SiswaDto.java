package com.pub.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiswaDto {
    String nis;
    String nama;
    Integer kelas_id;
    String alamat;
    Integer umur;
}
