Graphics3D 1300,650,16,2

SetBuffer BackBuffer()
Global top
.top
SeedRnd MilliSecs()
Global FontComicSansMs=LoadFont("Comic sans",18,1)
Global FontCalibri=LoadFont("Calibri",22,1)
Global FontVerdana=LoadFont("Verdana",22,0,0)
Global FontCalibri40=LoadFont("Calibri",40)
imagex=LoadImage("media/x.png")
MaskImage imagex,255,174,201
imageyes=LoadImage("media/right.png")
MaskImage imageyes,255,174,201
Global frametimer=CreateTimer(50), frametimer2=CreateTimer(60)
Global ghost,GhostTimer,GhostWaitReplaceTimer,GhostAutoReplaceTimer,TimeWithGhost,cube,cam4,cam,cam2,cam3
Global TimeToRemakePudding,pudding,TimeWithPudding,ConditionRemakePudding,WhoHasPudding,fvfq,win,lose,wallt,dd,xsw#,nsb,blockview#,inputline2w
Global bggq#,frfqq#,cdeq#,fvfqq#,seq#,BluePlayerScore,RedPlayerScore,xo,inputline
Global walls,box1,box2,box3,box4,start,tyu,logosp,gob,ap,ya
Global ba=28,nosee1,pudding1,ghost1,sclick,senter
Global bullett=CreateSphere()
Global moveplayerblue,speedplayerblue,moveplayerred,speedplayerred
HideEntity bullett


;---Types---

Type help
	Field entitys
End Type

Type bullet
	Field bullethandle
End Type

Type wall
	Field wallhandle
End Type

Include "load3dworld.bb"
Global pike,player,playerenemy
;-------Hosting-------
load
.starte
;FreeEntity cube
;cam=0
;cam2=0
;cam3=0

Cls
Locate 0,0
Color 255,255,255
SetFont FontVerdana
		
Cls
g=0
j=0
h=0
;x=1
ent2=1
wll=2
RedPlayerScore=0
BluePlayerScore=0
GhostWaitReplaceTimer=0
GhostTimer=0
GhostAutoReplaceTimer=0
TimeWithGhost=0
TimeToRemakePudding=0
pudding=0
TimeWithPudding=0
ConditionRemakePudding=0
WhoHasPudding=0
fvfq=0
wallt=0
dd=0
xsw#=0
nsb=0
blockview=0
bggq=0
frfqq=0
cdeq=0
fvfqq=0
seq=0
i=0
;o=0
;tyu=0

