package com.pub.course.controller;

import com.pub.course.dto.Kelas_MataPelajaranDto;
import com.pub.course.model.Kelas;
import com.pub.course.model.Kelas_MataPelajaran;
import com.pub.course.model.Mata_Pelajaran;
import com.pub.course.repository.KelasMataPelajaranRepository;
import com.pub.course.repository.KelasRepository;
import com.pub.course.repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kelas_mata-pelajaran")
public class KelasMataPelajaranController {

    @Autowired
    KelasMataPelajaranRepository kelasMataPelajaranRepository;

    @Autowired
    KelasRepository kelasRepository;

    @Autowired
    MataPelajaranRepository mataPelajaranRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return kelasMataPelajaranRepository.findAll();
    }

    @GetMapping("/find-mapel-by-kelas")
    public Object findAll(@RequestParam("kelasId") Integer kelasId) {
        return kelasMataPelajaranRepository.findMata_PelajaranByKelas(kelasId);
    }

    @PostMapping("/")
    public Object create(@RequestBody Kelas_MataPelajaranDto dto) {
        // check guru
        Kelas kelas = kelasRepository.findById(dto.getKelasId()).orElse(null);
        if (kelas == null) {
            return ResponseEntity.badRequest().body("id guru tidak ditemukan!");
        }

        // check siswa
        Mata_Pelajaran mataPelajaran = mataPelajaranRepository.findById(dto.getMataPelajaranId()).orElse(null);
        if (mataPelajaran == null) {
            return ResponseEntity.badRequest().body("id siswa tidak ditemukan!");
        }

        Kelas_MataPelajaran kelas_mataPelajaran = new Kelas_MataPelajaran();
        kelas_mataPelajaran.setKelas(kelas);
        kelas_mataPelajaran.setMata_Pelajaran(mataPelajaran);
        return kelasMataPelajaranRepository.save(kelas_mataPelajaran);
    }

}
