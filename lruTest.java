package pageReplaceAlgoTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class lruTest {

	@Test
	public void testLRU() {
		
		int result;

		//2	0 1 2 3 0 1 2 3 0 -1	0, 9
		lru test = new lru();
		test.pageString = new int[]{0, 1, 2, 3, 0, 1, 2, 3, 0, -1};
		test.lengthOfString = test.pageString.length;
		test.noOfFrames = 2;
		result = test.pageToFrame();
		assertEquals(0, result);	

		//3	12 13 15 16 17 18 -1	0, 6
		lru test1 = new lru();
		test1.pageString = new int[]{12, 13, 15, 16, 17, 18, -1};
		test1.lengthOfString = test1.pageString.length;
		test1.noOfFrames = 3;
		result = test1.pageToFrame();
		assertEquals(0, result);	

		//2	00 00 00 01 02 03 04 05 -1	2, 8
		lru test2 = new lru();
		test2.pageString = new int[]{00, 00, 00, 01, 02, 03, 04, 05, -1};
		test2.lengthOfString = test2.pageString.length;
		test2.noOfFrames = 2;
		result = test2.pageToFrame();
		assertEquals(2, result);

		//2	1 2 3 2 1 2 3 1 2 -1	2, 9
		lru test3 = new lru();
		test3.pageString = new int[]{1, 2, 3, 2, 1, 2, 3, 1, 2, -1};
		test3.lengthOfString = test3.pageString.length;
		test3.noOfFrames = 2;
		result = test3.pageToFrame();
		assertEquals(2, result);

		//3	1 1 1 2 3 4 2 1 4 3 2 1 4 3 1 -1	5, 15
		lru test4 = new lru();
		test4.pageString = new int[]{1, 1, 1, 2, 3, 4, 2, 1, 4, 3, 2, 1, 4, 3, 1, -1};
		test4.lengthOfString = test4.pageString.length;
		test4.noOfFrames = 3;
		result = test4.pageToFrame();
		assertEquals(5, result);

		//3	1 2 3 4 1 2 3 4 1 2 3 4 -1	0, 12
		lru test5 = new lru();
		test5.pageString = new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, -1};
		test5.lengthOfString = test5.pageString.length;
		test5.noOfFrames = 3;
		result = test5.pageToFrame();
		assertEquals(0, result);

		//3	1 3 7 4 7 5 1 3 6 2 1 7 -1	1, 12
		lru test6 = new lru();
		test6.pageString = new int[]{1, 3, 7, 4, 7, 5, 1, 3, 6, 2, 1, 7, -1};
		test6.lengthOfString = test6.pageString.length;
		test6.noOfFrames = 3;
		result = test6.pageToFrame();
		assertEquals(1, result);

		//3	4 7 3 0 1 7 3 8 5 4 5 3 4 7 -1	2, 14
		lru test7 = new lru();
		test7.pageString = new int[]{4, 7, 3, 0, 1, 7, 3, 8, 5, 4, 5, 3, 4, 7, -1};
		test7.lengthOfString = test7.pageString.length;
		test7.noOfFrames = 3;
		result = test7.pageToFrame();
		assertEquals(2, result);

		//3	0 1 2 3 1 3 1 3 2 1 3 1 -1	8, 12
		lru test8 = new lru();
		test8.pageString = new int[]{0, 1, 2, 3, 1, 3, 1, 3, 2, 1, 3, 1, -1};
		test8.lengthOfString = test8.pageString.length;
		test8.noOfFrames = 3;
		result = test8.pageToFrame();
		assertEquals(8, result);

		//3	1 2 3 4 1 2 5 1 2 3 4 5 -1	2, 12
		lru test9 = new lru();
		test9.pageString = new int[]{1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5, -1};
		test9.lengthOfString = test9.pageString.length;
		test9.noOfFrames = 3;
		result = test9.pageToFrame();
		assertEquals(2, result);

		//3	7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 -1	5, 16
		lru test10 = new lru();
		test10.pageString = new int[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, -1};
		test10.lengthOfString = test10.pageString.length;
		test10.noOfFrames = 3;
		result = test10.pageToFrame();
		assertEquals(5, result);

		//3	7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1 -1	8, 20
		lru test11 = new lru();
		test11.pageString = new int[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1, -1};
		test11.lengthOfString = test11.pageString.length;
		test11.noOfFrames = 3;
		result = test11.pageToFrame();
		assertEquals(8, result);

		//2	0 1 2 1 3 1 3 2 1 3 1 -1	4, 11
		lru test12 = new lru();
		test12.pageString = new int[]{0, 1, 2, 1, 3, 1, 3, 2, 1, 3, 1, -1};
		test12.lengthOfString = test12.pageString.length;
		test12.noOfFrames = 2;
		result = test12.pageToFrame();
		assertEquals(4, result);
	}

}
