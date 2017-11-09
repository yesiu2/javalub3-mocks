package com.demo.camera

import javafx.scene.Camera
import spock.lang.Specification

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

}
