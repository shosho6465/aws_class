package day07;

import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ex01_client {

	public static void main(String[] args) {
		//1. 서버 IP주소와 port를 지정
		String ip = "127.0.0.1";
		final int PORT = Ex01_Server.PORT;
		
		//2. IP주소와 port를 이용하여 연결 요청 후 성공하면 소켓 객체를 생성
		try(Socket socket = new Socket(ip, PORT)){
			System.out.println("[연결 성공!]");
			//전송하는 스레드
			 Thread t1 = new Thread(()->{
				 System.out.println("[서버로 전송할 메시지]");
				 Scanner scan = new Scanner(System.in);
				 ObjectOutputStream oos
				    = new ObjectOutputStream(socket.getOutputStream());
				 while(true) {
					 System.out.println("입략 : ");
					 String msg = scan.nextLine();
					 //서버로 전송
					 oos.writeUTF(msg);
					 oos.flush();
					 if(msg.equals("EXIT")) {
						 break;
					 }
				 }
					 
			 });
		
			//클라이언트가 전송하면 받아서 콘솔에 출력하는 스레드
			Thread t1 = new Thread(()->{
				System.out.println("[클라이언트가 전송한 메시지"]);
				try {
					ObjectInputStream ois 
					= new ObjectInputStream(socket.getInputStream());
					while(true) {
						String msg = ois.readUTF();
						System.out.println("클라이언트 : " + msg);
						if(msg.equals("EXIT")) {
							System.out.println("[클라이언트가 전송을 종료했습니다.]");
							break;
						}
					}
				}
				ObjectInputStream(socket.getInputStream());
			});
			t2.start();
			//클라이언트에게 메시지를 전송할 코드
			Thread t2 = new Thread(()->{
				
			});
			t2.start
			
		}catch(Exception e) {
			System.err.println("예외 발생");
		}
		System.out.println("[서버 종료]");
	}

}
