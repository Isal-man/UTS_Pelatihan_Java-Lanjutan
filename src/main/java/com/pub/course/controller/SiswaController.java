package com.pub.course.controller;

import com.pub.course.dto.SiswaDto;
import com.pub.course.model.Siswa;
import com.pub.course.repository.KelasRepository;
import com.pub.course.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siswa")
public class SiswaController {

    @Autowired
    SiswaRepository siswaRepository;

    @Autowired
    KelasRepository kelasRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return siswaRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody SiswaDto dto) {
        // convert to siswa model
        Siswa siswa = new Siswa();
        siswa.setNis(dto.getNis());
        siswa.setNama(dto.getNama());
        siswa.setAlamat(dto.getAlamat());
        siswa.setUmur(dto.getUmur());

        if(kelasRepository.findById(dto.getKelas_id()).isPresent()) {
            siswa.setKelas(kelasRepository.findById(dto.getKelas_id()).orElse(null));
            return ResponseEntity.ok(siswaRepository.save(siswa));
        } else {
            return ResponseEntity.badRequest().body("id kelas tidak ditemukan!");
        }
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody SiswaDto dto) {

        // check if id exist
        Siswa siswa = siswaRepository.findById(id).orElse(null);
        if (siswa == null) {
            return ResponseEntity.badRequest().body("id siswa tidak ditemukan!");
        }

        siswa.setNis(dto.getNis());
        siswa.setNama(dto.getNama());
        siswa.setAlamat(dto.getAlamat());
        siswa.setUmur(dto.getUmur());

        return ResponseEntity.ok(siswaRepository.save(siswa));
    }

    // @DeleteMapping("/{id}")
    // public Object delete(@PathVariable("id") Integer id) {
    //     // check if id exist
    //     Siswa siswa = siswaRepository.findById(id).orElse(null);
    //     if (siswa == null) {
    //         return ResponseEntity.badRequest().body("id tidak ditemukan!");
    //     }

    //     siswaRepository.delete(siswa);
    //     return null;
    // }

}
