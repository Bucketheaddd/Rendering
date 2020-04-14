package Rendering;

import java.awt.Color;
import java.awt.Graphics;

import Environment.*;
import Vector.Vector;

public class Camera {

	public Vector pos = new Vector(-20,0,0);
	public Vector dir = Vector.i;
	
	double theta_h = Math.PI / 4;
	double theta_v = Math.PI / 4;
	
	public final int width = 600;
	public final int height = 600;
	
	public void plot(Graphics g, Point p){
		
		Vector P = Vector.sub(p.pos, this.pos);
		
		if(Math.acos(Vector.dot(P, dir) / (P.mag() * dir.mag())) > Math.PI / 2){
			return;
		}
		
		Vector N_v = Vector.cross(dir, Vector.k);
		Vector N_h = Vector.cross(dir, N_v);
		
		
		int x = (int) (map( -Math.acos(Vector.dot(P,N_v) / (P.mag() * N_v.mag())) + Math.PI / 2, -theta_v / 2, theta_v / 2, 0, width));
		int y = (int) (map( -Math.acos(Vector.dot(P,N_h) / (P.mag() * N_h.mag())) + Math.PI / 2, -theta_h / 2, theta_h / 2, 0, height));
		
		g.setColor(Color.WHITE);
		
		g.drawRect(x, height - y, 2, 2);
		
	}
	
	private int[] getPoints(Point p){
		Vector N_v = Vector.cross(dir, Vector.k);
		Vector N_h = Vector.cross(dir, N_v);
		Vector P = Vector.sub(p.pos, this.pos);
		
		int x = (int) (map( -Math.acos(Vector.dot(P,N_v) / P.mag()) + Math.PI / 2, -theta_v / 2, theta_v / 2, 0, width));
		int y = (int) (map( -Math.acos(Vector.dot(P,N_h) / P.mag()) + Math.PI / 2, -theta_h / 2, theta_h / 2, 0, height));
		
		return new int[]{x,y};
	}
	
	public void plot(Graphics g, Point p1, Point p2){
		
	}
	
	public double map(double value, double low1, double high1, double low2, double high2){
		return low2 + (value - low1) * (high2 - low2) / (high1 - low1);
	}

}
