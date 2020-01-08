package nl.han.icdeapp;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import nl.han.icdeapp.controllers.EvlController;
import nl.han.icdeapp.models.Evl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/*
@RunWith(SpringRunner.class)
@WebMvcTest(EvlController.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EvlControllerTest 
{
	   @Autowired
	   private MockMvc mvc;

	   @MockBean
	   private EvlController evlController;

	   @Autowired
	   //private TestEntityManager entityManager;

	   @Autowired
	   //private ArrivalRepository arrivalRepository;

	   // CONTROLLER REST API TESTS

	   @Test
	   public void getArrivals() throws Exception {
	       Arrival arrival = new Arrival();
	       arrival.setCity("Yerevan");

	       List<Arrival> allArrivals = singletonList(arrival);

	       given(arrivalController.getAllArrivals()).willReturn(allArrivals);

	       mvc.perform(get(VERSION + ARRIVAL + "all")
	               .with(user("blaze").password("Q1w2e3r4"))
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$", hasSize(1)))
	               .andExpect(jsonPath("$[0].city", is(arrival.getCity())));
	   }

	   @Test
	   public void getArrivalsById() throws Exception {
	       Arrival arrival = new Arrival();
	       arrival.setCity("Yerevan");

	       given(arrivalController.getArrivalById(arrival.getId())).willReturn(arrival);

	       mvc.perform(get(VERSION + ARRIVAL + arrival.getId())
	               .with(user("blaze").password("Q1w2e3r4"))
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("city", is(arrival.getCity())));
	   }

	   // MODEL TESTS

	   @Test
	   public void whenFindAll() {
	       //given
	       Arrival firstArrival = new Arrival();
	       firstArrival.setCity("Yerevan");
	       entityManager.persist(firstArrival);
	       entityManager.flush();

	       Arrival secondArrival = new Arrival();
	       secondArrival.setCity("Israel");
	       entityManager.persist(secondArrival);
	       entityManager.flush();

	       //when
	       List<Arrival> arrivals = arrivalRepository.findAll();

	       //then
	       assertThat(arrivals.size()).isEqualTo(9);
	       assertThat(arrivals.get(7)).isEqualTo(firstArrival);
	       assertThat(arrivals.get(8)).isEqualTo(secondArrival);
	   }

	   @Test
	   public void whenFindAllById() {
	       //given
	       Arrival arrival = new Arrival();
	       arrival.setCity("Yerevan");
	       entityManager.persist(arrival);
	       entityManager.flush();

	       //when
	       Arrival testArrival = arrivalRepository.findAllById(arrival.getId());

	       //then
	       assertThat(testArrival.getCity()).isEqualTo(arrival.getCity());
	   }
}
*/







/*
package nl.han.icdeapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;

import nl.han.icdeapp.controllers.EvlController;
import nl.han.icdeapp.models.Evl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EvlControllerTest {
	
	// Add Mockito to stack
	// https://howtodoinjava.com/spring-boot2/testing/rest-controller-unit-test-example/
	// https://reflectoring.io/unit-testing-spring-boot/
	// https://github.com/thombergs/code-examples/tree/master/spring-boot/spring-boot-testing
	// https://www.mkyong.com/spring-boot/spring-boot-junit-5-mockito/
	// https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockito-junit-example/
	// https://www.springboottutorial.com/spring-boot-unit-testing-and-mocking-with-mockito-and-junit
	// https://www.baeldung.com/integration-testing-a-rest-api
	/*
    @InjectMocks
    EvlController evlController;
     
    @Mock
    Evl evl;

    @Test
    public void testAddEvl() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(employeeDAO.addEmployee(any(Evl.class))).thenReturn(true);
         
        Employee employee = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
    */
    // Verplaatsen naar los bestand
    // Test opvragen alles
    // Test opvragen
    // Test bewerken
    // Test delete
    // Test bovenstaande voor non-existent Evl
    /*
    @Test
    public void testAddEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(employeeDAO.addEmployee(any(Employee.class))).thenReturn(true);
         
        Employee employee = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
     
    @Test
    public void testFindAll() 
    {
        // given
        Employee employee1 = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        Employee employee2 = new Employee(2, "Alex", "Gussin", "example@gmail.com");
        Employees employees = new Employees();
        employees.setEmployeeList(Arrays.asList(employee1, employee2));
 
        when(employeeDAO.getAllEmployees()).thenReturn(employees);
 
        // when
        Employees result = employeeController.getEmployees();
 
        // then
        assertThat(result.getEmployeeList().size()).isEqualTo(2);
         
        assertThat(result.getEmployeeList().get(0).getFirstName())
                        .isEqualTo(employee1.getFirstName());
         
        assertThat(result.getEmployeeList().get(1).getFirstName())
                        .isEqualTo(employee2.getFirstName());
    }
    */
//}


