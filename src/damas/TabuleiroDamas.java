package damas;

public class TabuleiroDamas {
	Peca[][] tab=new Peca[8][8];
	
	public TabuleiroDamas() {
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<8;j+=2) {
				if(i%2==1) {
					int[] vet1= {i,j};
					tab[i][j]=new PecaPreta(convertVet(vet1));
					tab[i][j+1]=null;
				}
				else {
					int[] vet1= {i,j+1};
					tab[i][j]=null;
					tab[i][j+1]=new PecaPreta(convertVet(vet1));
				}
			}
		}
		for(int i=5;i<8;i++) {
			for(int j=0;j<8;j+=2) {
				if(i%2==1) {
					int[] vet1= {i,j};
					tab[i][j]=new PecaBranca(convertVet(vet1));
					tab[i][j+1]=null;
				}
				else {
					int[] vet1= {i,j+1};
					tab[i][j]=null;
					tab[i][j+1]=new PecaBranca(convertVet(vet1));
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
		String pos=""+('a'+(char)vet[1])+((char)(7-vet[0])+'1');
		return pos;
	}
	public void mover(String origem,String destino) {
		int[] vetor=convertString(origem);
		if(tab[vetor[0]][vetor[1]]!=null)
			tab[vetor[0]][vetor[1]].mover(destino);
	}
	public void remover(String posicao) {
		int[] vetor=convertString(posicao);
		tab[vetor[0]][vetor[1]]=null;
	}
	public void colocar(String posicao,Peca objeto) {
		int[] pos=convertString(posicao);
		tab[pos[0]][pos[1]]=objeto;
	}
}
