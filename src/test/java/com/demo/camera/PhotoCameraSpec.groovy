package com.demo.camera

import javafx.scene.Camera
import spock.lang.Specification
import sun.management.Sensor

class PhotoCameraSpec extends Specification {


    def "Should power up the sensor when camera is switched on"() {
        given:
        ImageSensor sensor = Mock(ImageSensor)
        PhotoCamera cam = new PhotoCamera(sensor)

        when:
        cam.turnOn()

        then:
        1 * sensor.turnOn()

    }

    def "Should power off the sensor when camera is switched off"() {
        // Testujemy tylko PhotoCamerę, Image sensor nas nie interesuje.
        // Wyłączenie kamery jest metodą PhotoCamera, a wyłączenie zasilania należy do zadań ImageSensora (Mock)
        given:

        ImageSensor sensor = Mock(ImageSensor)
        PhotoCamera cam = new PhotoCamera(sensor)

        when:
        cam.turnOff()

        then:
        1 * sensor.turnOff()

    }

    def "Press button should doing nothing when power is off"() {
        given:

        ImageSensor sensor = Mock(ImageSensor)
        PhotoCamera cam = new PhotoCamera(sensor)

        when:

        cam.pressButton()

        then:

        0 * sensor.turnOn()
        0 * sensor.turnOff()
        0 * sensor.read()
        !cam.isOn()
    }

}
