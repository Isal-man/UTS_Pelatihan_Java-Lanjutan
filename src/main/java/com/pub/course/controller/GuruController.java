package com.pub.course.controller;

import com.pub.course.dto.GuruDto;
import com.pub.course.model.Guru;
import com.pub.course.repository.GuruRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    GuruRepository guruRepository;

    @GetMapping("/find-all")
    public Object findAll() {
        return guruRepository.findAll();
    }

    @PostMapping("/")
    public Object create(@RequestBody GuruDto guruDto) {
        Guru guru = new Guru();
        guru.setNip(guruDto.getNip());
        guru.setNamaGuru(guruDto.getNamaGuru());
        guru.setNoTelepon(guruDto.getNoTelepon());
        return ResponseEntity.ok(guruRepository.save(guru));
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Integer id, @RequestBody GuruDto guruDto) {
        Guru guru = guruRepository.findById(id).orElse(null);
        if (guru == null) {
            return ResponseEntity.badRequest().body("id tidak ditemukan!");
        }

        guru.setNip(guruDto.getNip());
        guru.setNamaGuru(guruDto.getNamaGuru());
        guru.setNoTelepon(guruDto.getNoTelepon());
        return guruRepository.save(guru);
    }

    // @DeleteMapping("/{id}")
    // public Object delete(@PathVariable Integer id) {
    //     Guru guru = guruRepository.findById(id).orElse(null);
    //     if (guru == null) {
    //         return ResponseEntity.badRequest().body("id tidak ditemukan!");
    //     }

    //     guruRepository.delete(guru);
    //     return null;
    // }

}
