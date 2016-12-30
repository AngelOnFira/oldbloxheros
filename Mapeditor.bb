Graphics3D 800,600,16,2
SetBuffer BackBuffer()

Global fileout,w,ao#,e,save,bsave,dsave,as,blocko,tex

cam=CreateCamera()
light=CreateLight()
blocko=CreateCube()
tex=LoadTexture("Media/mark.png")

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
Function mapStart()
	Print "Press 'l' To load and 'n' For a new progect"
	ye=ye+12
	Repeat
		q=GetKey()
	Until q=108 Or q=110
	
	If q=108
		BHlvlfilen$=Input("What is the file name? (Do NOT include .BHME) ")
		ye=ye+12
		BHlvlfile=OpenFile("Maps/Map Editor/"+BHlvlfilen+".BHME")
		If BHlvlfile=0
			ye=ye+12
			Locate 0,ye
			Print "Error 1; File could not be found"
			ye=ye+24
			Delay 300
			Locate 0,ye
			Goto startq
		EndIf
	
		If BHlvlfile<>0
			SeekFile(BHlvlfile,1)
			n#=ReadLine$(BHlvlfile)
			x#=ReadLine$(BHlvlfile)
			y#=ReadLine$(BHlvlfile)
		EndIf
		
		If x=>0
			x="-"+x+""
		EndIf
		w=x
		e=y
		If e=>0
			e="-"+e+""
		EndIf
		
		picd$=ReadLine$(BHlvlfile)
		
		num#=4
		;Stop
		Repeat
			theblock.block=New block
			theblock\blockHandle=CopyEntity(blocko)
		
			picd$=ReadLine$(BHlvlfile)
		
			theblock\picked=picd
		
			If theblock\picked=1
				EntityColor theblock\blockHandle,0,255,0
			EndIf
		
			PositionEntity theblock\blockHandle,x,y,30
			x=x+2
			If x=Abs(w) And y<>e
				x=w
				y=y-2
			EndIf
			EntityTexture theblock\blockHandle,tex
			EntityPickMode theblock\blockHandle,3
		Until x=w And y=e
	ElseIf q=110
		Repeat
			x=Input("What is the X value? (Horizontal) ")
		Until x<>0
		If x=>0
			x="-"+x+""
		EndIf
		w=x
		Repeat
			y=Input("What is the Y value? (Vertical) ")
		Until y<>0
		e=y
		If e=>0
			e="-"+e+""
		EndIf
	
		Repeat
			theblock.block=New block
			theblock\blockHandle=CopyEntity(blocko)
			theblock\picked=0
			
			If theblock\picked=1
				EntityColor theblock\blockHandle,0,255,0
			EndIf
			
			PositionEntity theblock\blockHandle,x,y,30
			x=x+2
			If x=Abs(w) And y<>e
				x=w
				y=y-2
			EndIf
			EntityTexture theblock\blockHandle,tex
			EntityPickMode theblock\blockHandle,3
			
		Until x=w And y=e
		Cls
		
		FreeEntity blocko
	EndIf
End Function

Function mapMain()
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
						EntityTexture theblock\blockHandle,tex
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
				EntityTexture theblock\blockHandle,tex
			EndIf
		Next
		
		UpdateWorld
		RenderWorld
		Color 255,255,0
		If PickedEntity()>1
			Text 0,0,""+Int(EntityX(PickedEntity()))+","+Int(EntityY(PickedEntity()))+""
		EndIf
		
		Text 0,12,"Press esc to save"
		Color 255,255,255
		Flip
	Wend
End Function

Cls
Flip

Locate 0,0

Function manSave()
	Repeat
		Border=Input$("Do you want to the program to auto add a border? (1 for yes, 2 for no) ")
		If Border="1"
			blocko=CreateCube()
			absw=Abs(w)
			abse=Abs(e)
			ab1sw=absw*(-1)-2
			ab1se=abse*(-1)
			abse=abse+2
			absw=absw-2
			
			Repeat
				Border(ab1sw,abse)
				abse=abse-2
			Until abse=ab1se-2
			
			abse=Abs(e)+2
			absw=Abs(w)
			ab1sw=absw*(-1)
			ab1se=abse*(-1)
			
			Repeat
				Border(absw,abse)
				abse=abse-2
			Until abse=ab1se
			
			abse=Abs(e)+2
			absw=Abs(w)
			ab1sw=absw*(-1)
			ab1se=abse*(-1)
			
			Repeat
				Border(ab1sw,abse)
				ab1sw=ab1sw+1
			Until ab1sw=absw
			
			abse=Abs(e)
			absw=Abs(w)
			ab1sw=absw*(-1)
			ab1se=abse*(-1)
			
			Repeat
				Border(ab1sw,ab1se)
				ab1sw=ab1sw+2
			Until ab1sw=absw
			
		EndIf
		
	Until Border="1" Or Border="2"
	
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
		dr$=WaitKey()
	Until dr$=49 Or dr$=50 Or dr$=51
	If dr=49
		fileout=WriteFile("Maps/Map Editor/"+in$+".BHME")
		
		save
		
		WriteLine(fileout,""+as+"")
		
		Locate 0,36
		dt=36
		
		Cls
		For theblock.block=Each block
			Text 0,0,"Saving..."
			If theblock\picked=1
				WriteLine(fileout,"1")
			ElseIf theblock\picked=0
				WriteLine(fileout,"0")
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
	
	If dr=50
		fileout=WriteFile("Maps/Blox Heros/"+in$+".BHlvl")
		save
		
		as=as-1
		WriteLine(fileout,""+as+"")
		
		Cls
		For d.save=Each save
			WriteLine(fileout,""+d\bsave+"")
			WriteLine(fileout,""+d\csave+"")
			Text 0,0,"Saving...
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
	
	If dr=51
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
End Function

Function save()
	Cls
	WriteLine(fileout,"This is the savefile of your map.") 
	WriteLine(fileout,""+Abs(w)+"")
	WriteLine(fileout,""+Abs(e)+"")
	
	For theblock.block=Each block
		Text 0,0,"Saving..."
		If theblock\picked=1
		theblock\fcx=EntityX(theblock\blockHandle)
		theblock\fcy=EntityY(theblock\blockHandle)
		as=as+1
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
	EntityTexture theblock\blockHandle,tex
	EntityPickMode theblock\blockHandle,3
	Cls
End Function
;~IDEal Editor Parameters:
;~C#Blitz3D