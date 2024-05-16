package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private HashMap<String, Livro> livrosEmprestados;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.livrosEmprestados = new HashMap<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public boolean emprestarLivro(String numeroRegistro) {
        for (Livro livro : livros) {
            if (livro.getNumeroRegistro().equals(numeroRegistro)) {
                livrosEmprestados.put(numeroRegistro, livro);
                return livros.remove(livro);
            }
        }
        return false;
    }

    public void devolverLivro(String numeroRegistro) {
        livros.add(livrosEmprestados.get(numeroRegistro));
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
