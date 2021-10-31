/*You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters.

 

Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
Example 2:

Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.
Example 3:

Input: properties = [[1,5],[10,4],[4,3]]
Output: 1
Explanation: The third character is weak because the second character has a strictly greater attack and defense.
 

Constraints:

2 <= properties.length <= 105
properties[i].length == 2
1 <= attacki, defensei <= 105 */

/*It is a 2-demision problem
We can regard the players as points in 2-demision coordinate axis
As we put all of the points on the graph, it will form a curve like this: (wek points are inside of the area made by the curve and x/y axis)
image
So we can describe this curve as an int[] maxH, the index stands for x value and y stands for maxH.
To form maxH, firstly we traverse all the points and makes finds out the max height of points with the same x value. Then we traverse the maxH from 100001 to zero, which guarantees every points with index i has the max height among i to 100001

Then we make our greedy approach: if the point[y] is less than maxH(point[x]+1), it's weak. */

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int[] maxH = new int[100002];
        int count = 0;
        for(int[] point:properties){
            maxH[point[0]] = Math.max(point[1],maxH[point[0]]);
        }
        for(int i=100000;i>=0;i--){
            maxH[i] = Math.max(maxH[i+1],maxH[i]);
        }
        
        for(int[] point:properties){
            if(point[1]<maxH[point[0]+1])
                count++;
        }
        return count;
    }
}
