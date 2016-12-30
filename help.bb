Function help()
	;FreeEntity cube
	;HideEntity box1
	;HideEntity box2
	;HideEntity box3
	;HideEntity box4
	cubered=CreateCube()
	;types(entitys,help,cubered)
	EntityColor cubered,255,0,0
	cubeblue=CreateCube()
	;types(entitys,help,cubeblue)
	cubejello=CreateCube()
	;types(entitys,help,cubejello)
	ghost=CreateCube()
	;types(entitys,help,ghost)
	wall=CreateCube()
	;types(entitys,help,wall)
	indvisablock=CreateCube()
	;types(entitys,help,indvisablock)
	shower=CreateCube()
	;types(entitys,help,shower)
	ScaleEntity shower,1,10,1
	EntityColor shower,255,255,0
	EntityColor indvisablock,0,0,0
	EntityColor ghost,195,195,195
	EntityAlpha ghost,.15
	EntityColor cubejello,230,43,0
	EntityAlpha cubejello,.8
	EntityColor cubeblue,0,0,255
	PositionEntity shower,-14,4,34
	PositionEntity indvisablock,-16,-3,30
	PositionEntity wall,-16,6,30
	PositionEntity ghost,-16,3,30
	PositionEntity cubejello,-16,0,30
	PositionEntity cubered,-16,12,30
	PositionEntity cubeblue,-16,9,30

	red=2
	blue=2
	While Not KeyHit(28)
		If green=0
			greenc=greenc+1
		ElseIf red=0
			redc=redc+1
		ElseIf blue=0
			bluec=bluec+1
		EndIf
		
		If green=1
			greenc=greenc-1
		ElseIf red=1
			redc=redc-1
		ElseIf blue=1
			bluec=bluec-1
		EndIf
		
		If green=0 And greenc=255
			green=1
			red=0
			blue=2
		ElseIf red=0 And redc=255
			green=2
			red=1
			blue=0
		ElseIf blue=0 And bluec=255
			green=0
			red=2
			blue=1
		EndIf
		
		EntityColor wall,redc,greenc,bluec
		
		If x#=0
			MoveEntity shower,-.1,0,0
		EndIf
		
		If x#=1
			MoveEntity shower,.1,0,0
		EndIf
		
		If w#<=85
			x#=0
		Else
			x#=1
		EndIf
		
		If w#=170
			w#=0
		EndIf
		
		w#=w#+1
		
		TurnEntity indvisablock,.1,.2,.3
		TurnEntity cubered,.1,.2,.3
		TurnEntity cubeblue,.1,.2,.3
		TurnEntity wall,.1,.2,.3
		TurnEntity ghost,.1,.2,.3
		TurnEntity cubejello,.1,.2,.3 
		UpdateWorld
		RenderWorld
		Text 410,50,"The red cube is considered Player 1, and is shown on the left hand screen."
		Text 410,115,"The blue cube is considered Player 2, and is shown on the right hand screen."
		Text 410,180,"This is a wall block, it separates halls and the spawn points. They differ in color."
		Text 410,245,"The invisa-block's location is randomised. It makes you a ghost for a set amount of time."
		Text 410,310,"This cube is jello, and speeds you up, for a set amount of time. One might look at it as a drug."
		Text 410,375,"This block has no name, but messes with comunications, clearing the map for a bit."
		Text 300,600,"Press Enter to continue"
		Text 250,500,"The green flag over one of the players head's makes that player it. Player 1 uses w,a,s,d to move around, and player 2 uses the arrow keys."
		Text 250,520,"Once a player has the flag, they gain points. A score for both players to reach is set at the beginning of the match."
		Text 250,540,"A normal match (2-3 mins) has about 10000 points. The mininum number to start with is 1000. If there is ever a glitch with the program," 
		Text 250,560,"Exit And restart it, And add a post in the glitches zone on the website at www.MetalMouseSoftware.webs.com."
		Flip
	Wend
	Cls
	FreeEntity cubered
	FreeEntity cubeblue
	FreeEntity wall
	FreeEntity ghost
	FreeEntity cubejello
	FreeEntity indvisablock
	FreeEntity shower
	FreeEntity cam4
	load
End Function