import { useState } from "react";

const EX_ITEMS = {
  {label : "예제1", isOpen : false, el : <Ex1/>},
  {label : "예제2", isOpen : false, el : <Ex2/>},
  {label : "예제3", isOpen : false, el : <Ex3/>}.
}

function App2() {
  return(
    <div className="App">
      <Main />
    </div>
  )

  function Main(){
    let[items, setItems] = useState(EX_ITEMS);

    const cahngeEx = (label)=>{
      console.log(items)
      const updateEx = EX_ITEMS.map(item=>{
        if(item.label === label){
          console.log(!item.isOpen)
          return {...item, isOpen : !item.isOpen};
        }
        return {...item, isOpen : false}
      });
      setItems(updateEx);
    }
  
  return (
    <div>
      <h1>메인</h1>
      <div>
        <EX_ITEMS.map(item=>{
          return <button> {EX_ITEMS.label} " {EX_ITEMS.isOpen ? "접기" : "보기"}</button>
           })
      </div>
    <div>
      { true ? <Ex1 /> : null }
      { true ? <Ex2 /> : null }
    </div>
  )<EX_ITEMS.map(item=>{
    return <button onClick={()=>changeEx(EX_ITEMS.label)}>{EX_ITEMS.label} : {EX_ITEMS.isOpen} </button>
}

}

function Ex3(){
  return <div><h1>예제</h1></div>
}

export default App2;