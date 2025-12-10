package day07;

public class Ex09_Lombok {
	public final static int PORT = 7000;
	public static void main(String[] args) {
		//1. port 지정
		
		
		try(ServerSocker serverSocket) = new ServerSocket(port)){
			System.out.println("[연결 대기 중 ....!!!"]);
			Socket socket = serverSocket.accept();
			System.out.println("[연결 성공....!!!]");
			
		}catch(Exception e) {
			System.err.println("[예외가 발생했습니다...!!!"]);
		}

	}



}