package br.edu.ifpb.mt.dac.dtos.livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LivroDTO{
    private String nome;
    private String autor;
    private String genero;
    private LocalDate localDate;
}
