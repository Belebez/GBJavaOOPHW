public class Railway extends Ground{
    protected String typeTrain;

    public Railway() {
        super();
        this.typeTrain = getTypeTrain();
    }

    protected String getTypeTrain() {
        return typeTrain;
    }

    protected void setTypeTrain(String typeTrain) {
        this.typeTrain = typeTrain;
    }
}
