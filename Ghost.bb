Function ghost()	
	If GhostAutoReplaceTimer=0
		ghost=CreateCube()
		EntityColor ghost,195,195,195
		EntityAlpha ghost,.15
		EntityType ghost,6
		;.gs
		Repeat
			PositionEntity ghost,Rnd(0,levelx),Rnd(0,levely),30
			UpdateWorld
		Until CountCollisions(ghost)=0
		;If ghost<>0 And pudding<>0 And nsb<>0
		;If EntityX(ghost)<>EntityX(pudding) And EntityY(ghost)<>EntityY(pudding) Or EntityX(ghost)<>EntityX(nsb) And EntityY(ghost)<>EntityY(nsb)
		;Goto gs
		;EndIf
		;EndIf
		GhostAutoReplaceTimer=1
	EndIf
		
	If EntityCollided(Player,6)
		TimeWithGhost=0
		GhostTimer=1
		EntityAlpha Player,.2
		EntityType Player,10
		HideEntity ghost
	EndIf
		
	If EntityCollided(Playerenemy,6)
		TimeWithGhost=0
		GhostTimer=1
		EntityAlpha Playerenemy,.2
		EntityType Playerenemy,10
		HideEntity ghost
	EndIf
		
	If GhostTimer=1
		If TimeWithGhost=150
			EntityAlpha player,1
			EntityAlpha playerenemy,1	
			EntityType Playerenemy,1
			EntityType Player,1
			;MoveEntity player,0,3,0
			;MoveEntity player,0,-3,0
			;MoveEntity playerenemy,0,0,10
			;MoveEntity playerenemy,0,0,10
			GhostWaitReplaceTimer=1
		EndIf
	EndIf
		
	If GhostWaitReplaceTimer=1
		If TimeWithGhost=200               
			GhostAutoReplaceTimer=0
			GhostWaitReplaceTimer=0
		EndIf
	EndIf
		
	If GhostAutoReplaceTimer=1 And TimeWithGhost=400
		GhostAutoReplaceTimer=0
		FreeEntity ghost
	EndIf
End Function