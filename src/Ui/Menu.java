package Ui;

import Cinema.Opcoes;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        MetodosAuxliares auxliares = new MetodosAuxliares();

        boolean whileTrue = true;
        int linhaUser = 10, colunaUser = 10;

        System.out.println("CRIANDO MAPA DE ASSENTO");

        System.out.print("Digite a quantidade de linhas:");
        linhaUser = teclado.nextInt();
        auxliares.vereficaRespotaUser(linhaUser);

        System.out.print("Digite a quantidade de Colunas:");
        colunaUser = teclado.nextInt();
        auxliares.vereficaRespotaUser(colunaUser);

        Opcoes opcoes = new Opcoes(linhaUser+1,colunaUser+1);
        opcoes.imprimeMapa();

        while(whileTrue) {
            System.out.println("\n 1- Reservar um assento. " +
                    "\n 2- Cancelar uma reserva " +
                    "\n 3- Mostrar Quantidade de Reservas/Assentos Livres " +
                    "\n 4- Mostrar Mapa " +
                    "\n 5- Finalizar Reserva");

            System.out.print("Digite a opção desejada: ");
            int respotaUser = teclado.nextInt();


            switch (respotaUser){
                case 1:
                    System.out.println("\nRESERVANDO ASSENTO");

                    System.out.print("Escolha a Linha:");
                    String linha = teclado.next();
                    String linhaChar = auxliares.verficiaRepostaLinhaUser(linha);

                    System.out.print("Escolha a Coluna:");
                    int coluna = teclado.nextInt();
                    auxliares.verficiaRepostaColunaUser(coluna,colunaUser);

                    boolean reserva = opcoes.reservaAssento(linhaChar.toUpperCase().charAt(0),coluna);

                    while(!reserva){
                        System.out.println("Não foi possivel reservar seu assento pois já está reservado, tente outro.");

                        opcoes.imprimeMapa();

                        System.out.print("Escolha a Linha:");
                        linha = teclado.next();
                        linhaChar = auxliares.verficiaRepostaLinhaUser(linha);

                        System.out.print("Escolha a Coluna:");
                        coluna = teclado.nextInt();

                        reserva = opcoes.reservaAssento(linhaChar.toUpperCase().charAt(0),coluna);
                    }

                    if(reserva) {
                        System.out.println("Sua reserva foi realizada com Sucesso!");
                        opcoes.imprimeMapa();
                    }
                    break;
                case 2:
                    System.out.println("\nCANCELAR UM ASSENTO");

                    System.out.print("Escolha a Linha:");
                    linha = teclado.next();
                    linhaChar = auxliares.verficiaRepostaLinhaUser(linha);

                    System.out.print("Escolha a Coluna:");
                    coluna = teclado.nextInt();
                    auxliares.verficiaRepostaColunaUser(coluna,colunaUser);

                    boolean cancelaRersva = opcoes.cancelaReservaAssento(linhaChar.toUpperCase().charAt(0),coluna);

                    while(!cancelaRersva && opcoes.getAssentosOcupados() != 0) {
                       System.out.println("O Assento que está querendo cancelar não está reservado.");

                        opcoes.imprimeMapa();

                        System.out.print("Escolha a Linha:");
                        linhaChar = auxliares.verficiaRepostaLinhaUser(linha);

                        System.out.print("Escolha a Coluna:");
                        coluna = teclado.nextInt();

                        cancelaRersva = opcoes.cancelaReservaAssento(linhaChar.toUpperCase().charAt(0),coluna);
                    }

                    if(cancelaRersva) {
                        System.out.println("Sua reserva foi cancelada com Sucesso!");
                        opcoes.imprimeMapa();
                    }else{
                        System.out.println("Não há assentos reservados para cancelar");
                    }

                    break;
                case 3:
                    System.out.println("QUANTINDADE DE ASSENTOS LIVRES E RESERVADOS");
                    opcoes.qtdAssentosLivreOcupado();
                    System.out.println("Quantidade de assentos livres:" + opcoes.getAssentosLivres());
                    System.out.println("Quantidade de assentos ocupados:" + opcoes.getAssentosOcupados());
                    break;
                case 4:
                    System.out.println("\nMOSTRA MAPA");

                    opcoes.imprimeMapa();
                    break;
                default:
                    whileTrue = false;
            }
        }
    }
}
