public class Ground extends Transport{
    protected String typeGround;

    public Ground() {
        super();
        this.typeGround = getTypeGround();
    }

    protected String getTypeGround() {
        return typeGround;
    }

    protected void setTypeGround(String typeGround) {
        this.typeGround = typeGround;
    }

}
