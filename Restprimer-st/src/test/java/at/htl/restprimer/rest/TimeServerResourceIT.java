package at.htl.restprimer.rest;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class TimeServerResourceIT {
    private Client client;
    private WebTarget tut;

    @Before
    public void initClien(){
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/restprimer-st-1.0-SNAPSHOT/rs/time");
    }

    @Test
    public void fetchTime(){
        Response response = this
                .tut
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();
        assertThat(response.getStatus(), is(200));
        String payload = response.readEntity(String.class);
        assertTrue(payload.startsWith("time"));
    }

    public static void main(String args[]){
        System.out.println("Hello World");
    }
}
