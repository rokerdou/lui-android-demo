


function onCreated()

	local root = view{key0="0"};
	local sub = view{key1="1"}
	sub:addChild(view{key1_0 = "10"})
	root:addChild(sub)
	root:addChild(view{key2="2"})
	return  root
end