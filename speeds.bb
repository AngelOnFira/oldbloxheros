Function speeds()
	If WhoHasPudding=0
			If RedPlayerScore>BluePlayerScore
				SpeedPlayerBlue=8
				MovePlayerBlue=.8
				SpeedPlayerRed=6
				MovePlayerRed=.6
			EndIf
			If BluePlayerScore>RedPlayerScore
				SpeedPlayerBlue=6
				MovePlayerBlue=.6
				SpeedPlayerRed=8
				MovePlayerRed=.8
			EndIf
		EndIf

		If WhoHasPudding=1
			SpeedPlayerBlue=15
			MovePlayerBlue=1.5
			If RedPlayerScore>BluePlayerScore
				SpeedPlayerRed=6
				MovePlayerRed=.6
			ElseIf BluePlayerScore>RedPlayerScore
				SpeedPlayerRed=8
				MovePlayerRed=.8
			EndIf
		EndIf
		
		If WhoHasPudding=2
			SpeedPlayerRed=15
			MovePlayerRed=1.5
			If BluePlayerScore>RedPlayerScore
				SpeedPlayerBlue=6
				MovePlayerBlue=.6
			ElseIf RedPlayerScore>BluePlayerScore
				SpeedPlayerBlue=8
				MovePlayerBlue=.8
			EndIf
		EndIf
		If xo=2
			SpeedPlayerRed=0
			MovePlayerRed=0
			SpeedPlayerBlue=0
			MovePlayerBlue=0
			xo=0
		EndIf
		xo=xo+1
End Function
