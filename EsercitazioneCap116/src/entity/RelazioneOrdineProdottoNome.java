package entity;

import java.util.Comparator;

public class RelazioneOrdineProdottoNome implements Comparator<Prodotto>{

	@Override
	public int compare(Prodotto o1, Prodotto o2) {
		int result = o1.getCodiceProdotto()-o2.getCodiceProdotto();

		if (result==0)
			return result;

		result = o1.getNome().compareTo(o2.getNome());
		if (result!=0)
			return result;
		else
			return o1.getCodiceProdotto()-o2.getCodiceProdotto();

 	}

}
