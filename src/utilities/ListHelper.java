package utilities;

import java.util.List;
import java.util.Random;

public abstract class ListHelper {

	public static <T> T selectRandom (List<T> list) {
		Random random = new Random();
		int index = random.nextInt(list.size());
		return list.get(index);
	}
	
}
