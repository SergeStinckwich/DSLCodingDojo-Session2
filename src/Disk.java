public class Disk {

    public static final int UNKNOWN_SIZE = -1;

    private final int size;

    private final int speed;

    private final Interface iface;

    public Disk(int size, int speed, Interface iface) {
        this.size = size;
        this.speed = speed;
        this.iface = iface;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public Interface getIface() {
        return iface;
    }

    public enum Interface {
        SATA, SAS
    }
}