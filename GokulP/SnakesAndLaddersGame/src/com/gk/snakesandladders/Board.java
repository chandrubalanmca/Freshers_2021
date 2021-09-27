package com.gk.snakesandladders;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Board{
	 Random rand=new Random();
	
	Map<Integer, Integer> snakesAndLaddersPosition=new HashMap<>();
	void snakesAndLaddersPosition(int ladderPercent,int snakePercent) {
		
        int ladderCount=0,snakeCount=0;
        while(true) {
            int random1=rand.nextInt(100);
            int random2=rand.nextInt(100);
            if(random1>random2 && random2<90 && random1>10 && random2>3 && snakeCount<snakePercent &&
                    !snakesAndLaddersPosition.containsKey(random1) && !snakesAndLaddersPosition.containsValue(random1) &&
                    !snakesAndLaddersPosition.containsKey(random2) && !snakesAndLaddersPosition.containsValue(random2)) {
                snakesAndLaddersPosition.put(random1, random2);
                snakeCount++;
            }
            else if(random1<random2 && random2 >10 && random1>5 && random1<90 && ladderCount<ladderPercent &&
                    !snakesAndLaddersPosition.containsKey(random1) && !snakesAndLaddersPosition.containsValue(random1) &&
                    !snakesAndLaddersPosition.containsKey(random2) && !snakesAndLaddersPosition.containsValue(random2)) {
                snakesAndLaddersPosition.put(random1, random2);
                ladderCount++;
               
            }
            if(ladderCount+snakeCount==ladderPercent+snakePercent) {
                break;
            }
        }
	
    }
	public void view() {
		int value=100,positionVal;
		boolean isEvenRow=true;
		for(int i=10;i>=1;i--) {
			isEvenRow=i%2==0;
			value=!isEvenRow?value-10:value;
			for(int j=1;j<=10;j++) {
				
			value=!isEvenRow?value+1:value;
			positionVal=snakesAndLaddersPosition.containsKey(value)?snakesAndLaddersPosition.get(value)-value:0;
			System.out.printf("%3d ",positionVal);
			value=!isEvenRow?value:value--;
			}
			System.out.println();
			value=!isEvenRow?value-10:value;
			
		}
			
		}
		}
	

