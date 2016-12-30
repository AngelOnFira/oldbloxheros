Function game()

	Speeds()

	WaitTimer(frametimer)
		

	move()
		
		If KeyHit(157)
			bullet.bullet=New bullet
			bullet\bullethandle=CopyEntity(bullett)
			EntityType bullet\bullethandle,4
			ScaleEntity bullet\bullethandle,.5,.5,.5
			;PositionEntity bullet\bullethandle, EntityX(player, 1), EntityY(player, 1), EntityZ(player, 1)	;place the bullet at the guns position
			;RotateEntity bullet\bulletHandle, EntityPitch(player, 1), EntityYaw(player, 1), EntityRoll(player, 1)
			PositionEntity bullet\bullethandle, EntityX(Player), EntityY(Player), EntityZ(Player)
			RotateEntity bullet\bullethandle, EntityPitch(Player), EntityYaw(Player), EntityRoll(Player)
		EndIf
		
		TurnEntity pike,0,2,0
		
		;EntityBox player,EntityX(player),EntityY(player),EntityZ(player),.2,.2,.2
		;EntityBox playerenemy,EntityX(playerenemy),EntityY(playerenemy),EntityZ(playerenemy),.2,.2,.2

	
		For everybullet.bullet=Each bullet
			;MoveEntity bullet\bullethandle, 0, 0, 2
			MoveEntity bullet\bullethandle,0,.6,0
		Next
		
		pudding
		nosee
		ghost
		
		If KeyHit(28)
			TranslateEntity pudding,1,1,0
		EndIf
		
		If WhoGetsPoints=Blue
			BluePlayerScore=BluePlayerScore+1
		ElseIf WhoGetsPoints=Red
			RedPlayerScore=RedPlayerScore+1
		EndIf
		
		If EntityCollided(Player,1)
			EntityType Player,3
			EntityType Playerenemy,3
			PositionEntity Player,spawnbluex,spawnbluey,30
			PositionEntity Playerenemy,spawnredx,spawnredy,30
			EntityType Player,1
			EntityType Playerenemy,1
		
			If WhoGetsPoints=Red
				WhoGetsPoints=Blue
			ElseIf WhoGetsPoints=Blue
				WhoGetsPoints=Red
			EndIf
		EndIf
		
		UpdateWorld
		
		;pudding
		;nosee
		;ghost
		
		For everybullet=Each bullet
			If CountCollisions(bullet\bullethandle) > 0;If EntityCollided(bullet\bullethandle,wll)
				FreeEntity bullet\bullethandle
				Delete everybullet
			EndIf
			;ResetEntity bullet\bullethandle
		Next

		If WhoGetsPoints=Blue
			;EntityParent pike,player
			PositionEntity pike,EntityX(player),EntityY(Player),EntityZ(pike)
			If xo=2
			EndIf
			BluePlayerScore=BluePlayerScore+1
		ElseIf WhoGetsPoints=Red	
			If xo=2
				RedPlayerScore=RedPlayerScore+1
			EndIf
			;EntityParent pike,playerenemy
			PositionEntity pike,EntityX(playerenemy),EntityY(Playerenemy),EntityZ(pike)
		EndIf
		
		If ya=0
			MoveEntity pike,0,.05,0
			ap=ap+1
		ElseIf ya=1
			MoveEntity pike,0,-.05,0
			ap=ap+1
		EndIf
		If ap=30 And ya=0
			ya=1
			ap=0
		ElseIf ap=30 And ya=1
			ap=0
			ya=0
		EndIf
		
		RenderWorld
		;Text 300,0, "x;"+EntityX(player)+", y;"+EntityY(player)+", z;"+EntityZ(player)
		;Text 300,24, "x; "+levelx+", y; "+levely 
		
		Text 0,0,"Blue Player; " + BluePlayerScore + ""
		Text 0,12,"Red Player; " + RedPlayerScore + ""
		
		
		If KeyHit(24)
			PositionEntity cam2,0,0,0
			m=.7
		EndIf
		
		If RedPlayerScore>BluePlayerScore
			RedPoints=RedPlayerScore-BluePlayerScore	
			Text 0,60,"Red is winning by " + RedPoints + " points"
		ElseIf BluePlayerScore>RedPlayerScore
			BluePoints=BluePlayerScore-RedPlayerScore
			If RedPoints>-1
				Text 0,60,"Blue is winning by " + BluePoints + " points"
			EndIf
		EndIf
		
		If RedPoints>BluePoints And w=0
			If RedPoints>=0 And RedPoints<51
				Text 0,48,"Red is winning"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; L " + RedPoints + "/50"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>50 And RedPoints<101
				Text 0,48,"Meh"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; K " + RedPoints + "/100"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>100 And RedPoints<151
				Text 0,48,"Better"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; J " + RedPoints + "/150"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>150 And RedPoints<201
				Text 0,48,"Red is on a roll."
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; I " + RedPoints + "/200"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>200 And RedPoints<301
				Text 0,48,"Red is on a roll!"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; H " + RedPoints + "/300"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>300 And RedPoints<401
				Text 0,48,"SNAP!"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; G " + RedPoints + "/400"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>400 And RedPoints<601
				Text 0,48,"Blue IS FAILING"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; F " + RedPoints + "/600"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>600 And RedPoints<801
				Text 0,48,"Red IS GODLIKE!"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; E " + RedPoints + "/800"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>800 And RedPoints<1001
				Text 0,48,"Red is BEYOND GODLIKE!!!"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; D " + RedPoints + "/1000"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>1000 And RedPoints<1401
				Text 0,48,"SOMEONE KILL Red!"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; C " + RedPoints + "/1400"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>1400 And RedPoints<2001
				Text 0,48,"RAGING PYSCOPATHIC MANIAC"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; B " + RedPoints + "/2000"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
			If RedPoints>2000
				Text 0,48,"LEEEROYYY JENKINS!!!"
				SetFont FontCalibri40
				Text 800,0,"Red's Rank; A " + RedPoints + "/INFINITY"
				Text 800,24,"Blue's Rank; L"
				SetFont FontVerdana
			EndIf
		EndIf
		
		
		
		If BluePoints>RedPoints And w=0
			If BluePoints>=0 And BluePoints<51
				Text 0,48,"Blue is winning"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; L " + BluePoints + "/50"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>50 And BluePoints<101
				Text 0,48,"Meh"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; K " + BluePoints + "/100"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>100 And BluePoints<151
				Text 0,48,"Better"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; J " + BluePoints + "/150"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>150 And BluePoints<201
				Text 0,48,"Blue is on a roll."
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; I " + BluePoints + "/200"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>200 And BluePoints<301
				Text 0,48,"Blue is on a roll!"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; H " + BluePoints + "/300"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>300 And BluePoints<401
				Text 0,48,"SNAP!"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; G " + BluePoints + "/400"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>400 And BluePoints<601
				Text 0,48,"Red IS FAILING"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; F " + BluePoints + "/600"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>600 And BluePoints<801
				Text 0,48,"Blue is GODLIKE!"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; E " + BluePoints + "/800"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>800 And BluePoints<1001
				Text 0,48,"Blue is BEYOND GODLIKE!!!"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; D " + BluePoints + "/1000"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>1000 And BluePoints<1401
				Text 0,48,"SOMEONE KILL BLUE"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; C " + BluePoints + "/1400"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>1400 And BluePoints<2001
				Text 0,48,"RAGING PYSCOPATHIC MANIAC"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; B " + BluePoints + "/2000"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
			If BluePoints>2000
				Text 0,48,"LEEEROYYY JENKINS!!!"
				SetFont FontCalibri40
				Text 800,0,"Blue's Rank; A " + BluePoints + "/INFINITY"
				Text 800,24,"Red's Rank; L"
				SetFont FontVerdana
			EndIf
		EndIf

		RedPointsToWin=inputline-RedPlayerScore
		BluePointsToWin=inputline-BluePlayerScore
			
		Text 0,72,"Blue needs " + BluePointsToWin + " more points to win"
		Text 0,84,"Red needs " + RedPointsToWin + " more points to win"
		
		If KeyHit(25)
			Text 0,24,"Paused"
			FlushKeys
			Repeat
			Until KeyHit=0 And KeyDown=0
			Delay 300
			WaitKey()
		EndIf
		
		If RedPlayerScore=>inputline
			FlushKeys
			Cls
			For thewall.wall=Each wall
				FreeEntity thewall\wallhandle
			Next
			FreeEntity cam
			FreeEntity cam2
			If pike<>0
				FreeEntity pike
			EndIf
			If GhostAutoReplaceTimer=1 Or GhostWaitReplaceTimer=1
				If ghost<>0
					FreeEntity ghost
				EndIf
			EndIf
			If pudding <> 0
				FreeEntity pudding
			EndIf
		
			CameraViewport cam3,0,0,1300,650
			While Not KeyHit(28)
				PositionEntity player,-1,-7,20
				PositionEntity playerenemy,-1,3,20
				TurnEntity player,.1,.2,.3
				TurnEntity playerenemy,.1,.2,.3
		
				UpdateWorld
				RenderWorld
		
				ws=1
				w=1
				DrawImage win,530,70
				DrawImage lose,480,400
				Flip
			Wend
			FreeEntity player
			FreeEntity playerenemy
			FreeEntity cam3
			;Goto top
			;load
		EndIf
		
		If BluePlayerScore=>inputline
			FlushKeys
			Cls
			For thewall.wall=Each wall
				FreeEntity thewall\wallhandle
			Next
			FreeEntity cam
			FreeEntity cam2
			If pike<>0
				FreeEntity pike
			EndIf
			If GhostAutoReplaceTimer=1 Or GhostWaitReplaceTimer=1
				If ghost<>0
					FreeEntity ghost
				EndIf
			EndIf
			If pudding<>0
				FreeEntity pudding
			EndIf
		
			CameraViewport cam3,0,0,1300,650
			While Not KeyHit(28)
				PositionEntity player,-1,3,20
				PositionEntity playerenemy,-1,-7,20
				TurnEntity player,.1,.2,.3
				TurnEntity playerenemy,.1,.2,.3
				UpdateWorld
				RenderWorld
				ws=1
				w=1
				DrawImage win,530,70
				DrawImage lose,480,400
				Flip
			Wend
			FreeEntity player
			FreeEntity playerenemy
			FreeEntity cam3
			;Goto top
			;load
		EndIf
		
		If EntityX(Player) > levelx-1 Or EntityX(Player) < (levelx*-1)-1 Or EntityY(Player) > levely+1 Or EntityY(Player) < (levely*-1)+1
			PositionEntity Player,spawnbluex,spawnbluey,30
			EntityAlpha player,1
			EntityType Player,1
		EndIf
		
		If EntityX(Playerenemy) > levelx-1 Or EntityX(Playerenemy) < (levelx*-1)-1 Or EntityY(Playerenemy) > levely+1 Or EntityY(Playerenemy) < (levely*-1)+1
			PositionEntity Playerenemy,spawnredx,spawnredy,30
			EntityAlpha playerenemy,1	
			EntityType Playerenemy,1
		EndIf
		
		PositionEntity player,EntityX(player),EntityY(player),30
		PositionEntity playerenemy,EntityX(playerenemy),EntityY(playerenemy),30	
		
		Flip
		
		TimeWithGhost=TimeWithGhost+1
		TimeWithPudding=TimeWithPudding+1
		bggq#=bggq#+1
		gob=1
End Function