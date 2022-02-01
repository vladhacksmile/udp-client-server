import java.awt.geom.Ellipse2D;

public class OrganizationCircle {
    private int x;
    private int y;
    private int id;
    private Ellipse2D shape;
    private Organization organization;
    private boolean triggered;

    public OrganizationCircle(Ellipse2D shape, Organization organization) {
        this.shape = shape;
        this.organization = organization;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ellipse2D getShape() {
        return shape;
    }

    public void setShape(Ellipse2D shape) {
        this.shape = shape;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public boolean isTriggered() {
        return triggered;
    }

    public void setTriggered(boolean triggered) {
        this.triggered = triggered;
    }
}
