import com.fazecast.jSerialComm.SerialPort;
import java.util.Random;
import java.util.Scanner;

public class SensorDataProcessor {

    private static Random random = new Random();

    // Representação dos sensores
    private static class SensorData {
        int luminosidade; // de 0 a 100
        double temperatura; // em Celsius
        int umidade; // de 0 a 100

        public SensorData(int luminosidade, double temperatura, int umidade) {
            this.luminosidade = luminosidade;
            this.temperatura = temperatura;
            this.umidade = umidade;
        }

        @Override
        public String toString() {
            return "Luminosidade: " + luminosidade + "%, Temperatura: " + temperatura + "°C, Umidade: " + umidade + "%";
        }
    }

    // Método para buscar as portas seriais disponíveis
    private static String buscarPortaArduino() {
        // Listando todas as portas seriais disponíveis
        SerialPort[] portas = SerialPort.getCommPorts();

        if (portas.length == 0) {
            return null;  // Retorna null se não encontrar nenhuma porta
        }

        // Simula a busca por uma porta válida (vamos pegar a primeira)
        for (SerialPort porta : portas) {
            System.out.println("Encontrada porta: " + porta.getSystemPortName());
            return porta.getSystemPortName();
        }
        return null;  // Caso não encontre, retorna null
    }

    // Método que simula a leitura dos dados dos sensores via comunicação serial
    private static SensorData lerDadosDosSensores() {
        // Simula a leitura de dados do Arduino (dados aleatórios)
        int luminosidade = random.nextInt(101); // de 0 a 100
        double temperatura = -10 + random.nextDouble() * 60; // de -10°C a 30°C
        int umidade = random.nextInt(101); // de 0 a 100

        // Retorna os dados simulados
        return new SensorData(luminosidade, temperatura, umidade);
    }

    // Processamento dos dados (simula uma análise simples)
    private static void processarDados(SensorData dados) {
        // Analisando a luminosidade
        if (dados.luminosidade < 20) {
            System.out.println("Ambiente muito escuro.");
        } else if (dados.luminosidade > 80) {
            System.out.println("Ambiente muito claro.");
        } else {
            System.out.println("Luminosidade adequada.");
        }

        // Analisando a temperatura
        if (dados.temperatura < 15) {
            System.out.println("Ambiente frio.");
        } else if (dados.temperatura > 30) {
            System.out.println("Ambiente quente.");
        } else {
            System.out.println("Temperatura confortável.");
        }

        // Analisando a umidade
        if (dados.umidade < 40) {
            System.out.println("Ambiente seco.");
        } else if (dados.umidade > 80) {
            System.out.println("Ambiente muito úmido.");
        } else {
            System.out.println("Umidade adequada.");
        }
    }

    public static void main(String[] args) {
        // Buscando a porta do Arduino
        System.out.println("Buscando a porta do Arduino...");
        String porta = buscarPortaArduino();

        // Caso a porta não seja encontrada
        if (porta == null) {
            System.out.println("Erro: Nenhuma porta serial do Arduino encontrada.");
            return;
        }

        System.out.println("Porta encontrada: " + porta);

        // Configuração do SerialPort para a simulação de coleta de dados
        SerialPort serialPort = SerialPort.getCommPort(porta);
        serialPort.openPort();  // Abre a porta serial

        // Simula a leitura dos dados dos sensores e processamento
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione 'Enter' para coletar dados dos sensores...");

        // Loop para simular a coleta de dados
        for (int i = 0; i < 5; i++) {
            System.out.println("\nColetando dados... (Pressione Enter)");
            scanner.nextLine();  // Espera pelo pressionamento de tecla

            // Simulando a leitura dos sensores
            SensorData dados = lerDadosDosSensores();
            System.out.println(dados);

            // Processando os dados coletados
            processarDados(dados);

            try {
                // Espera 2 segundos antes de coletar novos dados
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Fechando a porta serial
        serialPort.closePort();
        System.out.println("\nSimulação concluída. Porta serial fechada.");
    }
}
