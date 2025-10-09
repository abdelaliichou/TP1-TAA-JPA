package model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String body;
    private Boolean isCorrect;

    // many responses belong to a question
    @ManyToOne
    private Question question;


    public Response(
            String body,
            Boolean isCorrect
    ) {
        this.body = body;
        this.isCorrect=  isCorrect;
    }

}

