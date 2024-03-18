package projetobdII.biblioteca.services;

import lombok.AllArgsConstructor;
import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.dao.PersistenciaDacException;
import projetobdII.biblioteca.dtos.livro.LivroCreateDTO;
import projetobdII.biblioteca.dtos.livro.LivroDTO;
import projetobdII.biblioteca.dtos.livro.LivroDeleteDTO;
import projetobdII.biblioteca.dtos.livro.LivroUpdateDTO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.RegraNegocioException;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LivroService {
    private final ObjectMapper objectMapper;
    private final LivroDAO livroDAO;

    public LivroDTO criarLivro(LivroCreateDTO livroCreateDTO) throws RegraNegocioException {
        try{
            livroDAO.save(retornaLivroEntity(livroCreateDTO));
            return retornaLivroDTO(livroCreateDTO);
        }catch (PersistenciaDacException erro){
            throw new RegraNegocioException("Ocorreu algum erro ao tentar salvar o livro.");
        }
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
    public List<LivroDTO> listarLivros() {
        try {
            return livroDAO.getAll().stream().map(this::retornaLivroDTO).toList();
        } catch (PersistenciaDacException erro) {
            erro.printStackTrace();
        }
        return null;
    }

    // Métodos conversão:
    public LivroEntity retornaLivroEntity(Object object){
        LivroEntity livroEntity = null;
        if(object instanceof LivroCreateDTO){
            livroEntity = objectMapper.convertValue((LivroCreateDTO) object, LivroEntity.class);
        }
        else if(object instanceof LivroDTO){
            livroEntity = objectMapper.convertValue((LivroDTO) object, LivroEntity.class);
        }
        else if(object instanceof LivroUpdateDTO){
            livroEntity = objectMapper.convertValue((LivroUpdateDTO) object, LivroEntity.class);
        }
        else if(object instanceof  LivroDeleteDTO){
            livroEntity = objectMapper.convertValue((LivroDeleteDTO) object, LivroEntity.class);
        }
        return livroEntity;
    }


    public LivroDTO retornaLivroDTO(Object object){
        LivroDTO livroDTO = null;
        if(object instanceof LivroCreateDTO){
            livroDTO = objectMapper.convertValue((LivroCreateDTO) object, LivroDTO.class);
        }
        else if(object instanceof LivroEntity){
            livroDTO = objectMapper.convertValue((LivroEntity) object, LivroDTO.class);
        }
        else if(object instanceof LivroUpdateDTO){
            livroDTO = objectMapper.convertValue((LivroUpdateDTO) object, LivroDTO.class);
        }
        return livroDTO;
    }
}
