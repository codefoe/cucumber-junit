package hooks

import groovy.json.JsonSlurper
import javafx.scene.shape.Path
import org.junit.Test


class Hook {
    @Test
    void method() {
        def baseUrl = new URL('http://www.trello.com')
        def connection = baseUrl.openConnection()


    }


    Object hello(String...jsonPath) {
        Path path = Path.

        println("I am in the groovy Hello there")
        File properties = new File("/Users/ernest/IdeaProjects/cucumber-junit4/properties.json")
        JsonSlurper json = new JsonSlurper()
        def result = json.parse(properties)


        for(String s: jsonPath) {

            println json.parse(result[s])
        }

         return result[jsonPath]

    }
}
