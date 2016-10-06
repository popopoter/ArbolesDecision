package ArbolesDecision.dataRecording;

import ArbolesDecision.arbolDecision.discreteDistance;
import ArbolesDecision.pacman.game.Constants.GHOST;
import ArbolesDecision.pacman.game.Constants.MOVE;
import ArbolesDecision.pacman.game.Game;
import ArbolesDecision.strategy.Strategy;


public class DataTuple {

	public enum DiscreteTag {
		VERY_LOW, LOW, MEDIUM, HIGH, VERY_HIGH, NONE;

		public static DiscreteTag DiscretizeDouble(double aux) {
			if (aux < 0.1)
				return DiscreteTag.VERY_LOW;
			else if (aux <= 0.3)
				return DiscreteTag.LOW;
			else if (aux <= 0.5)
				return DiscreteTag.MEDIUM;
			else if (aux <= 0.7)
				return DiscreteTag.HIGH;
			else
				return DiscreteTag.VERY_HIGH;
		}
	}

	//public MOVE DirectionChosen;
	public Strategy strategy;
	public int closestNonEdibleGhost;
	public discreteDistance closestGhost;
	
	// General game state this - not normalized!
	/*public int mazeIndex;
	private boolean isBlinkyEdible = false;
	private boolean isInkyEdible = false;
	private boolean isPinkyEdible = false;
	private boolean isSueEdible = false;
	
	private int blinkyDist = -1;
	private int inkyDist = -1;
	private int pinkyDist = -1;
	private int sueDist = -1;
	public int numOfPillsLeft;
	public int currentLevel;
	public int pacmanPosition;
	public int pacmanLivesLeft;
	public int currentScore;
	public int totalGameTime;
	public int currentLevelTime;
	public int numOfPowerPillsLeft;
	// Ghost this, dir, dist, edible - BLINKY, INKY, PINKY, SUE

	public MOVE blinkyDir;
	public MOVE inkyDir;
	public MOVE pinkyDir;
	public MOVE sueDir;
	// Util data - useful for normalization
	public int numberOfNodesInLevel;
	public int numberOfTotalPillsInLevel;
	public int numberOfTotalPowerPillsInLevel;
	private int maximumDistance = 150;
	 */

