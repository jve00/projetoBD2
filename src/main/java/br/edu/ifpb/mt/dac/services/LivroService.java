package br.edu.ifpb.mt.dac.services;

import br.edu.ifpb.mt.dac.dao.LivroDAO;
import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;
import br.edu.ifpb.mt.dac.dtos.livro.LivroCreateDTO;
import br.edu.ifpb.mt.dac.dtos.livro.LivroDTO;
import br.edu.ifpb.mt.dac.dtos.livro.LivroUpdateDTO;
import br.edu.ifpb.mt.dac.entities.LivroEntity;
import br.edu.ifpb.mt.dac.exceptions.RegraNegocioException;
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
