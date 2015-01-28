


function onCreated()
    
	local root = view{Marginleft=0,Margintop=0,Width=120,Height=1000,BackgroundColor="#ddeeff"}
    local sub = view {Marginleft=60,Margintop=0,Width=30,Height=300,BackgroundColor="#ffeedd"}
    local subb = view {Marginleft=90,Margintop=0,Width=30,Height=300,BackgroundColor="#ffffff"}
    root:addChild(view{Marginleft=30,Margintop=0,Width=30,Height=300,BackgroundColor="#eeccff"})
    root:addChild(sub)
    root:addChild(subb)
    
	return  root
end