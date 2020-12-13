
package queuproject;


public class non_deterministic {
    private double lamda;
    private double mue;
    private double L;
    private double Lq;
    private double W;
    private double Wq;
    private double P0;
    private double Pn;

    public non_deterministic(){}
    
    public non_deterministic(double lamda, double mue){
        this.lamda = lamda;
        this.mue = mue;
    }

    public double getWq() {
        return Wq;
    }


    public double getLamda() {
        return lamda;
    }

    public void setLamda(double lamda) {
        this.lamda = lamda;
    }

    public double getMue() {
        return mue;
    }

    public void setMue(double mue) {
        this.mue = mue;
    }

    public double getL() {
        return L;
    }
    
    public double getLq() {
        return Lq;
    }

    public double getW() {
        return W;
    }

    public double getP0() {
        return P0;
    }
    public double getPn() {
        return Pn;
    }
    void non_model1(int n)
    {
        double row=this.lamda/this.mue;
        this.P0=1.0-row;
        if(n>0){
        this.Pn=Math.pow(row, n)*(1-row);
        }
        this.W=1.0/(this.mue-this.lamda);
        this.L=this.lamda*this.W;
        this.Wq=(this.lamda)/(this.mue*(this.mue-this.lamda));
        this.Lq=this.lamda*this.Wq;
        
    }
}

    
