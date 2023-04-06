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
        this(make, model, smart, screenSize, resolution);
    }

    public Television(final String make, final String model,
                      final boolean smart, final int screenSize,
                      final int resolution) {
        if (make == null)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        if (make.isEmpty())
            throw new IllegalArgumentException("Invalid parameter in constructor");
        if (model == null)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        if (model.isEmpty())
            throw new IllegalArgumentException("Invalid parameter in constructor");
        if (screenSize < 32)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        if (resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");
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
        if (t == null)
            throw new IllegalArgumentException
                ("null parameter in the compareTo method");
        if (this.make.compareTo(t.getMake()) == 0) {
            if (this.model.compareTo(t.getModel()) == 0) {
                return this.screenSize - t.getScreenSize();
            }
            return this.model.compareTo(t.getModel());
        }
        return this.make.compareTo(t.getMake());
    }

    public String toString() {
        return String.format
            ("%s-%s, %d inch%s tv with %s resolution",
             this.make, this.model, this.screenSize,
             (this.smart) ? " smart" : "",
             (this.fourK) ? "4K" : String.format("%d", this.resolution));
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Television))
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
