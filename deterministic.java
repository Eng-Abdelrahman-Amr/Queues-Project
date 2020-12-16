
package queuproject;

public class deterministic {
    
    int ti = 0;
    int nt = 0;
    int wq = 0;

  public  deterministic() {

    }

    void model1(double m, double la, int K, int T, int mm) {
        double mue = m;
        double lamda = la;
        int k = K;
        int t = T;
        int M = mm;

        if (lamda > mue) {
            System.out.println("lamda>mue");
            ti = (int) (((k - (mue / lamda)) / (mue + lamda)));
            if (t <= (1 / lamda)) {
                System.out.println("t<=1/lamda");
                nt = 0;
                wq = 0;
            } else if (t > (1 / lamda) && t < ti) {
                System.out.println("t>1/lamda");
                nt = (int) (t * lamda) - (int) ((t * mue) - (mue / lamda));
                wq = (int) (((1 / mue) - (1 / lamda)) * (nt - 1));

            } else if (t > ti) {
                System.out.println("t>ti");
                nt = k - 1;
                wq = (int) (((1 / mue) - (1 / lamda)) * ((lamda * ti) - 2));

            }

        } else if (mue > lamda) {
            System.out.println("mue>lamda");
            ti = (int) (M / (mue - lamda));
            if (t < ti) {
                System.out.println("(t<ti)");
                nt = M + (int) (lamda * t) - (int) (mue * t);
                wq = (int) ((M - 1 + nt) * (1 / mue) - nt * (1 / lamda));
            } else if (t >= ti) {
                System.out.println("t>=ti");
                nt = 0;
                wq = 0;
            }
        } else if (lamda == mue) {
            System.out.println("lama==mue");
            nt = M;
            wq = (int) ((M - 1) * (1 / mue));
        }
    }
}

    


