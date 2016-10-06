package ArbolesDecision.dataRecording;

import ArbolesDecision.pacman.controllers.Controller;
import ArbolesDecision.pacman.game.Constants.MOVE;
import ArbolesDecision.pacman.game.Game;

/**
 * The DataCollectorHumanController class is used to collect training data from playing PacMan.
 * Data about game state and what MOVE chosen is saved every time getMove is called.
 * @author andershh
 *
 */
public class DataCollectorController extends Controller<MOVE>{
	private Controller<MOVE> controller;
	
	public DataCollectorController(Controller<MOVE> input){
		this.controller = input;
	}
	
	@Override
	public MOVE getMove(Game game, long dueTime) {
		MOVE move = this.controller.getMove(game, dueTime);
		
		DataTuple data = new DataTuple(game, move);
				
		DataSaverLoader.SavePacManData(data);		
		return move;
	}

}