load3Dworld()

	;Get map to play
	While mapdata=0
	
	Folder$="C:\Users\Forest\Desktop\Stuffed\Blitz Saves\Blox Heros + Map Editor\Maps\Blox Heros"
	thisdir=ReadDir(Folder$)
	Locate 0,60
		
	Repeat
		File$=NextFile(thisdir)
		If File="" Then Exit
		Print File
	Forever
		
	Locate 0,0
	mapname$=Input$("What is the name of the map you wish to play? (Do not add .BHlvl) ")
		
	mapdata=0
	
		mapdata=OpenFile("Maps/Blox Heros/"+mapname$+".BHlvl")
		If mapdata=0
			mapdata=OpenFile("Maps/"+mapname$+".BHlvl")
		EndIf
		If mapdata=0
			Print "That is not a valid map"
			Print "Press any key to continue"
			WaitKey
			Stop
		EndIf
		Cls
	Wend
			
	walls=CreateCube()		
			
	crap1=ReadLine(mapdata)
	crap1=ReadLine(mapdata)
	crap1=ReadLine(mapdata)
	timestr=ReadLine(mapdata)

	g=Rnd(100)
	h=Rnd(40)
	j=Rnd(40)
	
	;Loading walls loop
	For t= 0 To timestr
		thewall.wall=New wall
		thewall\wallhandle=CopyEntity(walls)		
		
		;walln\wao=walls
		
		x=ReadLine(mapdata)
		RedPlayerScore=ReadLine(mapdata)
		
		
		PositionEntity thewall\wallhandle,x,RedPlayerScore,30
		EntityType thewall\wallhandle,2
		EntityColor thewall\wallhandle,g,h,j
		
		If g>150
			BluePlayerScore=1
		ElseIf h>170
			i=1
		ElseIf j>170
			o=1
		EndIf
		
		
		If BluePlayerScore=1
			g=g-1
		ElseIf BluePlayerScore=0
			g=g+1
		EndIf
		
		If i=1
			h=h-1
		ElseIf i=0
			h=h+1
		EndIf
		
		If o=1
			j=j-1
		ElseIf o=0
			j=j+1
		EndIf
	Next
		
	FreeEntity walls
	FlushKeys
	Cls
		
	SetBuffer BackBuffer()
		
	While Not KeyHit(28) And inputline=>1000 And inputline<=99999999
		Cls
		Locate 390,350
		as=GetKey()
		ase$=Chr$(as)
		Rect 656,348,79,26,0
		inputline=inputline+""+Chr$(as)+""
		
		If as=8
			If Len(inputline)>0 Then inputline=Left$(inputline,Len(inputline)-1)
		EndIf
		
		If inputline>99999999
			inputline=Left$(inputline,Len(inputline)-1)
		EndIf
		
		If inputline<1000
			DrawImage imagex,740,340
		ElseIf inputline=>1000 And inputline<=99999999
			DrawImage imageyes,740,340
		EndIf
		
		Print "What is the score to play to?"
		Locate 600,375
		Print "Must be at least 1000"
		
		Locate 657,350
		Print Inputline
		;as=Input$("What is the winning score?   ")
		;DrawImage logo,0,0
		
		Flip
		Delay 20
	Wend
		
	Cls
		
	While Not KeyHit(1)
	
		Game()
		
	Wend
	
	PositionEntity Player,0,2,30
	PositionEntity Playerenemy,0,-2,30
	RedPlayerScore=0
	BluePlayerScore=0
	RedPoints=0
	BluePoints=0
	TimeWithGhost=0
	TimeWithPudding=0
	Locate 0,0
	Cls
	For thewall.wall=Each wall
		FreeEntity thewall\wallhandle
	Next
	
	;FreeEntity cam
	;FreeEntity cam2
	;FreeEntity pike
	;FreeEntity player
	;FreeEntity playerenemy
	;FreeEntity cam3
	;FreeEntity ghost
	;FreeEntity pudding
	
	Goto top
		
	.Map1
	Data -29,21
	Data -29,19
	Data -29,17
	Data -29,15
	Data -29,13
	Data -29,11
	Data -29,9
	Data -29,7
	Data -29,5
	Data -29,3
	Data -29,1
	Data -29,-1
	Data -29,-3
	Data -29,-5
	Data -29,-7
	Data -29,-9
	Data -29,-11
	Data -29,-13
	Data -29,-15
	Data -29,-17
	Data -29,-19
	Data -29,-21
	;22
	Data -28,21
	Data -28,-21
	;1
	Data -26,21
	Data -26,-21
	;1
	Data -24,21
	Data -24,8
	Data -24,6
	Data -24,4
	Data -24,-4
	Data -24,-6
	Data -24,-8
	Data -24,-21
	;9
	Data -22,21
	Data -22,14
	Data -22,12
	Data -22,10
	Data -22,-10
	Data -22,-12
	Data -22,-14
	Data -22,-21
	;6
	Data -20,21
	Data -20,-21
	;2
	Data -18,21
	Data -18,6
	Data -18,4
	Data -18,-4
	Data -18,-6
	Data -18,-21
	;7
	Data -16,21
	Data -16,10
	Data -16,8
	Data -16,6
	Data -16,-6
	Data -16,-8
	Data -16,-10
	Data -16,-21
	;7
	Data -14,21
	Data -14,-21
	;1
	Data -12,21
	Data -12,-21
	;1
	Data -10,21
	Data -10,6
	Data -10,4
	Data -10,2
	Data -10,0
	Data -10,-2
	Data -10,-4
	Data -10,-6
	Data -10,-21
	;7
	Data -8,21
	Data -8,12
	Data -8,-12
	Data -8,-21
	;2
	Data -6,21
	Data -6,12
	Data -6,-12
	Data -6,-21
	;2
	Data -4,21
	Data -4,12
	Data -4,4
	Data -4,2
	Data -4,0
	Data -4,-2
	Data -4,-4
	Data -4,-12
	Data -4,-21
	;7
	Data -2,21
	Data -2,0
	Data -2,-21
	;1
	Data 0,21
	Data 0,16
	Data 0,8
	Data 0,0
	Data 0,-8
	Data 0,-16
	Data 0,-21
	;7
	Data 2,21
	Data 2,0
	Data 2,-21
	;1
	Data 4,21
	Data 4,12
	Data 4,4
	Data 4,2
	Data 4,0
	Data 4,-2
	Data 4,-4
	Data 4,-12
	Data 4,-21
	;7
	Data 6,21
	Data 6,12
	Data 6,-12
	Data 6,-21
	;2
	Data 8,21
	Data 8,12
	Data 8,-12
	Data 8,-21
	;2
	Data 10,21
	Data 10,6
	Data 10,4
	Data 10,2
	Data 10,0
	Data 10,-2
	Data 10,-4
	Data 10,-6
	Data 10,-21
	;7
	Data 12,21
	Data 12,-21
	;1
	Data 14,21
	Data 14,-21
	;1
	Data 16,21
	Data 16,10
	Data 16,8
	Data 16,6
	Data 16,-6
	Data 16,-8
	Data 16,-10
	Data 16,-21
	;7
	Data 18,21
	Data 18,6
	Data 18,4
	Data 18,-4
	Data 18,-6
	Data 18,-21
	;7
	Data 20,21
	Data 20,-21
	;2
	Data 22,21
	Data 22,14
	Data 22,12
	Data 22,10
	Data 22,-10
	Data 22,-12
	Data 22,-14
	Data 22,-21
	;6
	Data 24,21
	Data 24,8
	Data 24,6
	Data 24,4
	Data 24,-4
	Data 24,-6
	Data 24,-8
	Data 24,-21
	;9
	Data 26,21
	Data 26,-21
	;1
	Data 28,21
	Data 28,-21
	;1
	Data 29,21
	Data 29,19
	Data 29,17
	Data 29,15
	Data 29,13
	Data 29,11
	Data 29,9
	Data 29,7
	Data 29,5
	Data 29,3
	Data 29,1
	Data 29,-1
	Data 29,-3
	Data 29,-5
	Data 29,-7
	Data 29,-9
	Data 29,-11
	Data 29,-13
	Data 29,-15
	Data 29,-17
	Data 29,-19
	Data 29,-21
	
