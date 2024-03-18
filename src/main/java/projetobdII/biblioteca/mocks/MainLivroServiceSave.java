package projetobdII.biblioteca.mocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.dtos.livro.LivroCreateDTO;
import projetobdII.biblioteca.dtos.livro.LivroDeleteDTO;
import projetobdII.biblioteca.dtos.livro.LivroUpdateDTO;
import projetobdII.biblioteca.enuns.GeneroLivro;
import projetobdII.biblioteca.services.LivroService;

import java.time.LocalDate;

public class MainLivroServiceSave {

    public static void main(String[] args) throws Exception {
        LivroService livroService = new LivroService(new ObjectMapper(), new LivroDAO());

        // Criando livro:
        LivroCreateDTO livroCreateDTO = new LivroCreateDTO("Harry Potter", "Ninguem", GeneroLivro.FICCAO_CIENTIFICA, LocalDate.now());
        System.out.println(livroService.criarLivro(livroCreateDTO));

//        // Atualizando livro:
//        LivroUpdateDTO livroUpdateDTO = new LivroUpdateDTO(22, "Harry Potter", "Ninguem", GeneroLivro.FANTASIA, LocalDate.now());
//        System.out.println(livroService.atualizarLivro(livroUpdateDTO));
//
//        // Listando todos os livros:
//        System.out.println(livroService.listarLivros());
//
//        // Deletando livro
//        System.out.println(livroService.deletarLivro(new LivroDeleteDTO(22, "Harry Potter", "Ninguem", GeneroLivro.ROMANCE, LocalDate.now())));
    }
}
