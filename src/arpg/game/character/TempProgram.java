/**
 * 
 */
package arpg.game.character;

import java.util.Scanner;

/**
 * @author Andrew
 * 
 */
public class TempProgram {
	
	/**
	 * 
	 */
	public TempProgram () {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Class<?> c = null;
		
		StatType[] typeArray = null;
		
		while (!(c != null) || !c.isEnum()) {
			try {
				System.out.print(":");
				c = Class.forName(sc.nextLine().trim());
				System.out.println();
			}
			catch (ClassNotFoundException e) {
				
				continue;
				
			}
		}
		typeArray = (StatType[]) c.getEnumConstants();
		
		String[] names = new String[typeArray.length];
		StringBuilder sb = new StringBuilder();
		
		sb.append("switch (c) {\n");
		for (int i = 0; i < typeArray.length; i++) {
			
			names[i] = typeArray[i].toString();
			sb.append("case \"");
			sb.append(typeArray[i].toString());
			sb.append("\":\n");
			sb.append("\t");
			sb.append("return ");
			sb.append(c.getCanonicalName());
			sb.append(".");
			sb.append(typeArray[i].toString());
			sb.append(";\n");
		}
		sb.append('}');
		
		System.out.println(sb);
		sc.close();
	}
}
