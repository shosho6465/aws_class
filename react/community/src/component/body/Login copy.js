import { useState } from "react";


function Login(){

	let [info, setInfo] = useState({id : "", pw : ""})

	const changeHandler = e =>{
		const {name, value} = e.target;
		setInfo({...info, [name] : value});
	}
	const submitHandler = e =>{
		e.preventDefault();

		login(info);
	}

	const comments = async ()=>{
		try{
			const response = await fetch(`/api/v2/posts/${po_num}/comments?page=${page}`, 
				{
				method : "Get",
				headers : {
					"Content-Type" : "application/json",
				}
			});
			if(!response.ok){
				alert("네트워크에 문제가 발생했습니다.");
				return;
			}
			const res = await response.json();
			console.log(res);
		}catch(e){
			console.error(e);
		}
	}

	return(
		<div>
			<h1>로그인</h1>
			<form onSubmit={submitHandler}>
				<div>
					<label htmlFor="id">아이디 : </label>
					<input type="text" name="id" id="id" onChange={changeHandler}/>
				</div>
				<div>
					<label htmlFor="pw">비번 : </label>
					<input type="text" name="pw" id="pw" onChange={changeHandler}/>
				</div>
				<button>로그인</button>
			</form>
		</div>
	)
}

export default Login;