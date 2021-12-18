package usingjcapi;

import java.util.Comparator;

public class BalanceComparator implements Comparator<TrafficCard>{

	@Override
	public int compare(TrafficCard o1, TrafficCard o2) {
		TrafficCard card1 = (TrafficCard)o1;
		TrafficCard card2 = (TrafficCard)o2;
		if(card1.mBalance == card2.mBalance)
			return 0;
		else if(card1.mBalance > card2.mBalance)
			return 1;
		else
			return -1;
	}
}
