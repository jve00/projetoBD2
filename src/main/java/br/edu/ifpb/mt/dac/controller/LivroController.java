package br.edu.ifpb.mt.dac.controller;


import br.edu.ifpb.mt.dac.dtos.livro.LivroCreateDTO;
import br.edu.ifpb.mt.dac.dtos.livro.LivroDTO;
import br.edu.ifpb.mt.dac.dtos.livro.LivroUpdateDTO;
import br.edu.ifpb.mt.dac.entities.LivroEntity;
import br.edu.ifpb.mt.dac.exceptions.RegraNegocioException;
import br.edu.ifpb.mt.dac.services.LivroService;

public class LivroController {


    private LivroService livroService;

    public LivroDTO criarLivro(LivroCreateDTO livroCreateDTO) throws RegraNegocioException {
        return livroService.criarLivro(livroCreateDTO);
    }

    public LivroDTO atualizarLivro(LivroUpdateDTO livroUpdateDTO) throws RegraNegocioException {
        return livroService.atualizarLivro(livroUpdateDTO);
    }

    public LivroEntity retornaLivroEntity(Object object){
        return livroService.retornaLivroEntity(object);
    }

    public LivroDTO retornarLivroDTO(Object object){
        return livroService.retornaLivroDTO(object);
    }



}
