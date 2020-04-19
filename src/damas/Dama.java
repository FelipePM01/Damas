package damas;

public class Dama extends Peca {
	Dama(Peca object){
		object.color=this.color;
		object.position=this.position;
		object.tabuleiro=this.tabuleiro;
		
	}
	public void mover(String destino) {
		int[] vetOrigem=tabuleiro.convertString(position);
		int[] vetDestino=tabuleiro.convertString(destino);
		if(Math.abs(vetOrigem[0]-vetDestino[0])==Math.abs(vetOrigem[1]-vetDestino[1])&Math.abs(vetOrigem[0]-vetDestino[0])!=0&&tabuleiro.tab[vetDestino[0]][vetDestino[1]]==null) {
			String[] between=between(destino);
			boolean bloqueado=false;
			String[] eliminado= {""};
			int tamanho=0;
			for(int i=0;i<between.length;i++) {
				int[] posicao=tabuleiro.convertString(between[i]);
				Peca objeto=tabuleiro.tab[posicao[0]][posicao[1]];
				if(objeto!=null) {
					if(objeto.color!=this.color&& tamanho==0) {
						eliminado[tamanho]=objeto.position;
					}
					else bloqueado=true;
				}
			
			}
			if(bloqueado==false) {
				if(tamanho==1)tabuleiro.remover(eliminado[0]);
				tabuleiro.colocar(destino, this);
				tabuleiro.remover(position);
				this.position=destino;
			}
		}
		
	}
}
