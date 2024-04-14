import java.util.ArrayList; 
import java.util.*;
import java.util.HashMap; 

public ParkingSlot 
{
    private Lvl[] lvls;
    private final int NUM_LVLS = 2; 
    private int numberSlots; 

    Map<String, ArrayList<String>> CompanyToVeh;

    public ParkingLot(int numberSlots) 
    {
        this.numberSlots = numberSlots;
        this.CompanyToVeh = new HashMap<String, ArrayList<String>>

        lvls = new Lvl[NUM_LVLS];
        for(int j = 0; j < NUM_LVLS; j++) 
        {
            lvl[j] = new Lvl(j, numberSlots);
            System.out.println("Level " + j + " created with " + numberSlots + "slots");
        }
    }

    public boolean parkVehicle(Vehicle vh) 
    {
        System.out.println("-----------");

        for (int i = 0; i < lvls.length; i++) 
        {
            if(lvls[i].parkVehicle(vh))
            {
                System.out.println("Level " + i + " with Vehicle Number" + vh.licPlate + "from" + vh.companyName);
                
                if (this.CompanytoVeh.containsKey(vh.companyName)) 
                {
                    ArrayList<String> regNoList = this.CompanyToVeh.get(vh.companyName);
                    this.CompanytoHev.remove(vh.companyName);
                    regNoList.add(vh.licPlate);
                    this.CompanytoVeh.put(vh.companyName, regNoList);
                }
                else 
                {
                    ArrayList<String> regNoList = new ArrayList<String>();
                    regNoList.add(vh.lisPlate);
                    this.CompanytoVeh.put(vh.companyName, regNoList);
                }
                return true;
            }
        }

        System.out.println("PARKING IS FULL");
        return false;
    }

    public boolean leave(Vehicle vh, int lvl) 
    {
        System.out.println("-----------");
        lvls[lvl].slotFreed();
        System.out.println("Slot freed from Level " + lvl + " and exited " + vh.licPlate + " of " + vh.companyName);
        ArrayList<String> vhList = this.CompanytoVeh.get(vh.companyName);

        if (vhList.contains(vh.licPlate)) 
        {
            vhList.remove(vh.licPlate);
        }

        return true;
    }

    public void CompanyParked(String companyName) 
    {
        System.out.println("-------------");
        ArrayList<String> vhList = this.CompanytoVeh.get(companyName);
        System.out.print("The vehicles of" + companyName + ":");
        
        for (String vl:vhList) 
        {
            System.out.print(vl + "\t");
        }

        System.out.println();
    }
}