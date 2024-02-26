; Procedure Homework
; Authors: Ryan Meyer & Nathaniel Sullivano
; Date: December 2023

; sub1 Procedure - calculates (2*X+Y)/Z
; Returns result in eax
; Expects X, Y, Z to be passed on the stack from the calling procedure

.586
INCLUDE io.h            
.MODEL FLAT
.STACK 4096
.DATA

totallbl   BYTE    "Non Remainder Total is: ", 0
totalval   BYTE     11 DUP (?), 0

.CODE
sub1   PROC

	push        ebp                     ; save base pointer
	mov         ebp, esp                ; establish stack frame
	
	mov         eax, [ebp+8]            ; X
    mov         ebx, [ebp+12]           ; Y
    mov         ecx, [ebp+16]           ; Z

                                        ; Calculate (2*X+Y)/Z
    imul        eax, 2                  ; 2*X
    add         eax, ebx                ; 2*X + Y
    mov         edx, 0                  ; clear edx
    div         ecx                     ; (2*X + Y) / Z

    dtoa        totalval, eax           ; convert to ASCII
    output      totallbl, totalval      ; output label and area

    pop         ebp                     ; restore base pointer
    pop         ebx                     ; restore registers
    pop         ecx
    pop         edx
    pop         eax
    ret                                 ; return to caller
sub1   ENDP

END                                     ; end of source code