Function Activate()
	Locate 0,0
	readedfile=ReadFile("activation.dat")
	If readedfile=0
		file=WriteFile("activation.dat")
		a=Rnd(9)
		b=Rnd(9)
		c=Rnd(9)
		d=Rnd(9)
		WriteString(file,"0")
		WriteString(file,a)
		WriteString(file,b)
		WriteString(file,c)
		WriteString(file,d)
		CloseFile(file)
	EndIf
	If readedfile>0
		z=ReadString$(readedfile)
		x=1
		If x=z
			po=1
			Goto e
		EndIf
		a=ReadString$(readedfile)
		b=ReadString$(readedfile)
		c=ReadString$(readedfile)
		d=ReadString$(readedfile)
	EndIf
	
	q=(((a-5)*2)+10)
	w=(((b*2)*3)-5)
	e=(((c+2)*3)-8)
	r=(((d+3)*2)-7)
	numcoded$=""+a+""+b+""+c+""+d+""
	deco$=""+w+""+r+""+e+""+q+""
	.dot
	Print "The first time you click Activate in the game menu, this program will asign your computer a random number."
	Print "This number has to be sent to wizcardforest@gmail.com. This beta version is free, so AngelOnFira will send you back a number to enter bellow."
	Print "The coded number is " + numcoded + "."
	decoq$=Input$("What is the number you receved? ")
	If decoq$=deco$
		Print "Activation sussesful"
		Print "Thank you for registering"
		Print "To play, you need to restart the game. Press any key to end."
		po=1
		wq=WriteFile("High Scores.dat")
		WriteString(wq,"1")
		CloseFile(wq)
		WaitKey()
		End
	Else
		Print "Try again"
		Goto dot
	EndIf
	Print ""+numcoded$+", "+deco$+""
	WaitKey()
	.e
End Function

