package com.pub.course.controller;

import com.pub.course.dto.Eskul_SiswaDto;
import com.pub.course.model.Eskul;
import com.pub.course.model.Eskul_Siswa;
import com.pub.course.model.Siswa;
import com.pub.course.repository.EskulRepository;
import com.pub.course.repository.EskulSiswaRepository;
import com.pub.course.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eskul_siswa")
public class EskulSiswaController {

    @Autowired
    EskulSiswaRepository eskulSiswaRepository;

    @Autowired
    EskulRepository eskulRepository;

    @Autowired
    SiswaRepository siswaRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return eskulSiswaRepository.findAll();
    }

    @GetMapping("/find-siswa-by-eskul")
    public Object findAll(@RequestParam("eskulId") Integer eskulId) {
        return eskulSiswaRepository.findSiswaByEskul(eskulId);
    }

    @PostMapping("/")
    public Object create(@RequestBody Eskul_SiswaDto dto) {
        // check guru
        Eskul eskul = eskulRepository.findById(dto.getEskulId()).orElse(null);
        if (eskul == null) {
            return ResponseEntity.badRequest().body("id guru tidak ditemukan!");
        }

        // check siswa
        Siswa siswa = siswaRepository.findById(dto.getSiswaId()).orElse(null);
        if (siswa == null) {
            return ResponseEntity.badRequest().body("id siswa tidak ditemukan!");
        }

        Eskul_Siswa eskul_Siswa = new Eskul_Siswa();
        eskul_Siswa.setEskul(eskul);
        eskul_Siswa.setSiswa(siswa);
        return eskulSiswaRepository.save(eskul_Siswa);
    }

}
