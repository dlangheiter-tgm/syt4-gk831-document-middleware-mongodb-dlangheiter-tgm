package windcentral;


import general.SimplexNoise;

public class WindengineSimulation {

    private int id;
    private SimplexNoise[] noises = new SimplexNoise[6];
    private byte noiseCount = 0;
    private double x = 0.0;

    public WindengineSimulation(int id) {
        this.id = id;
        for (int i = 0; i < noises.length; i++) {
            this.noises[i] = new SimplexNoise((int) (Math.random() * 100));
        }
    }

    private double getRandomDouble(int inMinimum, int inMaximum) {
        if (noiseCount + 1 > noises.length) {
            noiseCount = 0;
        }
        double rand = (noises[noiseCount].noise(x, 0) + 1.0) / 2;
        noiseCount++;

        double number = (rand * ((inMaximum - inMinimum) + 1)) + inMinimum;
        return Math.round(number * 100.0) / 100.0;
    }

    private int getRandomInt(int inMinimum, int inMaximum) {
        return ((int) (this.getRandomDouble(inMinimum, inMaximum)*100))/100;
    }

    public WindengineData getData() {
        x += 0.02;

        WindengineData data = new WindengineData();
        data.setWindengineID(id);
        data.setWindspeed(getRandomDouble(0, 80));
        data.setTemperature(getRandomDouble(-40, 40));
        data.setPower(getRandomDouble(0, 2000));
        data.setBlindpower(getRandomDouble(0, 200));
        data.setRotationspeed(getRandomDouble(0, 200));
        data.setBladeposition(getRandomInt(0, 45));
        return data;
    }

}