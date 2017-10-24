package fr.exia.frigo;
 
import java.util.ArrayList;
import java.util.List;
 
public class Model {
   
    /**
     * Ma collection d'observateurs.
     */
    private List<ModelObserver> list =
            new ArrayList<ModelObserver>();
 
    /**
     * Temp�rature int�rieure du r�frig�rateur.
     * En degr�s celcius.
     */
    private double temperatureInt = 0;
   
    /**
     * Humidit� int�rieure du r�frig�rateur.
     * En pourcentage d'humidit� relative dans l'air.
     */
    private double humiditeInt = 0;
   
    /**
     * Temp�rature de consigne pour l'asservissement
     * du r�frig�rateur. En degr�s celcius.
     */
    private double temperatureConsigne = 0;
 
    public double getTemperatureInt() {
        return temperatureInt;
    }
 
    public void setTemperatureInt(double temperatureInt) {
        this.temperatureInt = temperatureInt;
    }
 
    public double getHumiditeInt() {
        return humiditeInt;
    }
 
    public void setHumiditeInt(double humiditeInt) {
        this.humiditeInt = humiditeInt;
    }
 
    public double getTemperatureConsigne() {
        return temperatureConsigne;
    }
 
    public void setTemperatureConsigne(double temperatureConsigne) {
        this.temperatureConsigne = temperatureConsigne;
    }
   
    public void addObserver(ModelObserver observer) {
        list.add(observer);
    }
   
    public void removeObserver(ModelObserver observer) {
        list.remove(observer);
    }
   
    private void notifyTemperatureIntChanged() {
        for (ModelObserver observer : list) {
            observer.onTemperatureIntChanged(
                    this.temperatureInt);
        }
    }
   
    private void notifyHumidityIntChanged() {
        for (ModelObserver observer : list) {
            observer.onHumidityIntChanged(
                    this.humiditeInt);
        }
    }
   
    private void notifyTemperatureConsigneChanged() {
        for (ModelObserver observer : list) {
            observer.onTemperatureConsigneChanged(
                    this.temperatureConsigne);
        }
    }
   
}