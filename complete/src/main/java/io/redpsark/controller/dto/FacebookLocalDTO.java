package io.redpsark.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacebookLocalDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String descricaoPost;
}
