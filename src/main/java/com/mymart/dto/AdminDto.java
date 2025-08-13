package com.mymart.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminDto 
{
  private Long adminId;
  @NotBlank(message="Name is required")
  private String name;
  @NotBlank(message="email is mandatory")
  @Email(message="email is invalid")
  private String workMail;
  @Pattern(regexp = "\\d{10}", message = "Must be exactly 10 digits")
  private String contact;
  @NotBlank(message="Password is required")
  @Size(min=8,max=14)
  private String password;
}
