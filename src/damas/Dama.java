package damas;

public class Dama extends Peca {
	Dama(Peca object){
		this.color=object.color;
		this.tabuleiro=object.tabuleiro;
		this.position=object.position;
	}
	public void mover(String destino) {
		int[] vetOrigem=tabuleiro.convertString(position);
		int[] vetDestino=tabuleiro.convertString(destino);
		if(Math.abs(vetOrigem[0]-vetDestino[0])==Math.abs(vetOrigem[1]-vetDestino[1])&Math.abs(vetOrigem[0]-vetDestino[0])!=0&&tabuleiro.tab[vetDestino[0]][vetDestino[1]]==null&&tabuleiro.turno==(this.color+"s")) {
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
						tamanho++;
					}
					else bloqueado=true;
				}
			
			}
			if(bloqueado==false) {
				if(tamanho==1&&(tabuleiro.atacante==(this.color+"s")||tabuleiro.atacante==this.position)) {
					tabuleiro.remover(eliminado[0]);
					tabuleiro.colocar(destino, this);
					tabuleiro.remover(position);
					this.position=destino;
					tabuleiro.atacante=position;
					podeCapturar();
				}
				
				else {
					if(tabuleiro.atacante==null) {
						tabuleiro.colocar(destino, this);
						tabuleiro.remover(position);
						this.position=destino;
						tabuleiro.atacante=null;
						if(this.color=="branca")tabuleiro.turno="pretas";
						else tabuleiro.turno="brancas";
					}
				}
				
			}
		}
		
	}
	void podeCapturar() {
		int[] vet=tabuleiro.convertString(position);
		int i=1,j=1;
		while(vet[0]+i<7&&vet[1]+j<7) {
			if(tabuleiro.tab[vet[0]+i][vet[1]+j]!=null) {
				if(tabuleiro.tab[vet[0]+i][vet[1]+j].color==this.color) {
					if(tabuleiro.atacante==position) {
						tabuleiro.atacante=null;
						if(this.color=="branca")tabuleiro.turno="pretas";
						else tabuleiro.turno="brancas";
					}
					break;
				}
				else {
					if(tabuleiro.tab[vet[0]+(i+1)][vet[1]+(j+1)]==null) {
						if(this.color=="branca") {
							if(tabuleiro.atacante==null)tabuleiro.atacante="brancas";
						}
						else {
							if(tabuleiro.atacante==null)tabuleiro.atacante="pretas";
						}
						return;
					}
					else break;
				}
			}
			i++;j++;
		}
		while(vet[0]-i>0&&vet[1]+j<7) {
			if(tabuleiro.tab[vet[0]-i][vet[1]+j]!=null) {
				if(tabuleiro.tab[vet[0]-i][vet[1]+j].color==this.color) {
					if(tabuleiro.atacante==position) {
						tabuleiro.atacante=null;
						if(this.color=="branca")tabuleiro.turno="pretas";
						else tabuleiro.turno="brancas";
					}
					break;
				}
				else {
					if(tabuleiro.tab[vet[0]-(i+1)][vet[1]+(j+1)]==null) {
						if(this.color=="branca") {
							if(tabuleiro.atacante==null)tabuleiro.atacante="brancas";
						}
						else {
							if(tabuleiro.atacante==null)tabuleiro.atacante="pretas";
						}
						return;
					}
					else break;
				}
			}
			i++;j++;
		}
		while(vet[0]+i<7&&vet[1]-j>0) {
			if(tabuleiro.tab[vet[0]+i][vet[1]-j]!=null) {
				if(tabuleiro.tab[vet[0]+i][vet[1]-j].color==this.color) {
					if(tabuleiro.atacante==position) {
						tabuleiro.atacante=null;
						if(this.color=="branca")tabuleiro.turno="pretas";
						else tabuleiro.turno="brancas";
					}
					break;
				}
				else {
					if(tabuleiro.tab[vet[0]+(i+1)][vet[1]-(j+1)]==null) {
						if(this.color=="branca") {
							if(tabuleiro.atacante==null)tabuleiro.atacante="brancas";
						}
						else {
							if(tabuleiro.atacante==null)tabuleiro.atacante="pretas";
						}
						return;
					}
					else break;
				}
			}
			i++;j++;
		}
		while(vet[0]-i>0&&vet[1]-j>0) {
			if(tabuleiro.tab[vet[0]-i][vet[1]-j]!=null) {
				if(tabuleiro.tab[vet[0]-i][vet[1]-j].color==this.color) {
					if(tabuleiro.atacante==position) {
						tabuleiro.atacante=null;
						if(this.color=="branca")tabuleiro.turno="pretas";
						else tabuleiro.turno="brancas";
					}
					break;
				}
				else {
					if(tabuleiro.tab[vet[0]-(i+1)][vet[1]-(j+1)]==null) {
						if(this.color=="branca") {
							if(tabuleiro.atacante==null)tabuleiro.atacante="brancas";
						}
						else {
							if(tabuleiro.atacante==null)tabuleiro.atacante="pretas";
						}
						return;
					}
					else break;
				}
			}
			i++;j++;
		}
		if(tabuleiro.atacante==position) {
			tabuleiro.atacante=null;
			if(this.color=="branca")tabuleiro.turno="pretas";
			else tabuleiro.turno="brancas";
			
		}
		
		
	}
}
