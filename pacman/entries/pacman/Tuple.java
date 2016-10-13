package ArbolesDecision.pacman.entries.pacman;

import ArbolesDecision.arbolDecision.Tree;
import ArbolesDecision.arbolDecision.discreteDistance;
import ArbolesDecision.customData.DataTuple;
import ArbolesDecision.pacman.game.Constants.DM;
import ArbolesDecision.pacman.game.Constants.GHOST;
import ArbolesDecision.pacman.game.Constants.MOVE;
import ArbolesDecision.pacman.game.Game;

public class Tuple {
	
	
	

	public static String predict(Game game, Tree tree) {
		// TODO Auto-generated method stub
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
		int closestNonEdibleGhost = blinkyDistance;
		if(inkyDistance< closestNonEdibleGhost)
			closestNonEdibleGhost = inkyDistance;
		if(pinkyDistance < closestNonEdibleGhost)
			closestNonEdibleGhost = pinkyDistance;
		if(sueDistance < closestNonEdibleGhost)
			closestNonEdibleGhost = sueDistance;
		
		discreteDistance closestGhost = discreteDistance.discretizeInt(closestNonEdibleGhost);
		
		
		boolean eatableGhost = false;
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)>0){
				eatableGhost = true;
			}		
		DataTuple tuple = new DataTuple("?",closestGhost.toString(),String.valueOf(eatableGhost));
		String action = tree.recorrer(tuple, tree.atributes);
		return action;
	}
	
	
	
	
	
	
}
