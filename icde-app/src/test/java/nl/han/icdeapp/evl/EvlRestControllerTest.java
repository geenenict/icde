package nl.han.icdeapp.evl;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EvlRestControllerTest 
{    	
    @LocalServerPort
    int serverPort;
	
    @Test
    public void testGetEvlListSuccess() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
         
        final String baseUrl = "http://localhost:" + serverPort + "/evls";
        URI uri = new URI(baseUrl);
     
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
         
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        //Assert.assertEquals(true, result.getBody().contains("["));
    }
}