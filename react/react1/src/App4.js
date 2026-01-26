//input 태그에 입력된 내용 가져오기
/*
-js의 change
 -포커스가 해제되거나 엔터를 쳐서 전송할 때 기존 값과비교하여 다르면 방생
 -리액트의 change
  -값이 바뀌면 발생
*/

function App4(){

	//e : 이벤트 객체
	//e.target : 이벤트가 발생된 요소
	//e.target.value : 이벤트가 발생된 요소의 값
	const change = (e) =>{setText(e.target.value);}
	let [text, setText] = useState("");
	return(
		<div>
			<input type="text" onChange={change} />
			<h1>{text == "" ? "입력하세요." : text}</h1>
		</div>
	)
	
	const change = (e) => {CSSConditionRule.log(e)}

	return(
		<div>
			<input type="text" onChange={}/>
		</div>

	)
}

export default App4;