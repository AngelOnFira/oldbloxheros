	Graphics3D 800,600,16,2
	SetBuffer BackBuffer()
	
	Global fileout,OppositeX,ao#,OppositeY,save,bsave,dsave,WritingOut,blocko,BlockTexture
	Global temp,temp1,temp2,temp3,isborder
	
	cam=CreateCamera()
	light=CreateLight()
	blocko=CreateCube()
	BlockTexture=LoadTexture("Media/mark.png")
	
Type spawn
	Field p1x
	Field p1y
	Field p2x
	Field p2y
End Type
	
Type block
	Field blockhandle
	Field picked
	Field fcx
	Field fcy
End Type
	
Type save
	Field bsave
	Field csave
End Type
	
	.startq
	ytextposition=0
	Print "Press 'l' To load and 'n' For a new progect"
	ytextposition=ytextposition+12
	Repeat
		StartGetKey=GetKey()
	Until StartGetKey=108 Or StartGetKey=110
	
	If StartGetKey=108
	
		Folder$= CurrentDir$() + "Maps\Map Editor"
		thisdir=ReadDir(Folder$)
		Locate 0,72
		File$=NextFile(thisdir)
		File$=NextFile(thisdir)
		Repeat
		
			File$=NextFile(thisdir)
			If File="" Then Exit
			
			Print File
			
		Forever
		
		Locate 0,12
		BHlvlfilen$=Input("What is the file name? (Do NOT include .BHME) ")
		ytextposition=ytextposition+12
		BHlvlfile=OpenFile("Maps/Map Editor/"+BHlvlfilen+".BHME")
		If BHlvlfile=0
			ytextposition=ytextposition+12
			Locate 0,ytextposition
			Print "Error 1; File could not be found"
			ytextposition=ytextposition+24
			Print "Press any key to continue"
			WaitKey()
			cls
			Locate 0,0
			Goto startq
		EndIf
	
		If BHlvlfile<>0
			SeekFile(BHlvlfile,1)
			Crapline=ReadLine$(BHlvlfile)
			LoadedMapX#=ReadLine$(BHlvlfile)
			LoadedMapY#=ReadLine$(BHlvlfile)
		EndIf
		
		If LoadedMapX=>0
			LoadedMapX="-"+LoadedMapX+""
		EndIf
			OppositeX=LoadedMapX
			OppositeY=LoadedMapY
		If OppositeY=>0
			OppositeY="-"+OppositeY+""
		EndIf
		
		picd$=ReadLine$(BHlvlfile)
		
		num#=4
		Repeat
			theblock.block=New block
			theblock\blockHandle=CopyEntity(blocko)
			
			picd$=ReadLine$(BHlvlfile)
			
			theblock\picked=picd
			
			If theblock\picked=1
				EntityColor theblock\blockHandle,0,255,0
			EndIf
			
			If theblock\picked=2
				EntityColor theblock\blockHandle,0,0,255
			EndIf
			
			If theblock\picked=3
				EntityColor theblock\blockHandle,255,0,0
			EndIf
			
			PositionEntity theblock\blockHandle,LoadedMapX,LoadedMapY,30
			LoadedMapX=LoadedMapX+2
			If LoadedMapX=Abs(OppositeX) And LoadedMapY<>OppositeY
				LoadedMapX=OppositeX
				LoadedMapY=LoadedMapY-2
			EndIf
			EntityTexture theblock\blockHandle,BlockTexture
			EntityPickMode theblock\blockHandle,3
		Until LoadedMapX=OppositeX And LoadedMapY=OppositeY
		
		;s.spawn=first spawn
		For t.block = Each block
		
			If EntityX(t\blockhandle) = temp And EntityY(t\blockhandle) = temp1
				EntityColor t\blockhandle,0,0,255
				Print t\blockhandle
				WaitKey()
			EndIf
			
			If EntityX(t\blockhandle) = temp2 And EntityY(t\blockhandle) = temp3
				EntityColor t\blockhandle,255,0,0
				Print t\blockhandle
				WaitKey()
			EndIf
		Next
	
	ElseIf StartGetKey=110
		Repeat
			LoadedMapX=Input("What is the X value? (Horizontal) ")
		Until LoadedMapX<>0
		If LoadedMapX=>0
			LoadedMapX="-"+LoadedMapX+""
		EndIf
		OppositeX=LoadedMapX
		Repeat
			LoadedMapY=Input("What is the Y value? (Vertical) ")
		Until LoadedMapY<>0
		OppositeY=LoadedMapY
		If OppositeY=>0
			OppositeY="-"+OppositeY+""
		EndIf
	
		Repeat
			theblock.block=New block
			theblock\blockHandle=CopyEntity(blocko)
			theblock\picked=0
			
			If theblock\picked=1
				EntityColor theblock\blockHandle,0,255,0
			EndIf
			
			PositionEntity theblock\blockHandle,LoadedMapX,LoadedMapY,30
			LoadedMapX=LoadedMapX+2
			If LoadedMapX=Abs(OppositeX) And LoadedMapY<>OppositeY
				LoadedMapX=OppositeX
				LoadedMapY=LoadedMapY-2
			EndIf
			EntityTexture theblock\blockHandle,BlockTexture
			EntityPickMode theblock\blockHandle,3
		Until LoadedMapX=OppositeX And LoadedMapY=OppositeY
		Cls
		
		FreeEntity blocko
	EndIf
	
	.make
	
	While Not KeyHit(1)
		Cls
		
		If KeyDown(30)
			MoveEntity cam,0,0,1
		EndIf
		If KeyDown(44)
			MoveEntity cam,0,0,-1
		EndIf
			If KeyDown(203)
			MoveEntity cam,1,0,0
		EndIf
		If KeyDown(208)
			MoveEntity cam,0,1,0
		EndIf
		If KeyDown(205)
			MoveEntity cam,-1,0,0
		EndIf
		If KeyDown(200)
			MoveEntity cam,0,-1,0
		EndIf
		
		CameraPick(cam,MouseX(),MouseY())
		For theblock.block=Each block
			If PickedEntity()=theblock\blockHandle
				If MouseHit(1)
					If theblock\picked=0
						theblock\picked=1
					Else
						EntityColor theblock\blockhandle,255,255,255
						EntityTexture theblock\blockHandle,BlockTexture
						theblock\picked=0
					EndIf
				EndIf
			EndIf
		Next
		
		For theblock.block=Each block
			If theblock\picked=1
				EntityColor theblock\blockHandle,0,255,0
			ElseIf theblock\picked=0
				EntityColor theblock\blockhandle,255,255,255
				EntityTexture theblock\blockHandle,BlockTexture
			EndIf
		Next
		
		UpdateWorld
		RenderWorld
		;Line 0,50,800,50
		Color 255,255,0
		If PickedEntity()>1
			Text 0,0,""+Int(EntityX(PickedEntity()))+","+Int(EntityY(PickedEntity()))+""
		EndIf
		
		Text 0,12,"Press esc to add spawn points"
		Color 255,255,255
		Flip
		
		If ao=1 Goto here
	
	Wend
	
	.spawnd
	spnyd2=0
	spnxd=0
	spnyd=0
	
	While Not KeyHit(1) Or spnyd2=1
		Repeat
			Text 0,0,"Click to add the Blue player's spawn point"
			CameraPick(cam,MouseX(),MouseY())
			For theblock.block=Each block
				If PickedEntity()=theblock\blockHandle
					If MouseHit(1)
						theblock\picked=2
						EntityColor theblock\blockhandle,0,0,255
						spnxd=1
					EndIf
				EndIf
			Next
			;CameraPick(cam,MouseX(),MouseY())
			;For theblock.block=Each block
			;	;EntityColor theblock\blockHandle,200,20,20
			;	If PickedEntity()=theblock\blockHandle
			;		If MouseHit(1)
			;			s.spawn=New spawn
			;			s\p1x=EntityX(PickedEntity())
			;			s\p1y=EntityY(PickedEntity())
			;			EntityColor PickedEntity(),0,0,255
			;			spnxd=1
			;		EndIf
			;	EndIf
			;Next
			
			Flip
			
			UpdateWorld
			RenderWorld
		Until spnxd=1
		
		Repeat
			Text 0,0,"Click to add the Red player's spawn point"
			CameraPick(cam,MouseX(),MouseY())
			For theblock.block=Each block
				If PickedEntity()=theblock\blockHandle
					If MouseHit(1)
						theblock\picked=3
						EntityColor theblock\blockhandle,255,0,0
						spnyd=1
					EndIf
				EndIf
			Next
			
			;CameraPick(cam,MouseX(),MouseY())
			;For theblock.block=Each block
				;EntityColor theblock\blockHandle,200,20,20
			;	If PickedEntity()=theblock\blockHandle
			;		If MouseHit(1)
			;			s.spawn=first spawn
			;			s\p2x=EntityX(PickedEntity())
			;			s\p2y=EntityY(PickedEntity())
			;			EntityColor PickedEntity(),255,0,0
			;			spnyd=1
			;		EndIf
			;	EndIf
			;Next
			
			Flip
			
			UpdateWorld
			RenderWorld
		Until spnyd=1
		
		Repeat
			Text 0,0,"If you wish to re-add the spawn points, press 'r'.
			Text 0,12,"Press esc To continue And save, If you want To re-edit the map, press 'm'"
			
			If KeyHit(19)
				FlushKeys()
				frh=1
				spnyd=0
				spnxd=0
				For theblock.block=Each block
					If theblock\picked=2
						theblock\picked=0
						EntityTexture theblock\blockhandle,BlockTexture
					ElseIf theblock\picked=3
						theblock\picked=0
						EntityTexture theblock\blockhandle,BlockTexture
					EndIf
				Next
				ao=1
				Goto make
				.here
				ao=0
				Goto spawnd
			EndIf
			
			If KeyHit(50)
				FlushKeys()
				spnyd=0
				spnxd=1
				Goto make
				Flip
			EndIf
			
			If KeyHit(1)
				Goto Exits
			EndIf
			
			Flip
			UpdateWorld
			RenderWorld
		Forever
	Wend
	
	.Exits

	;-----SAVING-----
	Cls
	Flip
	
	Locate 0,0
	
	Repeat
		border=Input$("Do you want to the program to auto add a border? (1 for yes, 2 for no) ")
		;Stop
		If border="1"
			blocko=CreateCube()
			absw=Abs(OppositeX)
			abse=Abs(OppositeY)
			ab1sw=absw*(-1)-2
			ab1se=abse*(-1)
			;Repeat
			abse=abse+2
			absw=absw-2
			isborder=1
			
			Repeat
				border(ab1sw,abse)
				abse=abse-2
			Until abse=ab1se-2
			
			abse=Abs(OppositeY)+2
			absw=Abs(OppositeX)
			ab1sw=absw*(-1)
			ab1se=abse*(-1)
			
			Repeat
				border(absw,abse)
				abse=abse-2
			Until abse=ab1se
			
			abse=Abs(OppositeY)+2
			absw=Abs(OppositeX)
			ab1sw=absw*(-1)
			ab1se=abse*(-1)
			
			Repeat
				border(ab1sw,abse)
				ab1sw=ab1sw+1
			Until ab1sw=absw
			
			abse=Abs(OppositeY)
			;abse=abse+2
			absw=Abs(OppositeX)
			ab1sw=absw*(-1)
			ab1se=abse*(-1)
			
			Repeat
				border(ab1sw,ab1se)
				ab1sw=ab1sw+2
			Until ab1sw=absw
			
		EndIf
		
	Until border="1" Or border="2"
	
	Cls
	
	Locate 0,0
	Repeat
		in$=Input$("What do you want to call this file? ")
		test=OpenFile("Maps/Blox Heros/"+in+".BHlvl")
		test2=OpenFile("Maps/Map Editor/"+in+".BHME")
		If test<>0 Or test2<>0
			Print "There is already a file with that name. (Press 1 to overwrite, and 2 to re-name)"
			FlushKeys
			ctr=0
			While Not ctr=49 Or ctr=50
				ctr=GetKey()
			Wend
		EndIf
	Until ctr<>50
	.o3
	Print "Press 1 to save as .BHME, 2 to export it as .BHlvl, and 3 if you need to know the difference "
	Repeat
		KeyForSave$=WaitKey()
		;KeyForSave$=GetKey()
	Until KeyForSave$=49 Or KeyForSave$=50 Or KeyForSave$=51
	;Stop
	
	If KeyForSave=49
		fileout=WriteFile("Maps/Map Editor/"+in$+".BHME")
	
		save(0,border)
	
		;WritingOut=WritingOut-1
		WriteLine(fileout,""+WritingOut+"")
	
		Locate 0,36
		dt=36
	
		;For d.save=Each save
		Cls
		For theblock.block=Each block
			Text 0,0,"Saving..."
			Flip
			If theblock\picked=1
				WriteLine(fileout,"1")
			ElseIf theblock\picked=0
				WriteLine(fileout,"0")
			ElseIf theblock\picked=2
				WriteLine(fileout,"2")
			ElseIf theblock\picked=3
				WriteLine(fileout,"3")
			EndIf
		Next
		Cls
		Locate 0,0
		Print "...Saved"
		While Not KeyHit(1)
			Text 0,12,"Press esc to close"
		Wend
	
		CloseFile(fileout)
	EndIf
	
	If KeyForSave=50
		fileout=WriteFile("Maps/Blox Heros/"+in$+".BHlvl")
		
		save(49,border)
	
		;WritingOut=WritingOut
		WriteLine(fileout,""+WritingOut+"")
	
		Cls
		For d.save=Each save
			;For theblock.block=Each block
			WriteLine(fileout,""+d\bsave+"")
			WriteLine(fileout,""+d\csave+"")
			Text 0,0,"Saving..."
			Flip
		Next
	
		yy=24
	
		Cls
		Locate 0,0
		Print "...Saved"
		While Not KeyHit(1)
			Text 0,12,"Press esc to close"
		Wend
	
		CloseFile(fileout)
	EndIf
	
	If KeyForSave=51
		FlushKeys
		Print "..."
		Print "Pick the save option if you want to re-edit the map again."
		Print "This can only be opened with the map editor. If you wanted to"
		Print "Play it with Blox heros, you would choose to export it."
		Print "Press enter to contiue"
		Print "..."
		While Not KeyHit(28)
			Flip
		Wend
		Cls
		Text 0,0,"What do you want to call this file? "+in+""
		Locate 0,12
		Goto o3
	EndIf
	
	;For theblock.block=Each block
	;FreeEntity theblock\blockHandle
	;Delete theblock
	;Next

	;While Not KeyHit(1)
	;Wend

