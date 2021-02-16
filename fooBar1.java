package testHello;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

	public static void main(String[] args) {
        int remainingArea = 15324;
        List<Integer> areas = new ArrayList<>();
        int side = remainingArea;
        while (side != 0) {
            side = (int) Math.floor(Math.sqrt(remainingArea));
            int area = side * side;
            remainingArea = remainingArea - area;
            if (side != 0) {
                areas.add(area);
            }
        }

        Integer[] TableauFix = areas.toArray(new Integer[0]);
//		return TableauFix
	}
}
