public class Processor {

    private final int cores;

    private final Type type;

    public Processor(int cores, Type type) {
        this.cores = cores;
        this.type = type;
    }

    public int getCores() {
        return cores;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        i386, i586, i686
    }
}