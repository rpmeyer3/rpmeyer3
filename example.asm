;program to calculate the surface area of a rectangular prism

.586
.MODEL FLAT
INCLUDE io.h
.STACK 4096

.DATA
input1        DWORD  ?
input2        DWORD  ?
input3      DWORD  ?

prompt1 BYTE    "Input 1: (0-50)", 0
prompt2 BYTE    "Input 2: (0-50)", 0
prompt3 BYTE    "Input 3:(0-50)", 0
string  BYTE    30 DUP (?)
totallbl BYTE    "The resulting value is: ", 0
totalval BYTE    11 DUP (?), 0

.CODE
_MainProc PROC
        input   prompt1, string, 30   ; get input1
        atod    string          ; convert to integer
        mov     input1, eax       ; store in memory

        input   prompt2, string, 40    ; repeat for the rest
        atod    string
        mov     input2, eax

        input   prompt3, string, 40     ;repeat
        atod    string 
        mov     input3, eax
        
        mov     eax, input1 ;move input1 to eax
        mov     ebx, input2 ;move input2 to ebx
        mov     ecx, input3 ;move input3 to ecx
        
        add     eax, ebx    ;add input1 and input2
        imul    ecx         ;multiply by input3
        mov     ecx, eax    ;move eax to ecx
        mov     eax, 2      ;move 2 to eax
        imul    ebx         ;multiply by input2
        mov     ebx, eax    ;move eax to ebx
        mov     eax, ecx    ;move ecx to eax
        div     ebx         ;divide by 2 * input2

        
        dtoa    totalval, eax       ; convert to ASCII
        output  totallbl, totalval   ; output label and area

        mov     eax, 0  ; exit with return code 0
        ret

_MainProc ENDP
END


