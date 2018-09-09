public class Vehicle
{
    // A unique ID for this vehicle.
    private String id;
    // The destination of this vehicle.
    private String destination;
    // The location of this vehicle.
    private String location;




    /**
     * Constructor for objects of class Taxi.
     * @param base The name of the company's base.
     * @param id This Vehicle's unique id.
     */
    public Vehicle(String id)
    {
        this.id = id;
    }

    /**
     * Return the status of this vehicle.
     * @return The status.
     */
    public String getStatus()
    {
        return id + " at " + location + " headed for " + destination;
    }

    /**
     * Return the ID of the vehicle.
     * @return The ID of the vehicle.
     */
    public String getID()
    {
        return id;
    }


    /**
     * Return the location of the vehicle.
     * @return The location of the vehicle.
     */
    public String getLocation()
    {
        return location;
    }


    /**
     * Sets the location of the vehicle.
     * @param location The intended location
     */
    public void setLocation(String location)
    {
        this.location = location;
    }


    /**
     * Return the destination of the vehicle.
     * @return The destination of the vehicle.
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * Set the intented destination of the vehicle.
     * @param destination The intended destination.
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }

}