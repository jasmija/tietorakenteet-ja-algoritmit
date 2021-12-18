
package usingjcapi;

import java.util.*;

/**
 *
 * @author kamaj
 */
public class TrafficCard implements Comparable<TrafficCard> {
	int mTravellerNumber;
	String mOwnerName;
	float mBalance;

	public TrafficCard(int tNumber, String oName, float balance) {
		mTravellerNumber = tNumber;
		mOwnerName = oName;
		mBalance = balance;
	}

	@Override
	public String toString() {
		return "owner: " + mOwnerName + " number: " + mTravellerNumber + " balance: " + mBalance;
	}

	@Override
	public int compareTo(TrafficCard o) {
		TrafficCard card = (TrafficCard) o;
		if (mBalance == card.mBalance)
			return 0;
		else if (mBalance > card.mBalance)
			return 1;
		else
			return -1;
	}
	
	public Integer getTravellernumber() {
		return (Integer) mTravellerNumber;
	}

}
