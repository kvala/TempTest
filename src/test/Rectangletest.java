package test;

import java.awt.Rectangle;

public class Rectangletest extends Rectangle{
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		
		if(getClass() != obj.getClass()){
			return false;
		}
		
		Rectangletest other = (Rectangletest) obj;
		
		if(this.width == other.width && this.height == other.height ){
			return true;
		}
		
		return false;
	};

	public static void main(String[] args) {
		Rectangletest r1 = new Rectangletest();
		r1.width = 4;
		r1.height = 6;
		
		Rectangletest r2 = new Rectangletest();
		r2.width = 4;
		r2.height = 6;
		
		System.out.println(r1.equals(r2));
	}

}
