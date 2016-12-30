Function getscore()

While Not KeyHit(28) And inputline=>1000 And inputline<=9999999
		Cls
		Locate 390,350
		as=GetKey()
		ase$=Chr$(as)
		Rect 656,348,79,26,0
		inputline=inputline+""+Chr$(as)+""
		
		If as=8
			If Len(inputline)>0 Then inputline=Left$(inputline,Len(inputline)-1)
		EndIf
		
		If inputline>9999999
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
	
End Function