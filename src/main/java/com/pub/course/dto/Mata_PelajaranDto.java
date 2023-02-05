package com.pub.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mata_PelajaranDto {
    
    String nama;
    private Integer guruId;

}
