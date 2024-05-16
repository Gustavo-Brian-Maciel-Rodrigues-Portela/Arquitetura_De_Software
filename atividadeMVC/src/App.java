import controller.BibliotecaController;
import model.Biblioteca;
import view.BibliotecaView;

public class App {
    public static void main(String[] args) {
        BibliotecaView view = new BibliotecaView(new BibliotecaController(new Biblioteca()));

        view.iniciar();
    }
}
