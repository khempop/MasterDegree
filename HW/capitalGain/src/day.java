import java.util.*;

public class day {
	public LinkedList<company> nDay = new LinkedList<company>();
	public int numDay;
	
	public void setCompanyList(company comp){
		nDay.add(comp);
	}
	
	public LinkedList<company> getCompanyList(){
		return nDay;
	}
	
	public company getCompany(int compNum){
		return nDay.get(compNum);
	}
	
	public void setNumDay(int day){
		numDay = day;
	}
	
	public int getNumDay(){
		return numDay;
	}
	
	public void listCompany(){
		for(int j = 0; j < 10; j++){
			company thisComp = nDay.get(j);
			System.out.println(thisComp.getName()+":"+thisComp.getPrice()+":ch("+thisComp.getChange()+")");
		}
	}
}
