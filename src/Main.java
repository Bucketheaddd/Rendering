import java.awt.Graphics;
import java.util.ArrayList;

import Vector.Vector;
import Environment.Point;
import Rendering.Camera;

public class Main {
	int width,height;
	Camera c = new Camera();
	ArrayList<Point> points = new ArrayList<Point>();
	double theta = 0;
	
	public void setup(){ 
		for(int i = 0; i < 10;i++ ){
			for(int j = 0; j < 10; j++){
				for(int k = 0; k < 10; k++){
					points.add( new Point(new Vector((double) i+1,(double) j,(double) k)));
				}
			}
			
		}
		//c.dir.mult(-1);
	}

	public void update(){
		c.pos.add(new Vector(0.001,0.001,0.001));
		//c.dir = new Vector(-Math.cos(theta), Math.sin(theta), 0);
		theta -= 0.001;
		
		//System.out.println(c.dir.toString());
	}

	public void show(Graphics g){
		for(Point point: points){
			c.plot(g, point);
		}
		
	}

	public Main(int width,int height){
		this.width = width;
		this.height = height;
	}
}
