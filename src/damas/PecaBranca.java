package damas;

public class PecaBranca extends Peca {
	PecaBranca(String pos,TabuleiroDamas tabuleiro){
		color="branca";
		position=pos;
		
		this.tabuleiro=tabuleiro;
	}
	public void mover(String destino) {
		int[] vetOrigem=tabuleiro.convertString(position);
		int[] vetDestino=tabuleiro.convertString(destino);
		if(Math.abs(vetOrigem[0]-vetDestino[0])==Math.abs(vetOrigem[1]-vetDestino[1])&&Math.abs(vetOrigem[0]-vetDestino[0])!=0&&tabuleiro.tab[vetDestino[0]][vetDestino[1]]==null) {
			String[] between=between(destino);
			if(between==null && vetOrigem[0]>vetDestino[0]) {
				tabuleiro.colocar(destino, this);
				tabuleiro.remover(position);
				position=destino;
			}
			else {
				if(between!=null&&between.length==1) {
					Dama dama=new Dama(this);
					int[] posi=new int[1];
					String str=between[0];
					posi=tabuleiro.convertString(str);
					Peca objeto=tabuleiro.tab[posi[0]][posi[1]];
					if(objeto!=null&&objeto.color=="preta") {
						tabuleiro.remover(between[0]);
						if(destino.charAt(1)=='8') {
						
							tabuleiro.colocar(destino,dama);
						}
						else tabuleiro.colocar(destino, this);
						tabuleiro.remover(position);
						if(destino.charAt(1)=='8') {
							dama.position=destino;
						}
						else position=destino;
						
					}
				}
			}
		}
		
	}
}
