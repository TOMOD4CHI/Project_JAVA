package entity;

public class Finance {
    private double depense=0;
    private double revenue=0;

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getDepense() {
        return depense;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }
    @Override
    public String toString() {
        return "entity.Finance \n" +
                "Depense=" + depense + ", Revenue=" + revenue ;
    }
    public void factures(){
        return;
    }
}
