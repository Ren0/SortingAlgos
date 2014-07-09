package sortingalgostest;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class ParallelSortTest {
	@Test
	public void test() {
		JUnitCore.runClasses(ParallelComputer.methods(), SortTest.class);
	}
}
