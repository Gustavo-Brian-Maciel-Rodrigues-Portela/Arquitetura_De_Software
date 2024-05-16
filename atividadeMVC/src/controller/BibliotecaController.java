package controller;

import model.Biblioteca;
import model.Livro;

import java.util.List;

public class BibliotecaController {
    private Biblioteca biblioteca;

    public BibliotecaController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void adicionarLivro(String titulo, String autor, String numeroRegistro) {
        Livro livro = new Livro(titulo, autor, numeroRegistro);
        biblioteca.adicionarLivro(livro);
    }

    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        return biblioteca.buscarLivrosPorTitulo(titulo);
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        return biblioteca.buscarLivrosPorAutor(autor);
    }

    public boolean emprestarLivro(String numeroRegistro) {
        return biblioteca.emprestarLivro(numeroRegistro);
    }

    public void devolverLivro(String numeroRegistro) {
        biblioteca.devolverLivro(numeroRegistro);
    }

    public List<Livro> getLivros() {
        return biblioteca.getLivros();
    }
}