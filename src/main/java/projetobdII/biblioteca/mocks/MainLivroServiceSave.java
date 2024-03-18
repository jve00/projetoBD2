package projetobdII.biblioteca.mocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.dtos.livro.LivroCreateDTO;
import projetobdII.biblioteca.dtos.livro.LivroDeleteDTO;
import projetobdII.biblioteca.dtos.livro.LivroUpdateDTO;
import projetobdII.biblioteca.exceptions.RegraNegocioException;
import projetobdII.biblioteca.services.LivroService;

import java.time.LocalDate;

@RequiredArgsConstructor
public class MainLivroServiceSave {

    public static void main(String[] args) throws Exception {
        LivroService livroService = new LivroService(new BeanUtils(), new LivroDAO());
        // Criando livro:
        LivroCreateDTO livroCreateDTO = new LivroCreateDTO("Harry Potter", "Ninguem", "FICCAO_CIENTIFICA", LocalDate.now());
        System.out.println(livroService.criarLivro(livroCreateDTO));
        // atualizando livro:
        LivroUpdateDTO livroUpdateDTO = new LivroUpdateDTO(22, "Harry Potter", "Ninguem", "FICCAO_CIENTIFICA", LocalDate.now());
        System.out.println(livroService.atualizarLivro(livroUpdateDTO));
        // listando todos os livros:
        System.out.println(livroService.listarLivros());
        // deletando livro
        System.out.println(livroService.deletarLivro(new LivroDeleteDTO(22, "Harry Potter", "Ninguem", "FICCAO_CIENTIFICA", LocalDate.now())));
    }
}
