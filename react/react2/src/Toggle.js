import '.toggle.css'

function Toggle(){

	const menus = ["메뉴1", "메뉴2", "메뉴3"];
	const [activeMenu, setActiveMenu] = useState("");
	return (
		<div>
			<ul className="menu-list">
				{
					menus.map(menu=>{
						return(
							<li 
							onClick={()=> setActive(menu)}
							className={"menu-item " + {activeMenu === menu ? "active" : ""}}
							key={menu}>{menu}</li>
						);
					})
				}
				<li className="menu-item">메뉴1</li>
				<li className="menu-item">메뉴2</li>
				<li className="menu-item">메뉴3</li> 
			</ul>
		</div>
	)
}