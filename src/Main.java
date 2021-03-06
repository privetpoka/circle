/**
 * Created by vparshkin on 02/07/2017.
 */
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int result = 0;
    public static HashMap<Dot, Dot> list = new HashMap<Dot, Dot>();
    public static  double angle = Math.PI/2;
    public static  int quoter, counter;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = -1;
        int width = -1;
        try {
            radius = scanner.nextDouble();
        }catch (InputMismatchException a) {
            System.out.print("You ought to input double radius");
        }
        System.out.println("Enter length of segment: ");
        try {
            width = scanner.nextInt();
        }catch (InputMismatchException a) {
            System.out.print("You ought to input integer length of segment");
        }
        if (radius+width !=-2){

            process(radius,width);
            System.out.println("result " + result);
        }

    }

    /**
     * This method i've implemented to run with cycles around Circle
     */
    public static void process (double radius, double width){
        counter = 0;
        Evaluate evaluate = new Evaluate(radius);
        //Dot tmp = new Dot ();

        while (true){
            //tmp.init(evaluate.current_dot);
            //list.put(tmp, new Dot ());
            quoter = evaluate.current_dot.quoter;
            evaluate.check(width);

            if (evaluate.res == 1 || evaluate.res == 0 ){
                result = evaluate.res;
                return;
            }
            if (quoter != evaluate.current_dot.quoter && quoter == 1){
                return;
            }
           // list.replace(tmp, evaluate.current_dot);
            quoter = evaluate.current_dot.quoter;
            evaluate.check(0.2*width);

            if (quoter != evaluate.current_dot.quoter && quoter == 1){
                return;
            }
            result+=1;
        }


    }







}
