package business;

import java.util.Comparator;

import beans.Candidate;

public class CandidateComparator implements Comparator<Candidate> {

	public int compare(Candidate c1, Candidate c2) {
		if(c1.getNoteGlobale()>c2.getNoteGlobale()) {
			return -1;
		}
		else if (c1.getNoteGlobale()<c2.getNoteGlobale()) {
			return 1;
		}
		else {
			return 0;

		}
	}
	
	
	

}
