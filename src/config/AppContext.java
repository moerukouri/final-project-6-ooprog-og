package config;

public class AppContext {
    private AppContext() {}
    private static final AppContext INSTANCE = new AppContext();

    public AppContext getInstance() {
        return INSTANCE;
    }

    
}