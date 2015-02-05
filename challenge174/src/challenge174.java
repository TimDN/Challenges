import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

public class challenge174 {
	
	public static void main(String[] args){
		//Initialization
		int NumbOfColors = 8;
		int boardXSize = Integer.parseInt(args[0]);
		int boardYSize = Integer.parseInt(args[1]);
		int antSteps = Integer.parseInt(args[2]);
		Colour[] coloursArray = new Colour[NumbOfColors];
		coloursArray[0] = new Colour('R',Color.white,0);
		coloursArray[1] = new Colour('L',Color.black,1);
		coloursArray[2] = new Colour('R',Color.blue,2);
		coloursArray[3] = new Colour('L',Color.red,3);
		coloursArray[4] = new Colour('R',Color.green,4);
		coloursArray[5] = new Colour('L',Color.yellow,5);
		coloursArray[6] = new Colour('R',Color.gray,6);
		coloursArray[7] = new Colour('L',Color.pink,7);
		//Board(xSize,ySize,defaultColour)
		Board board = new Board(boardXSize,boardYSize,coloursArray[0]);
		//Ant(startPosX,startPosY)
		Ant ant = new Ant(boardXSize/2,boardYSize/2);
		//Hashmap of headings
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('N',2);
		map.put('E',3);
		map.put('S',0);
		map.put('W',1);
		//Ant loop
		int completedAntSteps = 0;
		while(completedAntSteps < antSteps)
		{
			int[] antPos = new int[2];
			char antHeading;
			char newAntHeading = 'N';
			Colour currentSquareColour;
			//Get ant position
			antPos[0] = ant.getPosX();
			antPos[1] = ant.getPosY();
			//get ant heading(North,East,West,South)
			antHeading = ant.getHeading();
			//get colour of Square that the ant is on
			currentSquareColour = (board.getSquare(antPos[0],antPos[1])).getCurrentColour();
			//Get turnDirection from Colour
			if(currentSquareColour.getTurnDirection() == 'L'){
				int temp = map.get(antHeading);
				if(temp - 1 < 0)
					newAntHeading = 'E';
				else
				{
					for (Entry<Character, Integer> entry : map.entrySet()) {
			            if (entry.getValue().equals(temp - 1)) {
			            	newAntHeading = entry.getKey();
			            }
			        }
				}
			}
			else if(currentSquareColour.getTurnDirection() == 'R'){
				int temp = map.get(antHeading);
				if(temp + 1 > 3)
					newAntHeading = 'S';
				else
				{
					for (Entry<Character, Integer> entry : map.entrySet()) {
			            if (entry.getValue().equals(temp + 1)) {
			            	newAntHeading = entry.getKey();
			            }
			        }
				}
			}
			else{
				System.err.print("WTF!!");
			}
			//Set new Heading
			 ant.setHeading(newAntHeading);
			ant.moveAnt();
			//Change color of the square that the ant left
			Square lastAntSquare = board.getSquare(antPos[0],antPos[1]);
			int colourPos =lastAntSquare.getCurrentColour().getColourPos();
			lastAntSquare.setCurrentColour(coloursArray[colourPos + 1 >= NumbOfColors ? 0 :colourPos + 1]);
			completedAntSteps++;
		}
		//Creates the Img for output
		BufferedImage img = new BufferedImage(boardXSize, boardYSize,
			    BufferedImage.TYPE_INT_RGB);
		for(int x = 0; x < boardXSize; x++){
			for(int y = 0; y < boardYSize;y++){
				//Get colour of Square(x,y) get the Color object of that class and its RGB value
				img.setRGB(x,y, ((board.getSquare(x, y)).getCurrentColour()).getColour().getRGB());
			}
		}
		File f = new File("AntPicture.png");
		try {
			ImageIO.write(img, "PNG", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("All Done");
	}
}
