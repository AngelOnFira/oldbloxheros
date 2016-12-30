Repeat
			thisa=Rnd(1,14)
			Select thisa
			Case 1
				PositionEntity pudding,12,0,29
			Case 2
				PositionEntity pudding,-12,0,29
			Case 3
				PositionEntity pudding,14,14,29
			Case 4
				PositionEntity pudding,-14,14,29
			Case 5
				PositionEntity pudding,-14,-14,29
			Case 6
				PositionEntity pudding,14,-14,29
			Case 7
				PositionEntity pudding,0,18,29
			Case 8
				PositionEntity pudding,0,18,29
			Case 9
				PositionEntity pudding,0,-18,29
			Case 10
				PositionEntity pudding,0,-18,29
			Case 11
				PositionEntity pudding,26,14,29
			Case 12
				PositionEntity pudding,-26,14,29
			Case 13
				PositionEntity pudding,-26,-14,29
			Case 14
				PositionEntity pudding,26,-14,29
			End Select
			pudding1=thisa
		Until nosee1<>pudding1 And pudding1<>ghost1