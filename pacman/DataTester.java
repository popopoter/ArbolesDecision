package ArbolesDecision.pacman;

import java.util.ArrayList;

import ArbolesDecision.customData.DataSet;
import ArbolesDecision.dataRecording.DataSaverLoader;
import ArbolesDecision.dataRecording.DataTuple;
public class DataTester {
	public static void main(String... args) {
		//DataTuple[] tuples = DataSaverLoader.LoadPacManData();
		DataSet s = new DataSet();
		
		//Orden raya
		s.atributes.put("Strategy",0);
		s.atributes.put("Distance",1);
		System.out.println(s.countTuples());
		System.out.println(s.claseMayoritaria());
		DataSet j = s.divide("Strategy", "Eat");
		System.out.println(j.sameClass("Strategy"));
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
