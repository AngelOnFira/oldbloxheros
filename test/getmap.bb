Function getmap()

While mapdata=0

DebugLog CurrentDir$()

Folder$= CurrentDir$() + "Maps/Blox Heros"
thisdir=ReadDir(Folder$)
Locate 0,60
	
Repeat
	File$=NextFile(thisdir)
	If File="" Then Exit
	Print File
Forever
	
Locate 0,0
mapname$=Input$("What is the name of the map you wish to play? (Do not add .BHlvl) ")
;Stop
mapdata=0

	mapdata=OpenFile("Maps/Blox Heros/"+mapname$+".BHlvl")
	If mapdata=0
		mapdata=OpenFile("Maps/"+mapname$+".BHlvl")
	EndIf
	If mapdata=0
		Print "That is not a valid map"
		Print "Press any key to continue"
		WaitKey
	EndIf
	Cls
Wend

End Function