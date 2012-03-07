import junit.framework.Assert;
import org.junit.Test;

public class FunctionSequenceDSLTest {
    /* DSL final
    computer();
      processor();
        cores(2);
        i386();
      disk();
        size(150);
      disk()
	size(75);
        speed(7200);
        sata();
    */

@Test
public final void testTruth() {
	Assert.assertEquals(true, true);
	}

@Test
public final void testComputerWithoutDevices(){
  Computer c = new Computer(null, null);
  Assert.assertEquals(c.getProcessor(), null);
}

@Test
public final void testComputerStatement(){
  Assert.assertEquals(ComputerBuilder.script1().getProcessor(), null);
}
@Test
public final void testComputerWith1Processor(){
  Assert.assertEquals(ComputerBuilder.script2().getProcessor().getCores(), 2);
  Assert.assertEquals(ComputerBuilder.script2().getProcessor().getType(), Processor.Type.i386);
}
@Test
public final void testComputerWith1Processor1Disk(){
  Assert.assertEquals(ComputerBuilder.script3().getProcessor().getCores(), 2);
  Assert.assertEquals(ComputerBuilder.script3().getProcessor().getType(), Processor.Type.i386);
  Assert.assertEquals(ComputerBuilder.script3().getDisks().length, 1);
  Assert.assertEquals(ComputerBuilder.script3().getDisks()[0].getSize(), 150);
}

@Test
public final void testComputerWith1Processor2Disk(){
  Assert.assertEquals(ComputerBuilder.script4().getProcessor().getCores(), 2);
  Assert.assertEquals(ComputerBuilder.script4().getProcessor().getType(), Processor.Type.i386);
  Assert.assertEquals(ComputerBuilder.script4().getDisks().length, 2);
  Assert.assertEquals(ComputerBuilder.script4().getDisks()[0].getSize(), 150);
}
}