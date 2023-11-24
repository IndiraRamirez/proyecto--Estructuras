package proyectoestructuras;

public class Promocion {
    private double cashback;
    private int kmGarantia;
    private int cantMantenimientosGratis;

    public Promocion(double cashback, int kmGarantia, int cantMantenimientosGratis) {
        this.cashback = cashback;
        this.kmGarantia = kmGarantia;
        this.cantMantenimientosGratis = cantMantenimientosGratis;
    }

    public double getCashback() {
        return cashback;
    }

    public void setCashback(double cashback) {
        this.cashback = cashback;
    }

    public int getKmGarantia() {
        return kmGarantia;
    }

    public void setKmGarantia(int kmGarantia) {
        this.kmGarantia = kmGarantia;
    }

    public int getCantMantenimientosGratis() {
        return cantMantenimientosGratis;
    }

    public void setCantMantenimientosGratis(int cantMantenimientosGratis) {
        this.cantMantenimientosGratis = cantMantenimientosGratis;
    }
}