const int transistorPin = 9;    // connected to the base of the transistor

 void setup() {
   // set  the transistor pin as output:
   pinMode(transistorPin, OUTPUT);
 }

 void loop() {

   
   for(int i=0; i<255;i++){
    analogWrite(transistorPin,i);
    delay(10);
   }
 }

