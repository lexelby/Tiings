package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_22a
   extends TilingType
{
   public TilingTypeNC6_22a(){
      super( "NC6-22a", 6, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{ 68};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,4,5, 0},
            {1, 5,4, 1,4,5, 0},
            {0, 4,5, 2,2,1, 0},
      };
      info = "b=c=f\na=d=e\nC=F\nB=D\nE+F=360\n(A+2B+C=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .8;
      double ln2 = ln1 * getParam(paramValues, 0)/100;

      double angcf = Functions.BisectionMethod(new Func(ln2/ln1), 40, 120, 0.001);

      double lenad = 2*calcSide(ln1/2,ln2,angcf);
      double lenbd = calcSide(ln1,ln2,angcf);
      double angb = calcAngle(ln1,lenbd,lenad) + calcAngle(lenbd,ln1,ln2);
      double angbdc = calcAngle(lenbd,ln2,ln1);
      double angadb = calcAngle(lenad,lenbd,ln1);
      double angeda = calcAngle(lenad/2,ln2,ln1/2);
      double angd = angbdc + angadb - angeda;
      
      double x2 = ln1 + ln1*Math.cos((180-angb)*DEG2RAD );
      double y2 =       ln1*Math.sin((180-angb)*DEG2RAD );
      double x3 =  x2 + ln2*Math.cos((-angb-angcf)*DEG2RAD );
      double y3 =  y2 + ln2*Math.sin((-angb-angcf)*DEG2RAD );
      double x4 =  x3 + ln2*Math.cos((-angb-angcf+180-angd)*DEG2RAD );
      double y4 =  y3 + ln2*Math.sin((-angb-angcf+180-angd)*DEG2RAD );
      double x5 =  x4 + ln1*Math.cos((-angb-angd)*DEG2RAD );
      double y5 =  y4 + ln1*Math.sin((-angb-angd)*DEG2RAD );
      
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(5);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(5);
   }
   private class Func implements IFunction{
      private double ln;
      Func(double ln0){ ln = ln0; }
      public double calculate(double angcf) {
         double lenad = 2*calcSide(.5,ln,angcf);
         double lenbd = calcSide(1,ln,angcf);
         double angb = calcAngle(1,lenbd,lenad) + calcAngle(lenbd,1,ln);
         double angbdc = calcAngle(lenbd,ln,1);
         double angadb = calcAngle(lenad,lenbd,1);
         double angeda = calcAngle(lenad/2,ln,.5);
         double angd = angbdc + angadb - angeda;
         return angb-angd;
      }
   }   
}