package com.app;

class Codig {

	public static void main(String[] args) {
		String s="aa bb cc ddd";
		    		        String [] ss=s.split(" ");
		            int start=0;
		            int end=ss.length-1;
		            while(start<end){
		             String temp=ss[start];
		             ss[start]=ss[end];
		             ss[end]=temp;
		             start++;
		             end--;
		               }
		              for(String s1:ss){
		                System.out.print(s1);
		              }
		              String newString=String.join(" ",ss);
		              //return newString;
		    System.out.println(newString+"fff");
	
	}

}
