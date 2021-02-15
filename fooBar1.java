package testHello;

import java.util.ArrayList;

public class HelloWorld 
{


	public static void main(String[] args)
	{
		int area = 15324;
		int y = area;
        ArrayList<Integer> areas  = new ArrayList<Integer>();
        	
		while (y != 0) 
		{
		  y = (int) Math.floor(Math.sqrt(area));
          area = area - y*y;
    
            if (y != 0)
            {
                areas.add(y*y);
            }
		} 
        
		
		int[] TableauFix = new int [areas.size()];
		for(int i = 0; i < areas.size() ; i++)
		{
			System.out.println("val " + areas.get(i));
			TableauFix[i] = areas.get(i);
		}

//		return TableauFix
				
		
	}
}
