package pageReplaceAlgoTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ fifoTest.class, lruTest.class, NfuTest.class, OptimalTest.class })
public class AllTests {

}
