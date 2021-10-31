/*Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100 */

/*The basic idea is for each temperature value in the passed array T, scan backward starting from the day before that temperature, day-1, until finding a temperature that is the same value or higher. For each day while scanning backward, fill in the array to be returned, result, with the number of days until this warmer temperature. Process the array T from the last day (day =T.length-1) to the first day (day=0). The values written into result are 1...n scanning backward from a temperature until a same or higher temperature is found. The value in result for the first day (day-1) before a temperature is 1, the second day before the temperature is 2, then 3, etc. After entering some values in result, a temperature from an earlier day may overwrite those values because that earlier day may be a sooner warmer day.

The above algorithm is illustrated in the graphic below. The blue bars are temperatures for each day, with the height of the blue bars being the value of the temperature, so warmer bars are higher and cooler bars are shorter. The orange arrows are the number of days to scan backward from a temperature, writing the numeric values above the orange arrows, into the correnponding index in result. */




class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int day = T.length - 1; day >= 0; day--)
            for (int i = day - 1; i >= 0 && T[i] < T[day]; i--)  
                result[i] = day - i;
        return result;
    }
}
