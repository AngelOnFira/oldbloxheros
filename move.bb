Function move()
	If KeyDown(200)
		MoveEntity Player,0,MovePlayerBlue,0
		moveforward=1
	EndIf
	
	If KeyDown(203)
		TurnEntity Player,0,0,SpeedPlayerBlue
		moveleft=1
	EndIf
	
	If KeyDown(205)
		TurnEntity Player,0,0,-SpeedPlayerBlue
		moveright=1
	EndIf
	
	If KeyDown(208)
		MoveEntity Player,0,-MovePlayerBlue,0
		movebackward=1
	EndIf
	
	If KeyDown(17)
		MoveEntity Playerenemy,0,MovePlayerRed,0
		moveforward=1
	EndIf
	If KeyDown(30)
		TurnEntity Playerenemy,0,0,SpeedPlayerRed
		moveleft=1
	EndIf
	If KeyDown(32)
		TurnEntity Playerenemy,0,0,-SpeedPlayerRed
		moveleft=1
	EndIf
	If KeyDown(31)
		MoveEntity Playerenemy,0,-MovePlayerRed,0
		movebackward=1
	EndIf
End Function
