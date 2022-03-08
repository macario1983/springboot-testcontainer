package com.springboot.testcontainer.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.testcontainer.configuration.FixtureFactoryConfiguration;
import com.springboot.testcontainer.configuration.FlywayMigrationConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@AutoConfigureMockMvc(print = MockMvcPrint.LOG_DEBUG)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext
@Import({FlywayMigrationConfiguration.class, FixtureFactoryConfiguration.class})
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Testcontainers
public abstract class AbstractControllerTest {

    @Container
    private static final PostgreSQLContainer CONTAINER = new PostgreSQLContainer("postgres:10.19-alpine")
            .withDatabaseName("testcontainer")
            .withUsername("root")
            .withPassword("root");

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", CONTAINER::getUsername);
        registry.add("spring.datasource.password", CONTAINER::getPassword);
    }
}
