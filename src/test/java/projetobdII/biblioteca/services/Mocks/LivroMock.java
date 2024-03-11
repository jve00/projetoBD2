package projetobdII.biblioteca.services.Mocks;

import projetobdII.biblioteca.dtos.livro.LivroCreateDTO;
import projetobdII.biblioteca.dtos.livro.LivroDTO;
import projetobdII.biblioteca.dtos.livro.LivroUpdateDTO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.enuns.GeneroLivro;

import java.time.LocalDate;
import java.util.Random;

public class LivroMock {
    public static LivroCreateDTO retornaLivroCreateDTOMock(){
        return new LivroCreateDTO("Harry Potter", "Ninguem", "FICCAO_CIENTIFICA", LocalDate.now());
    }

    public static LivroEntity retornaLivroEntityMock(){
        return new LivroEntity(new Random().nextInt(),"Harry Potter", "Ninguem", LocalDate.now(), GeneroLivro.FICCAO_CIENTIFICA);
    }
    public static LivroDTO retornaLivroDTOMock(){
        return new LivroDTO("Harry Potter", "Ninguem", "FICCAO_CIENTIFICA", LocalDate.now());
    }
    public static LivroUpdateDTO retornaLivroUpdateMock(){
        return new LivroUpdateDTO("Harry Potter", "Ninguem", "FICCAO_CIENTIFICA", LocalDate.now());
    }
}
