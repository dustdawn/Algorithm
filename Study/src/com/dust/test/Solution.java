package com.dust.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	    public static boolean isValid(String s) {
	        if(s == null)
	            return false;
	        if( s.charAt(0)!= '('&&s.charAt(0) != '['&& s.charAt(0) != '{')
	            return false;
	        
	        for(int i=0;i<s.length();i++)
	        {
	            if(s.charAt(i) == '(' )
	            {
	                if(!s.contains("}"))
	                    return false;
	                for(int j=i+1;j<s.length();j++)
	                {
	                    if( (s.charAt(j) == ')') && (i+j)%2==0)
	                        return false;
	                   
	                }
	            }
	             if(s.charAt(i) == '[')
	             {
	                if(!s.contains("}"))
	                    return false;
	                for(int j=i+1;j<s.length();j++)
	                {
	                    if( (s.charAt(j) == ']') && (i+j)%2==0)
	                        return false;
	                   
	                }
	             }
	            if(s.charAt(i) == '{')
	            {
	                
	                if(!s.contains("}"))
	                    return false;
	                for(int j=i+1;j<s.length();j++)
	                {
	                    if( (s.charAt(j) == '}') && (i+j)%2==0)
	                        return false;        
	                    
	                } 
	            }
	        }
	        return true;
	    }
	    


	public static void main(String[] args) {
		try {
			while(true){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if(isValid(s)) {
			System.out.println("true");
		}
		else
			System.out.println("false");
			}
		}catch(IOException e) {}

	}

}
