import java.util.*;

public class day {
	public ArrayList<company> nDay = new ArrayList<company>();
	public int numDay;
	
	public void setCompanyList(company comp){
		nDay.add(comp);
	}
	
	public ArrayList<company> getCompanyList(){
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
		System.out.println("Day #"+numDay+" Market Index:");
		System.out.println("Company        Price        Changes");
		for(int j = 0; j < 10; j++){
			company thisComp = nDay.get(j);
			System.out.println("   "+thisComp.getName()+"             "+thisComp.getPrice()+"             "+thisComp.getChange());
		}
	}
}