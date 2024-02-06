import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class bikeTest {

    private Bike myBike;

    @BeforeEach
    public void initializeBike(){
        myBike = new Bike();
    }

    @Test
    public void turnBikeOn_bikeTurnOn(){
        assertFalse(myBike.checkStatus());

        myBike.start();

        assertTrue(myBike.checkStatus());
    }

    @Test
    public void turnBikeOff_bikeTurnOff(){
        assertFalse(myBike.checkStatus());

        myBike.start();
        assertTrue(myBike.checkStatus());

        myBike.stop();
        assertFalse(myBike.checkStatus());
    }

    @Test
    public void bikeIsOff_turnBikeOff(){
        assertFalse(myBike.checkStatus());

        myBike.stop();
        assertFalse(myBike.checkStatus());
    }

    @Test
    public void accelerateBike_speedIncreases(){
        assertFalse(myBike.checkStatus());
        myBike.start();
        assertEquals(1, myBike.checkGear());
        assertEquals(0, myBike.checkSpeedometer());

        myBike.accelerator();
        assertEquals(1, myBike.checkSpeedometer());
        assertEquals(1, myBike.checkGear());

        myBike.accelerator();
        myBike.accelerator();
        assertEquals(3, myBike.checkSpeedometer());
    }

    @Test
    public void accelerateBikeWhileOff_speedDoesntIncrease(){
        assertFalse(myBike.checkStatus());

        myBike.accelerator();
        assertEquals(0, myBike.checkSpeedometer());
    }

    @Test
    public void accelerateToMoreThan20_changGearTo2() {
        assertFalse(myBike.checkStatus());
        myBike.start();
        for (int count = 1; count <= 20; count++) {
            myBike.accelerator();
        }
        assertEquals(20, myBike.checkSpeedometer());
        assertEquals(1, myBike.checkGear());

        myBike.accelerator();
        assertEquals(21, myBike.checkSpeedometer());
        assertEquals(2, myBike.checkGear());

        myBike.accelerator();
        assertEquals(2, myBike.checkGear());
        assertEquals(23, myBike.checkSpeedometer());
    }

    @Test
    public void changeGearTo2_accelerateTwice(){
        assertFalse(myBike.checkStatus());
        myBike.start();
        for (int count = 1; count <= 22; count++) {
            myBike.accelerator();
        }
        assertEquals(2, myBike.checkGear());
        assertEquals(23, myBike.checkSpeedometer());

        myBike.accelerator();
        assertEquals(25, myBike.checkSpeedometer());
    }

    @Test
    public void accelerateToMoreThan30_changGearTo3() {
        assertFalse(myBike.checkStatus());
        myBike.start();
        for (int count = 1; count <= 20; count++) {
            myBike.accelerator();
        }
        assertEquals(20, myBike.checkSpeedometer());
        assertEquals(1, myBike.checkGear());

        for (int count = 1; count <= 5; count++) {
            myBike.accelerator();
        }
        assertEquals(2, myBike.checkGear());
        assertEquals(29, myBike.checkSpeedometer());

        myBike.accelerator();
        assertEquals(3, myBike.checkGear());
        assertEquals(31, myBike.checkSpeedometer());
    }

    @Test
    public void gearAt3_accelerateThrice(){
        assertFalse(myBike.checkStatus());
        myBike.start();
        for (int count = 1; count <= 26; count++) {
            myBike.accelerator();
        }
        assertEquals(31, myBike.checkSpeedometer());
        assertEquals(3, myBike.checkGear());

        myBike.accelerator();
        assertEquals(34, myBike.checkSpeedometer());

        myBike.accelerator();
        assertEquals(37, myBike.checkSpeedometer());
    }

    @Test
    public void accelerateMoreThan40_gearChangeTo4(){
        assertFalse(myBike.checkStatus());
        myBike.start();
        for (int count = 1; count <=29; count++) {
            myBike.accelerator();
        }
        assertEquals(40, myBike.checkSpeedometer());
        assertEquals(3, myBike.checkGear());

        myBike.accelerator();
        assertEquals(4, myBike.checkGear());
        assertEquals(43, myBike.checkSpeedometer());

        myBike.accelerator();
        assertEquals(47, myBike.checkSpeedometer());
    }

    @Test
    public void carDoesNotDecelerateWhenOff(){
        assertFalse(myBike.checkStatus());

        myBike.brake();
        assertFalse(myBike.checkStatus());
    }

    @Test
    public void bikeGear1_speedReduceBy1(){
        assertFalse(myBike.checkStatus());
        myBike.start();
        assertEquals(1, myBike.checkGear());

        for (int count = 1; count <= 15; count++){
            myBike.accelerator();
        }
        assertEquals(15, myBike.checkSpeedometer());

        myBike.brake();
        assertEquals(14, myBike.checkSpeedometer());

        myBike.brake();
        myBike.brake();
        assertEquals(12, myBike.checkSpeedometer());
    }

    @Test
    public void bikeOnGear2_itDecreasesTwice(){
        assertFalse(myBike.checkStatus());
        myBike.start();
        for (int count = 1; count <= 23; count++) {
            myBike.accelerator();
        }
        assertEquals(25, myBike.checkSpeedometer());
        assertEquals(2, myBike.changeGear());

        myBike.brake();
        assertEquals(23, myBike.checkSpeedometer());
        myBike.brake();
        assertEquals(21, myBike.checkSpeedometer());
    }

    @Test
    public void bikeOnGear3_itDecreasesThrice(){
        assertFalse(myBike.checkStatus());
        myBike.start();
        for (int count = 1; count <= 28; count ++){
            myBike.accelerator();
        }
        assertEquals(37, myBike.checkSpeedometer());
        assertEquals(3, myBike.checkGear());

        myBike.brake();
        assertEquals(34, myBike.checkSpeedometer());
        myBike.brake();
        assertEquals(31, myBike.checkSpeedometer());
    }

    @Test
    public void bikeOnGear4_itDecreasesFourTimes(){
        assertFalse(myBike.checkStatus());
        myBike.start();
        for (int count = 1; count <= 31; count ++){
            myBike.accelerator();
        }
        assertEquals(47, myBike.checkSpeedometer());
        assertEquals(4, myBike.checkGear());

        myBike.brake();
        assertEquals(43, myBike.checkSpeedometer());
        myBike.brake();
        assertEquals(39, myBike.checkSpeedometer());
    }
}
