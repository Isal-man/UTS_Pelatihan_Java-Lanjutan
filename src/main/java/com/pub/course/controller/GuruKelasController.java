package com.pub.course.controller;

import com.pub.course.dto.GuruKelasDto;
import com.pub.course.model.Guru;
import com.pub.course.model.GuruKelas;
import com.pub.course.model.Siswa;
import com.pub.course.repository.GuruKelasRepository;
import com.pub.course.repository.GuruRepository;
import com.pub.course.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guru_kelas")
public class GuruKelasController {

    @Autowired
    GuruKelasRepository guruKelasRepository;

    @Autowired
    GuruRepository guruRepository;

    @Autowired
    SiswaRepository siswaRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return guruKelasRepository.findAll();
    }

    @GetMapping("/find-siswa-by-guru")
    public Object findAll(@RequestParam("guruId") Integer guruId) {
        return guruKelasRepository.findSiswaByGuru(guruId);
    }

    @PostMapping("/")
    public Object create(@RequestBody GuruKelasDto guruKelasDto) {
        // check guru
        Guru guru = guruRepository.findById(guruKelasDto.getGuruId()).orElse(null);
        if (guru == null) {
            return ResponseEntity.badRequest().body("id guru tidak ditemukan!");
        }

        // check siswa
        Siswa siswa = siswaRepository.findById(guruKelasDto.getSiswaId()).orElse(null);
        if (siswa == null) {
            return ResponseEntity.badRequest().body("id siswa tidak ditemukan!");
        }

        GuruKelas guruKelas = new GuruKelas();
        guruKelas.setGuru(guru);
        guruKelas.setSiswa(siswa);
        return guruKelasRepository.save(guruKelas);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Integer id, @RequestBody GuruKelasDto dto) {

        GuruKelas guruKelas = guruKelasRepository.findById(id).orElse(null);
        if (guruKelas == null) {
            return ResponseEntity.badRequest().body("ID Tidak Ditemukan");
        }

        Guru guru = guruRepository.findById(dto.getGuruId()).orElse(null);
        if (guru == null) {
            return ResponseEntity.badRequest().body("ID Guru Tidak Ditemukan");
        }

        Siswa siswa = siswaRepository.findById(dto.getSiswaId()).orElse(null);
        if (siswa == null) {
            return ResponseEntity.badRequest().body("ID Siswa Tidak Ditemukan");
        }

        guruKelas.setGuru(guru);
        guruKelas.setSiswa(siswa);

        return ResponseEntity.ok(guruKelasRepository.save(guruKelas));

    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {

        GuruKelas guruKelas = guruKelasRepository.findById(id).orElse(null);

        if (guruKelas == null) {
            return ResponseEntity.badRequest().body("ID Tidak Ditemukan");
        }

        guruKelasRepository.delete(guruKelas);
        return null;

    }

}
