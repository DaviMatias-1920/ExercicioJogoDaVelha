package exercicioJogoDaVelha;

// Aqui farei os métodos necessários para executar o jogo
/* Eu quero que o programa pergunte onde o jogador quer colocar seu símbolo 
 * com base no número que está em cada zona
 */
public class Tabuleiro {
	
	private String[] [] matriz = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
	
	public String MostrarTabuleiro() {
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				System.out.printf("  " +matriz[linha][coluna]);
			}
			System.out.println("\n");
		}
		return null;
	}
	
	public boolean ValidarPosicao(String p) {
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				if (matriz[linha][coluna].equals(p)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void ExecutarJogada(String p, String simbolo) {
		if (p.equals("1")) {
			matriz[0][0] = simbolo;
		}
		else if (p.equals("2")) {
			matriz[0][1] = simbolo;
		}
		else if (p.equals("3")) {
			matriz[0][2] = simbolo;
		}
		else if (p.equals("4")) {
			matriz[1][0] = simbolo;
		}
		else if (p.equals("5")) {
			matriz[1][1] = simbolo;
		}
		else if (p.equals("6")) {
			matriz[1][2] = simbolo;
		}
		else if (p.equals("7")) {
			matriz[2][0] = simbolo;
		}
		else if (p.equals("8")) {
			matriz[2][1] = simbolo;
		}
		else if (p.equals("9")) {
			matriz[2][2] = simbolo;
		}
	}
	
	public String Ganhar(int totalJogadas) {
		String [] t = new String[8];
		String vencedor = "null";
		if (totalJogadas == 9) {
			vencedor = "Deu Velha!";
		}
		//Formas de ganhar na horizontal
		t[0] = matriz[0][0] + matriz[0][1] + matriz[0][2];
		t[1] = matriz[1][0] + matriz[1][1] + matriz[1][2];
		t[2] = matriz[2][0] + matriz[2][1] + matriz[2][2];
		
		//Formas de ganhar na vertical
		t[3] = matriz[0][0] + matriz[1][0] + matriz[2][0];
		t[4] = matriz[0][1] + matriz[1][1] + matriz[2][1];
		t[5] = matriz[0][2] + matriz[1][2] + matriz[2][2];
		
		//Formas de ganhar na diagonal
		t[6] = matriz[0][0] + matriz[1][1] + matriz[2][2];
		t[7] = matriz[0][2] + matriz[1][1] + matriz[2][0];
		
		for (int i = 0; i < t.length; i++) {
			if (t[i].equals("XXX")) {
				vencedor = "Jogador 1";
			}
			
			else if (t[i].equals("OOO")) {
				vencedor = "Jogador 2";
			}
		}
		return vencedor;
	}
}
