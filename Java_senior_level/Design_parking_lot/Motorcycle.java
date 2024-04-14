public class Motorcycle extends Vehicle 
{
        public Motorcycle(String licPlate, String companyName) 
        {
            slotsNeeded = 1; 
            siz = VSize.Motorcycle; 
            this.licPlate = licPlate; 
            this.companyName = companyName;
        }

        public boolean canFitlnSlot(ParkingSlot slot) 
        {
            return slot.getSize() == VSize.CarSize || slot.gteSize() == VSize.Motorcycle;
        }
}