public class Automobile extends Ground{
    protected String typeAutomobile;

    public Automobile() {
        super();
        this.typeAutomobile = getTypeAutomobile();
    }

    protected String getTypeAutomobile() {
        return typeAutomobile;
    }

    protected void setTypeAutomobile(String typeAutomobile) {
        this.typeAutomobile = typeAutomobile;
    }
}
