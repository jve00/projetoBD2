package projetobdII.biblioteca.controller;


import projetobdII.biblioteca.dtos.livro.LivroCreateDTO;
import projetobdII.biblioteca.dtos.livro.LivroDTO;
import projetobdII.biblioteca.dtos.livro.LivroUpdateDTO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.RegraNegocioException;
import projetobdII.biblioteca.services.LivroService;

import java.lang.reflect.InvocationTargetException;

public class LivroController {


    private LivroService livroService;

    public LivroDTO criarLivro(LivroCreateDTO livroCreateDTO) throws RegraNegocioException {
        return livroService.criarLivro(livroCreateDTO);
    }

    public LivroDTO atualizarLivro(LivroUpdateDTO livroUpdateDTO) throws RegraNegocioException {
        return livroService.atualizarLivro(livroUpdateDTO);
    }

    public LivroEntity retornaLivroEntity(Object object) throws InvocationTargetException, IllegalAccessException {
        return livroService.retornaLivroEntity(object);
    }

    public LivroDTO retornarLivroDTO(Object object) throws InvocationTargetException, IllegalAccessException {
        return livroService.retornaLivroDTO(object);
    }



}
