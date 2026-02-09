import { useState } from "react";

function Insert(){
	
		let [date, setDate] = useState("");
		let [list, setList] = useState("");

		const addTodo = (e) =>{
			e.preventDefault(); //form 태그 전송 기능 막기
			//비동기 통신으로 날짜, 할 일을 전송해서 추가하는 함수를 선언
			const sendInsertTodo = async ()=>{
				try{
					const response = await fetch("/api/v1/todos", {
						method : "Post",
						headers : {
							"Content-type" : "application/json"
						},
						body : JSON.stringify({
							date : date,
							text : list
						})
					});

					if(response.status == 200){
						const result = await response.json();
						if(result){
							alert("할 일을 등록했습니다.");
							setList("");
						}else{
							alert("할 일을 등록하지 못했습니다.")
						}
					}

				}catch{
					console.error(e);				
				}
			}
			//함수 호출
			sendInsertTodo();
		}
		
		function dateChange(e){

			setDate(e.target.value);
		}
	
	return (
		<div>
			<h1>할 일 등록1</h1>
			<form className="insert-form" 
			onSubmit={addTodo} method="post">
				<div>
				<label htmlFor="todo">할 일 :</label>
				<input type="text" placeholder="할 일을 입력하세요." name="todo"
				//이름 없는 함수를 만들어서 실행문{} 안에 set함수를 넣은 것. set함수에 넣은 매개변수의 값이 곧 변수의 값이 된다.
				onChange={e=>setList(e.target.value)} id="todo" value={list}/>
				</div>
				<div>
				<label htmlFor="text">날짜 :</label>
				<input type="date" name="date"
				onChange={dateChange} id="text"/>
				</div>
				<button>등록</button>
			</form>
			<h1>{date}</h1>
			<h1>{list}</h1>
		</div>	
	);
}

export default Insert;