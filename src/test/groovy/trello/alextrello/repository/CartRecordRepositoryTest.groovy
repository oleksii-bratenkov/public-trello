package trello.alextrello.repository

import be.janbols.spock.extension.dbunit.DbUnit
import org.springframework.beans.factory.annotation.Autowired
import trello.alextrello.configuration.PostgresqlDbSpecification

class CartRecordRepositoryTest extends PostgresqlDbSpecification {

    @Autowired
    CartRecordRepository cartRecordRepository


        @DbUnit(datasourceProvider = { dataSource }, content = {
                board(id:1, title:"some title")
                cart(id:1, title: "first cart", description: "some good description", board_id:1)
                cart(id:2, title: "second cart", description: "some middle description", board_id:1)
                cart(id:3, title: "first cart", description: "some description", board_id:1)
                record(id:1, title:"first record", description:"some description", comment:"some comment", deadline:"[NOW]", cart_id:1, record_order:1 )
                record(id:2, title:"second record", description:"some another description", comment:"some another comment", deadline:"[NOW]", cart_id:1, record_order:2 )
                record(id:3, title:"third record", description:"some another third description", comment:"some another third comment", deadline:"[NOW]", cart_id:2, record_order:1)
            })
    def "test repository" () {

            when:
            def cartRecordsList = cartRecordRepository.findAllByCartIdOrderByRecordOrderAsc(1L)

            then:
            cartRecordsList.size() == 2
    }
}
