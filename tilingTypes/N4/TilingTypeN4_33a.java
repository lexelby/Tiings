package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN4_33a
   extends TilingType
   implements IFunction
{
   private double c,d;
   public TilingTypeN4_33a(){
      super( "N4-33a", 4, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {2, 1,2, 0,0,1, 1},
            {0, 2,1, 0,1,2, 0},
            {1, 0,3, 3,0,3, 1},
            {2, 1,2, 3,0,1, 1},
            };
      info = "a=b=c\nB+C+3D=360\n3A+B=360\n(B+2C=360)";
   }
   public void initialiseImpl(){
      c = Functions.BisectionMethod(this, 80, 130, .001);
      d = 360-3*c;
   }   
   public double calculate(double c0) {
      double d0 = 360-3*c0;
      double dx = 1 - Math.cos(d0*DEG2RAD) - Math.cos(c0*DEG2RAD);
      double dy = Math.sin(c0*DEG2RAD) - Math.sin(d0*DEG2RAD);
      double a = Math.atan2(dy,dx)/DEG2RAD +180-d0;
      return 2*a - 3*c0;
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1;
      double x2 = ln - ln* Math.cos(d*DEG2RAD); 
      double y2 = ln* Math.sin(d*DEG2RAD); 
      double x3 = ln* Math.cos(c*DEG2RAD); 
      double y3 = ln* Math.sin(c*DEG2RAD); 

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1, ln, 0);
      baseTile.setPoint(2, x2,y2);
      baseTile.setPoint(3, x3,y3);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[1].getX(2);
      offsets[1] = tiles[4].getY(3)-tiles[1].getY(2);
      offsets[2] = tiles[5].getX(1)-tiles[2].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[2].getY(0);
   }

}
