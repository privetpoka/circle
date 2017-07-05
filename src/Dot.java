/**
 * Created by vparshkin on 02/07/2017.
 */
import static java.lang.Math.*;

/**
 *  class of singke dot which is used to simplify calculation
 */
public class Dot {
    public double angle;
    public double x;
    public double y;
    public int quoter;
    public Dot (double x_, double y_){
        this.x=x_;
        this.y=y_;
        this.setQuoter();
        this.setAngle();
    }
    public Dot () {
        this.x = 0;
        this.y = 0;
    }
    public Dot (Dot dot){

        this.x = dot.x;
        this.y=dot.y;
        this.setQuoter();
        this.setAngle();
    }

    public void setQuoter (){

        if (this.x >=0) {
            if (this.y >=0)
                this.quoter = 1;
            else if (this.y < 0)
                this.quoter = 4;
        }
        else if (this.y >=0)
            this.quoter = 2;
        else this.quoter = 3;
    }

    public void setAngle() {

        double ang;
        ang = acos (abs(this.x)/sqrt((this.x * this.x) + (this.y * this.y)));
        switch (this.quoter) {
            case 1:
                this.angle = ang;
                break;
            case 2:
                this.angle = Math.PI - ang;
                break;
            case 3:
                this.angle = Math.PI + ang;
                break;
            case 4:
                this.angle = 2*Math.PI - ang;
                break;
            default:
                break;

        }

    }

    public void init (Dot dot){

        this.x = dot.x;
        this.y = dot.y;
        this.setQuoter();
        this.setAngle();
    }

    public void init (double x, double y){

        this.x = x;
        this.y = y;
        this.setQuoter();
        this.setAngle();
    }







}


