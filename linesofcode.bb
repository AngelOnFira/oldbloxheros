path$="C:\Users\Forest\Desktop\Blox Heros + Map Editor\Blox Heros"
dir=ReadDir(path)
Global totallines,temptotal,temptotal2

files=0
file$=NextFile$(dir)

Repeat
	files=files+1
	file$=NextFile$(dir)
	If file=""
		Exit
		Exit
	EndIf
Forever
files=files-2

;Dim array$(files)
;Dim array2$(files)

dir=ReadDir(path)

For i=1 To files
;	array(i)
	file=NextFile$(dir)
	temp$=Right$(file,3)
	If temp=".bb" And file<>"linesofcode.bb"
	;Stop
		DebugLog file
		fileopen=OpenFile(file)
		Repeat
			crap=ReadLine(fileopen)
			totallines=totallines+1	
		Until Eof(fileopen)
		
		totallines=totallines-1
		
		DebugLog totallines
		temptotal2=totallines-temptotal
		DebugLog temptotal2
		temptotal=temptotal2
		DebugLog ""
		;CloseFile file
	EndIf
Next

Print "There are a total of "+totallines+" lines"