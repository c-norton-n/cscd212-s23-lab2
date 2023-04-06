package cscd212classes.lab2;

public class Television implements Comparable<Television> {

    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart,
                      final int screenSize, final int resolution,
                      final String make) {
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        this.fourK = (resolution == 2160) ? true : false;
    }

    public Television(final String make, final String model,
                      final boolean smart, final int screenSize,
                      final int resolution) {
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        this.fourK = (resolution == 2160) ? true : false;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getResolution() {
        return this.resolution;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    public int compareTo(final Television t) {
        if (this.make.compareTo(t.getMake()) == 0) {
            if (this.model.compareTo(t.getModel()) == 0) {
                return this.screenSize - t.getScreenSize();
            }
            return this.model.compareTo(t.getModel());
        }
        return this.make.compareTo(t.getMake());
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (o instanceof Television)
            return false;
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode()
            + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK)
            + resolution;
    }
}