	public DataTuple(Game game, MOVE move) {
		//if (move == MOVE.NEUTRAL) {
			//move = game.getPacmanLastMoveMade();
		//}

		this.strategy = game.strategy;
		
		int blinkyDistance = 1000;
		int inkyDistance = 1000;
		int pinkyDistance = 1000;
		int sueDistance = 1000;
		
		if(game.getGhostLairTime(GHOST.BLINKY)==0 && !game.isGhostEdible(GHOST.BLINKY)){
			blinkyDistance = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.BLINKY));
			
		}

		if(game.getGhostLairTime(GHOST.INKY)==0 && !game.isGhostEdible(GHOST.INKY)){
			inkyDistance = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.INKY));
			
		}

		if(game.getGhostLairTime(GHOST.PINKY)==0 && !game.isGhostEdible(GHOST.PINKY)){
			pinkyDistance = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.PINKY));
			
		}

		if(game.getGhostLairTime(GHOST.SUE)==0 && !game.isGhostEdible(GHOST.SUE)){
			sueDistance = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.SUE));
			
		}
		closestNonEdibleGhost = blinkyDistance;
		if(inkyDistance< closestNonEdibleGhost)
			closestNonEdibleGhost = inkyDistance;
		if(pinkyDistance < closestNonEdibleGhost)
			closestNonEdibleGhost = pinkyDistance;
		if(sueDistance < closestNonEdibleGhost)
			closestNonEdibleGhost = sueDistance;
		
		closestGhost = discreteDistance.discretizeInt(closestNonEdibleGhost);
		
		/*if (game.getGhostLairTime(GHOST.BLINKY) == 0) {
			this.isBlinkyEdible = game.isGhostEdible(GHOST.BLINKY);
			this.blinkyDist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.BLINKY));
		}
		
		if (game.getGhostLairTime(GHOST.INKY) == 0) {
			this.isInkyEdible = game.isGhostEdible(GHOST.INKY);
			this.inkyDist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.INKY));
		}
		
		if (game.getGhostLairTime(GHOST.PINKY) == 0) {
			this.isPinkyEdible = game.isGhostEdible(GHOST.PINKY);
			this.pinkyDist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.PINKY));
		}
		
		if (game.getGhostLairTime(GHOST.SUE) == 0) {
			this.isSueEdible = game.isGhostEdible(GHOST.SUE);
			this.sueDist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.SUE));
		}
		/*this.DirectionChosen = move;
		this.mazeIndex = game.getMazeIndex();
		this.currentLevel = game.getCurrentLevel();
		this.numOfPillsLeft = game.getNumberOfActivePills();
		this.pacmanPosition = game.getPacmanCurrentNodeIndex();
		this.pacmanLivesLeft = game.getPacmanNumberOfLivesRemaining();
		this.currentScore = game.getScore();
		this.totalGameTime = game.getTotalTime();
		this.currentLevelTime = game.getCurrentLevelTime();
		this.numOfPowerPillsLeft = game.getNumberOfActivePowerPills();

		this.blinkyDir = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.BLINKY), DM.PATH);
		this.inkyDir = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.INKY), DM.PATH);
		this.pinkyDir = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.PINKY), DM.PATH);
		this.sueDir = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.SUE), DM.PATH);

		this.numberOfNodesInLevel = game.getNumberOfNodes();
		this.numberOfTotalPillsInLevel = game.getNumberOfPills();
		this.numberOfTotalPowerPillsInLevel = game.getNumberOfPowerPills();
		 */
	}

	public DataTuple(String data) {
		String[] dataSplit = data.split(";");
		
		this.strategy = Strategy.valueOf(dataSplit[0]);
		this.closestGhost = discreteDistance.valueOf(dataSplit[1]);
				/*
		this.isBlinkyEdible = Boolean.parseBoolean(dataSplit[1]);
		this.isInkyEdible = Boolean.parseBoolean(dataSplit[2]);
		this.isPinkyEdible = Boolean.parseBoolean(dataSplit[3]);
		this.isSueEdible = Boolean.parseBoolean(dataSplit[4]);
		this.DirectionChosen = MOVE.valueOf(dataSplit[0]);
		 * this.mazeIndex = Integer.parseInt(dataSplit[1]);

		//this.numOfPillsLeft = Integer.parseInt(dataSplit[1]);
		this.currentLevel = Integer.parseInt(dataSplit[2]);
		this.pacmanPosition = Integer.parseInt(dataSplit[3]);
		this.pacmanLivesLeft = Integer.parseInt(dataSplit[4]);
		this.currentScore = Integer.parseInt(dataSplit[5]);
		this.totalGameTime = Integer.parseInt(dataSplit[6]);
		this.currentLevelTime = Integer.parseInt(dataSplit[7]);
		this.numOfPillsLeft = Integer.parseInt(dataSplit[8]);
		this.numOfPowerPillsLeft = Integer.parseInt(dataSplit[9]);
		this.blinkyDist = Integer.parseInt(dataSplit[0]);
		this.inkyDist = Integer.parseInt(dataSplit[1]);
		this.pinkyDist = Integer.parseInt(dataSplit[2]);
		this.sueDist = Integer.parseInt(dataSplit[3]);
		
		 this.blinkyDir = MOVE.valueOf(dataSplit[18]);
		this.inkyDir = MOVE.valueOf(dataSplit[19]);
		this.pinkyDir = MOVE.valueOf(dataSplit[20]);
		this.sueDir = MOVE.valueOf(dataSplit[21]);
		this.numberOfNodesInLevel = Integer.parseInt(dataSplit[22]);
		this.numberOfTotalPillsInLevel = Integer.parseInt(dataSplit[23]);
		this.numberOfTotalPowerPillsInLevel = Integer.parseInt(dataSplit[24]);  
		*/
	}

	public String getSaveString() {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(this.strategy + ";");
		stringbuilder.append(this.closestGhost+";");
		
		/*
		stringbuilder.append(this.isBlinkyEdible + ";");
		stringbuilder.append(this.isInkyEdible + ";");
		stringbuilder.append(this.isPinkyEdible + ";");
		stringbuilder.append(this.isSueEdible + ";");
		stringbuilder.append(this.blinkyDist + ";");
		stringbuilder.append(this.inkyDist + ";");
		stringbuilder.append(this.pinkyDist + ";");
		stringbuilder.append(this.sueDist + ";");
		//stringbuilder.append(this.DirectionChosen + ";");
		stringbuilder.append(this.numOfPillsLeft + ";");
		/*
		stringbuilder.append(this.pacmanPosition + ";");
		stringbuilder.append(this.pacmanLivesLeft + ";");
		stringbuilder.append(this.currentLevelTime + ";");
		stringbuilder.append(this.numOfPowerPillsLeft + ";");
		 */
		/*
		stringbuilder.append(this.blinkyDir + ";");
		stringbuilder.append(this.inkyDir + ";");
		stringbuilder.append(this.pinkyDir + ";");
		stringbuilder.append(this.sueDir + ";");
		stringbuilder.append(this.numberOfNodesInLevel + ";");
		stringbuilder.append(this.numberOfTotalPillsInLevel + ";");
		stringbuilder.append(this.numberOfTotalPowerPillsInLevel + ";");
*/
		return stringbuilder.toString();
	}

	/**
	 * Used to normalize distances. Done via min-max normalization. Supposes
	 * that minimum possible distance is 0. Supposes that the maximum possible
	 * distance is 150.
	 * 
	 * @param dist
	 *            Distance to be normalized
	 * @return Normalized distance
	 */
	/*public double normalizeDistance(int dist) {
		return ((dist - 0) / (double) (this.maximumDistance - 0)) * (1 - 0) + 0;
	}

	public DiscreteTag discretizeDistance(int dist) {
		if (dist == -1)
			return DiscreteTag.NONE;
		double aux = this.normalizeDistance(dist);
		return DiscreteTag.DiscretizeDouble(aux);
	}

	public double normalizeLevel(int level) {
		return ((level - 0) / (double) (Constants.NUM_MAZES - 0)) * (1 - 0) + 0;
	}

	public double normalizePosition(int position) {
		return ((position - 0) / (double) (this.numberOfNodesInLevel - 0)) * (1 - 0) + 0;
	}

	public DiscreteTag discretizePosition(int pos) {
		double aux = this.normalizePosition(pos);
		return DiscreteTag.DiscretizeDouble(aux);
	}

	public double normalizeBoolean(boolean bool) {
		if (bool) {
			return 1.0;
		} else {
			return 0.0;
		}
	}

	public double normalizeNumberOfPills(int numOfPills) {
		return ((numOfPills - 0) / (double) (this.numberOfTotalPillsInLevel - 0)) * (1 - 0) + 0;
	}

	public DiscreteTag discretizeNumberOfPills(int numOfPills) {
		double aux = this.normalizeNumberOfPills(numOfPills);
		return DiscreteTag.DiscretizeDouble(aux);
	}

	public double normalizeNumberOfPowerPills(int numOfPowerPills) {
		return ((numOfPowerPills - 0) / (double) (this.numberOfTotalPowerPillsInLevel - 0)) * (1 - 0) + 0;
	}

	public DiscreteTag discretizeNumberOfPowerPills(int numOfPowerPills) {
		double aux = this.normalizeNumberOfPowerPills(numOfPowerPills);
		return DiscreteTag.DiscretizeDouble(aux);
	}

	public double normalizeTotalGameTime(int time) {
		return ((time - 0) / (double) (Constants.MAX_TIME - 0)) * (1 - 0) + 0;
	}

	public DiscreteTag discretizeTotalGameTime(int time) {
		double aux = this.normalizeTotalGameTime(time);
		return DiscreteTag.DiscretizeDouble(aux);
	}

	public double normalizeCurrentLevelTime(int time) {
		return ((time - 0) / (double) (Constants.LEVEL_LIMIT - 0)) * (1 - 0) + 0;
	}

	public DiscreteTag discretizeCurrentLevelTime(int time) {
		double aux = this.normalizeCurrentLevelTime(time);
		return DiscreteTag.DiscretizeDouble(aux);
	}

	/**
	 * 
	 * Max score value lifted from highest ranking PacMan controller on PacMan
	 * vs Ghosts website: http://pacman-vs-ghosts.net/controllers/1104
	 * 
	 * @param score
	 * @return
	 */
	/*
	public double normalizeCurrentScore(int score) {
		return ((score - 0) / (double) (82180 - 0)) * (1 - 0) + 0;
	}

	public DiscreteTag discretizeCurrentScore(int score) {
double aux = this.normalizeCurrentScore(score);
		return DiscreteTag.DiscretizeDouble(aux);
	}
*/
}
