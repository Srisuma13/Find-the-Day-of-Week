import java.util.*;
import java.lang.*;
public class FindDay{
public static String DayOfWeek(int month, int day, int year) {
       int oddDays=0;
       oddDays+=day%7;
       String s=null;
       int t[] = {3, 0 ,3, 2, 3, 2, 3, 3, 2, 3, 2, 3};
       if(year%400==0 || year%4==0 && year%100!=0){
           for(int i=1;i<month;i++){
               if(i==2){
                   oddDays+=1;
               }
               oddDays+=t[i-1];
           }
       }
       else{
          for(int i=1;i<month;i++){
               oddDays+=t[i-1];
           }
       }
       year-=1;
       year%=1000;
       year%=400;
       if(year>0 && year<100){
           oddDays+=(2*(year/4)+(year-year/4));
       }
       else if(year>=100 && year<200){
           oddDays+=5;
           year-=100;
           oddDays+=(2*(year/4)+(year-year/4));
       }
       else if(year>=200 && year<300){
           oddDays+=3;
           year-=200;
         oddDays+=(2*(year/4)+(year-year/4));
       }
       else{
           year-=300;
           oddDays+=1;
         oddDays+=(2*(year/4)+(year-year/4));
       }
       oddDays%=7;
       switch(oddDays){
           case 0: s="SUNDAY";
                   break;
           case 1: s="MONDAY";
                   break;
           case 2: s="TUESDAY";
                   break;
           case 3: s="WEDNESDAY";
                   break;
           case 4: s="THURSDAY";
                   break;
           case 5: s="FRIDAY";
                   break;
           case 6: s="SATURDAY";
                   break;
           default:
                   s="INVALID DAY";
       }
       return s;
   }
public static void main(String args[]){
  Scanner sc=new Scanner(System.in);
  int d,m,y;
  System.out.println("Enter the date, month and year respectively where year lies between 2000 and 3000");
  d=sc.nextInt();
  m=sc.nextInt();
  y=sc.nextInt();
  System.out.println("The day of the week is "+FindDay.DayOfWeek(m,d,y));
}
}
