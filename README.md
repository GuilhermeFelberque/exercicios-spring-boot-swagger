# 🚀 Minhas Atividades de Java Web com Spring Boot

Este repositório foi criado para centralizar e organizar todas as atividades práticas desenvolvidas durante as aulas de desenvolvimento web com Java e Spring Boot. O objetivo principal é evoluir conceitos de Orientação a Objetos (como encapsulamento e herança) e manipulação de arquivos locais (TXT e CSV), integrando-os diretamente a uma API REST com retornos em formato JSON.

---

## 📌 Índice de Projetos

Abaixo estão listados todos os sistemas e APIs desenvolvidos, com caminhos diretos para suas respectivas pastas e arquivos de dados.

## 🎵 1. A API da Playlist

- **O que faz:** Transforma um programa de terminal em um servidor local. A API lê um arquivo de texto local com músicas salvas, converte as informações em objetos Java (título, artista e ano de lançamento) e os envia para o navegador em formato JSON. Também permite cadastrar novas músicas sem apagar as já existentes.
- **Endpoints desenvolvidos:**
  - `GET /playlist/listar` — Lê o arquivo `minha_playlist.txt` linha por linha e retorna a lista completa de músicas em JSON.
  - `POST /playlist/adicionar` — Recebe uma nova música via `@RequestBody` e salva no final do arquivo em modo append.
- **Conceitos aplicados:** Criação de APIs REST com `@RestController`, manipulação de arquivos com `FileReader`/`BufferedReader` e `FileWriter`/`BufferedWriter` (modo *append*), configuração de CORS para testes via Swagger Editor.

📂 [Acessar arquivos desta atividade](./playlistapi)
📄 [Ver arquivo de dados desta atividade (minha_playlist.txt)](./arquivos/minha_playlist.txt)

## ⚔️ 2. O Catálogo de Personagens Web

- **O que faz:** Simula o backend de uma tela de seleção de personagens de jogos. O servidor lê uma base de dados no formato CSV, interpreta as regras de herança dos guerreiros (`LutadorCorpoACorpo` e `Atirador`) e entrega uma lista completa ou filtrada conforme a escolha do usuário na URL.
- **Endpoints desenvolvidos:**
  - `GET /personagens/todos` — Lê o arquivo CSV, faz o `split(";")` e instancia as classes filhas corretas.
  - `GET /personagens/categoria/{tipo}` — Filtra os personagens da categoria especificada (`lutador` ou `atirador`) usando o operador `instanceof`.
- **Conceitos aplicados:** Herança de classes, manipulação de arquivos estruturados (CSV), uso de variáveis de caminho (`@PathVariable`) e filtros de busca com listas.

📂 [Acessar arquivos desta atividade](./src/main/java/com/example/Catalogo_De_Personagens)
📄 [Ver arquivo de dados desta atividade (personagens_db.csv)](./arquivos/personagens_db.csv.txt)

## 🏆 3. O Portal do Hackathon

- **O que faz:** Atua como o painel de controle de um Hackathon. Ao ser acionado pela web, o servidor processa em lote um arquivo de inscrições brutas, valida as regras de idade (14 a 21 anos), gera arquivos separados de aprovados e pendências, e retorna um relatório estatístico em tempo real.
- **Endpoints desenvolvidos:**
  - `POST /hackathon/processar` — Valida as inscrições, gera os arquivos locais de saída (`aprovados_hackathon.txt` e `pendencias_inscricao.txt`) e retorna um JSON com o resumo do processamento.
- **Conceitos aplicados:** Validação de regras de negócio complexas, leitura/escrita simultânea de múltiplos arquivos com `BufferedReader`/`BufferedWriter` e criação de DTOs (`RelatorioProcessamento`) para respostas personalizadas.

📂 [Acessar arquivos desta atividade](./src/main/java/com/example/Portal_Do_Hackathon)
📄 [Ver inscrições brutas (inscricoes_brutas.txt)](./arquivos/inscricoes_brutas.txt)
📄 [Ver relatório de aprovados (aprovados_hackathon.txt)](./arquivos/aprovados_hackathon.txt)
📄 [Ver relatório de pendências (pendencias_inscricao.txt)](./arquivos/pendencias_inscricoes.txt)

---

## 📖 Documentação da API

Toda a API está documentada seguindo o padrão **OpenAPI 3.0.3**, contendo as três seções (Playlist, Personagens e Hackathon) com descrições, exemplos de requisição/resposta e schemas dos objetos.

📄 [Ver documentação Swagger (swagger.yaml)](./swagger.yaml)

> Para visualizar a documentação de forma interativa, basta copiar o conteúdo do arquivo e colar no [Swagger Editor](https://editor.swagger.io).

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Função no Projeto |
|---|---|
| **Java** | Linguagem de programação principal do ecossistema. |
| **Spring Boot** | Framework para criação da API REST e gerenciamento do servidor web local. |
| **OpenAPI / Swagger** | Documentação e testes interativos dos endpoints da API. |
| **JSON** | Formato de comunicação e transferência de dados entre a API e o cliente. |
| **TXT / CSV** | Utilizados como persistência local de dados (simulando bancos de dados em arquivos). |
