import java.util.ArrayList;

public abstract class Vehicle 
{
    protected ArrayList<ParkingSlot> parkingSlots = new Arr();

    protected String licPlate;

    protected int slotsNeeded;

    protected VSize siz; 

    protected String companyName;

    public int getSlotsNeeded() 
    {
        return slotsNeeded;
    }

    public void parkingSlot(ParkingSlot s) 
    {
        parkingSlots.add(s);
    }

    public VSize getSize() 
    {
        return siz;
    }

    public void clearSlots() 
    {
        for (int i = 0; i < parkingSlots.size(); i++) 
        {
            parkingSlots.get(i).removeVehicle();
        }
        parkingSlots.clear();
    }

    public abstract boolean canFitlnSlot(ParkingSlot spot);
}