package projetobdII.biblioteca.services;

import org.apache.commons.beanutils.BeanUtils;
import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.dao.PersistenciaDacException;
import projetobdII.biblioteca.dtos.livro.LivroCreateDTO;
import projetobdII.biblioteca.dtos.livro.LivroDTO;
import projetobdII.biblioteca.dtos.livro.LivroDeleteDTO;
import projetobdII.biblioteca.dtos.livro.LivroUpdateDTO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.RegraNegocioException;
import java.lang.reflect.InvocationTargetException;
import java.lang.IllegalAccessException;
import java.util.List;
import lombok.RequiredArgsConstructor;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class LivroService {
    private final BeanUtils beanUtils;
    private final LivroDAO livroDAO;

    public LivroDTO criarLivro(LivroCreateDTO livroCreateDTO) throws RegraNegocioException {
        try{
            livroDAO.save(retornaLivroEntity(livroCreateDTO));
            return retornaLivroDTO(livroCreateDTO);
        }catch (PersistenciaDacException | InvocationTargetException | IllegalAccessException erro){
            throw new RegraNegocioException("Ocorreu algum erro ao tentar salvar o livro.");
        }
    }

    public LivroDTO atualizarLivro(LivroUpdateDTO livroUpdateDTO) throws RegraNegocioException{
        try{
            livroDAO.update(retornaLivroEntity(livroUpdateDTO));
            return retornaLivroDTO(livroUpdateDTO);
        }catch (PersistenciaDacException | InvocationTargetException | IllegalAccessException erro){
            throw new RegraNegocioException("Ocorreu algum erro ao tentar atualizar o livro.");
        }
    }

    public LivroDTO deletarLivro(LivroDeleteDTO livroDeleteDTO) throws RegraNegocioException {
        try {
            livroDAO.delete(retornaLivroEntity(livroDeleteDTO));
            return retornaLivroDTO(livroDeleteDTO);
        } catch (PersistenciaDacException | InvocationTargetException | IllegalAccessException erro) {
            throw new RegraNegocioException("Ocorreu algum erro ao tentar deletar o livro.");
        }
    }

    // Método de listar livros
    public List<LivroDTO> listarLivros() throws Exception{
        return livroDAO.getAll().stream().map(livroEntity -> {
            try {
                return retornaLivroDTO(livroEntity);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    // Métodos conversão:
    public LivroEntity retornaLivroEntity(Object object) throws InvocationTargetException, IllegalAccessException {
        LivroEntity livroEntity = null;
        if(object instanceof LivroCreateDTO){
            BeanUtils.copyProperties(livroEntity, (LivroCreateDTO) object);
        }
        else if(object instanceof LivroDTO){
            BeanUtils.copyProperties(livroEntity, (LivroDTO) object);
        }
        else if(object instanceof LivroUpdateDTO){
            BeanUtils.copyProperties(livroEntity, (LivroUpdateDTO) object);
        }
        else if(object instanceof  LivroDeleteDTO){
            BeanUtils.copyProperties(livroEntity, (LivroDeleteDTO) object);}
        return livroEntity;
    }


    public LivroDTO retornaLivroDTO(Object object) throws InvocationTargetException, IllegalAccessException {
        LivroDTO livroDTO = null;
        if(object instanceof LivroCreateDTO){
            BeanUtils.copyProperties(livroDTO, (LivroCreateDTO) object);
        }
        else if(object instanceof LivroEntity){
            BeanUtils.copyProperties(livroDTO, (LivroEntity) object);
        }
        else if(object instanceof LivroUpdateDTO){
            BeanUtils.copyProperties(livroDTO, (LivroUpdateDTO) object);
        }
        return livroDTO;
    }
}
