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
		
		If KeyDown(57)
			Delay 10
		Else
			g=Rnd(40,70)
			If g>65
				g=Rnd(70,170)
			EndIf
			Delay g
		EndIf
		vw=vw+1
	Until b=1
	Text 220,238,"Press Any Key To Continue"
	Flip
	FlushKeys
	FlushMouse
	WaitKey()

	Color 230,10,240
End Function
