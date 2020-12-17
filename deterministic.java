/*
    This class deals with  deterministic queues and we have 1 model:
    1-  d / d / 1 / K-1
    
    and we calculate the following :
    1- n(t)
    2- wq(n)
    
*/
package queuproject;

public class deterministic { 
    /* input variables */
    private double lamda;
    private double mu;
    private int k;
    private int t;
    private short n;
  
    /* output variables */
    private int ti = 0;
    private int nt = 0;
    private int wqn = 0;

  /* constructors */      
  public  deterministic() {}
   
  /* constructor for d / d / 1 /k-1 */
   public deterministic (double lamda, double mu, int t)
   {
       this.lamda = lamda;
       this. mu = mu;
       this.t = t;
   }
      public deterministic (double lamda, double mu,short n)
   {
       this.lamda = lamda;
       this. mu = mu;
       this.n = n;
   }
   public deterministic (double lamda, double mu, int k, int t, short n)
   {
       this.lamda = lamda;
       this. mu = mu;
       k++;
       
       this.k = k;
       this. t = t;
       this.n = n;
   }
   /* setter and getter functions */
    public int getTi() {
        return ti;
    }

    public int getNt() {
        return nt;
    }

    public int getWqn() {
        return wqn;
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

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
      public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public short getN() {
        return n;
    }

    public void setN(short n) {
        this.n = n;
    }
    /* calc nt only */
    public void model_Nt(int M)
    {
        /* case 1 */
        if(lamda >= mu)
        {
            if(k==0)
            {
                nt = (int) (lamda * t) - (int)( (mu * t) - (mu / lamda));
                return;
            }

                ti = (int) (((k - ((mu) / (lamda))) / ((lamda) - (mu)))+ 0.1);
                
                min_ti(1, M);
                if((1 / lamda) > t)
                {
                    nt = 0;
                    
                }else if( ((1 / lamda) <= t) && (t <= ti))
                {
                    nt = (int) (lamda * t) - (int)( ((mu * t) - (mu / lamda))+0.1);
                  //  System.out.println("yes "+  ((mu * t)-(mu / lamda)));
                }else if(t > ti)
                {
                    nt = k-1;
                    // or nt = k-2;
                }
            
    }else 
         /* case 2 */
        {
            if(M == 0)
            {
                 nt = 0;
                 // or nt = 1
                 return;
            }
              if(k==0)
            {
                nt = M + (int)(lamda * t) - (int)( mu * t);
                return;
            }
                
                ti = (int) (M / (mu - lamda));
                min_ti(2, M);
                if(t < ti)
                {
                   nt = M + (int)(lamda * t) - (int)( mu * t);
                }else if(  t >= ti)
                {
                    nt = 0;
                    // or nt = 1;
                }else if( t <= (1 / lamda))
                        {
                            nt = M;
                        }
            }
        }
    /* calc wqn only */
  public void model_Wqn(int M)
    {
        /* case 1 */
        if(lamda >= mu)
        {
            if(k==0)
            {
                wqn = (int)((1 / mu) - (1 / lamda)) * (n-1);
                return;
            }
                
                ti = (int) (((k - (mu / lamda)) / (lamda - mu)));
                
                min_ti(1, M);
                if(n == 0 )
                {
                    wqn = 0;
                }
                else if((lamda * ti) > n)
                {
                    wqn = (int)((1 / mu) - (1 / lamda)) * (n-1);
                }else if( n >= (lamda * ti))
                {
                    wqn = (int)(((1 / mu) - (1 / lamda)) * ((lamda * ti)-2));
                }
            
    }else 
         /* case 2 */
        {
            if(M ==0 )
            {
                wqn = 0;
                return ;
            }
        
             if(k==0)
            {
                wqn = (int)(((M-1+n) * (1.0 / mu)) - (n * (1.0/ lamda)));
                return;
            }
                
              ti = (int) (M / (mu - lamda));
               
                min_ti(2, M);
                if(n == 0 )
                {
                    wqn = (int)((M -1) / (2.0 * mu) );
                }
                else if(n <= (lamda * ti))
                {
                    wqn = (int)(((M-1+n) * (1.0 / mu)) - (n * (1.0/ lamda)));
                }else if( n > (lamda * ti))
                {
                    wqn = 0;
                }
        }
    }
  /* calc the minimum ti */
void min_ti(int select, int M)
{
    
   
    if(select ==1 )
    {
        int x = ti;
    while(x>2)
    {
        x--;
        
        int y = (int) (lamda * x) - (int)((x - (1 /lamda))  / (1/mu));
                //(int)((mu * x) - (mu / lamda));
            
        if(y == k)
        {
            ti=x;
           
        }
        }
    }
      if(select == 2){
    int x=ti;
    while(x>2)
    {
        x--;
      
        int y = (int) ((mu * x) - (lamda * x ));
           
        if(y == M)
        {
            ti = x;
         
            
        }else{
            
        }
    }
}
}
}

    


