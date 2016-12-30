Function pudding()
	If TimeToRemakePudding=0
		pudding=CreateCube()
		EntityColor pudding,230,43,0
		EntityAlpha pudding,.8
		EntityType pudding,8
		
		Repeat
			PositionEntity pudding,Rnd(0,levelx),Rnd(0,levely),30
			UpdateWorld
		Until CountCollisions(pudding)=0
		
		TimeToRemakePudding=1
	EndIf
	
	If EntityCollided(Player,8)
		TimeWithPudding=0
		ConditionRemakePudding=1
		WhoHasPudding=1
		HideEntity pudding
	EndIf
	
	If EntityCollided(Playerenemy,8)
		TimeWithPudding=0
		ConditionRemakePudding=1
		WhoHasPudding=2
		HideEntity pudding
	EndIf
	
	If ConditionRemakePudding=1
		If TimeWithPudding=150
			WhoHasPudding=0
			fvfq=1
		EndIf
	EndIf
	
	If fvfq=1
		If TimeWithPudding=300          
			TimeToRemakePudding=0
			fvfq=0
		EndIf
	EndIf
End Function