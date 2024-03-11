package projetobdII.biblioteca.dtos.livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroCreateDTO {
    private String nome;
    private String autor;
    private String genero;
    private LocalDate localDate;
}
