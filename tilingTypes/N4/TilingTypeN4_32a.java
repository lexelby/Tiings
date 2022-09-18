package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN4_32a
   extends TilingType
   implements IFunction
{
   private double c,d;
   public TilingTypeN4_32a(){
      super( "N4-32a", 4, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {2, 0,1, 1,0,1, 0},
            {0, 0,1, 2,1,2, 1},
            {1, 0,3, 3,0,3, 0},
            {2, 0,1, 4,0,1, 1},
            
            {0, 2,3, 5,2,3, 0},
            {1, 0,3, 6,0,3, 1},
            {2, 0,1, 7,0,1, 0},
            {0, 0,1, 8,1,2, 1},
            {1, 0,3, 9,0,3, 0},
            {2, 0,1,10,0,1, 1},
            
            };
      info = "a=b=c\n3A+2B=360\nC+3D=360\n(B+2C=360)";
   }
   public void initialiseImpl(){
      c = Functions.BisectionMethod(this, 80, 90, .001);
      d = (360-3*c)/2;
   }
   
   public double calculate(double c0) {
      double d0 = (360-3*c0)/2;
      double dx = 1 - Math.cos(d0*DEG2RAD) - Math.cos(c0*DEG2RAD);
      double dy = Math.sin(c0*DEG2RAD) - Math.sin(d0*DEG2RAD);
      double a = Math.atan2(dy,dx)/DEG2RAD +180-d0;
      return 2*a + d0 - 360;
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
      offsets[0] = tiles[0].getX(0)-tiles[5].getX(1);
      offsets[1] = tiles[0].getY(0)-tiles[5].getY(1);
      offsets[2] = tiles[8].getX(2)-tiles[3].getX(2);
      offsets[3] = tiles[8].getY(2)-tiles[3].getY(2);
   }

}
