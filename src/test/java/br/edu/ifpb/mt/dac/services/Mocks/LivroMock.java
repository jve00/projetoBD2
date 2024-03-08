package br.edu.ifpb.mt.dac.services.Mocks;

import br.edu.ifpb.mt.dac.dtos.livro.LivroCreateDTO;
import br.edu.ifpb.mt.dac.dtos.livro.LivroDTO;
import br.edu.ifpb.mt.dac.dtos.livro.LivroUpdateDTO;
import br.edu.ifpb.mt.dac.entities.classe.LivroEntity;
import br.edu.ifpb.mt.dac.enuns.GeneroLivro;

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
