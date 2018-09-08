import java.util.*;

/**
 * A Taxi Company manages a fleet of taxis and shuttles.
 * Taxis move between single destinations.
 * Shuttles move around circular routes.
 * 
 * @author David J. Barnes 
 * @version 2010.12.03
 */
public class TaxiCo
{
    // The name of this company.
    private String companyName;
    // The name of the company's base.
    private final String base;    
    // The fleet of taxis.
    private ArrayList<Taxi> taxiFleet;
    // The fleet of shuttles.
    private ArrayList<Shuttle> shuttleFleet;
    // A value for allocating taxi ids.
    private int nextID;
    // A list of available destinations for shuttles.
    private ArrayList<String> destinations;

    /**
     * Constructor for objects of class TaxiCo.
     * @param name The name of this company.
     */
    public TaxiCo(String name)
    {
        companyName = name;
        base = "base";
        taxiFleet = new ArrayList<Taxi>();
        shuttleFleet = new ArrayList<Shuttle>();
        nextID = 1;
        destinations = new ArrayList<String>();
        fillDestinations();
    }
    
    /**
     * Record that we have a new taxi.
     * A unique ID will be allocated.
     */
    public void addTaxi()
    {
        Taxi taxi = new Taxi(base, "Car #" + nextID);
        taxiFleet.add(taxi);
        // Increment the ID for the next one.
        nextID++;
    }
    
    /**
     * Record that we have a new shuttle.
     * An arbitrary route is assigned to it.
     */
    public void addShuttle()
    {
        // Sanity warning:
        // The following is a thoroughly contrived way to create a route!
        
        // Create a random list of destinations for its route.
        Collections.shuffle(destinations);
        ArrayList<String> route = new ArrayList<String>();
        // The starting point is always the base.
        route.add(base);
        // Decide on an (arbitrary) length for all routes.
        final int ROUTE_LENGTH = 3;
        for(int i = 0; i < ROUTE_LENGTH; i++) {
            route.add(destinations.get(i));
        }
        
        Shuttle shuttle = new Shuttle("Shuttle #" + nextID, route);
        shuttleFleet.add(shuttle);
        // Increment the ID for the next one.
        nextID++;
    }
    
    /**
     * Return the taxi with the given id.
     * @param id The id of the taxi to be returned.
     * @return The matching taxi, or null if no match is found.
     */
    public Taxi lookup(String id)
    {
        boolean found = false;
        Taxi taxi = null;
        Iterator<Taxi> it = taxiFleet.iterator();
        while(!found && it.hasNext()) {
            taxi = it.next();
            if(id.equals(taxi.getID())) {
                found = true;
            }
        }
        if(found) {
            return taxi;
        }
        else {
            return null;
        }
    }

    /**
     * Show the status of the fleet of taxis and shuttles. 
     */
    public void showStatus()
    {
        System.out.println("Current status of the " + companyName + " fleet");
        for(Taxi taxi : taxiFleet) {
            System.out.println(taxi.getStatus());
        }
        for(Shuttle shuttle : shuttleFleet) {
            System.out.println(shuttle.getStatus());
        }
    }
    
    /**
     * Put all the possible shuttle destinations in a list.
     */
    private void fillDestinations()
    {
        destinations.add("Canterbury West");
        destinations.add("Canterbury East");
        destinations.add("The University");
        destinations.add("Whitstable");
        destinations.add("Herne Bay");
        destinations.add("Sainsbury's");
        destinations.add("Darwin");
    }
}
