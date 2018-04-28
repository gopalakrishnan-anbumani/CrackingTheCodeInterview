package com.program.chapter1;

public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(urlifyTwo("G G G G g g g g",15));
	}
	
	public static String urlify(String url, int num){
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
