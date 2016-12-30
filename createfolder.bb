filesearch(1,"Maps")
filesearch(1,"Maps/Blox Heros")
filesearch(1,"Maps/Map Editor")
;filesearch(2,"High Score.blx")

Function filesearch(which,name$)

If which=1
	If FileType(name)=2
		CreateDir CurrentDir$()+""+name
	EndIf
Else
	If FileType(name)<>1 And dat<>0
		Restore .highscore
		Read num
		Read name
		file=WriteFile(name)
		For i=0 To num
			Read lines
			WriteString(file,""+lines)
			Next
		;CreateDir CurrentDir$()+""+name
	EndIf
EndIf

End Function

.highscore
Data 1
Data "High Scores.blx"
Data 1