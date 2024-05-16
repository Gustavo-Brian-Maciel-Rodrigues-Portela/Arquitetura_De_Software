package model;

public class Livro {
    private String titulo;
    private String autor;
    private String numeroRegistro;

    public Livro(String titulo, String autor, String numeroRegistro) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroRegistro = numeroRegistro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }
}
