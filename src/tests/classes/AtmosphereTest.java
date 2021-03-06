package classes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 09/01/2017.
 */
public class AtmosphereTest {

    @Test
    public void testAtmosphere() {
    /* Case of Atmosphere */
        Atmosphere atmosphere = new Atmosphere(10, 20.2, 200, 15);

        System.out.println(String.format("Humidity: %s", atmosphere.getHumidity()));
        System.out.println(String.format("Pressure: %s", atmosphere.getPressure()));
        System.out.println(String.format("Rising: %s", atmosphere.getRising()));
        System.out.println(String.format("Visibility: %s", atmosphere.getVisibility()));

        assertEquals(10, atmosphere.getHumidity());
        assertEquals(20.2, atmosphere.getPressure(),2);
        assertEquals(200, atmosphere.getVisibility(),0);
        assertEquals(15, atmosphere.getRising());

    }

}