Function save(key,border)
	Cls
	If borber=1
		WriteLine(fileout,"This is the savefile of your map.") 
		WriteLine(fileout,""+(Abs(OppositeX)+2)+"")
		WriteLine(fileout,""+(Abs(OppositeY)+2)+"")
	Else
		WriteLine(fileout,"This is the savefile of your map.") 
		WriteLine(fileout,""+Abs(OppositeX)+"")
		WriteLine(fileout,""+Abs(OppositeY)+"")
	EndIf
	;s.spawn=First spawn
	;Print s\p1x
	;Print s\p1y
	;Print s\p2x
	;Print s\p2y
	;WaitKey()
	;WriteLine(fileout,""+s\p1x+"")
	;WriteLine(fileout,""+s\p1y+"")
	;WriteLine(fileout,""+s\p2x+"")
	;WriteLine(fileout,""+s\p2y+"")
	
	Stop
	If key=49
	Stop
		For theblock.block=Each block
			Text 0,0,"Saving..."
			If theblock\picked=2
			Stop
				WriteLine(fileout,""+EntityX(theblock\blockHandle)+"")
				WriteLine(fileout,""+EntityY(theblock\blockHandle)+"")
			EndIf
		Next
		For theblock.block=Each block
			Text 0,0,"Saving..."
			If theblock\picked=3
				WriteLine(fileout,""+EntityX(theblock\blockHandle)+"")
				WriteLine(fileout,""+EntityY(theblock\blockHandle)+"")
			EndIf
		Next
	EndIf
	
	For theblock.block=Each block
		Text 0,0,"Saving..."
		If theblock\picked=1
			theblock\fcx=EntityX(theblock\blockHandle)
			theblock\fcy=EntityY(theblock\blockHandle)
			WritingOut=WritingOut+1
			d.save=New save
			d\bsave=theblock\fcx
			d\csave=theblock\fcy
		EndIf
	Next
End Function

Function Border(abswp,absep)
	theblock.block=New block
	theblock\blockHandle=CopyEntity(blocko)
	theblock\picked=1

	If theblock\picked=1
		EntityColor theblock\blockHandle,0,255,0
	EndIf

	PositionEntity theblock\blockHandle,abswp,absep,30
	EntityTexture theblock\blockHandle,BlockTexture
	EntityPickMode theblock\blockHandle,3
	Cls

End Function