package LabirentOdev;

import java.util.Scanner;

public class Oyun {
	
	private Labirent labirent;
	
	
	public static final int YUKARI = 1;
	public static final int ASAGI = 2;
	public static final int SAGA = 3;
	public static final int SOLA = 4;
	public static final int HATALI = 0;

	
	private int skor;
	
	public Oyun(){
		labirent = null;
		skor = 0;
	}
	
	public Oyun(int[][] matris){
		skor = 0;
		yukle(matris);
	}
	
	public void yukle(int[][] matris){
		
		labirent = new Labirent(matris);	
	}
	
	public void baslat(){
		while(true){
			sahneyiYazdir();
			int yon = kullanicidanYonBilgisiAl();
			adamiHareketEttir(yon);
			if(bittiMi())
				break;
		}
		
	}
	
	private boolean bittiMi() {
		boolean oyunBitti = false;
		
		if(labirent.getAdamX() == labirent.getHedefX() && labirent.getAdamY() == labirent.getHedefY()){
                    if (labirent.oyundakiesya==labirent.toplananesya) {
                           System.out.println("Tebrikler! Çıkışı buldunuz");
			oyunBitti = true;
                    }
			
		}
		return oyunBitti;

	}

	private void adamiHareketEttir(int yon) {
		
		switch(yon){
			
			case YUKARI:
				if(labirent.adaminYeriniGuncelle(labirent.getAdamX(), labirent.getAdamY()-1,YUKARI))
					skor++;
				break;
				
			case SOLA:
				if(labirent.adaminYeriniGuncelle(labirent.getAdamX()-1, labirent.getAdamY(),SOLA))
					skor++;
				break;
	
			case ASAGI:
				if(labirent.adaminYeriniGuncelle(labirent.getAdamX(), labirent.getAdamY()+1,ASAGI))
					skor++;
				break;
			
			case SAGA:
				if(labirent.adaminYeriniGuncelle(labirent.getAdamX()+1, labirent.getAdamY(),SAGA))
					skor++;
				break;
		}
	}

	private int kullanicidanYonBilgisiAl() {
		
		Scanner consol = new Scanner(System.in);
		
		System.out.print("Yön Tuşları (w = yukarı, s = aşağı, a = sol, d = sağ), seçiniz: ");
		String secimStr = consol.next();
		
		char secim = secimStr.charAt(0);
		int yon = HATALI;
		
		switch(secim){
			case 'w':
			case 'W': 
				yon = YUKARI;
				break;
				
			case 'a':
			case 'A':
				yon = SOLA;
				break;
				
			case 's':
			case 'S':	
				yon = ASAGI;
				break;
				
			case 'd':
			case 'D':	
				yon = SAGA;
				break;
	
		}

		return yon;

	}

	public void sahneyiYazdir(){
		System.out.println("-------------------------\n");
		
		System.out.println(labirent);
		
		System.out.println("\n Toplam Adım: "+skor);
                  System.out.println("\n Toplam Eşya Sayısı: "+labirent.oyundakiesya);
                  System.out.println("\n Toplanan Eşya Sayısı: "+labirent.toplananesya);
		System.out.println("\n-------------------------\n");
		
	}
	
}
