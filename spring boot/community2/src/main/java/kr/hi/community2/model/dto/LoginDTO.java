package kr.hi.community2.model.dto;

import kr.hi.community2.dao.UserDAO;
import lombok.AllArgsConstructor;

/*record는 값을 객체의 값을 수정할 수 없는 클래스
 * -선언된 모든 필드가 private final로 지정
 * -settet는 없고, getter만 추가
 * -상속 불가
 * -모든 필드가 매개변수로 받는 생성자를 추가
 * -모든 필드가 같으면 같다고 판별하는 equals를 추가
 * -toString을 추가
 * =@Date, @AllArgsConstructor 안 써도 됨
 * */
public record LoginDTO(
		String id,
		String pw,
		String email){
	
	
}

//@Date
//@AllArgsConstructor
//public class LoginDTO{
//	String id;
//	String pw;
//	String email;
//	
//} 과 setter가 없다는 것만 빼고 똑같다.
