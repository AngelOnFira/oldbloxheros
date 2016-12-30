Function nosee()
	If seq#=0
		nsb=CreateCube()
		EntityColor nsb,0,0,0
		EntityType nsb,9
		;.gsss
		Repeat
			PositionEntity nsb,Rnd(0,levelx),Rnd(0,levely),30
			UpdateWorld
		Until CountCollisions(nsb)=0
	
		;If ghost<>0 And pudding<>0 And nsb<>0
		;If EntityX(ghost)<>EntityX(pudding) And EntityY(ghost)<>EntityY(pudding) Or EntityX(ghost)<>EntityX(nsb) And EntityY(ghost)<>EntityY(nsb)
		;Goto gsss
		;EndIf
		;EndIf
		seq#=1
	EndIf
	
	If EntityCollided(Player,9)
		bggq#=0
		frfqq#=1
		dd=CreateCube()
		EntityAlpha dd,0
		EntityColor dd,0,0,0
		blockview#=1
		FreeEntity nsb
	EndIf
	
	If EntityCollided(Playerenemy,9)
		bggq#=0
		frfqq#=1
		dd=CreateCube()
		EntityAlpha dd,0
		EntityColor dd,0,0,0
		blockview#=1
		FreeEntity nsb
	EndIf
	
	If frfqq#=1
		If bggq#=150
			FreeEntity dd
			frfqq#=0
			fvfqq#=1
			blockview#=0
		EndIf
	EndIf
	
	If fvfqq#=1
		If bggq#=300          
			seq#=0
			fvfqq#=0
		EndIf
	EndIf
	
	If blockview#=1
		xsw#=xsw#+.05
		EntityAlpha dd,xsw#
		If xsw#>.95
			EntityAlpha dd,1
			blockview#=0
			xsw#=0
			bggq#=0
		EndIf
	EndIf
		
End Function