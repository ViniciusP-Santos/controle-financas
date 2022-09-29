package br.com.ifg.controlefinanca.models.email.entity;

import br.com.ifg.controlefinanca.models.usuario.Usuario;
import br.com.ifg.controlefinanca.models.email.enuns.StatusEmail;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name= "EMAIL")
public class Email {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long emailId;
    private String emailTo;
    private String subject;
//    @Column(columnDefinition = "TEXT")
//    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
    private String urlConfirme;
    @ManyToOne
    private Usuario usuario;

    //remover
    public String getEmailFrom(){
        return System.getenv("EMAIL_BOOT");
    }

}
