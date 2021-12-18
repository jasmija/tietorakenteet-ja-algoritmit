package usingjcapi;

import java.util.Comparator;

public class TravellerNumberComparator implements Comparator<TrafficCard>{

	@Override
	public int compare(TrafficCard o1, TrafficCard o2) {
		TrafficCard card1 = (TrafficCard)o1;
		TrafficCard card2 = (TrafficCard)o2;
		if(card1.mTravellerNumber == card2.mTravellerNumber)
			return 0;
		else if(card1.mTravellerNumber > card2.mTravellerNumber)
			return 1;
		else
			return -1;
	}
}
