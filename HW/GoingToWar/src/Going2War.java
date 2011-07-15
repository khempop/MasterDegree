import java.util.*;

public class Going2War{

 //public static String[] c1 = {"Kc","Ad","Jh","As"};
 //public static String[] c2 = {"Tc","Jd","Qh","Ks"};

 public static String[] c1 = {"9c","Td","Jh","Qs","Kc","Ad","9h","Ts","Jc","Qd","Kh","As"};
 public static String[] c2 = {"Tc","Jd","Qh","Ks","Ac","Ah","Th","Js","Qc","Kd","9d","9s"};

 //public static String[] c1 = {"9c","Td","Jh","Qs"};
 //public static String[] c2 = {"Tc","Jd","Qh","Ks","Ac","Ah","Th","Js","Qc","Kd","9d","9s"};

 //public static String[] c1 = {"Kc","Ad","Jh","As"};
 //public static String[] c2 = {"Tc","Jd","Qh","Ks"};

 //public static String[] c1 = {"9c","Td"};
 //public static String[] c2 = {"Tc","9d"};

 public static LinkedList<String> cline1 = new LinkedList<String>();
 public static LinkedList<String> cline2 = new LinkedList<String>();

 public static int m1 = 0;
 public static int m2 = 0;
 public static int step = 0;

 public static int chk = 0;
 public static void main(String args[]){
 cloneC();
 while(chk==0){
 compare();
 }

 }

 public static void compare(){
 String tmpF1 = "";
 String tmpF2 = "";

 if((cline1.size() == 0) || (cline2.size()) == 0){
 chk = 1;
 if(cline1.size()<cline2.size()){
 System.out.println("c2 win!!");
 }else{
 System.out.println("c1 win!!");
 }
 }else{
 m1 = chkVal(cline1.getFirst());
 m2 = chkVal(cline2.getFirst());
 if(m1 > m2){
 tmpF1 = cline1.getFirst();
 tmpF2 = cline2.getFirst();

 cline1.removeFirst();
 cline2.removeFirst();

 cline1.add(tmpF1);
 cline1.add(tmpF2);
 }

 if(m2 > m1){
 tmpF1 = cline1.getFirst();
 tmpF2 = cline2.getFirst();

 cline1.removeFirst();
 cline2.removeFirst();

 cline2.add(tmpF1);
 cline2.add(tmpF2);
 }

 if(m2 == m1){
 LinkedList<String> tmpCard1 = new LinkedList<String>();
 LinkedList<String> tmpCard2 = new LinkedList<String>();
 int x = 0;

 tmpCard1.add(cline1.getFirst());
 cline1.removeFirst();
 tmpCard2.add(cline2.getFirst());
 cline2.removeFirst();
 step++;
 System.out.print("c1:");
 for(int s = 0; s < cline1.size();s++){
 System.out.print(cline1.get(s)+" ");
 }
 System.out.println("");
 System.out.print("c2:");
 for(int s = 0; s < cline2.size();s++){
 System.out.print(cline2.get(s)+" ");
 }
 System.out.println("");
 System.out.println("==== Step "+Integer.toString(step)+"====");

 while(x==0){

 tmpCard1.add(cline1.getFirst());
 cline1.removeFirst();

 tmpCard2.add(cline2.getFirst());
 cline2.removeFirst();

 if(cline1.size() == 0){
 x = 1;
 step++;

 for(int i=0; i < tmpCard1.size();i++){
 cline2.add(tmpCard1.get(i));
 cline2.add(tmpCard2.get(i));
 }

 System.out.print("c1:");
 for(int k = 0; k < cline1.size();k++){
 System.out.print(cline1.get(k)+" ");
 }

 System.out.println("");
 System.out.print("c2:");
 for(int k = 0; k < cline2.size();k++){
 System.out.print(cline2.get(k)+" ");
 }
 System.out.println("");
 System.out.println("==== Step "+Integer.toString(step)+"====");
 break;
 }else if(cline2.size() == 0){
 x = 1;
 step++;

 for(int i=0; i < tmpCard1.size();i++){
 cline1.add(tmpCard1.get(i));
 cline1.add(tmpCard2.get(i));
 }

 System.out.print("c1:");
 for(int k = 0; k < cline1.size();k++){
 System.out.print(cline1.get(k)+" ");
 }

 System.out.println("");
 System.out.print("c2:");
 for(int k = 0; k < cline2.size();k++){
 System.out.print(cline2.get(k)+" ");
 }
 System.out.println("");
 System.out.println("==== Step "+Integer.toString(step)+"====");
 break;
 }else{

 int t1 = chkVal(cline1.getFirst());
 int t2 = chkVal(cline2.getFirst());
 step++;
 System.out.print("c1:");
 for(int s = 0; s < cline1.size();s++){
 System.out.print(cline1.get(s)+" ");
 }
 System.out.println("");
 System.out.print("c2:");
 for(int s = 0; s < cline2.size();s++){
 System.out.print(cline2.get(s)+" ");
 }
 System.out.println("");
 System.out.println("==== Step "+Integer.toString(step)+"====");

 if(t1 > t2){
 tmpCard1.add(cline1.getFirst());
 cline1.removeFirst();
 tmpCard2.add(cline2.getFirst());
 cline2.removeFirst();

 for(int i=0; i< tmpCard1.size();i++){
 cline1.add(tmpCard1.get(i));
 cline1.add(tmpCard2.get(i));
 }
 x = 1;
 }
 if(t2 > t1){
 tmpCard1.add(cline1.getFirst());
 cline1.removeFirst();
 tmpCard2.add(cline2.getFirst());
 cline2.removeFirst();

 for(int i=0; i< tmpCard1.size();i++){
 cline2.add(tmpCard1.get(i));
 cline2.add(tmpCard2.get(i));
 }
 x = 1;
 }

 }
 }
 }
 step++;
 System.out.print("c1:");
 for(int x = 0; x < cline1.size();x++){
 System.out.print(cline1.get(x)+" ");
 }
 System.out.println("");
 System.out.print("c2:");
 for(int x = 0; x < cline2.size();x++){
 System.out.print(cline2.get(x)+" ");
 }
 System.out.println("");
 System.out.println("==== Step "+Integer.toString(step)+"====");

 if(step == 100000){
 chk=1;
 System.out.println("Over 100,000 steps");
 }
 }
 }

 public static void cloneC(){
 for(int i = 0; i < c1.length; i++){
 cline1.add(c1[i]);
 }
 for(int i = 0; i < c2.length; i++){
 cline2.add(c2[i]);
 }
 }

 public static int chkVal(String card){
 char firstStr = card.toCharArray()[0];
 if(firstStr == 'T'){
 return 10;
 }
 if(firstStr == 'J'){
 return 11;
 }
 if(firstStr == 'Q'){
 return 12;
 }
 if(firstStr == 'K'){
 return 13;
 }
 if(firstStr == 'A'){
 return 14;
 }
 return Integer.parseInt(Character.toString(firstStr));
 }
}