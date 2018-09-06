package test;

import java.util.HashMap;
import java.util.Map;

public class ExcelNumber {

	public String convertToTitle(int n) {

		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			n--;
			Character c = (char) ('A' + n % 26);
			n /= 26;
			sb.append(c);
		}
		return sb.reverse().toString();
//		StringBuilder sb = new StringBuilder();
//		while(n > 0)
//		{
//			n = n / 26;
//			if(n > 26)
//			{
//				sb.append("A");
//			}
//			else
//			{
//				
//			}
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelNumber e = new ExcelNumber();
		System.out.println(e.convertToTitle(7001));

	}

}
