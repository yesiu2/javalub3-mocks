package com.demo

import spock.lang.Specification

class ExampleSpec extends Specification {

    def "Sample client should call sample server"() {
        given:
        Server server = Mock(Server)
        MyClient client = new MyClient(server)

        when:
        client.doAClientThing()

        then:
        1 * server.doAServerThing()
    }

    // These classes are the implementation - here they are in the same file just for convenience
    // Put your implementation code under src/main/java
    class MyClient {

        private final Server server;

        MyClient(Server server) {
            this.server = server;
        }

        void doAClientThing() {
            server.doAServerThing();
        }
    }

    interface Server {
        void doAServerThing();
    }
}
