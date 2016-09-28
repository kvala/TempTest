package test;

import java.util.ArrayList;
import java.util.List;

public class NTN {
	List<NTN> children;
	public int value;
	
	public NTN(int value){
		this.value = value;
		this.children = new ArrayList<NTN>();
	}

}
