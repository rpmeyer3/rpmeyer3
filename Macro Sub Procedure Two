; Procedure Homework
; Authors: Ryan Meyer & Nathaniel Sullivano                                          
; Date: December 2023

; sub2 Procedure - calculates (Y/15-X)*Z
;  Returns result in eax
;  Expects X, Y, and Z to be passed on the stack from the calling procedure

.586
INCLUDE io.h
.MODEL FLAT
.STACK 4096

.DATA

totallbl   BYTE     "Non Remainder Total is:", 0
totalval   BYTE	    11 DUP (?) ; 11 bytes for ASCII string



.CODE
sub2   PROC

		push        ebp                     ; save base pointer
		mov         ebp, esp                ; establish stack frame
		mov         eax, [ebp+8]		    ; X
		mov         ebx, [ebp+12]		    ; Y

										    ;Calculate (X/15-Y)*Z
		mov		     edx, 0					; clear edx
		mov		     ecx, 15			    ; clear edx
		div 		 ecx				    ; eax = X/15
		mov          ecx, [ebp+16]			; Z
		sub			 eax, ebx				; eax = X/15 - Y
        imul		 eax, ecx				; eax = (X/15 - Y)*Z

		dtoa        totalval, eax		    ; convert to ASCII
		output		totallbl, totalval	    ; output label and area

        pop		 ebp                        ; restore base pointer
		pop		 ebx                        ; restore registers
		pop		 ecx
		pop		 edx
		pop		 eax

		ret                                 ; return to caller
sub2   ENDP

END                             ; end of source code