Function load()
	sclick=LoadSound("media/click.wav")
	senter=LoadSound("media/send.wav")
	Flushkeys
	logo=LoadImage("media/logo.png")
	MaskImage logo,255,255,255
	win=LoadImage("media/win.png")
	MaskImage win,255,255,255
	lose=LoadImage("media/lose.png")
	MaskImage lose,255,255,255
	e=LoadFont("Calibri",25)
	SetFont e
	y=0

	;logosp=LoadSprite("media/logo.png")
	;PositionEntity logosp,-6,4,10
	;ScaleSprite logosp,3,1

	box1=LoadSprite("Media/box.png")
	PositionEntity box1,y,1,10
	EntityPickMode box1,3
	ScaleSprite box1,.7,.7
	y=y-2

	box2=LoadSprite("Media/box.png")
	PositionEntity box2,y,3,10
	EntityPickMode box2,3
	ScaleSprite box2,.7,.7

	y=y+4
	box3=LoadSprite("Media/box.png")
	PositionEntity box3,y,-1,10
	EntityPickMode box3,3
	ScaleSprite box3,.7,.7

	box4=LoadSprite("Media/box.png")
	PositionEntity box4,4,-3,10
	EntityPickMode box4,3
	ScaleSprite box4,.7,.7

	cube=CreateCube()
	ScaleEntity cube,.4,.4,.4
	EntityColor cube,0,20,240

	cam4=CreateCamera()
	CameraViewport cam4,0,0,1300,650
	light=CreateLight()

	dwe=ReadFile("High Scores.dat")
	If dwe>0
	fde=ReadString$(dwe)
	EndIf

	While Not KeyHit(1) Or Exits=1 Or start=1 Or creds=1 Or help=1
		Flushkeys
		CameraPick(cam4,MouseX(),MouseY())

		exits=0
		start=0
		creds=0
		help=0

		If PickedEntity()=box1 And dwe=0
			PositionEntity cube,EntityX(box1)+4,EntityY(box1),10
			bf=1 
			If MouseHit(1) And PickedEntity()=box1 And dwe=0
				Cls
				Activate
			EndIf
		EndIf
		If PickedEntity()=box1 And dwe>0
			PositionEntity cube,EntityX(box1)+4,EntityY(box1),10
			bf=2
			If MouseHit(1) And PickedEntity()=box1 And dwe>0
				start=1
			EndIf
		EndIf
		If PickedEntity()=box2
			PositionEntity cube,EntityX(box2)+4,EntityY(box2),10
			bf=3
			If MouseHit(1) And PickedEntity()=box2
				End
			EndIf
		EndIf
		If PickedEntity()=box3
			PositionEntity cube,EntityX(box3)+4,EntityY(box3),10
			bf=4
			If MouseHit(1) And PickedEntity()=box3
				Cls
				vw=1
				creds
			EndIf
		EndIf
		If PickedEntity()=box4
			PositionEntity cube,EntityX(box4)+4,EntityY(box4),10
			bf=5
			If MouseHit(1)
				help
			EndIf
		EndIf

		If start=0
			TurnEntity cube,.1,.2,.3
		EndIf

		;RotateEntity logosp,.1,.1,.1

		UpdateWorld
		RenderWorld
		DrawImage logo,0,0
		Color 230,10,240

		Select bf

		Case 1
		Rect 601,211,99,99,0
		Case 2
		Rect 601,211,99,99,0
		Case 3
		Rect 471,81,99,99,0
		Case 4
		Rect 731,341,99,99,0
		Case 5
		Rect 861,471,99,99,0

		End Select

		If dwe=0
			SetFont FontComicSansMs
			Text 650,260,"Activate",True,True
			SetFont FontCalibri
		EndIf
		If dwe>0 And fde=1
			Text 650,260,"Start",True,True
		EndIf


		SetFont FontCalibri
		Text 910,520,"Help",True,True
		Text 520,130,"Exit",True,True
		Text 780,390,"Credits",True,True
		Flip
		If ShouldFlushMouse#=0
			FlushMouse
			ShouldFlushMouse#=ShouldFlushMouse#+1
		ElseIf ShouldFlushMouse#=>1
			ShouldFlushMouse#=ShouldFlushMouse#+1
		EndIf
		If ShouldFlushMouse#=8
			ShouldFlushMouse#=0
		EndIf

	Wend

	e=0
	y=0
	If tyu=0
		;cr cam4
		FreeEntity cam4
		FreeEntity light
		FreeEntity box1
		FreeEntity box2
		FreeEntity box3
		FreeEntity box4
		;Color 255,255,255
		tyu=1
	EndIf
