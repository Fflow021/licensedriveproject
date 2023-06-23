import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MotoristaGenerico> motoristaLista = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("==== Sistema de Habilitações ====");
        System.out.println("=================================");

        while(true) {
            System.out.println("\n[0] Fechar o programa\n[1] Adiciona uma CNH\n" +
                    "[2] Mostrar todos no sistema\n[3] Buscar uma CNH\n" +
                    "[4] Adicionar pontos numa CNH\n[5] Função de 'Autofill'\n");
            int input = Integer.parseInt(scanner.nextLine());
            
            if (input == 0) {
                System.out.println("Muito obrigado!");
                break;
            }
            
            if (input == 1) {
                System.out.println("CNH Comercial: [1] SIM [2] NÃO");
                int respComercial = Integer.parseInt(scanner.nextLine());

                System.out.println("Nome:");
                String nome = scanner.nextLine();

                System.out.println("Carteira Provisória: [1] SIM [2] NÃO");
                int resp = Integer.parseInt(scanner.nextLine());
                boolean provisoria = true;

                if(resp == 2) {
                    provisoria = false;
                }

                if(respComercial == 1) {
                    System.out.println("Tipo de veiculo:");
                    String veiculoTipo = scanner.nextLine();

                    System.out.println("cargaLista:");
                    String cargaLista = scanner.nextLine();

                    MotoristaComercial motorista = new MotoristaComercial(nome,provisoria,cargaLista,veiculoTipo);
                    motoristaLista.add(motorista);
                } else {
                    motoristaLista.add(new MotoristaGenerico(nome,provisoria));
                }

            }

            if (input == 2) {
                if(motoristaLista.isEmpty()) {
                    System.out.println("O sistema está vazio");
                }

                for(MotoristaGenerico motorista: motoristaLista) {
                    System.out.println(motorista + "\n");
                }
                System.out.println("Número de pessoas no Sistema: " + motoristaLista.size());
            }

            if (input == 3) {
                System.out.println("Nome: ");
                String nome = scanner.nextLine();

                if(motoristaLista.isEmpty()) {
                    System.out.println("O sistema está vazio.");
                } else {
                    boolean encontrado = false;
                    for(MotoristaGenerico motorista: motoristaLista) {
                        if (motorista.getNome().equals(nome)) {
                            System.out.println(motorista);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Nenhum motorista com esse nome encontrado.");
                    }
                }

            }

            if (input == 4) {
                System.out.println("Nome:");
                String nome = scanner.nextLine();

                boolean encontrado = false;
                for (MotoristaGenerico motorista: motoristaLista) {
                    if (motorista.getNome().equals(nome)) {
                        System.out.println("Pontos: ");
                        int pontos = Integer.parseInt(scanner.nextLine());
                        motorista.addPontos(pontos);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Nenhum motorista com esse nome encontrado.");
                }
            }

            if (input == 5) {
                Random random = new Random();
                String[] cargaLista = {"Perigosa","Refrigerada","Liquido","A granel", "Variados", "Volumosa"};
                String[] veiculoLista = {"Caminhão", "Caminhonete", "Van", "Picape", "Caminhão Baú", "Carreta"};

                for (int i = 0; i < 1000; i++) {
                    String nome = "Motorista" + (motoristaLista.size() + 1);
                    boolean provisorio = random.nextBoolean();

                    int decision = random.nextInt(2);
                    if (decision == 0) {
                        motoristaLista.add(new MotoristaGenerico(nome,provisorio));
                    } else {
                        String carga = cargaLista[random.nextInt(cargaLista.length)];
                        String veiculo = veiculoLista[random.nextInt(veiculoLista.length)];

                        motoristaLista.add(new MotoristaComercial(nome,provisorio,carga,veiculo));
                    }
                }
            }
        }
    }
}