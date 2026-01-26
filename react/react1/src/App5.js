import { useState } from "react";

/**
 * 
 * 버튼을 누르면 input 태그에 입력된 값을 h1 태그에 추가하는 기능을 구현하세요.
 * 1. state 변수가 2개 필요 => state 변수 선언
 * -input 값이 바뀔 때마다 변하는 변수
 * -h1태그에 출력할 변수
 * 2. input 태그 값이 바뀌면 state 변수에 값이 바뀌도록 작성
 * -App4 예제 활용
 * -input 태그에 change 이벤트를 등록
 * -change 이벤트를 실행항 함수 추가
 * -구현
 * 2. 버튼을 클릭하면 printText값이 inpuText 값이 되도록 수정
 * -버튼에 click 이벤트를 등록
 * -click 이벤트를 실행할 함수를 추가
 * -구현 : printText값이 inputText값이 되도록 구현
 */
function App5(){

	//useState는 배열을 반환
	//0번지에는 변수가, 1번지에는 0번지의 값을 바꿀 수 있는 setter를 반환
	let [printText, setPrintText] = useState("");
	let [inputText, setInputText] = useState("");
	
	const inputChange = (e) =>{ console.log("change");}
	const btnClick = () => { console.log("클릭")}

	return (
		<div>
			<input onChange={inputChange} />
			<button>입력</button>
			<h1></h1>
		</div>
	)
}

export default App5;