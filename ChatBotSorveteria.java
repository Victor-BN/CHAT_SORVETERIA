import java.text.Normalizer;
import java.util.regex.Pattern;

public class ChatBotSorveteria {

   
    private boolean aguardandoSabor = false;

    public String mensagemBoasVindas() {
        return "Ola! Eu sou o Gelin, o chatbot da sorveteria. Como posso te ajudar hoje?";
    }

    public String mensagemDespedida() {
        return "Ate a proxima! Volte sempre na Gelato Feliz. Tchau!";
    }

    
    public String normalizar(String mensagem) {
        String semAcento = Normalizer.normalize(mensagem, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return semAcento.toLowerCase().trim();
    }

   
    private boolean contemPalavra(String msg, String palavra) {
        return Pattern.compile("\\b" + Pattern.quote(palavra) + "\\b").matcher(msg).find();
    }

    
    public String responder(String msg) {

        
        if (aguardandoSabor) {
            if (msg.contains("chocolate") || msg.contains("morango")
                    || msg.contains("baunilha") || msg.contains("napolitano")) {

                aguardandoSabor = false; 
                return "Otima escolha! Seu sorvete de " + extrairSabor(msg)
                        + " ja esta sendo preparado. Mais alguma coisa?";
            } else {
                return "Nao entendi o sabor. Temos chocolate, morango, baunilha e napolitano. Qual voce quer?";
            }
        }

        // --- Regra 1: saudacao (usa correspondencia por palavra inteira, pois
        // "oi" e "ola" sao curtas e poderiam aparecer dentro de outras palavras,
        // como em "ch-ola-te" ou "d-oi-s") ---
        if (contemPalavra(msg, "ola") || contemPalavra(msg, "oi") || msg.contains("bom dia")
                || msg.contains("boa tarde") || msg.contains("boa noite")) {
            return "Oi! Seja bem-vindo(a) a Gelato Feliz. Quer ver o cardapio ou ja quer fazer um pedido?";
        }

        // --- Regra 2: agradecimento ---
        if (msg.contains("obrigado") || msg.contains("obrigada") || msg.contains("valeu")) {
            return "Disponha! Estou aqui se precisar de mais alguma coisa.";
        }

        // --- Regra 3: cardapio/sabores ---
        if (msg.contains("cardapio") || msg.contains("sabores") || msg.contains("sabor")) {
            return "Nossos sabores disponiveis sao: chocolate, morango, baunilha e napolitano.";
        }

        // --- Regra 4: preco/valor ---
        if (msg.contains("preco") || msg.contains("valor") || msg.contains("quanto custa")) {
            return "A casquinha simples custa R$ 8,00 e o sorvete de pote custa R$ 15,00.";
        }

        // --- Regra 5: horario de funcionamento ---
        if (msg.contains("horario") || msg.contains("aberto") || msg.contains("funciona")) {
            return "Funcionamos todos os dias, das 10h as 22h.";
        }

        // --- Regra 6: endereco/localizacao ---
        if (msg.contains("endereco") || msg.contains("localizacao") || msg.contains("onde fica")) {
            return "Estamos na Rua das Delicias, numero 123, no centro da cidade.";
        }

        // --- Regra 7 (composta): entrega em casa/domicilio ---
        if (msg.contains("entrega") && (msg.contains("casa") || msg.contains("domicilio"))) {
            return "Sim, fazemos entrega em domicilio! A taxa de entrega e de R$ 5,00 e o prazo e de ate 40 minutos.";
        }

        // --- Regra 8 (composta): sorvete + chocolate juntos ---
        if (msg.contains("sorvete") && msg.contains("chocolate")) {
            return "O sorvete de chocolate e o nosso mais vendido! Feito com chocolate belga, e uma delicia.";
        }

        // --- Regra 9: iniciar um pedido (abre o contexto/estado) ---
        if (msg.contains("pedido") || msg.contains("quero pedir") || msg.contains("gostaria de pedir")
                || msg.contains("fazer um pedido")) {
            aguardandoSabor = true;
            return "Perfeito! Qual sabor voce gostaria: chocolate, morango, baunilha ou napolitano?";
        }

        // --- Fallback: mensagem nao reconhecida ---
        return "Desculpe, nao entendi sua mensagem. Voce pode perguntar sobre cardapio, precos, "
                + "horario, entrega ou fazer um pedido.";
    }

    
    private String extrairSabor(String msg) {
        if (msg.contains("chocolate")) return "chocolate";
        if (msg.contains("morango")) return "morango";
        if (msg.contains("baunilha")) return "baunilha";
        if (msg.contains("napolitano")) return "napolitano";
        return "sorvete";
    }
}
