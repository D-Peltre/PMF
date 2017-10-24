package fr.exia.frigo;
 
public interface ModelObserver {
 
    void onTemperatureIntChanged(double value);
   
    void onHumidityIntChanged(double value);
   
    void onTemperatureConsigneChanged(double value);
   
}