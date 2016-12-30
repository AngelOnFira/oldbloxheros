Graphics3D 1300,650,16,2
SetBuffer BackBuffer()
Global top
.top
Global timer=CreateTimer(60)
SeedRnd MilliSecs()
Global FontComicSansMs=LoadFont("Comic sans",18,1)
Global FontCalibri=LoadFont("Calibri",22,1)
Global FontVerdana=LoadFont("Verdana",22,0,0)
Global FontCalibri40=LoadFont("Calibri",40)
Global imagex=LoadImage("media/x.png")
MaskImage imagex,255,174,201
Global imageyes=LoadImage("media/right.png")
MaskImage imageyes,255,174,201
Global frametimer=CreateTimer(50), frametimer2=CreateTimer(60)
Global ghost,GhostTimer,GhostWaitReplaceTimer,GhostAutoReplaceTimer,TimeWithGhost,cube,cam4,cam,cam2,cam3
Global TimeToRemakePudding,pudding,TimeWithPudding,ConditionRemakePudding,WhoHasPudding,fvfq,win,lose,wallt,dd,xsw#,nsb,blockview#,inputline2w
Global bggq#,frfqq#,cdeq#,fvfqq#,seq#,BluePlayerScore,RedPlayerScore,xo,inputline
Global walls,box1,box2,box3,box4,start,tyu,logosp,gob,ap,ya
Global ba=28,nosee1,pudding1,ghost1,sclick,senter
Global bullett=CreateSphere()
Global moveplayerblue,speedplayerblue,moveplayerred,speedplayerred
Global box,colorlvl
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

Include "createfolder.bb"

Include "load3dworld.bb"
Global pike,player,playerenemy

Include "getmap.bb"
Global mapdata,spawnbluex,spawnbluey,spawnredx,spawnredy,levelx,levely
Include "readmap.bb"

Include "getscore.bb"

Include "maingame.bb"

Include "activate.bb"

Include "load.bb"

Include "credits.bb"

Include "pudding.bb"

Include "invisibleblock.bb"

Include "ghost.bb"

Include "help.bb"

Include "speeds.bb"

Include "move.bb"
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

;Get map to play
getmap()
;Then read the map
readmap()

load3Dworld()
		
getscore()
		
	Cls
		
	While Not KeyHit(1)
	
Game()
		
	Wend
	
	PositionEntity Player,spawnbluex,spawnbluey,30
	PositionEntity Playerenemy,spawnredx,spawnredy,30
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

Function initalize()
	
End Function	
	
;Function types(thehandle,thetype,theentity)
;	thistype.thetype+""=New thetype+""
;	thistype\thehandle=theentity
;End Function


.dat
Data "Made by Metal Mouse Software 2011[President is AngelOnFira[Game Design by AngelOnFira[Graphics by AngelOnFira[Programed by AngelOnFira[Original idea by AngelOnFira[[CREATOR[AngelOnFira[[Programed with Blitz 3D[Current version; 1.02b {"