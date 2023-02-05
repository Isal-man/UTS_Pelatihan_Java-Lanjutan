package com.pub.course.controller;

import com.pub.course.dto.KelasDto;
import com.pub.course.model.Guru;
import com.pub.course.model.Kelas;
import com.pub.course.repository.GuruRepository;
import com.pub.course.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kelas")
public class KelasController {
    
    @Autowired
    GuruRepository guruRepository;

    @Autowired
    KelasRepository kelasRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return kelasRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody KelasDto dto) {
        // convert to siswa model
        Kelas kelas = new Kelas();
        kelas.setNama(dto.getNama());

        Guru guru = guruRepository.findById(dto.getGuruId()).orElse(null);
        if(guru == null) {
            return ResponseEntity.badRequest().body("ID Guru Tidak Ditemukan");
        }

        kelas.setGuru(guru);

        // save and return
        return ResponseEntity.ok(kelasRepository.save(kelas));
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody KelasDto dto) {

        // check if id exist
        Kelas kelas = kelasRepository.findById(id).orElse(null);
        if(kelas == null) {
            return ResponseEntity.badRequest().body("ID Kelas Tidak Ditemukan");
        }

        kelas.setNama(dto.getNama());

        Guru guru = guruRepository.findById(dto.getGuruId()).orElse(null);
        if(guru == null) {
            return ResponseEntity.badRequest().body("ID Guru Tidak Ditemukan");
        }

        kelas.setGuru(guru);

        return ResponseEntity.ok(kelasRepository.save(kelas));
    }

    // @DeleteMapping("/{id}")
    // public Object delete(@PathVariable("id") Integer id) {
    //     // check if id exist
    //     Kelas kelas = kelasRepository.findById(id).orElse(null);
    //     if(kelas == null) {
    //         return ResponseEntity.badRequest().body("ID Kelas Tidak Ditemukan");
    //     }

    //     kelasRepository.delete(kelas);
    //     return null;
    // }

}
