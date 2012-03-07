public class Computer {

    private final Processor processor;

    private final Disk[] disks;

    public Computer(Processor processor, Disk[] disks) {
        this.processor = processor;
        this.disks = disks;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Disk[] getDisks() {
        return disks;
    }
    
}