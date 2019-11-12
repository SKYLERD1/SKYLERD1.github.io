/*
Author Name: Skyler Swiderski
Date: 08/28/2019
Program Name: Swiderski_Drone
Purpose: In this particular file, it provides the information/data needed to create the drone
	object for the application class. This is a service class.
*/

package week01_drone;

public class Swiderski_Drone_ServiceClass {
	public double x_loc;
	public double y_loc;
	public double z_loc;
	
	/**
	This is a default constructor. It sets the x, y, z coordinate/number positions of the drone to 0.
	*/
	public Swiderski_Drone_ServiceClass() {
		this.x_loc = 0.0;
		this.y_loc = 0.0;
		this.z_loc = 0.0;
	}
	
	/**
	This method sets a new value for the x-coordinate/number position of the drone.

	@param new_x_loc This parameter variable adds the new x value for 
		the current x-coordinate/number position of the drone.
	 * @return 
	*/
	public void setX_Loc(double new_x_loc) {
		this.x_loc += new_x_loc;
	}

	/**
	This method sets a new value for the y-coordinate/number position of the drone.

	@param new_y_loc This parameter variable adds the new y value for 
		the current y-coordinate/number position of the drone.
	*/
	public void setY_Loc(double new_y_loc) {
		this.y_loc += new_y_loc;
	}

	/**
	This method sets a new value for the z-coordinate/number position of the drone.

	@param new_z_loc This parameter variable adds the new z value for 
		the current z-coordinate/number position of the drone.
	*/
	public void setZ_Loc(double new_z_loc) {
		this.z_loc += new_z_loc;
	}

	/**
	This method returns the X-coordinate/number position of the drone.

	@return x_loc This variable contains x-coordinate/number position of the drone.
	*/
	public double getX_Loc() {
		return this.x_loc;
	}

	/**
	This method returns the Y-coordinate/number position of the drone.

	@return y_loc This variable contains y-coordinate/number position of the drone.
	*/
	public double getY_Loc() {
		return this.y_loc;
	}
	
	/**
	This method returns the Z-coordinate/number position of the drone.

	@return z_loc This variable contains z-coordinate/number position of the drone.
	*/
	public double getZ_Loc() {
		return this.z_loc;
	}

	/**
	This method returns the x, y, z coordinate/number positions of the drone in a string message.

	@return msg This variable contains a message to the user about the x, y, z
		coordinate/number positions of the drone.
	*/
	public String getXYZ_Loc() {
		String msg = "Current Drone Location Positions:" + "\n" + "X: " + this.getX_Loc() +
			"\n" + "Y: " + this.getY_Loc() + "\n" + "Z: " + this.getZ_Loc();
		return msg;
	}
}
