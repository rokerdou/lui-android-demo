


function onCreated()

	local root = view{Marginleft=0,Margintop=0,Width=800,Height=1300,BackgroundColor="#000000"};
	local sub = view{Marginleft=10,Margintop=220,Width=700,Height=300,BackgroundColor="#fecc11"}
	
	root:addChild(sub)

	return  root
end