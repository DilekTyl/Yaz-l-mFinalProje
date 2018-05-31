package com.spring;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTServisiOgrenci {

	private List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();

	public RESTServisiOgrenci() {
		
	}
	public RESTServisiOgrenci(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}
	class Ogrenci {
		int ogrenciNo;
		String ad, soyad;
		public int getogrencNo() {return ogrenciNo;}
		public String getAd() { return ad;}
		public String getSoyad() { return soyad;}
	}
	/** http://localhost:8080/ogrenci/listele */
	@RequestMapping("/ogrenci/listele")
	public List<Ogrenci> ogrenciListele() {
		return ogrenciler;
	}
	/** http://localhost:8080/ogrenci/olustur?ad=Mehmet&soyad=Kara4  */
	@RequestMapping(value="/ogrenci/olustur",method = RequestMethod.GET)
	public synchronized Ogrenci ogrenciOlustur(int ogrenciNo, String ad, String soyad) {
		return ogrenciEkle(ogrenciler, ogrenciNo, ad, soyad);
	}
	/** http://localhost:8080//ogrenci/olustur/post */
	@RequestMapping(
			value="/ogrenci/olustur/post", // hangi uri'den cevap verecegi
			method = RequestMethod.POST // sadece post istegi
	)
	public synchronized Ogrenci ogrenciOlusturPost(int ogrenciNo,String ad, String soyad) {
		return ogrenciEkle(ogrenciler,ogrenciNo, ad, soyad);
	}
	protected Ogrenci ogrenciEkle(List<Ogrenci> liste, int ogrenciNo,String ad, String soyad) {
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.ogrenciNo=ogrenciNo;
		ogrenci.ad=ad;
		ogrenci.soyad=soyad;
		liste.add(ogrenci);
		return ogrenci;
	}
	 public Ogrenci getOgrenci(int ogrenciNo) {
	        List<Ogrenci> ogrenciHashMap = null;
			@SuppressWarnings("null")
			Ogrenci ogrenci = ogrenciHashMap.get(ogrenciNo);
	        return ogrenci;
	    }
	 @SuppressWarnings("null")
	public void silOgrenci(int ogrenciNo) {
		 List<Ogrenci> ogrenciHashMap = null;
	     ogrenciHashMap.remove(ogrenciNo);
	    }
}




