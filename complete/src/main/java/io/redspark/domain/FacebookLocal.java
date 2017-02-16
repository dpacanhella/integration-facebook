package io.redspark.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FACEBOOK")
public class FacebookLocal {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "FACE_ID")
    private Long id;
    
    @Column(name = "FACE_NOME")
    private String nome;
    
    @Column(name = "FACE_SOBRENOME")
    private String sobrenome;
    
    @Column(name = "FACE_EMAIL")
    private String email;
    
    @Column(name = "FACE_DESCRICAO_POST")
    private String descricaoPost;
}
