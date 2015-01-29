

function onCreated()
    
	local root = view{Marginleft="0%",Margintop="0%",Width="100%",Height="100%",BackgroundColor="#ddeeff"}
    local sub = view {Marginleft="25%",Margintop="20%",Width="50%",Height="50%",BackgroundColor="#ffeedd"}
    root:addChild(sub)

    
	return  root
end