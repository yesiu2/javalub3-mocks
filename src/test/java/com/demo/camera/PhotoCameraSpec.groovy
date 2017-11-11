package com.demo.camera

import javafx.scene.Camera
import org.junit.rules.Stopwatch
import org.spockframework.util.Assert
import spock.lang.Specification
import sun.management.Sensor
import com.google.common.base.Stopwatch

import java.awt.Image
import java.util.concurrent.TimeUnit

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

    def "Press button with power on, copying data from sensor to memory card."(){
        given:
        ImageSensor sensor = Mock(ImageSensor)
        Card card = Mock(Card)
        boolean status
        PhotoCamera cam = new PhotoCamera(sensor, card, status)
        cam.turnOn()
        when:

        cam.pressButton()



        then:
        cam.isOn()
        1 * card.write(sensor.read())
    }

    def "Writing data should take few seconds"(){
        given:
        ImageSensor sensor = Mock(ImageSensor)
        Card card = Mock(Card)
        boolean status
        PhotoCamera cam = new PhotoCamera(sensor, card, status)
        cam.turnOn()

        when:
        Stopwatch sw = new Stopwatch().start()
        cam.pressButton()
        sw.stop()

        then:
        cam.isOn()
        1 * card.write(sensor.read())
        sw.elapsed(TimeUnit.SECONDS) > 2


    }

}
