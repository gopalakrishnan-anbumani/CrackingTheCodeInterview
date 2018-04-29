package com.program.chapter1;

public class URLify {

	public static void main(String[] args) {
		char[] in = "Gopal Krish  ".toCharArray();
		char[] res = urlify(in, 11);
		for(char c : res){
			System.out.print(c +" ");
		}
	}
	
	/**
	 * Add %20 in passing char[] no need to create new char[]. extra Space also added in the passing char[]
	 * @param url
	 * @param trueLength
	 * @return
	 */
	public static char[] urlify(char url[],int trueLength){
		//Find Space count
		int spaceCount = 0; int index =0;
		for(int i = 0; i < trueLength; i++){
			if(url[i] == ' ') spaceCount++;
		}
		index = trueLength + spaceCount * 2;
		
		if(trueLength < url.length) {
			
			url[trueLength] = '\0';
		}
		
		for(int i = trueLength - 1;i >= 0 ;i--){
			if(url[i] == ' '){
				url[index-1] = '0';
				url[index-2] = '2';
				url[index-3] = '%';
				index = index - 3;
			}else{
				url[index-1] = url[i];
				index--;
			}
		}
		return url;
	}
	
	
	//The following methods solve if the String have spaces at beginning and End. 
	// Extra Spaces also It'll remove. 
	public static String urlifywithExtraSpace(String url, int num){
		char[] chars = url.toCharArray();
		StringBuilder sb = new StringBuilder("");
		boolean validSpace = false;
		int i = 0;
		for(char c : chars){
			if(c == ' '){
				if(validSpace && i<num){
					sb.append("%20");
					validSpace = false;
					i++;
				}			
			}else{
				sb.append(c);
				validSpace = true;
				i++;
			}
		}
		return sb.toString();
	}
	public static String urlifyTwo(String url,int len){
		char[] chars = url.toCharArray();
		int count = 0;
		for(char c : chars){
			if(c!=' '){
				count++;
			}
		}
		int spaceLen = len - count;
		int extraLen = spaceLen * 3;
		char[] res = new char[count+extraLen];
		String trim = url.trim();
		boolean validSpace = true;
		int index = 0;
		for(char ch : trim.toCharArray()){
			
			if(ch == ' '){
				if(validSpace){
					validSpace = false;
					res[index++] = '%';
					res[index++] = '2';
					res[index++] = '0';
				}
			}else{
				res[index++] = ch;
				validSpace = true;
			}
		}
		StringBuilder sb =new StringBuilder("");
		
		for(char c : res){
			sb.append(c);
		}
		return sb.toString();
	}

}
