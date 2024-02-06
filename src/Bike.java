public class Bike {

    private boolean isOn;
    private int speedometer;
    private int gear;

    public boolean checkStatus() {
        return isOn;
    }

    public void start() {
        isOn = true;
    }

    public void stop() {
        isOn = false;
    }

    public int checkGear() {
        return gear;
    }

    public int changeGear(){
        if (checkSpeedometer() >=0 && checkSpeedometer() <= 20){
            return 1;
        } else if (checkSpeedometer() >= 21 && checkSpeedometer() <= 30) {
            return 2;
        } else if (checkSpeedometer() >=31 && checkSpeedometer() <= 40) {
            return 3;
        } else return 4;
    }

    public int checkSpeedometer() {
        return speedometer;
    }

    public void accelerator() {
        if (isOn) {
            gear = changeGear();
            if (checkSpeedometer() >= 0 && checkSpeedometer() <= 20) {
                speedometer++;
            } else if (checkSpeedometer() >= 21 && checkSpeedometer() <= 30) {
                speedometer += 2;
            } else if (checkSpeedometer() >= 31 && checkSpeedometer() <= 40) {
                speedometer += 3;
            } else if (checkSpeedometer() > 41) {
                speedometer += 4;
            }
            gear = changeGear();
        }
    }

    public void brake() {
        if(isOn) {
            gear = changeGear();
            if (checkSpeedometer() >= 0 && checkSpeedometer() <= 20) {
                speedometer--;
            } else if (checkSpeedometer() >=21 && checkSpeedometer() <= 30) {
                speedometer -= 2;
            } else if (checkSpeedometer() >=31 && checkSpeedometer() <= 40) {
                speedometer -= 3;
            } else if (checkSpeedometer() > 41) {
                speedometer -= 4;
            }
        }
    }
}


