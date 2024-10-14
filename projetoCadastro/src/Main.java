import models.Usuario;
import repository.UsuarioRepositoryImpl;

public class Main {

    public static void main(String[] args) {
        UsuarioRepositoryImpl users = new UsuarioRepositoryImpl();

        users.addUsuario(new Usuario("testeA", "12345678900", 18));
        users.addUsuario(new Usuario("testeB", "12345678901", 19));
        users.addUsuario(new Usuario("testeC", "12345678902", 20));

        users.listarUsuarios();

        users.removerUsuario("12345678901");

        users.listarUsuarios();

        // tudo funcionando, agora so falta fazer os testes unitarios

    }


}



