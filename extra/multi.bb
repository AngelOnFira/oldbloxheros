Graphics3D 800,600,16,2

Global theirip,gamename$,recvd,msg$,txt$,txt2$
;Global

cam=CreateCamera()
light=CreateLight()

player=CreateCube()
PositionEntity player,0,0,30

otherplayer=CreateCube()
PositionEntity otherplayer,0,0,30
timer=CreateTimer(60)

.hostquestion

Print "Host? (Y/N)"
WaitKey()

Global stream

IP=CountHostIPs("192.168.1.255")
IP=HostIP(1)

If KeyHit(21)
	stream=CreateUDPStream(2200)
	hostname$=Input$("What should the game name be? ")
	recvd=0
	While Not KeyHit(1) Or recvd=1
		If MilliSecs()-currsearch>2000
			WriteLine(stream,100)
			WriteLine(stream,hostname)
			SendUDPMsg(stream,IP,2201)
			currsearch=MilliSecs()
			Print "sent"
		EndIf
		If RecvUDPMsg(stream)
			msg=ReadLine(stream)
			If msg=101
				recvd=1
				theirip=UDPMsgIP(stream)
			EndIf
		EndIf
	Wend
ElseIf KeyHit(49)
	stream=CreateUDPStream(2201)
	foundhost=0
	While Not foundhost=1
		Cls
		If RecvUDPMsg(stream)
			If ReadLine(stream)=100
				gamename$=ReadLine(stream)
				.joinquestion
				Print "Would you like to join "+gamename+"'s game? (Y/N)"
				WaitKey()
				
				If KeyHit(21)
					WriteLine(stream,101)
					SendUDPMsg(stream,IP,2200)
					foundhost=1
					theirip=UDPMsgIP(stream)
				ElseIf KeyHit(49)
					Cls
					Locate 0,0
				Else
					Goto joinquestion
				EndIf
			EndIf
		EndIf
		Locate 0,0
		Print "Waiting for hosts..."
		Flip
	Wend
Else
	Goto hostquestion
EndIf

While Not KeyHit(1)

	If KeyHit(28)
		MoveEntity player,0,.0312312,0
	EndIf
	If KeyDown(205)
		TurnEntity player,0,0,-2
		q=1
	EndIf
	
	If KeyDown(208)
		MoveEntity player,0,-.2,0
		w=1
	EndIf
	
	If KeyDown(203)
		TurnEntity player,0,0,2
		e=1
	EndIf
	
	If KeyDown(200)
		MoveEntity player,0,.2,0
		r=1
	EndIf
	
	msg=q+""+w+""+e+""+r
	q=0
	w=0
	e=0
	r=0
	WriteLine(stream,"200"+msg)
	
	If recvd=1
		SendUDPMsg(stream,theirip,2201)
	Else
		SendUDPMsg(stream,theirip,2200)
	EndIf
	
	If MilliSecs()-fullsendtime>15000
		;WriteLine(stream,201)
		;WriteLine(stream,EntityX(player))
		;WriteLine(stream,EntityY(player))
		;WriteLine(stream,EntityZ(player))
		;WriteLine(stream,EntityRoll(player))
		WriteLine(stream,"201"+LSet$(EntityX(player),7)+""+LSet$(EntityY(player),7)+""+LSet$(EntityZ(player),7)+""+LSet$(EntityRoll(player),7))
		;Stop
		DebugLog "201"+LSet$(EntityX(player),7)+""+LSet$(EntityY(player),7)+""+LSet$(EntityZ(player),7)+""+LSet$(EntityRoll(player),7)
		txt="201"+LSet$(EntityX(player),7)+""+LSet$(EntityY(player),7)+""+LSet$(EntityZ(player),7)+""+LSet$(EntityRoll(player),7)
		;Stop
		If recvd=1
			SendUDPMsg(stream,theirip,2201)
		Else
			SendUDPMsg(stream,theirip,2200)
		EndIf
		fullsendtime=MilliSecs()
	EndIf
	
	While RecvUDPMsg(stream)
		datarecv$=ReadLine(stream)
		;Stop
		DebugLog datarecv$
		whichsend=Mid$(datarecv,1,3)
		If whichsend="200"
			If Mid$(datarecv,4,1)="1"
				TurnEntity otherplayer,0,0,-2
			EndIf
			If Mid$(datarecv,5,1)="1"
				MoveEntity otherplayer,0,-.2,0
			EndIf
			If Mid$(datarecv,6,1)="1"
				TurnEntity otherplayer,0,0,2
			EndIf
			If Mid$(datarecv,7,1)="1"
				MoveEntity otherplayer,0,.2,0
			EndIf
		ElseIf whichsend="201"
			txt2=datarecv
			x#=Mid$(datarecv,4,7)
			x=Int(x)
			;If x>0
		;		x=Floor#(x)
	;		Else
;				x=Ceil#(x)
;			EndIf
			
			y#=Mid$(datarecv,11,7)
			y=Int(y)
;			If y>0
;				y=Floor#(y)
;			Else
;				y=Ceil#(y)
;			EndIf
			
			z#=Mid$(datarecv,4,7)
			z=Int(z)
;;			If z>0
;				z=Floor#(z)
;			Else
;				z=Ceil#(z)
;			EndIf
			roll=Mid$(datarecv,25,7)
			PositionEntity otherplayer,x,y,z
			RotateEntity otherplayer,0,0,roll
			x2#=Mid$(datarecv,4,7)
			x2=x2-x
			y2#=Mid$(datarecv,11,7)
			y2=y2-y
			z2#=Mid$(datarecv,18,7)
			z2=z2-z
			TranslateEntity otherplayer,x2,y2,z2
		EndIf
	Wend
	
	UpdateWorld
	RenderWorld
	
	WaitTimer(timer)
	
	Text 0,12,txt2
	Text 0,0,txt
	Text 0,24, EntityX(otherplayer)
	Text 0,36, EntityY(otherplayer)
	Text 0,48, EntityZ(otherplayer)
	Text 0,60, x
	Text 0,72, y
	Text 0,84, z
	Text 0,96, x2
	Text 0,108, y2
	Text 0,120, z2
	
	Flip
Wend