public class ParkingSlot 
{
    private Vehicle vh; 
    private VSize siz;
    private int lane; 
    private int slotNumber; 
    private Lvl l;

    public ParkingSlot(Lvl lvl, int r, int num, VSize vs) 
    {
        l = lvl; 
        lane = r; 
        slotNumber = num;
        siz = vs;
    }

    public boolean isAvailable() 
    {
        return vh == null;
    }

    public boolean canFirVehicle(Vehicle vh) 
    {
        return isAvaialble() & vh.canFitlnSlot(this);
    } 

    public boolean park(Vehicle vObj) 
    {
        if(!canFirVehicle(vObj)) 
        {
            return false;
        }

        vh = vObj;
        vh.parklnSlot(this);
        return true;
    }

    public int getLane() 
    {
        return lane;
    }

    public int getSlotNumber() 
    {
        return slotNumber;
    }

    public VSize getSize() 
    {
        return siz;
    }

    public void removeVehicle() 
    {
        l.slotFreed();
        vh=null;
    }
}