package projetobdII.biblioteca.dtos.livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projetobdII.biblioteca.enuns.GeneroLivro;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LivroDTO{
    private String nome;
    private String autor;
    private GeneroLivro genero;
    private LocalDate localDate;
}
