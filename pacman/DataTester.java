package ArbolesDecision.pacman;

import java.util.ArrayList;

import Arboles.atributos.ClosestAgresiveGhost;
import Arboles.atributos.Eatable;
import ArbolesDecision.arbolDecision.SeleccionAtributo;
import ArbolesDecision.customData.DataSet;
import ArbolesDecision.dataRecording.DataSaverLoader;
import ArbolesDecision.dataRecording.DataTuple;
public class DataTester {
	public static void main(String... args) {
		//DataTuple[] tuples = DataSaverLoader.LoadPacManData();
		DataSet s = new DataSet();
		s.atributes.add( ClosestAgresiveGhost.getInstance());
		s.atributes.add(Eatable.getInstance());
		SeleccionAtributo sel = new SeleccionAtributo();
		//System.out.println(s.countConditional(0, "Kill"));
		//System.out.println(s.countConditional(0, "Eat"));
		System.out.println(s.countDoubleConditional(0, "Run", 2, "true"));
		System.out.println(s.countConditional(0, "Run"));
		System.out.println(s.countTuples());
		System.out.println(sel.getInfoT(s));
		
		//System.out.println(sel.getInfo(s, s.atributes.get(0)));
		
		//System.out.println(s.countConditional(0,"Eat"));
		//s.print();
		//System.out.println(s.claseMayoritaria());
		//ArrayList<String> list = s.atributeValues("Strategy");
		
		
		/*int counter = 0;
		System.out.println("");
		for (DataTuple d : tuples) {
			System.out.println("Normal: "+counter+") "+d.getSaveString());
			/*
			System.out.print("Discrete: "+d.DirectionChosen + ", "  + d.strategy + ";" + d.discretizePosition(d.pacmanPosition) + ", "
					+ d.pacmanLivesLeft + ", " + d.discretizeCurrentLevelTime(d.currentLevelTime) + ", "
					+ d.discretizeNumberOfPills(d.numOfPillsLeft) + ", " + d.discretizeNumberOfPowerPills(d.numOfPowerPillsLeft) + ", " + d.isBlinkyEdible
					+ ", " + d.isInkyEdible + ", " + d.isPinkyEdible + ", " + d.isSueEdible + ", " + d.discretizeDistance(d.blinkyDist) + ", "
					+ d.discretizeDistance(d.inkyDist) + ", " + d.discretizeDistance(d.pinkyDist) + ", " + d.discretizeDistance(d.sueDist)
					+ ", " + d.blinkyDir+ ", " + d.inkyDir+ ", " + d.pinkyDir+ ", " + d.sueDir + "\n");
			counter++;
			if (counter>10000) break;
		}
	 	 */

	}
}
