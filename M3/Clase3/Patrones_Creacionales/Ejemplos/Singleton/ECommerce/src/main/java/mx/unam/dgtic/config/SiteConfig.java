package mx.unam.dgtic.config;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class SiteConfig {
    private static SiteConfig instance;
    private String siteName;
    private String theme;
    private boolean enableNotifications;

    private SiteConfig(){
        siteName="My online shop";
        theme="#e3e3e3";
        enableNotifications=true;
    }

    public static SiteConfig  getInstance(){
        if(instance == null){
            instance=new SiteConfig();
        }
        return instance;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isEnableNotifications() {
        return enableNotifications;
    }

    public void setEnableNotifications(boolean enableNotifications) {
        this.enableNotifications = enableNotifications;
    }

    @Override
    public String toString() {
        return "SiteConfig{" +
                "siteName='" + siteName + '\'' +
                ", theme='" + theme + '\'' +
                ", enableNotifications=" + enableNotifications +
                '}';
    }
}
