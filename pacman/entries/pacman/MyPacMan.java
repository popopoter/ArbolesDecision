package ArbolesDecision.pacman.entries.pacman;

import java.util.ArrayList;
import java.util.Hashtable;

import ArbolesDecision.arbolDecision.Tree;
import ArbolesDecision.arbolDecision.discreteDistance;
import ArbolesDecision.customData.DataTuple;
import ArbolesDecision.pacman.controllers.Controller;
import ArbolesDecision.pacman.game.Constants.DM;
import ArbolesDecision.pacman.game.Constants.GHOST;
import ArbolesDecision.pacman.game.Constants.MOVE;
import ArbolesDecision.pacman.game.Game;
import ArbolesDecision.pacman.game.internal.Ghost;
import ArbolesDecision.strategy.Eat;
import ArbolesDecision.strategy.Run;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	private MOVE myMove=MOVE.NEUTRAL;
	private static final int MIN_DISTANCE=20;
	//if a ghost is this close, run away
	Tree tree= new Tree();
	 Hashtable <String,Integer> atributes;
	public MOVE getMove(Game game, long timeDue) 
	{
		GHOST ghost = GHOST.BLINKY;
		 atributes =  new Hashtable<String,Integer>();
		atributes.put("Strategy",0);
		atributes.put("Distance",1);
		discreteDistance closestGhost;
		int blinkyDistance = 1000;
		int inkyDistance = 1000;
		int pinkyDistance = 1000;
		int sueDistance = 1000;
		int closestNonEdibleGhost;
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
		if(inkyDistance< closestNonEdibleGhost){
			closestNonEdibleGhost = inkyDistance;
			ghost = GHOST.INKY;
		}
		if(pinkyDistance < closestNonEdibleGhost){
			
			closestNonEdibleGhost = pinkyDistance;
			ghost = GHOST.PINKY;
		}
		if(sueDistance < closestNonEdibleGhost){
			
			closestNonEdibleGhost = sueDistance;
			ghost = GHOST.SUE;
		}
		
		closestGhost = discreteDistance.discretizeInt(closestNonEdibleGhost);
		DataTuple test = new DataTuple("as",closestGhost.toString());
		String accion = tree.recorrer(test, atributes);
		if(accion.equals("Run"))
			return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
		if(accion.equals("Eat")){
			int current=game.getPacmanCurrentNodeIndex();
			int[] pills=game.getPillIndices();
			int[] powerPills=game.getPowerPillIndices();		
			
			ArrayList<Integer> targets=new ArrayList<Integer>();
			
			for(int i=0;i<pills.length;i++)					//check which pills are available			
				if(game.isPillStillAvailable(i))
					targets.add(pills[i]);
			
			for(int i=0;i<powerPills.length;i++)			//check with power pills are available
				if(game.isPowerPillStillAvailable(i))
					targets.add(powerPills[i]);				
			
			int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
			
			for(int i=0;i<targetsArray.length;i++)
				targetsArray[i]=targets.get(i);
			
			//return the next direction once the closest target has been identified
			return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
		
			
			
		}
		//Place your game logic here to play the game as Ms Pac-Man
		/*int current=game.getPacmanCurrentNodeIndex();
		
		//Strategy 1: if any non-edible ghost is too close (less than MIN_DISTANCE), run away
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<MIN_DISTANCE)
				{
					
					game.strategy=  new Run();
					return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
				}
				
				game.strategy=  new Eat();
		int[] pills=game.getPillIndices();
		int[] powerPills=game.getPowerPillIndices();		
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<pills.length;i++)					//check which pills are available			
			if(game.isPillStillAvailable(i))
				targets.add(pills[i]);
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);				
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		//return the next direction once the closest target has been identified
		return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
	*/
		return MOVE.NEUTRAL;
		
	}
}