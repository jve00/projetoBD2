package projetobdII.biblioteca.services;

import projetobdII.biblioteca.dao.LivroDAO;
import projetobdII.biblioteca.dtos.livro.LivroCreateDTO;
import projetobdII.biblioteca.dtos.livro.LivroDTO;
import projetobdII.biblioteca.dtos.livro.LivroUpdateDTO;
import projetobdII.biblioteca.entities.LivroEntity;
import projetobdII.biblioteca.exceptions.RegraNegocioException;
import projetobdII.biblioteca.services.Mocks.LivroMock;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;


@DisplayName("LivroService - class")
@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
class LivroServiceTest {
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private LivroDAO livroDAO;
    @InjectMocks
    private LivroService livroService;

    // Testes não funcionais, porque o banco localhost não foi criado.
    @Test
    @DisplayName("Deveria salvar um livro com sucesso")
    void deveriaSalvarLivroSucesso() throws RegraNegocioException {
        LivroCreateDTO livroCreateDTOMock = LivroMock.retornaLivroCreateDTOMock();
        LivroDTO livroDTOMock = LivroMock.retornaLivroDTOMock();
        LivroEntity livroEntityMock = LivroMock.retornaLivroEntityMock();

        when(objectMapper.convertValue(livroCreateDTOMock, LivroEntity.class)).thenReturn(livroEntityMock);
        when(objectMapper.convertValue(livroEntityMock, LivroDTO.class)).thenReturn(livroDTOMock);

        LivroDTO livroDTOCurrent = livroService.criarLivro(livroCreateDTOMock);

        assertNotNull(livroDTOCurrent);
        assertEquals(livroDTOCurrent.getAutor(), livroDTOMock.getAutor());
    }

    @Test
    @DisplayName("Deveria atualizar um livro com sucesso")
    void deveriaAtualizarLivroSucesso() throws RegraNegocioException{
        LivroUpdateDTO livroUpdateDTOMock = LivroMock.retornaLivroUpdateMock();
        LivroDTO livroDTOMock = LivroMock.retornaLivroDTOMock();
        LivroEntity livroEntityMock = LivroMock.retornaLivroEntityMock();

        when(objectMapper.convertValue(livroUpdateDTOMock, LivroEntity.class)).thenReturn(livroEntityMock);
        when(objectMapper.convertValue(livroEntityMock, LivroDTO.class)).thenReturn(livroDTOMock);

        LivroDTO livroDTOCurrent = livroService.atualizarLivro(livroUpdateDTOMock);

        assertNotNull(livroDTOCurrent);
        assertEquals(livroDTOCurrent.getAutor(), livroDTOMock.getAutor());

    }


}