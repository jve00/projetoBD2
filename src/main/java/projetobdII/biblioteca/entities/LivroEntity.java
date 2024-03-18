package projetobdII.biblioteca.entities;

import projetobdII.biblioteca.enuns.GeneroLivro;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "Livros")
@AllArgsConstructor
@NoArgsConstructor
public class LivroEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "AUTOR", nullable = false)
    private String autor;
    @Column(name = "DATA_DE_PUBLICACAO", nullable = false)
    private LocalDate dataDePublicacao;

    @Column(name = "GENERO", nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneroLivro genero;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public GeneroLivro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLivro genero) {
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
