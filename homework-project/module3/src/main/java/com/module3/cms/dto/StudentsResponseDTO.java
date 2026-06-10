package com.module3.cms.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class StudentsResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String gender;

    private List<String> subjects;

    private List<String> professors;



}
