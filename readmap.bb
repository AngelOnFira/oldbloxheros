Function readmap()

walls=CreateCube()		
		
crap1=ReadLine(mapdata)
levelx=ReadLine(mapdata)
levely=ReadLine(mapdata)
spawnbluex=ReadLine(mapdata)
spawnbluey=ReadLine(mapdata)
spawnredx=ReadLine(mapdata)
spawnredy=ReadLine(mapdata)
timestr=ReadLine(mapdata)
g=Rnd(100)
h=Rnd(40)
j=Rnd(40)

;Loading walls loop
For t= 0 To timestr
	thewall.wall=New wall
	thewall\wallhandle=CopyEntity(walls)
	
	x=ReadLine(mapdata)
	y=ReadLine(mapdata)
	
	
	PositionEntity thewall\wallhandle,x,y,30
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
	
End Function