package com.pub.course.controller;

import com.pub.course.dto.EskulDto;
import com.pub.course.model.Eskul;
import com.pub.course.repository.EskulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eskul")
public class EskulController {

    @Autowired
    EskulRepository eskulRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return eskulRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody EskulDto dto) {
        // convert to siswa model
        Eskul eskul = new Eskul();
        eskul.setNama(dto.getNama());

        // save and return
        return ResponseEntity.ok(eskulRepository.save(eskul));
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Integer id,
                         @RequestBody EskulDto dto) {

        // check if id exist
        Eskul eskul = eskulRepository.findById(id).orElse(null);
        if(eskul == null) {
            return ResponseEntity.badRequest().body("ID eskul Tidak Ditemukan");
        }

        eskul.setNama(dto.getNama());

        return ResponseEntity.ok(eskulRepository.save(eskul));
    }

    // @DeleteMapping("/{id}")
    // public Object delete(@PathVariable("id") Integer id) {
    //     // check if id exist
    //     Eskul eskul = eskulRepository.findById(id).orElse(null);
    //     if(eskul == null) {
    //         return ResponseEntity.badRequest().body("ID eskul Tidak Ditemukan");
    //     }

    //     eskulRepository.delete(eskul);
    //     return null;
    // }

}
