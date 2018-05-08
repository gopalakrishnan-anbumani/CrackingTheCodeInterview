package com.program.chapter1;

public class StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = joinAndCheck("gopal","palgo");
		System.out.println(res);
	}
	// Check One string of rotation of anoither String
	public static boolean joinAndCheck(String s1,String s2){
		String joinedString = s2+s2;
		int len = joinedString.length();
		int index = s2.indexOf(s1.charAt(0));
		while((index+s1.length())<=len){
			if(joinedString.substring(index,index+s1.length()).equalsIgnoreCase(s1)){
				return true;
			}
			index = s2.indexOf(s1.charAt(0),index+1);
			if(index==-1) return false;
		}
		return false;
	}

}
