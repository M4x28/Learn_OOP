package entity;

import java.util.Comparator;

public class RelazioneOrdineProdottoPrezzoDec implements Comparator<Prodotto>{

	@Override
	public int compare(Prodotto o1, Prodotto o2) {

		int result = o1.getCodiceProdotto()-o2.getCodiceProdotto();

		if (result==0)
			return result;

		result = Double.compare(o2.calcolaCosto(), o1.calcolaCosto());
		if (result!=0)
			return result;
		else
			return o1.getCodiceProdotto()-o2.getCodiceProdotto();

	}

}
