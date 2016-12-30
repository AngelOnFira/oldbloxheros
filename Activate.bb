Function Activate()
Stop
	Locate 0,0
	readedfile=ReadFile("activation.blx")
	If readedfile=0
		file=WriteFile("activation.blx")
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
	;If readedfile>0
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
		a=5
		b=5
		c=4
		d=5
	;EndIf
	
	q=(((a-5)*2)+10)
	w=(((b*2)*3)-5)
	e=(((c+2)*3)-8)
	r=(((d+3)*2)-7)
	numcoded$=""+a+""+b+""+c+""+d+""
	deco$=""+w+""+r+""+e+""+q+""
	DebugLog deco
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
		wq=WriteFile("High Scores.blx")
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