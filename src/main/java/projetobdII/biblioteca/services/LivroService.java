package projetobdII.biblioteca.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.dao.PersistenciaDacException;
import projetobdII.biblioteca.dtos.livro.LivroCreateDTO;
import projetobdII.biblioteca.dtos.livro.LivroDTO;
import projetobdII.biblioteca.dtos.livro.LivroDeleteDTO;
import projetobdII.biblioteca.dtos.livro.LivroUpdateDTO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.RegraNegocioException;

import java.util.List;

@RequiredArgsConstructor
public class LivroService {
    private final ObjectMapper beanUtils;
    private final LivroDAO livroDAO;


    public LivroDTO criarLivro(LivroCreateDTO livroCreateDTO) throws RegraNegocioException, PersistenciaDacException {
        livroDAO.save(retornaLivroEntity(livroCreateDTO));

        return retornaLivroDTO(livroCreateDTO);
    }

    public LivroDTO atualizarLivro(LivroUpdateDTO livroUpdateDTO) throws RegraNegocioException{
        try{
            livroDAO.update(retornaLivroEntity(livroUpdateDTO));
            return retornaLivroDTO(livroUpdateDTO);
        }catch (PersistenciaDacException erro){
            throw new RegraNegocioException("Ocorreu algum erro ao tentar atualizar o livro.");
        }
    }

    public LivroDTO deletarLivro(LivroDeleteDTO livroDeleteDTO) throws RegraNegocioException {
        try {
            livroDAO.delete(retornaLivroEntity(livroDeleteDTO));
            return retornaLivroDTO(livroDeleteDTO);
        } catch (PersistenciaDacException erro) {
            throw new RegraNegocioException("Ocorreu algum erro ao tentar deletar o livro.");
        }
    }

    // Método de listar livros
    public List<LivroEntity> listarLivros() throws Exception{
        return livroDAO.getAll();
    }

    // Métodos conversão:
    public LivroEntity retornaLivroEntity(Object object) {
        LivroEntity livroEntity = null;
        if(object instanceof LivroCreateDTO){
            LivroCreateDTO livroCreateDTO = (LivroCreateDTO) object;
            livroEntity = new LivroEntity(null, livroCreateDTO.getNome(), livroCreateDTO.getAutor(), livroCreateDTO.getLocalDate(), livroCreateDTO.getGenero());
        }
        else if(object instanceof LivroDTO){
            LivroDTO livroDTO = (LivroDTO) object;
            livroEntity = new LivroEntity(null, livroDTO.getNome(), livroDTO.getAutor(), livroDTO.getLocalDate(), livroDTO.getGenero());

        }
        else if(object instanceof LivroUpdateDTO){
            LivroUpdateDTO livroUpdateDTO = (LivroUpdateDTO) object;
            livroEntity = new LivroEntity(livroUpdateDTO.getIdLivroUpdateDTO(), livroUpdateDTO.getNome(), livroUpdateDTO.getAutor(), livroUpdateDTO.getLocalDate(), livroUpdateDTO.getGenero());
        }
        else if(object instanceof  LivroDeleteDTO) {
            LivroDeleteDTO livroDeleteDTO = (LivroDeleteDTO) object;
            livroEntity = new LivroEntity(livroDeleteDTO.getIdLivro(), livroDeleteDTO.getNome(), livroDeleteDTO.getAutor(), livroDeleteDTO.getLocalDate(), livroDeleteDTO.getGenero());
        }
        return livroEntity;
    }


    public LivroDTO retornaLivroDTO(Object object) {
        LivroDTO livroDTO = null;
        if(object instanceof LivroCreateDTO){
            LivroCreateDTO livroCreateDTO = (LivroCreateDTO) object;
            livroDTO = new LivroDTO(livroCreateDTO.getNome(), livroCreateDTO.getAutor(), livroCreateDTO.getGenero(), livroCreateDTO.getLocalDate());
        }
        else if(object instanceof LivroEntity){
            LivroEntity livroEntity1 = (LivroEntity) object;
            livroDTO = new LivroDTO(livroEntity1.getNome(), livroEntity1.getAutor(), livroEntity1.getGenero(), livroEntity1.getDataDePublicacao());
        }
        else if(object instanceof LivroUpdateDTO){
            LivroUpdateDTO livroUpdateDTO = (LivroUpdateDTO) object;
            livroDTO = new LivroDTO(livroUpdateDTO.getNome(), livroUpdateDTO.getAutor(), livroUpdateDTO.getGenero(), livroUpdateDTO.getLocalDate());
        }
        return livroDTO;
    }
}
