# Chatbot Sorveteria - Gelato Feliz 

Chatbot simples em Java para atendimento de uma sorveteria fictícia chamada **Gelato Feliz**. O bot (apelidado de **Gelin**) conversa pelo terminal e responde a mensagens sobre cardápio, preços, horário de funcionamento, endereço, entrega e permite iniciar um pedido de sorvete.

## Funcionalidades

- Saudação e despedida
- Informações sobre cardápio e sabores (chocolate, morango, baunilha, napolitano)
- Preços da casquinha e do pote
- Horário de funcionamento
- Endereço da loja
- Informações sobre entrega em domicílio
- Fluxo de pedido: o bot pergunta o sabor e confirma a escolha
- Reconhece mensagens sem acentuação e ignora maiúsculas/minúsculas

## Estrutura do projeto

- `Main.java` — classe principal, contém o loop de conversa no terminal
- `ChatBotSorveteria.java` — classe com a lógica de respostas do chatbot

## Como executar

### Opção 1: usando uma IDE (recomendado para iniciantes)

**IntelliJ IDEA:**
1. Abra o IntelliJ e clique em **File > New > Project from Existing Sources**.
2. Selecione a pasta onde estão os arquivos `Main.java` e `ChatBotSorveteria.java`.
3. Confirme as opções padrão até o projeto abrir.
4. No painel à esquerda, clique com o botão direito em `Main.java` e escolha **Run 'Main.main()'**.
5. O terminal de execução vai abrir na parte inferior da tela — é ali que você conversa com o bot.

**Eclipse:**
1. Abra o Eclipse e clique em **File > New > Java Project**.
2. Dê um nome ao projeto e finalize a criação.
3. Clique com o botão direito na pasta `src` do projeto e escolha **Import > File System**, apontando para a pasta com os dois arquivos `.java` (ou simplesmente arraste os arquivos para dentro da pasta `src`).
4. Clique com o botão direito em `Main.java` e escolha **Run As > Java Application**.
5. A conversa acontece no console, na parte inferior da tela.

**VS Code (com extensão Java):**
1. Instale a extensão **Extension Pack for Java**.
2. Abra a pasta que contém `Main.java` e `ChatBotSorveteria.java`.
3. Abra o arquivo `Main.java` e clique em **Run** (botão que aparece acima do método `main`).
4. A conversa acontece no terminal integrado do VS Code.



## Como usar o bot

Depois de iniciar, basta digitar mensagens no terminal, por exemplo:

```
Voce: ola
Voce: cardapio
Voce: quero fazer um pedido
Voce: chocolate
Voce: sair
```

Digite `sair`, `tchau` ou `encerrar` a qualquer momento para finalizar a conversa.

## Requisitos

- JDK 8 ou superior instalado
