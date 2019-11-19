package trello.alextrello

import spock.lang.Specification
import spock.lang.Unroll
import trello.alextrello.test.Calculator

@Unroll
class GroovyCalcTest extends Specification {
    def "calculate #a + #b = #c" () {
        given:
        def calculator = new Calculator()

        expect:
        calculator.sum(a, b) == c

        where:
        a << [4, 10, 12]
        b << [10, 22, 12]
        c << [14, 22, 30]
    }
}
