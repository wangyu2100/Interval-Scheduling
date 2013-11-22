package jp.co.wap.exam;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

/**
 * Author: Tony Wang
 * Completion Date: 2013.11.20
 * Remarks:This problem was solved by establishing a scoring system. 
 * Use a imaginary line scanning though the whole interval areas. 
 * Whenever the line enters, it earns one mark, whenever it leaves, one mark will be deducted. 
 * The highest score it gets can be treated as the moment when it scans through most of the overlapped areas.
 * 
 * The program has been tested using the given example test code, the results fit the expectation.
 */



public class Problem1 {
	
	public int getMaxIntervalOverlapCount(List<Interval> intervals) {
// TODO: Implement this method.
		
		//return 0 is interval list being null or empty.
		if(intervals.isEmpty()|| intervals == null)
			return 0;
		
		
		
		//declare two ArrayLists to store interval data; one for begin times, one for end times.
		ArrayList<Integer> arrayListBegin = new ArrayList<Integer>();
		ArrayList<Integer> arrayListEnd   = new ArrayList<Integer>();
		
		int intervalNumber = intervals.size();
		int maxNumber      = 0;
		int startingPoint  = 0;
		int endingPoint    = 0;
		int temp           = 0;
		
		
		for(int i=0;i<intervalNumber;i++)
			
		{
			arrayListBegin.add(intervals.get(i).getBeginMinuteUnit());
			arrayListEnd.add(intervals.get(i).getEndMinuteUnit());
		}
		
		//Sort the data in ascending order.
		Collections.sort(arrayListBegin);
		Collections.sort(arrayListEnd);
		
		
		for(int i=0;i<intervalNumber;i++)
		{
			intervals.get(i).getIntervalMinute();	
		}
		
		
		startingPoint = arrayListBegin.get(0);
		endingPoint   = arrayListEnd.get(intervalNumber-1);
		
	
		for(int j = startingPoint; j <endingPoint+1 ; j++)
		{
			
			for(int k = 0 ; k < intervalNumber ; k++)
			{
				
				//whenever pass a beginning of an interval, earns one mark.
				if(j == arrayListBegin.get(k))
				{
					temp++;
				}
				
				if(maxNumber<temp)
					maxNumber = temp;//use this mechanism to record the maximuam number ever appeared.
			}
		
			for(int l = 0 ; l < intervalNumber ; l++)
			{	
				//deduce one mark whenever leaves an interval.
				if(j == arrayListEnd.get(l))
				{
					temp--;
				}
				
			}
			
		}
		return maxNumber;//the final result (the maximum number ever occurred).
		

	}
	
	
}


