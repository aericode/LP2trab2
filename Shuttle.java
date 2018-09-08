import java.util.*;

/**
 * A shuttle.
 * Shuttles have a unique ID, a location and a list of destinations.
 * They operate a circular route.
 * 
 * @author David J. Barnes 
 * @version 2010.12.03
 */
public class Shuttle
{
    // A unique ID for this shuttle.
    private String id;
    // The next destination of this shuttle on its
    // circular route.
    private String destination;
    // The location of this shuttle.
    private String location;
    // The circular route of this shuttle.
    private ArrayList<String> route;
    // The destination number in route that the shuttle is
    // currently headed for.
    private int destinationNumber;

    /**
     * Constructor for objects of class Shuttle
     * @param id This shuttle's unique id.
     * @param route The route taken by this shuttle.
     *              The first entry is the starting location.
     */
    public Shuttle(String id, ArrayList<String> route)
    {
        this.id = id;
        setRoute(route);
    }
    
    /**
     * Return the status of this shuttle.
     * @return The status.
     */
    public String getStatus()
    {
        return id + " at " + location + " headed for " +
               destination;
    }
    
    /**
     * Return the ID of the shuttle.
     * @return The ID of the shuttle.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Return the location of the shuttle.
     * @return The location of the shuttle.
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * Return the destination of the shuttle.
     * @return The destination of the shuttle.
     */
    public String getDestination()
    {
        return destination;
    }
    
    /**
     * Indicate that this shuttle has arrived at its next destination.
     */
    public void arrived()
    {
        location = destination;
        setNextDestination();
    }
    
    /**
     * Set the next destination of the shuttle.
     */
    private void setNextDestination()
    {
        destinationNumber++;
        if(destinationNumber >= route.size()) {
            // End of the circular route.
            // Start from the beginning again.
            destinationNumber = 0;
        }
        setDestination(route.get(destinationNumber));
    }

    /**
     * Set the intented destination of the suttle.
     * @param destination The intended destination.
     */
    private void setDestination(String destination)
    {
        this.destination = destination;
    }
    
    /**
     * Set the route for this shuttle.
     * @param route The circular list of destinations.
     */
    private void setRoute(ArrayList<String> route)
    {
        // Make a copy of the list parameter.
        this.route = new ArrayList<String>();
        this.route.addAll(route);
        destinationNumber = 0;
        location = route.get(destinationNumber);
        setNextDestination();
    }

}
