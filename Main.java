import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ChatBotSorveteria bot = new ChatBotSorveteria();

        System.out.println("=========================================");
        System.out.println(" Bem-vindo(a) a Sorveteria Gelato Feliz! ");
        System.out.println("=========================================");
        System.out.println(bot.mensagemBoasVindas());
        System.out.println("(Digite 'sair' a qualquer momento para encerrar a conversa)");
        System.out.println();

        boolean conversando = true;

        while (conversando) {
            System.out.print("Voce: ");
            String mensagemUsuario = teclado.nextLine();

            String mensagemNormalizada = bot.normalizar(mensagemUsuario);

            // Comando de encerramento da conversa
            if (mensagemNormalizada.equals("sair") ||
                mensagemNormalizada.equals("tchau") ||
                mensagemNormalizada.equals("encerrar")) {

                System.out.println("Bot: " + bot.mensagemDespedida());
                conversando = false;
            } else {
                String resposta = bot.responder(mensagemNormalizada);
                System.out.println("Bot: " + resposta);
            }
        }

        teclado.close();
    }
}
