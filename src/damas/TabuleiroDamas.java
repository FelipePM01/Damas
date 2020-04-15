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
	private int[] convertString(String pos) {
		int a=(int)(pos.charAt(0)-'a');
		int b=7-(int)(pos.charAt(1)-'1');
		int[] vet= {a,b};
		return vet;
	}
	private String convertVet(int[] vet) {
		String pos=""+('a'+(char)vet[0])+((char)(7-vet[1])+'1');
		return pos;
	}
}
