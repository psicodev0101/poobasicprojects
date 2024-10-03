package repository;

import models.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioData {

    private static final String PATH = "./database.csv";

    public static void gravar(String usuarioString) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH, true))) {
                bufferedWriter.write(usuarioString); // escreve o texto no arquivo
                bufferedWriter.newLine(); // adiciona quebra de linha
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static List<String> ler() {
        String path = "./arquivo.csv";
        List<String> linhas = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                linhas.add(linha); // Armazena cada linha na lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linhas; // Retorna a lista de linhas
    }

    public static List<String[]> gerarTabela () {
        return ler().stream() // Lê as linhas usando o método ler
                .map(linha -> linha.split(";")) // Mapeia cada linha para um array
                .collect(Collectors.toList()); // Coleta os arrays em uma lista
    }

    public static void sincronizarDataBase(List<Usuario> usuarios){

    }

}
