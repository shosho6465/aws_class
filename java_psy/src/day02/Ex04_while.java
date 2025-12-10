package day02;

public class Ex04_while {
     public static void main(String[] args) {
    	 /* while 문법
    	  * 
    	  *while(조건식){
    	  *    실행문;
    	  *}
    	  *
    	  *for문과 비교를 위해 while문 추가, 실제 문법은 위를 참고
    	  *초기화;
    	  *while(조건식){
    	  *    실행문;
    	  *    증감식;//실제 while문에서 증감식 위치는 없음. 그냥 실행문
    	  *}
    	  */
    	 for(int i = 1; i <= 5; i++) {
    		 System.out.println(i);
    	 }
    	 int i = 1;
    	 while(i <= 5) {
    		  System.out.println(i);
    		  i++;
    	 }
     }
}
