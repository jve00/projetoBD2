package br.edu.ifpb.mt.dac.dtos.livro;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDeleteDTO {
    
    private String nome;
    private String autor;
    private String genero;
    private LocalDate localDate;

}
