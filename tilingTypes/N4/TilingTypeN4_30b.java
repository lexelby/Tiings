package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_30b
   extends TilingType
{
   public TilingTypeN4_30b(){
      super( "N4-30b", 4, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 80, 67};
      paramName = new String[]{ "Relative length", "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {2, 0,1, 1,0,1, 1},
            {0, 3,2, 2,2,3, 1},
            {2, 0,1, 0,0,1, 1},
            {0, 3,2, 4,2,3, 1},

            {2, 1,2, 3,1,2, 0},
            {0, 3,2, 6,2,3, 0},
            {2, 0,3, 5,0,3, 0},
            {0, 3,2, 8,2,3, 0},

            {1, 0,1, 6,0,1, 1},
            {1, 3,2,10,2,3, 1},
      };
      info = "A=60\nB=120\n(C+D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double h = w*Math.sqrt(3);
      double f = getParam(paramValues,0)/100;
      double g = 1-f;
      double d = 2*getParam(paramValues,1)/100;
      double e = 2-d;
    
      baseTile.setPoint(0,    0,    0);
      baseTile.setPoint(1,  d*h, -d*w);
      baseTile.setPoint(2,h*(g*e+d),w*(g*e-d));
      baseTile.setPoint(3,  h*f*e,  w*f*e);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[11].getX(0)-tiles[5].getX(0);
      offsets[1] = tiles[11].getY(0)-tiles[5].getY(0);
      offsets[2] = tiles[9].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[9].getY(0)-tiles[0].getY(0);
   }
}
