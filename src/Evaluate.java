/**
 * Created by vparshkin on 03/07/2017.
 */
import java.lang.Math.*;

/**
 * This class is for finding proper dots
 *
 */
public class Evaluate {

    public  int res = 0;
    public  double current_angle;
    public  int quoter;
    public  Circle circle;
    public  Dot current_dot;
    public Evaluate (double radius){

        this.circle = new Circle(radius);
        this.current_dot = new Dot (radius,0);
        this.current_angle = 0;
        this.quoter = current_dot.quoter;
    }

    public void check(double width) {

        if (width > this.circle.radius)
            return;
        if (width == this.circle.radius) {

            res = 1;
            return;
        }
        res =2;
        double a = this.current_dot.x;
        double b = this.current_dot.y;
        double x =0, y =0;
        Dot  dot = new Dot ();
        if (a ==0 || b ==0 ) {
            if (a == 0) {
                y = (this.circle.radius * this.circle.radius - width * width + b * b) / (2 * b);
                x = Math.sqrt( this.circle.radius*this.circle.radius - y*y);

                dot.init(x,y);
                if (dot.angle < current_dot.angle)
                    dot.init(-x,y);
            }

            if (b == 0) {
                x = (this.circle.radius * this.circle.radius - width * width + a * a) / (2 * a);
                y = Math.sqrt( this.circle.radius*this.circle.radius - x*x);
                dot.init(x,y);
                if ((dot.angle < current_dot.angle && dot.quoter !=1) || (dot.quoter == 4 && current_angle == 0))
                    dot.init(x,-y);
            }

        }else {
            /**
             * This is the main calculation algorithm of my program. Here i program calculate proper coordinates of nex dot
             */

            double temp = (this.circle.radius * this.circle.radius + a * a + b * b - width * width) / (2 * a);
            double c = (b / a);
            double discriminant = Math.sqrt(Math.pow((2 * c * temp), 2) - 4 * (c*c + 1) * (temp * temp - this.circle.radius * this.circle.radius));
            y = (2 * c * temp + discriminant) / (2 * (c*c + 1));
            double y2 = (2 * c * temp - discriminant) / (2 * (c*c + 1));
            x = Math.sqrt( this.circle.radius*this.circle.radius - y*y);
            dot.init(check_dot(new Dot (x,y), width));
            if (dot.angle < current_dot.angle || Math.abs(dot.quoter - current_dot.quoter) >1)
                dot.init(check_dot(new Dot (x,y2), width));
            /*dot.x = x;
            dot.y = y;
            dot.setQuoter();
            dot.setAngle();*/
        }
        this.current_dot.init(dot);
        this.current_angle = this.current_dot.angle;
    }

    /**
     * This method is needed cos we x only > 0 because of sqrt. So we ought to change sign of x "manually"
     */
    public Dot check_dot (Dot dot, double width){


        double len = Math.pow(dot.x-current_dot.x,2) + Math.pow(dot.y-current_dot.y,2);
        if (Math.abs(Math.sqrt(len) - width) > width/10)
            dot.init(-dot.x,dot.y);
        return dot;





    }
}