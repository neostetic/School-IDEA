package cz.polacek.kruh;

public class Application {

    public static void main(String[] args) {
        printCircle(generateCircle(new char[14][14], 10, 'o'));
    }

    public static char[][] generateCircle(char[][] array, int r, char character) {
        int a = array.length/2;
        int b = array[0].length/2;
        r = r/2;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if ((int) Math.sqrt((x-a)*(x-a) + (y-b)*(y-b)) == r) {
                    array[x][y] = character;
                } else {
                    array[x][y] = ' ';
                }
            }
        }
        return array;
    }

    public static void printCircle(char[][] c) {
        for (char[] chars : c) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

}
