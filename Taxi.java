/**
 * A taxi.
 * Taxis have a unique ID, a location and sometimes a destination.
 * They are either free or occupied.
 * 
 * @author David J. Barnes 
 * @version 2010.12.03
 */
public class Taxi
{
    // A unique ID for this taxi.
    private String id;
    // The destination of this taxi.
    private String destination;
    // The location of this taxi.
    private String location;
    // Whether it is free or not.
    private boolean free;

    /**
     * Constructor for objects of class Taxi.
     * @param base The name of the company's base.
     * @param id This taxi's unique id.
     */
    public Taxi(String base, String id)
    {
        this.id = id;
        location = base;
        destination = null;
        free = true;
    }
    
    /**
     * Book this taxi to the given destination.
     * The status of the taxi will no longer be free.
     * @param destination The taxi's destination.
     */
    public void book(String destination)
    {
        setDestination(destination);
        free = false;
    }

    /**
     * Return the status of this taxi.
     * @return The status.
     */
    public String getStatus()
    {
        return id + " at " + location + " headed for " +
               destination;
    }
    
    /**
     * Return the ID of the taxi.
     * @return The ID of the taxi.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Return the location of the taxi.
     * @return The location of the taxi.
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * Return the destination of the taxi.
     * @return The destination of the taxi.
     */
    public String getDestination()
    {
        return destination;
    }
    
    /**
     * Set the intented destination of the taxi.
     * @param destination The intended destination.
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
    /**
     * Indicate that this taxi has arrived at its destination.
     * As a result, it will be free.
     */
    public void arrived()
    {
        location = destination;
        destination = null;
        free = true;
    }
}
