import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Flood fill with overflow takes a filepath as args[0]
 * File should be structured as follows
 * Width Height
 * Image consisting
 * of char
 * starting point x y replacement char
 * 
 * Example file:
 * 3 2
 * xxx
 * x.x
 * 1 2 x
 */

public class main {
	public static void main(String[] args) throws IOException  {
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));

		String imageSize[] = reader.readLine().split(" ");
		int width = Integer.parseInt(imageSize[0]);
        int height = Integer.parseInt(imageSize[1]);
        
        char[][] image = new char[width][height];
        for(int h = 0; h < height;h++){
            String line = reader.readLine();
            for(int w = 0; w < width;w++){
            	image[w][h] = line.charAt(w);
            }
        }
        
        String[] floodInfo = reader.readLine().split(" ");
        Point startPoint = new Point();
        startPoint.x = Integer.parseInt(floodInfo[0]);
        startPoint.y = Integer.parseInt(floodInfo[1]);
        char replacementChar = floodInfo[2].charAt(0);
        
        FloodFill flood = new FloodFill(image,replacementChar,startPoint);
        flood.startFlood(true);
        image = flood.getImage();
        
        for(int c = 0; c < image[0].length;c++){
            for(int r = 0; r < image.length; r++){       
                System.out.print(image[r][c]);
            }
            System.out.println();
        }
	}
}
