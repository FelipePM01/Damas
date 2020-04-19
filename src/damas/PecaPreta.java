package damas;

public class PecaPreta extends Peca{
	PecaPreta(String pos,TabuleiroDamas tabuleiro){
		color="preta";
		position=pos;
		
		this.tabuleiro=tabuleiro;
	}
	public void mover(String destino) {
		int[] vetOrigem=tabuleiro.convertString(position);
		int[] vetDestino=tabuleiro.convertString(destino);
		if(Math.abs(vetOrigem[0]-vetDestino[0])==Math.abs(vetOrigem[1]-vetDestino[1])&Math.abs(vetOrigem[0]-vetDestino[0])!=0&&tabuleiro.tab[vetDestino[0]][vetDestino[1]]==null) {
			String[] between=between(destino);
			if(between==null && vetOrigem[0]<vetDestino[0]) {
				tabuleiro.colocar(destino, this);
				tabuleiro.remover(position);
				position=destino;
			}
			else {
				if(between.length==1) {
					Dama dama=new Dama(this);
					int[] posicao=tabuleiro.convertString(between[0]);
					Peca objeto=tabuleiro.tab[posicao[0]][posicao[1]];
					if(objeto.color=="branca") {
						tabuleiro.remover(between[0]);
						if(between[0].charAt(1)=='1') {
							
							tabuleiro.colocar(destino,dama);
						}
						else tabuleiro.colocar(destino, this);
						tabuleiro.remover(position);
						if(between[0].charAt(1)=='1') {
							dama.position=destino;
						}
						else position=destino;
					}
				}
			}
		}
		
	}
}
