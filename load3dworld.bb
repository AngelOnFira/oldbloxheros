Function load3dworld()

pike=LoadMesh("Media\pike.b3d")
RotateEntity pike,90,90,90
EntityColor pike,0,255,0
EntityType pike,1
ScaleEntity pike,.5,.5,.5

If cube<>0
	FreeEntity cube
EndIf


	Player=CreateCube()
	Playerenemy=CreateCube()
	
	;Player 1
	PositionEntity Player,spawnbluex,spawnbluey,30
	EntityColor Player,0,30,255
	EntityType Player,1
	;ScaleEntity player,.2,.2,.2
	EntityRadius player,.999
	
	;Player 2
	PositionEntity Playerenemy,spawnredx,spawnredy,30
	EntityType Playerenemy,1
	EntityColor Playerenemy,255,0,0
	;ScaleEntity playerenemy,.9,.9,.9
	EntityRadius playerenemy,.999
	
	;Collisions
	Collisions 1,1,2,2
	Collisions 1,2,2,2
	Collisions 1,6,2,2
	Collisions 1,8,2,2
	Collisions 1,9,2,2
	Collisions 4,2,2,2
	Collisions 8,2,2,2
	Collisions 6,2,2,2
	Collisions 9,2,2,2
	Collisions 8,9,2,2
	Collisions 6,8,2,2
	Collisions 6,9,2,2

	;Lights, camera, action
	light=CreateLight()
	
	;Player 2 cam
	cam=CreateCamera(Playerenemy)
	
	RotateEntity cam,0,0,180
	PositionEntity cam,0,-20,-10
	CameraViewport cam,0,0,630,600
	TurnEntity cam,70,0,180
	
	;Player 1 cam
	cam2=CreateCamera(player)
	RotateEntity cam2,0,0,180
	PositionEntity cam2,0,-20,-10
	TurnEntity cam2,70,0,180
	CameraViewport cam2,650,0,630,600
	
	;Map cam
	cam3=CreateCamera()
	CameraViewport cam3,550,40,250,190
	PositionEntity cam3,0,0,-2
	PositionEntity pike,EntityX(pike),EntityY(pike),29
	
End Function