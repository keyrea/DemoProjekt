package com.example.demo.repository;


import com.example.demo.model.Employee;
import com.example.demo.model.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MSSQLServerContainer;

//@RunWith(SpringRunner.class)
//@DataJpaTest
@ContextConfiguration
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MyRepositoryTest {

    public static MSSQLServerContainer<?> database = new MSSQLServerContainer<>(
            "mcr.microsoft.com/mssql/server:2019-latest").acceptLicense().withPassword("Intershop0!");

//    private static MSSQLServerContainer database = new MSSQLServerContainer(DockerImageName.parse("docker.tools.intershop.com/icm/intershophub/mssql-intershop:2019-latest")
//            .asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server")).withDatabaseName("employees").withPassword("Intershop0!");
    static
    {
        database.start();
    }

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry)
    {
        registry.add("spring.datasource.url", database::getJdbcUrl);
    }
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    FieldRepository fieldRepository;


    @Test
    public void myTest() throws Exception {

//        DockerImageName myImage = DockerImageName.parse("mcr.microsoft.com/mssql/server:2017-latest")
//                .asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server");
//        database = new MSSQLServerContainer(myImage).acceptLicense();
        database.start();

        System.out.println(database.getUsername());
        System.out.println(database.getPassword());
        System.out.println(database.getJdbcUrl());

        Employee employee = new Employee();
        Field field = fieldRepository.findById(1L).get();
////        employee.setId(3L);
        employee.setEmailId("admin@gmail.com");
        employee.setField(field);
        employee.setFirstName("admin");
        employee.setLastName("admin");
        employeeRepository.saveAndFlush(employee);
    }
}