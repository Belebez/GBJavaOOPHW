public class Transport {
    protected String typeOfTransport;


    public Transport() {
        this.typeOfTransport = getTypeOfTransport();
    }

    protected String getTypeOfTransport() {
        return typeOfTransport;
    }

    protected void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }
}
