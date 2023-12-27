package com.nd705.suppointspb.model.site;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkFormDto {
    private Long id;
    private String email;
    private String name;
    private String message;
}
