import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
* Description
*
* Luka is driving his truck along a long straight road with many traffic lights. For each traffic light he knows how long the red and green lights will be on (the cycle repeating endlessly).
*
* When Luka starts his journey, all traffic lights are red and just started their cycle. Luka moves one distance unit per second. When a traffic light is red, he stops and waits until it turns green.
*
* Write a program that determines how much time Luka needs to reach the end of the road. The start of the road is at distance zero, the end at distance L.
* Input specification
*
* The first line contains two integers N and L (1 <= N <= 100, 1 <= L <= 1000), the number of traffic lights on the road and the length of the road. Each of the next N lines contains three integers D, R and G, describing one traffic light (1 <= D < L, 1 <= R <= 100, 1 <= G <= 100). D is the distance of the traffic light from the start of the road. R and G denote how long the red and green lights are on, respectively. The traffic lights will be ordered in increasing order of D. No two traffic lights will share the same position.
* Output specification
*
* Output the time (in seconds) Luka needs to reach the end of the road.
* Sample input
*
* 4 30
* 7 13 5
* 14 4 4
* 15 3 10
* 25 1 1
* Sample output
*
* 36
*
* Problem number: 2311
*
* @author Guido J. Celada (celadaguido@gmail.com)
**/
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception{
		int lenghtRoad;
		int[][] trafficLight;
		int trafficLightsTotal;
		String readed;
		String[] readedArray;
		//Set up variables
		readed = in.readLine();
		readedArray = readed.split(" "); 
		trafficLightsTotal = Integer.parseInt(readedArray[0]);
		lenghtRoad = Integer.parseInt(readedArray[1]);
		trafficLight = new int[trafficLightsTotal+1][3]; //matrix of trafficLights, each having 0->Distance, 1->Red light duration, 2->Green light duration
		
		trafficLight[0][0] = 0;
				
		for (int i = 1; i <= trafficLightsTotal; i++){
			//Set up variables
			readed = in.readLine();
			readedArray = readed.split(" "); 
			trafficLight[i][0] = Integer.parseInt(readedArray[0]); //Distance
			trafficLight[i][1] = Integer.parseInt(readedArray[1]); //Red
			trafficLight[i][2] = Integer.parseInt(readedArray[2]); //Green			
		}
		
		
		int totalTime = 0;
		int waitTime = 0;
		
		for (int i = 1; i < trafficLight.length; i++){
			totalTime += (trafficLight[i][0] - trafficLight[i-1][0]);
			waitTime = totalTime%(trafficLight[i][1]+trafficLight[i][2]);
			if (waitTime < trafficLight[i][1]){
				waitTime = trafficLight[i][1] - waitTime;
				totalTime += waitTime;
			}
		}
		if (lenghtRoad > trafficLight[trafficLight.length-1][0])
			totalTime += lenghtRoad - trafficLight[trafficLight.length-1][0];	
		System.out.println(totalTime);
	}
}
