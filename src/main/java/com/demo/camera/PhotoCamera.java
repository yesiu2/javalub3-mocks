package com.demo.camera;

public class PhotoCamera {

    ImageSensor sensor;
    private boolean statusTurnOn = false;

    public PhotoCamera(ImageSensor sensor) {
        this.sensor = sensor;
        this.statusTurnOn = statusTurnOn;
    }

    public boolean isOn() {
        return statusTurnOn;
    }


    public void turnOn() {
        // not implemented || turns on the sensor
    }

    public void turnOff() {
        // not implemented || turns off the sensor
        // when camera is writing data, turning off shouldnt turn off the power
        // when writing data ends, camera cut the power of sensor
        this.statusTurnOn = false;
        sensor.turnOff();

    }

    public void pressButton() {
        // not implemented || should doing nothing when camera is off ||
        // when camera is on it should copy data from sensor to memory card
        // writing data on memory card should take few seconds

    }
}

//    TODO-Klasa Camera
//
//    TODO-Camera musi posiadać następujące zachowania:
//
//       todo-kuba Włączenie kamery włącza zasilanie sensora.
//       todo-wojtek Wyłączenie kamery odcina zasilanie sensora.
//        TODO-Naciśnięcie migawki jeśli zasilanie jest odcięte nie robi nic.
//        TODO-Naciśnięcie migawki z włączonym zasilaniem, kopiuje dane z sensora do karty pamięci. Zapisywanie danych do karty pamięci może zająć kilka sekund.
//       TODO- Jeśli dane są obecnie zapisywane, wyłączenie kamery nie odcina zasilania sensora
//        TODO-Kiedy zapis danych się zakończy, aparat odcina zasilanie sensora.


