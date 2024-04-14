public class Car extends Vehicle 
{
    public Car(String licPlate, companyName) 
    {
        slotsNeeded = 1; 
        siz = VSize.CarSize;
        this.licPlate = licPlate;
        this.companyName = companyName;
    }

    public boolean canFitlnSlot(ParkingSlot slot) 
    {
        return spot.getSize() = VSize.CarSize;
    }
}