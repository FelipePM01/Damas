package damas;

public class TabuleiroDamas {
	Peca[][] tab=new Peca[8][8];
	String turno="brancas";
	String atacante=null;
	public TabuleiroDamas() {
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<8;j+=2) {
				if(i%2==1) {
					int[] vet1= {i,j};
					tab[i][j]=new PecaPreta(convertVet(vet1),this);
					tab[i][j+1]=null;
				}
				else {
					int[] vet1= {i,j+1};
					tab[i][j]=null;
					tab[i][j+1]=new PecaPreta(convertVet(vet1),this);
				}
			}
		}
		for(int i=5;i<8;i++) {
			for(int j=0;j<8;j+=2) {
				if(i%2==1) {
					int[] vet1= {i,j};
					tab[i][j]=new PecaBranca(convertVet(vet1),this);
					tab[i][j+1]=null;
				}
				else {
					int[] vet1= {i,j+1};
					tab[i][j]=null;
					tab[i][j+1]=new PecaBranca(convertVet(vet1),this);
				}
			}
		}
		
	}
	int[] convertString(String pos) {
		int a=7-(int)(pos.charAt(1)-'1');
		int b=(int)(pos.charAt(0)-'a');
		int[] vet= {a,b};
		return vet;
	}
	String convertVet(int[] vet) {
		String pos=""+((char)('a'+vet[1]))+((char)((7-vet[0])+'1'));
		return pos;
	}
	public void mover(String origem,String destino) {
		int[] vetor=convertString(origem);
		if(tab[vetor[0]][vetor[1]]!=null) {
			if(turno=="brancas") {
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						if(tab[i][j]!=null&&tab[i][j].color=="branca") tab[i][j].podeCapturar();
					}
				}
			}
			else {
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						if(tab[i][j]!=null&&tab[i][j].color=="preta") tab[i][j].podeCapturar();
					}
				}
			}
			tab[vetor[0]][vetor[1]].mover(destino);
		}
	}
	public void remover(String posicao) {
		int[] vetor=convertString(posicao);
		tab[vetor[0]][vetor[1]]=null;
	}
	public void colocar(String posicao,Peca objeto) {
		int[] pos=convertString(posicao);
		tab[pos[0]][pos[1]]=objeto;
	}
	void imprimir() {
		for(int i=0;i<8;i++) {
			System.out.print((8-i)+" ");
			for(int j=0;j<8;j++) {
				
				if(tab[i][j]==null) {
					System.out.print("- ");
				}
				else {
					if(tab[i][j].ehDama==false) {
						if(tab[i][j].color=="preta") System.out.print("P ");
						else System.out.print("B ");
					}
					else {
						if(tab[i][j].color=="preta") System.out.print("Q ");
						else System.out.print("C ");
					}
				}
					
				
			}
			System.out.println("");
		}
		System.out.println("  a b c d e f g");
	}
}
