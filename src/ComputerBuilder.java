public class ComputerBuilder

{
	public static Computer c;
	public static Disk currentDisk;

public static void computer()
{
 c = new Computer(null, null);
}

public static void processor() {
Processor p = new Processor(0, null);
 c = new Computer(p, null);
}

public static void cores(int nbCores){
    Processor p = new Processor(nbCores, null);
    c = new Computer(p, null);
}

public static void i386(){
    Processor p = new Processor(c.getProcessor().getCores(), Processor.Type.i386);
    c = new Computer(p, null);
}

public static void disk(){
	Disk [] d = c.getDisks();
	Disk [] arrayDisk;
	if (d != null) {
		arrayDisk = new Disk[d.length+1];
		for (int i = 0; i < d.length; i++){
			arrayDisk[i] = d[i];
		}

	} else {
	    arrayDisk = new Disk[1];
	}
	c = new Computer(c.getProcessor(), arrayDisk);
}

public static void sata(){
	Disk [] diskArray = c.getDisks();
	int l = diskArray.length;
	Disk oldDisk = diskArray[l-1];
	Disk newDisk = new Disk(oldDisk.getSize(), oldDisk.getSpeed(), Disk.Interface.SATA);
	diskArray[l-1] = newDisk;
c = new Computer(c.getProcessor(),diskArray);
}

public static void speed(int s)
{
	Disk [] diskArray = c.getDisks();
	int l = diskArray.length;
	Disk oldDisk = diskArray[l-1];
	System.out.println(oldDisk);
	Disk newDisk = new Disk(oldDisk.getSize(), s, oldDisk.getIface());
	diskArray[l-1] = newDisk;
c = new Computer(c.getProcessor(),diskArray);
}

public static void size(int size){
	Disk d = new Disk(size, 0, null);
	c.getDisks()[c.getDisks().length-1] = d;
    c = new Computer(c.getProcessor(), c.getDisks());
}

	public static Computer script1()
	{
		// DSL script
		computer();
		// DSL script
		return c;
	}

	public static Computer script2()
	{

	    computer();
	      processor();
	        cores(2);
	        i386();

		return c;
	}

	public static Computer script3()
	{

	    computer();
	      processor();
	        cores(2);
	        i386();
	      disk();
	        size(150);

		return c;
	}

public static Computer script4()
{
	computer();
      processor();
        cores(2);
        i386();
      disk();
        size(150);
      disk();
		size(75);
        speed(7200);
        sata();
 
 return c;
 }

public static void main(String arg[]) {
	script4();
}
}