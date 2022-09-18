package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_14
   extends TilingType
   implements IFunction
{
   private double b;
   public TilingTypeN5_14(){
      super( "N5-14: Rolf Stein, 1985", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 1,2, 1,2,1, 1},
            {0, 0,1, 2,0,1, 0},

            {2, 4,3, 0,2,3, 0},
            {2, 1,0, 4,0,1, 0},
      };
      info = "2a=2c=d=e\nA=90\n2B+C=360\nC+E=180\n(2D+E=360)";
   }
   public void initialiseImpl(){
      b = Functions.BisectionMethod(this, 0, 90, 0.001);
   }   

   public void recalcBase(double[] paramValues) {
      double ln = .7;
      
      double x3 =         - ln*Math.cos( (90+b+b) * DEG2RAD);
      double y3 = ln/2+     ln*Math.sin( (90+b+b) * DEG2RAD);
      double x2 = x3 -      ln*Math.cos( (180+b) * DEG2RAD);
      double y2 = y3 +      ln*Math.sin( (180+b) * DEG2RAD);
      double x1 = x2 - .5 * ln*Math.cos( (-b) * DEG2RAD);
      double y1 = y2 + .5 * ln*Math.sin( (-b) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,  0, ln/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(4)-tiles[3].getY(3);
      offsets[2] = tiles[0].getX(4)-tiles[5].getX(3);
      offsets[3] = tiles[0].getY(4)-tiles[5].getY(3);
   }

   public double calculate(double b0){
      // get vertical offset
      double t = 1 + 2*Math.sin( (2*b0-270)*DEG2RAD ) - 3*Math.sin( (180-b0)*DEG2RAD );
      return t;
   }
}
