package com.pub.course.controller;

import com.pub.course.dto.Mata_PelajaranDto;
import com.pub.course.model.Guru;
import com.pub.course.model.Mata_Pelajaran;
import com.pub.course.repository.GuruRepository;
import com.pub.course.repository.MataPelajaranRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mata-pelajaran")
public class MataPelajaranController {
    
    @Autowired
    GuruRepository guruRepository;

    @Autowired
    MataPelajaranRepository mataPelajaranRepository ;

    @GetMapping("/find-all")
    public Object findAll() {
        return mataPelajaranRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody Mata_PelajaranDto dto) {
        // convert to siswa model
        Mata_Pelajaran mata_Pelajaran= new Mata_Pelajaran();
        mata_Pelajaran.setNama(dto.getNama());

        Guru guru = guruRepository.findById(dto.getGuruId()).orElse(null);
        if(guru == null) {
            return ResponseEntity.badRequest().body("ID Guru Tidak Ditemukan");
        }

        mata_Pelajaran.setGuru(guru);

        // save and return
        return ResponseEntity.ok(mataPelajaranRepository.save(mata_Pelajaran));
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody Mata_PelajaranDto dto) {

        // check if id exist
        Mata_Pelajaran mata_Pelajaran = mataPelajaranRepository.findById(id).orElse(null);
        if(mata_Pelajaran == null) {
            return ResponseEntity.badRequest().body("ID Kelas Tidak Ditemukan");
        }

        mata_Pelajaran.setNama(dto.getNama());

        Guru guru = guruRepository.findById(dto.getGuruId()).orElse(null);
        if(guru == null) {
            return ResponseEntity.badRequest().body("ID Guru Tidak Ditemukan");
        }

        mata_Pelajaran.setGuru(guru);

        return ResponseEntity.ok(mataPelajaranRepository.save(mata_Pelajaran));
    }

    // @DeleteMapping("/{id}")
    // public Object delete(@PathVariable("id") Integer id) {
    //     // check if id exist
    //     Mata_Pelajaran mata_Pelajaran = mataPelajaranRepository.findById(id).orElse(null);
    //     if(mata_Pelajaran == null) {
    //         return ResponseEntity.badRequest().body("ID Kelas Tidak Ditemukan");
    //     }

    //     mataPelajaranRepository.delete(mata_Pelajaran);
    //     return null;
    // }

}
