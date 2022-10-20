package unidade4.controleremoto;

public class AppTv {
	
	public static void main(String[] args) {
		
		Tv001 tv001 = new Tv001(110, 21);
		TvSDX tvSDX = new TvSDX(110, 42);
		
		tv001.ligarOuDesligar();
		tvSDX.ligarOuDesligar();
		
		tv001.mudarDeCanal(3);
		
		tvSDX.aumentarVolume();
		tvSDX.aumentarVolume();
		tvSDX.aumentarVolume();
		tvSDX.aumentarVolume();
		tvSDX.aumentarVolume();
		
		tv001.ligarOuDesligar();
		
		if (tv001.isLigado()) {
			System.out.println("A tv1 está ligada");
			tv001.ligarOuDesligar();
		}
		if (tvSDX.isLigado()) {
			System.out.println("A tv22 está ligada");
			tvSDX.ligarOuDesligar();
		}
		
	}

}