End Function

Function creds()
	SystemFont=LoadFont("system",24)
	SetFont SystemFont
	Locate 0,0
	vw=1
	Color 255,255,0
	Repeat
		Restore dat
		Read Text$
		a$=Mid$(Text$,vw,1)
		If a$="{" Then
			b=1
		ElseIf y=224 And c>35 And a$=" "
			f=f+1
			Text 220,238,"Press Any Key To Continue"
			WaitKey()
			FlushMouse
			Cls
			Rect 190,190,450,75,0
			a$=""
			y=200
			c=0
			Locate 200,200
		ElseIf a$="["
			d=1
			PlaySound (senter)
			Delay 300
		Else
			If r=2
				r=0
				PlaySound (sclick)
			EndIf
			r=r+1
		EndIf
		If d=1
			a$=""
			c=0
			d=0
			y=y+16
			Locate 0,y
		EndIf
		If b=0
			Write ""+a$+""
		EndIf
		c=c+1
		WhoGetsPoints=WhoGetsPoints+1
		g=Rnd(40,70)
		If g>65
			g=Rnd(70,170)
		EndIf
		Delay g
	Until b=1
	Text 220,238,"Press Any Key To Continue"
	Flip
	FlushKeys
	FlushMouse
	WaitKey()

	Color 230,10,240
End Function

Function pudding()
	If TimeToRemakePudding=0
		pudding=CreateCube()
		EntityColor pudding,230,43,0
		EntityAlpha pudding,.8
		EntityType pudding,8
		;.gss
		Repeat
			thisa=Rnd(1,14)
			Select thisa
			Case 1
				PositionEntity pudding,12,0,29
			Case 2
				PositionEntity pudding,-12,0,29
			Case 3
				PositionEntity pudding,14,14,29
			Case 4
				PositionEntity pudding,-14,14,29
			Case 5
				PositionEntity pudding,-14,-14,29
			Case 6
				PositionEntity pudding,14,-14,29
			Case 7
				PositionEntity pudding,0,18,29
			Case 8
				PositionEntity pudding,0,18,29
			Case 9
				PositionEntity pudding,0,-18,29
			Case 10
				PositionEntity pudding,0,-18,29
			Case 11
				PositionEntity pudding,26,14,29
			Case 12
				PositionEntity pudding,-26,14,29
			Case 13
				PositionEntity pudding,-26,-14,29
			Case 14
				PositionEntity pudding,26,-14,29
			End Select
			pudding1=thisa
		Until nosee1<>pudding1 And pudding1<>ghost1
		;If ghost<>0 And pudding<>0 And nsb<>0
		;If EntityX(ghost)<>EntityX(pudding) And EntityY(ghost)<>EntityY(if) Or EntityX(ghost)<>EntityX(nsb) And EntityY(ghost)<>EntityY(nsb)
		;Goto gss
		;EndIf
		;EndIf
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

Function nosee()
	If seq#=0
		nsb=CreateCube()
		EntityColor nsb,0,0,0
		EntityType nsb,9
		;.gsss
		Repeat
			thisa=Rnd(1,14)
			Select thisa
			Case 1
				PositionEntity nsb,12,0,29
			Case 2
				PositionEntity nsb,-12,0,29
			Case 3
				PositionEntity nsb,14,14,29
			Case 4
				PositionEntity nsb,-14,14,29
			Case 5
				PositionEntity nsb,-14,-14,29
			Case 6
				PositionEntity nsb,14,-14,29
			Case 7
				PositionEntity nsb,0,18,29
			Case 8
				PositionEntity nsb,0,18,29
			Case 9
				PositionEntity nsb,0,-18,29
			Case 10
				PositionEntity nsb,0,-18,29
			Case 11
				PositionEntity nsb,26,14,29
			Case 12
				PositionEntity nsb,-26,14,29
			Case 13
				PositionEntity nsb,-26,-14,29
			Case 14
				PositionEntity nsb,26,-14,29
			End Select
			nosee1=thisa
		Until nosee1<>pudding1 And nosee1<>ghost1
	
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
	
