package D_22_01_25.Level1;

public class EarthVolume {
    public static void main(String[] args){
        int radius = 6378;
        float pi = 3.14f;
        float volume = (float)(4/3*pi*radius*radius*radius);
        float volumeMiles = (float)(volume*0.6);
        System.out.println("The volume of earth in cubic kilometers is "+volume+" and cubic miles is "+volumeMiles);
    }
}
