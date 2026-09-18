{4.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el
equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa
el número 0 (cero).
Ayuda: Analizando las posibilidades encontramos que: Binario (N) es N si el valor es menor a 2.
¿Cómo obtenemos los dígitos que componen al número? ¿Cómo achicamos el número para la
próxima llamada recursiva? Ejemplo: si se ingresa 23, el programa debe mostrar: 10111.}
program P2_EJE4_TALLER;23
Procedure ImprimirRecursivo(n: integer);
Begin
 If (n <> 0) Then
  Begin
   ImprimirRecursivo(n Div 2);
   Write(n Mod 2);
  End;
End;
Procedure leerValor();
Var 
 num: integer;
Begin
 WriteLn('Ingrese valor: ');
 Read(num);
 While (num <> 0) Do
  Begin
   WriteLn('El numero ', num, ' en binario es: ');
   ImprimirRecursivo(num);
   WriteLn;
   WriteLn('Ingrese valor: ');
   Read(num);
  End;
End;
Begin
 leerValor();
End.