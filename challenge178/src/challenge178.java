public class challenge178 {
	public static double[] startingPos = new double[2];
	public static void main(String[] args) {
		startingPos[0] = 0;
		startingPos[1] = 5;
		startingPos = translate(startingPos,3, 2);
		startingPos = scale(startingPos,1,3,0.5);
		startingPos = rotate(startingPos,3,2,1.57079632679);
		startingPos = reflect(startingPos,'X');
		startingPos = translate(startingPos,2,-1);
		startingPos = scale(startingPos,0,0,-0.25);
		startingPos = rotate(startingPos,1,-3,3.14159265359);
		startingPos = reflect(startingPos,'Y');
		System.out.print(startingPos[0]);
		System.out.print(startingPos[1]);

	}
	public static double[] translate(double[] currentPos,double translateX,double translateY){
		currentPos[0] = currentPos[0] + translateX;
		currentPos[1] = currentPos[1] + translateY;
		
		return currentPos;
	}
	public static double[] rotate(double[] currentPos,double rotateX,double rotateY,double angle){
		double[] rotatedPos = new double[2];
		
		currentPos = translate(currentPos,-rotateX,-rotateY);
		rotatedPos[0] = currentPos[0] * Math.cos(angle) + currentPos[1] * Math.sin(angle);
		rotatedPos[1] =- currentPos[0] * Math.sin(angle) + currentPos[1] * Math.cos(angle);
		currentPos = translate(rotatedPos,rotateX,rotateY);
		
		return currentPos;
	}
	public static double[] scale(double[] currentPos,double scaleX,double scaleY,double scale){
		double[] scaledPos = new double[2];
		
		currentPos = translate(currentPos,-scaleX,-scaleY);
		scaledPos[0] = currentPos[0] * scale;
		scaledPos[1] = currentPos[1] * scale;
		currentPos = translate(scaledPos,scaleX,scaleY);
		
		return currentPos;
	}
	public static double[] reflect(double[] currentPos,char reflectAxis){
		
		if(reflectAxis == 'X'){
			currentPos[1] = -currentPos[1];
		}
		else if(reflectAxis == 'Y'){
			currentPos[0] = -currentPos[0];
		}
		
		return currentPos;
	}
}
