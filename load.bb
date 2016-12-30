Function load()
	Local colorlvl
	sclick=LoadSound("media/click.wav")
	senter=LoadSound("media/send.wav")
	FlushKeys
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
	
	box=LoadImage("Media/box.png")
	ResizeImage box,150,50
	exits=0
	start=0
	creds=0
	help=0
	singleplayer=0
	multiplayer=0
	
	cam4=CreateCamera()
	CameraViewport cam4,0,0,1300,650
	light=CreateLight()

	dwe=ReadFile("High Scores.dat")
	If dwe>0
	fde=ReadString$(dwe)
	EndIf
	
	For i=1 To 50
		WaitTimer(timer)
		Cls
		boxfast(100,650-i*(20-.16*i),"")
		boxfast(100,725-i*(20-.16*i),"")
		boxfast(100,800-i*(20-.16*i),"")
		boxfast(100,875-i*(20-.16*i),"")
		;DrawImage box,100,650-i*(10-.04*i)
		;DrawImage box,100,725-i*(10-.04*i)
		;DrawImage box,100,800-i*(10-.04*i)
		;DrawImage box,100,875-i*(10-.04*i)
		
		Flip
		Delay 10
	Next
	
	testy=0
	.mainmenu
	;---------;
	;Main menu;
	;---------;
	While Not KeyHit(1)
		Cls
		DrawImage box,100,50
		DrawImage box,100,125
		DrawImage box,100,200
		DrawImage box,100,275
		
		Color 255-(colorlvl*(20/50)),255-(colorlvl*(240/50)),255-(colorlvl*(10/50))
		If colorlvl<50
			colorlvl=colorlvl+1
		EndIf
		Text 0,0, colorlvl
		
		If dwe=0
			SetFont FontComicSansMs
			Text 175,75,"Activate",True,True
			SetFont FontCalibri
		EndIf
		If dwe>0 And fde=1
			Text 175,75,"Start",True,True
		EndIf
		
		Text 175,150,"Help",True,True
		Text 175,225,"Credits",True,True
		Text 175,300,"Exit",True,True
				
		If MouseHit(1)
			colorlvl=0
			;-----;
			;Start;
			;-----;
			If RectsOverlap (MouseX(),MouseY(),1,1,100,50,150,50)
				i=0
				While Not KeyHit(1)
					Cls
				DrawImage box,100,50
					DrawImage box,100,125
					DrawImage box,100,200
					
					red#=235+(colorlvl*.1)
					green#=15+(colorlvl*1.2)
					blue#=245+(colorlvl*.05)
					Color red,green,blue
					If colorlvl<200
						colorlvl=colorlvl+2
						If dwe=0
							SetFont FontComicSansMs
							Text 175,75,"Activate",True,True
							SetFont FontCalibri
						EndIf
						If dwe>0 And fde=1
							Text 175,75,"Start",True,True
						EndIf
						
						Text 175,300+i,"Exit",True,True
						Text 175,225,"Credits",True,True
						
						If i<500
							DrawImage box,100,275+i
							Text 175,300+i,"Exit",True,True
							i=i+1+(.075*i)
						EndIf
					EndIf
					
					Color 255-(colorlvl*(20/200)),255-(colorlvl*(240/200)),255-(colorlvl*(10/200))
					If colorlvl<200
						colorlvl=colorlvl+1
					EndIf
					
					
					Text 175,65,"Multiplayer",True,True
					Text 175,80,"1 computer",True,True
					Text 175,150,"Multiplayer",True,True
					Text 175,225,"Back",True,True
					
					If MouseHit(1)
						;----;
						;1 PC;
						;----;
						If RectsOverlap (MouseX(),MouseY(),1,1,100,50,150,50)
							For i=1 To 100
								Cls
								DrawImage box,100,50-1*i
								DrawImage box,100+i*12,125
								DrawImage box,100-2.5*i,200
								Text 175,65-1*i,"Multiplayer",True,True
								Text 175,80-1*i,"1 computer",True,True
								Text 175+i*12,150,"Multiplayer",True,True
								Text 175-2.5*i,225,"Back",True,True
								Flip
								Delay 10
							Next
							start=1
							Goto ennd
						;-----------;
						;Multiplayer;
						;-----------;
						ElseIf RectsOverlap (MouseX(),MouseY(),1,1,100,125,150,50)
							;multiplayer
						;-----------------;
						;BACK TO MAIN MENU;
						;-----------------;
						ElseIf RectsOverlap (MouseX(),MouseY(),1,1,100,200,150,50)
							i=0
							colorlvl=0
							While Not KeyHit(1)
								Cls
								
								DrawImage box,100,50
								DrawImage box,100,125
								DrawImage box,100,200
								
								If colorlvl<200
									red#=235+(colorlvl*.606)
									green#=15+(colorlvl*7.2727)
									blue#=245+(colorlvl*.303)
									Color red,green,blue
								
									Text 175,65,"Multiplayer",True,True
									Text 175,80,"1 computer",True,True
									Text 175,150,"Multiplayer",True,True
									Text 175,225,"Back",True,True
									Color 255,255,255
									Text 0,0, colorlvl
									Text 0,20, red
									Text 0,40, green
									Text 0,60, blue
								EndIf
								
								If colorlvl<200
									red#=255-(colorlvl*.606)
									green#=255-(colorlvl*7.2727)
									blue#=255-(colorlvl*.303)
									Color red,green,blue
								
									Text 175,75,"Start",True,True
									Text 175,150,"Help",True,True
									Text 175,225,"Credits",True,True
									Text 175,900-i*(10-.04*i),"Exit",True,True
									Color 255,255,255
									Text 0,0, colorlvl
									Text 0,20, red
									Text 0,40, green
									Text 0,60, blue
								EndIf

								
								Color 255-(colorlvl*(20/200)),255-(colorlvl*(240/200)),255-(colorlvl*(10/200))
								If colorlvl<200
									colorlvl=colorlvl+1
								EndIf
							
								
									;colorlvl=colorlvl+1				
									If dwe=0
										SetFont FontComicSansMs
										Text 175,75,"Activate",True,True
										SetFont FontCalibri
									EndIf
									If dwe>0 And fde=1
										Text 175,75,"Start",True,True
									EndIf
									
									;Text 175,300+i,"Exit",True,True
									Text 175,225,"Credits",True,True
									
									Color 330,10,340
									If i<100
										DrawImage box,100,875-i*(10-.04*i)
										Text 175,900-i*(10-.04*i),"Exit",True,True
										i=i+1
									Else
										DrawImage box,100,275
										Text 175,300,"Exit",True,True
										;colorlvl=200
										Goto mainmenu
									EndIf
									If i<500
										DrawImage box,100,275+i
										Text 175,300+i,"Exit",True,True
										i=i+1+(.025*i)
									EndIf
								
														
			;					If i<100
			;						DrawImage box,100,875-i*(10-.04*i)
			;						Text 175,900-i*(10-.04*i),"Exit",True,True
			;						i=i+1
			;					Else
			;						DrawImage box,100,275
			;						Text 175,300,"Exit",True,True
			;						colorlvl=200
			;						Goto mainmenu
			;					EndIf
			;					
			;					If dwe=0
			;						SetFont FontComicSansMs
			;						Text 175,75,"Activate",True,True
			;						SetFont FontCalibri
			;					EndIf
			;					If dwe>0 And fde=1
			;						Text 175,75,"Start",True,True
			;					EndIf
			;					
			;					Text 175,150,"Help",True,True
			;					Text 175,225,"Credits",True,True
															
		;						Flip
								;Delay 100
								Flip
							Wend
						EndIf
					EndIf
					
					
					Flip
					;Delay 10
				Wend
			;----;
			;HELP;
			;----;
			ElseIf RectsOverlap (MouseX(),MouseY(),1,1,100,125,150,50)
				trans
				help
			;-----;
			;CREDS;
			;-----;
			ElseIf RectsOverlap (MouseX(),MouseY(),1,1,100,200,150,50)
				trans
				Cls
				creds
				For i=0 To 99
					Cls
					DrawImage box,100,-50+1*i
					DrawImage box,1300-i*12,125
					DrawImage box,-150+2.5*i,200
					DrawImage box,100,650-3.75*i
					Flip
					;WaitKey()
					Delay 10
				Next
			;----;
			;EXIT;
			;----;
			ElseIf RectsOverlap (MouseX(),MouseY(),1,1,100,275,150,50)
				End
			Else
				testy=5
			EndIf
		EndIf
		
		Flip		
		
	Wend
	.ennd


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

Function trans()
For i=1 To 100
	Cls
	DrawImage box,100,50-1*i
	DrawImage box,100+i*12,125
	DrawImage box,100-2.5*i,200
	DrawImage box,100,275+3.75*i
	Flip
	Delay 10
Next
End Function

Function boxfast(x,y,textprint)
	DrawImage box,x,y
	Text x+75,y+25, textprint,1,1
End Function