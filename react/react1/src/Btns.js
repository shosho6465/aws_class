//한번도 사용하지 않은 컴포넌트의 함수명은 옅은 회색이다. > export 하면 검정색으로 바뀜
function Btn1(){
	return(
		<button>일반 버튼1</button>
	);
}

const Btn2 = () => {
	return (
		<button>일반 버튼2</button>
	);
}

//부모가 보낸 정보를 props 객체로 받음
function Btn3(props){
	return(
		//부모가 보낸 정보를 받는 방법 2. 부모
		<button style={{color : props.color}}>{props.text}</button>
	)
}

//부모가 보낸 정보를 객체로 받음
function Btn4({text="버튼", color}){
	return(
		<button style={{color : color}}>{text}</button>
	)
}
//예전 리액트는 반영 됐으나 18버전 이후에는 지양하기 때문에 적용안됨
Btn3.defaultProps = {
	text : "버튼",
	color : "green"
}

export {Btn1, Btn2, Btn3, Btn4};