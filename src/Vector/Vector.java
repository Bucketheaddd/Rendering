package Vector;

public class Vector {
	public double x,y,z;
	public static Vector i = new Vector(1,0,0);
	public static Vector j = new Vector(0,1,0);
	public static Vector k = new Vector(0,0,1);
	
	
	public void add(Vector v){
		this.x += v.x;
		this.y += v.y;
		this.z += v.z;
	}
	public void mult(double a){
		x*=a;
		y*=a;
		z*=a;
	}
	
	public static Vector add(Vector v1, Vector v2){
		return null;
	}
	public static Vector sub(Vector v1, Vector v2){
		return new Vector(v1.x - v2.x,v1.y - v2.y, v1.z - v2.z);
	}
	
	public Vector cross(Vector v){
		return cross(this, v);
	} 
	
	public static Vector cross(Vector v1, Vector v2){
		return new Vector((v1.y * v2.z - v2.y * v1.z),
				(v1.x * v2.z - v2.x * v1.z),
				(v1.y * v2.x - v2.y * v1.x));
	}
	
	public double mag(){
		return Math.sqrt(x*x + y*y + z*z);
	}
	 
	public void dot(Vector v){
		 
	}
	
	public static double dot(Vector v1, Vector v2){
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}
	
	public String toString(){
		return x + " " + y + " " + z;
	}
	
	public Vector(){
		this.x = 0;
		this.y=0;
		this.z=0;
	}
	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
 