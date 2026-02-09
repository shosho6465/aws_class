import { useState } from "react"

function RegisterPage(){

	const [info, setInfo] = useState({name : "", number : "", password : ""});
	const [name, value] = e.target;
	setInfo(...info, {name} : {value});

	function registerBtn(){
		passwordLength = password >= 8;
		//비밀번호가 8자 미만
		if(passwordLength){
			alert("비밀번호는 8자 이상이어야합니다.");
		}

		//전화번호에 하이픈(-)이 들어있음
		if()
	}

	return (
		<div>
			<div>
				<label>이름 :</label>
			</div>
			<div>
				<input type="text" name="name"/>
			</div>
			<div>
				<label>연락처 :</label>
			</div>
			<div>
				<input type="number" name="number"/>
			</div>
			<div>
				<label>비밀번호 :</label>
			</div>
			<div>
				<input type="password" name="password"/>
			</div>
			<button onClick={registerBtn}>가입하기</button>
		</div>
	)
}