package MathUtils.tests;

import MathUtils.vector.Vector2D;

public class Vector2DCloneTest {

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1,1);
        Vector2D v2 = v1.clone();

        v2.setX(2);

        System.out.println();

    }

}
