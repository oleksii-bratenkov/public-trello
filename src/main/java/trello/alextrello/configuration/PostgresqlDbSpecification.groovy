package trello.alextrello.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.testcontainers.containers.PostgreSQLContainer
import spock.lang.Specification

import javax.sql.DataSource

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
abstract class PostgresqlDbSpecification extends Specification
{

    @Autowired
    protected DataSource dataSource

    private static final Integer POSTGRES_PORT = 5432
    private static final String URL_PATTERN = "jdbc:postgresql://%s:%s/trello"
    private static final String TEST_USERNAME = "test_login"
    private static final String TEST_PASSWORD = "test_password"

    private
    static PostgreSQLContainer container = (PostgreSQLContainer) new PostgreSQLContainer("postgres:9.6.1")
            .withUsername(TEST_USERNAME)
            .withPassword(TEST_PASSWORD)
            .withDatabaseName("trello")
            .withExposedPorts(POSTGRES_PORT)

    static {
        container.start()
        String url = String.format(URL_PATTERN, container.getContainerIpAddress(), container.getMappedPort(POSTGRES_PORT))
        System.setProperty("spring.datasource.url", url)
        System.setProperty("spring.datasource.username", TEST_USERNAME)
        System.setProperty("spring.datasource.password", TEST_PASSWORD)
    }
}
