package ArbolesDecision.pacman;

import ArbolesDecision.customData.DataSet;
import ArbolesDecision.dataRecording.DataSaverLoader;
import ArbolesDecision.dataRecording.DataTuple;
public class DataTester {
	public static void main(String... args) {
		//DataTuple[] tuples = DataSaverLoader.LoadPacManData();
		System.out.println("Hola");
		DataSet s = new DataSet();
		
		s.atributes.put(1,"Strategy");
		s.atributes.put(0,"Distance");
		s.print();
		s.eliminarAtributo(0);
		s.print();
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
