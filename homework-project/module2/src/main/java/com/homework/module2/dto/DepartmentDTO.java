package com.homework.module2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.homework.module2.annotations.PasswordValidation;
import com.homework.module2.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long deptId;

    @NotBlank(message = "Title  of the Department cannot be blank")
    @Size(min = 3, max = 15, message = "Number of characters in title should be in the range: [3, 10]")
    private String title;

    @NotNull(message = "Active status is required")
    @JsonProperty("isActive")
    private Boolean isActive;

    @PrimeNumberValidation
    @NotNull(message = "Write a number")
    private Integer primeNumber;

    @PasswordValidation
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
