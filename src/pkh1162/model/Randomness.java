package pkh1162.model;
import java.util.Random;

/*
 * This class will deal with all the probabilities and randomness which the settlers will face. At the moment it
 * deals with doling out damage to settlers taken at locations. It does this by taking in a Settler's experience 
 * and calculating how much damage they should receive. Each level of experience has different damage probabilities,
 * these probabilities are determined by the RunnerType enum class, where the damage ranges each experience class takes
 * is given in the constructor brackets.
*/

public class Randomness {
	
	private Random r;
//	private Classification runnerType;
	
	public Randomness(){
		this.r = new Random();
	}

	
	
	public int locationDamage(Classification runner){
		int probability = r.nextInt(10);			//Initialises starting probability 0-9; lets me choose how often
													//each damage range will occur.
		
		/*
		 * Formula below is simply genRandomNum between (HighNum - LowNum) + LowNum;
		 * the HighNum and LowNum are dependent upon the experience level, defined in
		 * RunnerType.
		 */
		
		if (probability <1){					    //random number is 0: Low chance condition (10%)
			int result = r.nextInt(runner.getA2()-runner.getA1()) + runner.getA1();		
			return result;
		}
		else if (probability < 4){					//random number is [1,2,3]: Medium chance condition (30%)
			int result = r.nextInt(runner.getB2()-runner.getB1()) + runner.getB1();		
			return result;
		}
		else {										//random number is [4,5,6,7,8,9]: High chance condition (60%)
			int result = r.nextInt(runner.getC2()-runner.getC1()) + runner.getC1();	
			return result;
		}
	}
		
	}


