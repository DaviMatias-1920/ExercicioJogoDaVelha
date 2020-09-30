package exercicioJogoDaVelha;

//Este será meu Main

import java.util.Scanner;

public class JogoDaVelha {
	
	public static void main(String [] args) {
		Scanner ler = new Scanner(System.in);
		Tabuleiro jogo = new Tabuleiro();
		String posicao;
		/*verificadorJogada vai verificar se a jogada é válida. rodadas vai ser um contador de jogadas, caso chege
		 * na nona jogada e não tenha vencedor será velha 
		 */
		int verificadorJogada = 0, rodadas = 0;
		
		while(true) {
			System.out.println("-----Jogo da Velha-----");
			
			jogo.MostrarTabuleiro();
			
			do{
				System.out.print("Jogador 1, informe a zona desejada: ");
				posicao = ler.nextLine();
				while(!jogo.ValidarPosicao(posicao)) {
					System.out.println("Sua jogada não é válida, tente novamente.");
					System.out.println("Jogador 1, informe a zona desejada: ");
					posicao = ler.nextLine();
					verificadorJogada = 0;
				}
				jogo.ExecutarJogada(posicao, "X");
				verificadorJogada = 1;
				
			}while(verificadorJogada == 0);
			
			rodadas++;
			verificadorJogada = 0;
			jogo.MostrarTabuleiro();
			
			if(!jogo.Ganhar(rodadas).equals("null")) {
				break;
			}
			
			do{
				System.out.println("Jogador 2, informe a zona desejada: ");
				posicao = ler.nextLine();
				while(!jogo.ValidarPosicao(posicao)) {
					System.out.println("Sua jogada não é válida, tente novamente.");
					System.out.println("Jogador 2, informe a zona desejada: ");
					posicao = ler.nextLine();
					verificadorJogada = 0;
				}
				jogo.ExecutarJogada(posicao, "O");
				verificadorJogada = 1;
				
			}while(verificadorJogada == 0);
			
			rodadas++;
			verificadorJogada = 0;
			jogo.MostrarTabuleiro();
			
			if(!jogo.Ganhar(rodadas).equals("null")) {
				break;
			}
		}
		System.out.print(jogo.Ganhar(rodadas)+"foi o(a) vencedor(a)!");
	}
	
	
}
