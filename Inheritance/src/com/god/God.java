package com.god;

import com.live.Human;
import com.live.LivingThing;

public class God {

	public void manageLT(LivingThing LT){
		LT.eat();
		LT.sleep();
		if(LT instanceof Human) {
			Human human = new Human();
			human.study();
		}
		LT.work();
	}
}
