import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JogoModel {
	private ArrayList<ArrayList<String>> espacos = new ArrayList<ArrayList<String>>();
	private String vitoria = "";
	public final String X = "X";
	public final String O = "O";
	private final String VAZIO = "";
	private final ArrayList<String> possiveis = new ArrayList<String>();
	private int atual = 0;
	private int modo = 0;
	private Random random = new Random();
	public JogoModel() {
		espacos.add(new ArrayList<String>(Arrays.asList(VAZIO,VAZIO,VAZIO)));
		espacos.add(new ArrayList<String>(Arrays.asList(VAZIO,VAZIO,VAZIO)));
		espacos.add(new ArrayList<String>(Arrays.asList(VAZIO,VAZIO,VAZIO)));
		
		possiveis.add(X);
		possiveis.add(O);
	}
	
	public String adiciona(int x, int y) {
		if (espacos.get(y).get(x).equals("")){
			String valor = possiveis.get(atual);
			espacos.get(y).set(x, valor);
			
			if (atual == 0) {
				atual++;
			} else {
				atual--;
			}
			return valor;
		} else {
			return espacos.get(y).get(x);
		}
	}
	
	public ArrayList<Integer> cpuAdiciona() {
		int x = random.nextInt(3);
		int y = random.nextInt(3);
		
		while (!espacos.get(y).get(x).equals("")){
			x = random.nextInt(3);
			y = random.nextInt(3);
		}
		
		ArrayList<Integer> pos = new ArrayList<Integer>();
		pos.add(x);
		pos.add(y);
		
		return pos;
	}
	
	
	
	
	
	public boolean checaAcabou() {
		Boolean encontrou = false;
		//linhas são iguais?
		for(String valor: possiveis) {//Para cada valor possível da jogada
			for(ArrayList<String> linha: espacos) {//Para cada linha
				for(String pos: linha) {//Para cada posição do tabuleiro
					if (!pos.equals(valor)) {
						encontrou = false;
						break;
					}
					encontrou = true;
				}
				if (encontrou) {
					vitoria = valor + ": Venceu!";
					return true;
				}
			}
		}
		
		//colunas são iguais?
		for(String valor: possiveis) {//Para cada valor possível da jogada
			for (int i = 0; i<3;i++) {
				for (int j = 0; j<3;j++) {
					String pos = espacos.get(j).get(i);
					if (!pos.equals(valor)) {
						encontrou = false;
						break;
					}
					encontrou = true;
				}	
				if (encontrou) {
					vitoria = valor + ": Venceu!";
					return true;
				}
			}
		}
		
		for(String valor: possiveis) {//Diagonal
			if ((espacos.get(0).get(0).equals(valor) &&
				espacos.get(1).get(1).equals(valor) &&
				espacos.get(2).get(2).equals(valor) ) ||
					
				(espacos.get(0).get(2).equals(valor) &&
						espacos.get(1).get(1).equals(valor) &&
						espacos.get(2).get(0).equals(valor) ) ) {
				
				vitoria = valor + ": Venceu!";
				return true;
			}
				
		}
		
		
		//Ainda existe espaço vazio?
		for(ArrayList<String> linha  : espacos) {
			for (String s : linha) {
				if (s.equals(VAZIO) )
					return false;
			}
		}
		
		//Se não possui, e não há vencedor deu empate
		vitoria = "Deu Empate!";
		return true;
	}

	public ArrayList<ArrayList<String>> getEspacos() {
		return espacos;
	}

	public void setEspacos(ArrayList<ArrayList<String>> espacos) {
		this.espacos = espacos;
	}

	public String getVitoria() {
		return vitoria;
	}

	public void setVitoria(String vitoria) {
		this.vitoria = vitoria; 
	}

	public int getAtual() {
		return atual;
	}

	public void setAtual(int atual) {
		this.atual = atual;
	}

	public String getX() {
		return X;
	}

	public String getO() {
		return O;
	}

	public String getVAZIO() {
		return VAZIO;
	}

	public ArrayList<String> getPossiveis() {
		return possiveis;
	}
	
	
	
}
