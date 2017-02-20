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
    
    @Column(name = "FACE_MENSAGEM")
    private String mensagem;
    
    @Column(name = "FACE_DESTINATARIO")
    private String destinatario;
    
    @Column(name = "FACE_URL_FOTO")
    private String url;
}
