package problems.backtracking;

import java.util.ArrayList;
import problems.Strutture;

public class Backtracking {
	public int c = 0;
	public boolean turni(ArrayList<String> turni, ArrayList<String> persone, int k) {
		Strutture.SoluzioneTurni soluzione = new Strutture().new SoluzioneTurni(turni, persone, k);
		boolean b = soluzioneTurni(soluzione);
		for(int i = 0; i < soluzione.turni.size(); ++i) {
			System.out.print(soluzione.turni.get(i) + " -> ");
			System.out.println(soluzione.soluzione.get(i));
		}
		for(int i=0; i<soluzione.turniPersone.length; ++i) {
			System.out.print(soluzione.persone.get(i) + " ore: ");
			System.out.println(soluzione.turniPersone[i]);
		}
		return b;
	}
	
	private boolean soluzioneTurni(Strutture.SoluzioneTurni soluzione){
		c++;
		int x = 0;
		while(x < soluzione.persone.size())
			if(canAddTurni(x,soluzione)) {
				
				soluzione.soluzione.add(soluzione.persone.get(x));
				soluzione.turniPersone[x]++;
				
				if(isCompleteTurni(soluzione)) return true;
				else if(soluzioneTurni(soluzione)) return true;
				
				soluzione.soluzione.remove(soluzione.soluzione.size()-1);
				soluzione.turniPersone[x]--;
				x++;
			}
			else x++;
			
		return false;
	}
	
	private boolean canAddTurni(int x, Strutture.SoluzioneTurni soluzione) {
		if(soluzione.soluzione.isEmpty()) 
			return true;
		if(soluzione.soluzione.size()+1 > soluzione.turni.size())
			return false;
		if(soluzione.soluzione.get(soluzione.soluzione.size()-1).compareTo(soluzione.persone.get(x))==0)
			return false;
		int count = 0;
		for(String s : soluzione.soluzione)
			if(s.compareTo(soluzione.persone.get(x))==0)
				count++;
		if(count>soluzione.massimoNumeroDiTurni) 
			return false;
		return true;
	}
	
	private boolean isCompleteTurni(Strutture.SoluzioneTurni soluzione) {
		for(int i = 0; i < soluzione.turniPersone.length; ++i)
			if(soluzione.turniPersone[i] < (soluzione.turni.size()/soluzione.persone.size()) || soluzione.turniPersone[i] > soluzione.massimoNumeroDiTurni)
				return false;
		return true;
	}
	
	
}
