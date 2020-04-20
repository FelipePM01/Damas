package damas;

public class JogoDeDams {

	public static void main(String[] args) {
		TabuleiroDamas tabuleiro=new TabuleiroDamas();
		CSVReader csv=new CSVReader();
		csv.setDataSource("C:\\Users\\fpach\\Downloads\\comandos2.csv");
		String comandos[]=csv.requestCommands();
		
		System.out.println("Tabuleiro inicial:");
		tabuleiro.imprimir();
		
		for(int i=0;i<comandos.length;i++) {
			
			tabuleiro.mover(comandos[i].split(":")[0],comandos[i].split(":")[1]);
			System.out.println("Source: "+comandos[i].split(":")[0]);
			System.out.println("Target: "+comandos[i].split(":")[1]);
			tabuleiro.imprimir();
		}

	}

}
