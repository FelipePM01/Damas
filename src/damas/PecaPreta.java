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
		if(Math.abs(vetOrigem[0]-vetDestino[0])==Math.abs(vetOrigem[1]-vetDestino[1])&Math.abs(vetOrigem[0]-vetDestino[0])!=0&&tabuleiro.tab[vetDestino[0]][vetDestino[1]]==null&&tabuleiro.turno=="pretas") {
			String[] between=between(destino);
			if(between==null && vetOrigem[0]<vetDestino[0]) {
				Dama dama=new Dama(this);
				if(destino.charAt(1)=='1') {
					
					tabuleiro.colocar(destino,dama);
				}
				else tabuleiro.colocar(destino, this);
				tabuleiro.remover(position);
				if(destino.charAt(1)=='1') {
					dama.position=destino;
				}
				else this.position=destino;
				tabuleiro.atacante=null;
				tabuleiro.turno="brancas";
			}
			else {
				if(between.length==1) {
					Dama dama=new Dama(this);
					int[] posicao=tabuleiro.convertString(between[0]);
					Peca objeto=tabuleiro.tab[posicao[0]][posicao[1]];
					if(objeto!=null&&objeto.color=="branca") {
						tabuleiro.remover(between[0]);
						if(destino.charAt(1)=='1') {
							
							tabuleiro.colocar(destino,dama);
						}
						else tabuleiro.colocar(destino, this);
						tabuleiro.remover(position);
						if(destino.charAt(1)=='1') {
							dama.position=destino;
						}
						else this.position=destino;
						tabuleiro.atacante=this.position;
						this.podeCapturar();
					}
				}
			}
		}
		
	}
	void podeCapturar() {
		int[] vet=tabuleiro.convertString(position);
		if(vet[0]<6&&vet[1]<6&&tabuleiro.tab[vet[0]+1][vet[1]+1]!=null&&tabuleiro.tab[vet[0]+1][vet[1]+1].color!=this.color&&tabuleiro.tab[vet[0]+2][vet[1]+2]==null) {
			if(tabuleiro.atacante==null) tabuleiro.atacante="pretas";
		}
		else {
			if(vet[0]<6&&vet[1]>1&&tabuleiro.tab[vet[0]+1][vet[1]-1]!=null&&tabuleiro.tab[vet[0]+1][vet[1]-1].color!=this.color&&tabuleiro.tab[vet[0]+2][vet[1]-2]==null) {
				if(tabuleiro.atacante==null) tabuleiro.atacante="pretas";
			}
			else {
				if(vet[0]>1&&vet[1]>1&&tabuleiro.tab[vet[0]-1][vet[1]-1]!=null&&tabuleiro.tab[vet[0]-1][vet[1]-1].color!=this.color&&tabuleiro.tab[vet[0]-2][vet[1]-2]==null) {
					if(tabuleiro.atacante==null) tabuleiro.atacante="pretas";
				}
				else {
					if(vet[0]>1&&vet[1]<6&&tabuleiro.tab[vet[0]-1][vet[1]+1]!=null&&tabuleiro.tab[vet[0]-1][vet[1]+1].color!=this.color&&tabuleiro.tab[vet[0]-2][vet[1]+2]==null) {
						if(tabuleiro.atacante==null) tabuleiro.atacante="pretas";
					}
					else {
						if(tabuleiro.atacante==position) {
							tabuleiro.atacante=null;
							tabuleiro.turno="brancas";
						}
					}
				}
			}
		}
	}
}
