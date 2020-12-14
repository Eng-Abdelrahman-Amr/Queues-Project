
package queuproject;


public class non_deterministic {
    private double lamda;
    private double mu;
    private short c;
    private int k;
    
    private double L;
    private double Lq;
    private double W;
    private double Wq;
    private double P0;
    private double Pn;

    public non_deterministic(){}
    
    public non_deterministic(double lamda, double mu){
        this.lamda = lamda;
        this.mu = mu;
        
    }
     public non_deterministic(double lamda, double mue, int k){
        this.lamda = lamda;
        this.mu = mue;
        this.k = k;
    }
       public non_deterministic(double lamda, double mue, short c){
        this.lamda = lamda;
        this.mu = mue;
        this.c = c;
        
    }
      public non_deterministic(double lamda, double mue, short c, int k){
        this.lamda = lamda;
        this.mu = mue;
        this.c = c;
        this.k = k;
    }
      public void setC(short c)
      {
          this.c=c;
      }
      public void setK(int k)
      {
          this.k=k;
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

    public double getMu() {
        return mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
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
    int fact(int n)
    {
        int f = 1;
        for(int i=1;i<=n;i++)
        {
            f*=i;
        }
        
        return f;
    }
    void non_model1(int n)
    {
        double row=this.lamda/this.mu;
        this.P0=1.0-row;
        if(n>0){
        this.Pn=Math.pow(row, n)*(1-row);
        }
        this.W=1.0/(this.mu-this.lamda);
        this.L=this.lamda*this.W;
        this.Wq=(this.lamda)/(this.mu*(this.mu-this.lamda));
        this.Lq=this.lamda*this.Wq;
        
    }
       
          void non_model2(int n)
    {
        double row=this.lamda/this.mu;
       
        this.P0=(1.0-row)/(1.0-Math.pow(row,this.k+1));
        if(n>0){
            if(row == 1)
            {
                this.Pn = 1/(1+k);
            }else{
                this.Pn=Math.pow(row,n)*((1.0-row)/(1.0-Math.pow(row,this.k+1)));
               
            }
        }
        if(row == 1)
        {
            this.L = k/2;
        }else{
            this.L = row*(((1-(k+1)*Math.pow(row,this.k))+this.k*(Math.pow(row,this.k+1)))
                    /((1-row)*(1-Math.pow(row, this.k+1))));
        }
        double Pk;
      
            if(row == 1)
            {
                Pk = 1/(1+k);
            }else{
                Pk=Math.pow(row,k)*((1.0-row)/(1.0-Math.pow(row,this.k+1)));
            }
            
        this.Lq = this.L - (row*(1.0-Pk));
        this.W = this.L / (this.lamda*(1.0-Pk));
        this.Wq = this.W - (1.0/this.mu);
    }
          
          void non_model3(int n)
    {
        
        double r = this.lamda / this.mu;
        double row = r / this.c;
       
        this.P0=0;
       if(row<1)
       {
           for(int i=0;i<c;i++)
           {
               double temp = Math.pow(r, i)/ fact(i);
               
               P0+=temp;
           }
           
           P0 = P0 + ((c *Math.pow(r,c)) / (fact(c) * (c-r)));
         
          
       }else
       {
            for(int i=0;i<c;i++)
           {
               double temp =  Math.pow(r,i) / fact(i) ;
               P0+=temp;
           }
            P0 = P0 + ((Math.pow(r,c) / fact(c))*(c*mu/((c*mu)-lamda)));
       }
        P0 = Math.pow(P0, -1);
         
        if(n>0){
          if(n>=0 && n<c)
          {
              Pn = ((Math.pow(lamda, n) )/ (fact(n) * Math.pow(mu, n))) * P0 ;
          }else{
               Pn = ((Math.pow(lamda, n) )/ (Math.pow(c,n-c)*fact(c)* Math.pow(mu, n))) * P0 ;
          }
        }
        
        Lq = ((Math.pow(lamda / mu,c) * lamda * mu) / (fact(c-1) * Math.pow((c*mu) - lamda,2))) * P0 ;       
        L = Lq + r;
        W = (Lq / lamda) + (1.0 / mu);
        Wq = Lq / lamda;
    }
           void non_model4(int n)
    {
        
        double r = lamda / mu;
        double row = r / c;
       
        P0=0;
       if(row != 1)
       {
           for(int i=0;i<c;i++)
           {
               double temp = Math.pow(r, i)/ fact(i);
               
               P0+=temp;
           }
           
           P0 = P0 + ((Math.pow(r, c) / fact(c)) * ((1.0 - Math.pow(row,k-c+1.0)) / (1.0-row)));
         
          
       }else
       {
            for(int i=0;i<c;i++)
           {
               double temp =  Math.pow(r,i) / fact(i) ;
               P0+=temp;
           }
            P0 = P0 + ((Math.pow(r, c) / fact(c)) * (k-c+1.0));
       }
        
        P0 = Math.pow(P0, -1);
      
        if(n>0){
          if(n>=0 && n<c)
          {
              Pn = (Math.pow(r, n) / fact(n)) * P0 ;
          }else{
               Pn = ((Math.pow(r, n)) / (Math.pow(c,n-c)*fact(c))) * P0 ;
          }
        }
        
        Lq = ( ((row * Math.pow(r, c) * P0) / (fact(c)*Math.pow((1-row),2))) *
                (1-Math.pow(row,k-c+1) - ((1.0 - row) * (k-c+1)* (Math.pow(row,k-c)))));
        double temp=0.0;
        for(int i=0;i<c;i++)
        {
            temp = temp + ((c-i) * (Math.pow(r, i) / fact(i)));
        }
        double Pk;
        
          if(n>=0 && n<c)
          {
              Pk = (Math.pow(r, k) / fact(k)) * P0 ;
          }else{
               Pk = ((Math.pow(r, k)) / (Math.pow(c,k-c)*fact(c))) * P0 ;
          }
          
        L = Lq + c - (P0 * temp);
        W = L / (lamda * (1.0-Pk));
        Wq = Lq / (lamda * (1.0-Pk));
    }
}

    
