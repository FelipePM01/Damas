package damas;

public class PecaBranca extends Peca {
	PecaBranca(String pos){
		color="branca";
		position=pos;
	}
	public void mover(String destino) {
		int[] vetOrigem=tabuleiro.convertString(position);
		int[] vetDestino=tabuleiro.convertString(destino);
		if(Math.abs(vetOrigem[0]-vetDestino[0])==Math.abs(vetOrigem[1]-vetDestino[1])&Math.abs(vetOrigem[0]-vetDestino[0])!=0&&tabuleiro.tab[vetDestino[0]][vetDestino[1]]==null) {
			String[] between=between(destino);
			if(between==null && vetOrigem[0]>vetDestino[0]) {
				tabuleiro.colocar(destino, this);
				tabuleiro.remover(position);
				position=destino;
			}
			else {
				if(between.length==1) {
					int[] posicao=tabuleiro.convertString(between[0]);
					Peca objeto=tabuleiro.tab[posicao[0]][posicao[1]];
					if(objeto.color=="preta") {
						tabuleiro.remover(between[0]);
						tabuleiro.colocar(destino, this);
						tabuleiro.remover(position);
						position=destino;
					}
				}
			}
		}
		
	}
}
