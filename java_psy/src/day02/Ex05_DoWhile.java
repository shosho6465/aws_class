package day02;

public class Ex05_DoWhile {
     public static void main(String[] args) {
    	 /* do while문
    	  * -무조건 한 번은 실행
    	  * -실행 후 조건을 검사
    	  * -while()옆에 ; 반드시 붙여야 함
    	  * 문법
    	  *  do{
    	  *       실행문;
    	  *  } while(조건식);
    	  */
    	 int num = 10;
    	 do {
    		 System.out.println(num + "는 0보다 작습니다.(do while문)");
    	 }while(num < 10);
    	 
    	 
     }
}
