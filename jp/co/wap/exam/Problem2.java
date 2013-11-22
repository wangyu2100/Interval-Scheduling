package jp.co.wap.exam;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

/**
 * Author: Tony Wang
 * Completion Date: 2013.11.20
 * Remarks:This problem was mainly solved by following the idea of dynamic programming in weighted interval scheduling and recursion as well
 */



public class Problem2 {
	


	public int getMaxWorkingTime(List<Interval> intervals) {
// TODO: Implement this method.

		//Intervals cannot be empty or null as requested in the task.
		if(intervals.isEmpty()||intervals == null)
			return 0;

		//sorting the intervals in the list by the ending time of each interval.
		Collections.sort(intervals, new Comparator<Interval>() { public int compare(Interval o1, Interval o2) {return o1.getEndMinuteUnit()-o2.getEndMinuteUnit();}});
		
		int intervalNumber       = intervals.size();
		int[] M                  = new int[intervalNumber];
		int[] firstCalculation   = new int[intervalNumber];
		
		
		for(int i = intervalNumber-1; i >= 0; i--)
		{
			Interval interval1=intervals.get(i);
			firstCalculation[i]=-1;
			M[i]=0;
			
			for (int j=i-1;j>=0;j--)
			{
				Interval interval2=intervals.get(j);
				if(interval1.getBeginMinuteUnit() >= interval2.getEndMinuteUnit())
				{
					firstCalculation[i] = j;  
					j = -1;
				}
			}
			
		}
		
		
		//define new class to store relevant data.
		class Opt
		{
			private List<Interval> i;
			private int[] M;
			private int[] index;
			
			public Opt(List<Interval> i,int[] M,int[] index)
			{
				this.i = i;
				this.M = M;
				this.index = index;
			}
			
			private int maxTime(int task)
			{
				if(task<0)
					return 0;
				if (M[task] != 0) 
				{
		            return M[task];
		        }
				
				//recursion
				M[task] = Math.max(i.get(task).getIntervalMinute() + maxTime(index[task]), maxTime(task-1));
				
				return M[task];
			}
		}
		
		Opt opt=new Opt(intervals,firstCalculation,M);
		int Max=opt.maxTime(intervalNumber-1);
		
		return Max;
	}
	

}
