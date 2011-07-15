import java.io.*;

public class cbase{
	public static void main(String args[]) throws IOException{
		int dec = 0;
		int base = 0;
		int x = 0;
		while(x == 0){
			try{
				BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Input the number to be converted: ");
	    		dec = Integer.parseInt(buf.readLine());
	    		if(dec >= 0){
	    			x = 1;
	    		}else{
	    			System.out.println("Please enter number (>=0)");
	    			x = 0;
	    		}
			}catch(Throwable t){
				System.out.println("Please enter number");
			}
		}
		x = 0;
		while(x == 0){
			try{
				BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Input the base: ");
				base = Integer.parseInt(buf.readLine());
				if((base >= 2)&&(base <= 16)){
                                     x = 1;
                                }else{
                                     System.out.println("Please enter base between 2 and 16");
                                }
                         }catch(Throwable t){
                                System.out.println("Please enter number");
                         }
                }
                System.out.print("Decimal "+Integer.toString(dec)+" in base "+Integer.toString(base)+" is ");
                System.out.print(convertDec(dec,base));
        }
        public static String convertDec(int dec, int base){
            String bit = "";
            int bt = 0;
            if(dec > 0){
            	if(base!=16){
            		bit = convertDec(dec/base,base)+Integer.toString(dec%base);
            		return bit;
            	}
            	if(base == 16){
            		bt = dec%base;
            		if(bt==10){bit = convertDec(dec/base,base)+"A";}
            		if(bt==11){bit = convertDec(dec/base,base)+"B";}
            		if(bt==12){bit = convertDec(dec/base,base)+"C";}
            		if(bt==13){bit = convertDec(dec/base,base)+"D";}
            		if(bt==14){bit = convertDec(dec/base,base)+"E";}
            		if(bt==15){bit = convertDec(dec/base,base)+"F";}
            		if(bt<10){
            			bit = convertDec(dec/base,base)+Integer.toString(dec%base);
            		}
            		return bit;
            	}
		    }
           
	        return "";
	    }
}

