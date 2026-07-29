package com.example.playlistapi.controllers;

import com.example.playlistapi.entities.Musicas;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private final String arquivo = "arquivos/minha_playlist.txt";

    @GetMapping("/listar")
    public List<Musicas> listar() {
        List<Musicas> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String titulo = partes[0];
                String artista = partes[1];
                int ano = Integer.parseInt(partes[2]);
                lista.add(new Musicas(titulo, artista, ano));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return lista;
    }

    /*Obs: para testar este endpoint no Postman, foi necessário configurar
    * manualmente o metodo HTTP como POST e inserir o corpo (body) da
    *requisição no formato JSON (raw/JSON), já que o Postman cria as
    * requisições como GET por padrão e sem body.*/
    @PostMapping("/adicionar")
    public String adicionar(@RequestBody Musicas novaMusica) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(novaMusica.getTitulo() + ";" + novaMusica.getArtista() + ";" + novaMusica.getAnoLancamento());
            bw.newLine();
        } catch (IOException e) {
            return "Erro ao salvar a música: " + e.getMessage();
        }
        return "Música salva com sucesso!";
    }
}