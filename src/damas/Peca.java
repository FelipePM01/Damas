package damas;

public class Peca {
	String type;
	String position;
	TabuleiroDamas tabuleiro;
	protected String[] between(String destino) {
		String[] posicoes;
		int[] vetOrigem=tabuleiro.convertString(position);
		int[] vetDestino=tabuleiro.convertString(destino);
		if(Math.abs(vetOrigem[0]-vetDestino[0])==Math.abs(vetOrigem[1]-vetDestino[1]) && Math.abs(vetOrigem[0]-vetDestino[0])>1) {
			int a,b;
			posicoes=new String[Math.abs(vetOrigem[0]-vetDestino[0])-1];
			if(vetOrigem[0]<vetDestino[0]) a=1;
			else a=-1;
			if(vetOrigem[1]<vetDestino[1]) b=1;
			else b=-1;
			for(int i=1;i<Math.abs(vetOrigem[0]-vetDestino[0]);i++) {
				posicoes[i-1]=tabuleiro.convertVet({vetOrigem[0]+a*i,vetOrigem[1]+b*i});
			}
			return posicoes;
			
		}
		else {
			return null;
		}
	}
}