Function ghost()	
	If GhostAutoReplaceTimer=0
		ghost=CreateCube()
		EntityColor ghost,195,195,195
		EntityAlpha ghost,.15
		EntityType ghost,6
		;.gs
		Repeat
			thisa=Rnd(1,14)
			Select thisa
			Case 1
				PositionEntity ghost,12,0,29
			Case 2
				PositionEntity ghost,-12,0,29
			Case 3
				PositionEntity ghost,14,14,29
			Case 4
				PositionEntity ghost,-14,14,29
			Case 5
				PositionEntity ghost,-14,-14,29
			Case 6
				PositionEntity ghost,14,-14,29
			Case 7
				PositionEntity ghost,0,18,29
			Case 8
				PositionEntity ghost,0,18,29
			Case 9
				PositionEntity ghost,0,-18,29
			Case 10
				PositionEntity ghost,0,-18,29
			Case 11
				PositionEntity ghost,26,14,29
			Case 12
				PositionEntity ghost,-26,14,29
			Case 13
				PositionEntity ghost,-26,-14,29
			Case 14
				PositionEntity ghost,26,-14,29
			End Select
			ghost1=thisa
		Until ghost1<>pudding1 And nosee1<>ghost1
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

Function help()
	FreeEntity cube
	HideEntity box1
	HideEntity box2
	HideEntity box3
	HideEntity box4
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

Function initalize()
	
End Function	
	
;Function types(thehandle,thetype,theentity)
;	thistype.thetype+""=New thetype+""
;	thistype\thehandle=theentity
;End Function

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
			
	
		For everybullet.bullet=Each bullet
			;MoveEntity bullet\bullethandle, 0, 0, 2
			MoveEntity bullet\bullethandle,0,.6,0
		Next
		
		pudding
		nosee
		ghost
		
		If WhoGetsPoints=Blue
			BluePlayerScore=BluePlayerScore+1
		ElseIf WhoGetsPoints=Red
			RedPlayerScore=RedPlayerScore+1
		EndIf
		
		If EntityCollided(Player,1)
			EntityType Player,3
			EntityType Playerenemy,3
			PositionEntity Player,0,2,30
			PositionEntity Playerenemy,0,-2,30
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
		
		If EntityX(Player) > 29 Or EntityX(Player) < -29 Or EntityY(Player) > 21 Or EntityY(Player) < -21
			PositionEntity player,0,2,30
			EntityAlpha player,1
			EntityType Player,1
		EndIf
		
		If EntityX(Playerenemy) > 29 Or EntityX(Playerenemy) < -29 Or EntityY(Playerenemy) > 21 Or EntityY(Playerenemy) < -21
			PositionEntity playerenemy,0,-2,30
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

Function speeds()
	If WhoHasPudding=0
			If RedPlayerScore>BluePlayerScore
				SpeedPlayerBlue=8
				MovePlayerBlue=.8
				SpeedPlayerRed=6
				MovePlayerRed=.6
			EndIf
			If BluePlayerScore>RedPlayerScore
				SpeedPlayerBlue=6
				MovePlayerBlue=.6
				SpeedPlayerRed=8
				MovePlayerRed=.8
			EndIf
		EndIf

		If WhoHasPudding=1
			SpeedPlayerBlue=15
			MovePlayerBlue=1.5
			If RedPlayerScore>BluePlayerScore
				SpeedPlayerRed=6
				MovePlayerRed=.6
			ElseIf BluePlayerScore>RedPlayerScore
				SpeedPlayerRed=8
				MovePlayerRed=.8
			EndIf
		EndIf
		
		If WhoHasPudding=2
			SpeedPlayerRed=15
			MovePlayerRed=1.5
			If BluePlayerScore>RedPlayerScore
				SpeedPlayerBlue=6
				MovePlayerBlue=.6
			ElseIf RedPlayerScore>BluePlayerScore
				SpeedPlayerBlue=8
				MovePlayerBlue=.8
			EndIf
		EndIf
		If xo=2
			SpeedPlayerRed=0
			MovePlayerRed=0
			SpeedPlayerBlue=0
			MovePlayerBlue=0
			xo=0
		EndIf
		xo=xo+1
End Function

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

.dat
Data "Made by Metal Mouse Softwar		e 2011[President is AngelOnFira[Game Design by AngelOnFira[Graphics by AngelOnFira[Programed by AngelOnFira[Original idea by AngelOnFira[[CREATOR[AngelOnFira[[Programed with Blitz 3D[Current version; 1.02b {"