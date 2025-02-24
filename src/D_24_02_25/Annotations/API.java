package D_24_02_25.Annotations;

class LegacyAPI{
    @Deprecated
    public void oldFeature(){
        System.out.println("This is an old feature");
    }
    public void newFeature(){
        System.out.println("This is a new feature");
    }
}
public class API {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
