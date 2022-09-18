package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_30a
   extends TilingType
{
   public TilingTypeN4_30a(){
      super( "N4-30a", 4, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 55, 50};
      paramName = new String[]{ "Relative length", "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {0, 2,3, 0,2,3, 1},
            {2, 2,1, 2,1,2, 1},
            {2, 0,1, 0,0,1, 1},
            {0, 2,1, 4,1,2, 1},

            {0, 0,3, 3,0,3, 0},
            {2, 2,1, 6,1,2, 0},
            {2, 0,3, 5,0,3, 0},
            {0, 2,1, 8,1,2, 0},

            {1, 2,3, 6,2,3, 1},
            {1, 2,1,10,1,2, 1},
      };
      info = "A=60\nB=120\n(C+D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .35;
      double h = w*Math.sqrt(3);
      double f = 2*getParam(paramValues,0)/100;
      double g = 2-f;
    
      double d = 2*getParam(paramValues,1)/100;
      double e = 2-d;

      baseTile.setPoint(0,    0,    0);
      baseTile.setPoint(1,  h*f*d, -w*f*d);
      baseTile.setPoint(2,h*(e+g*d),w*(e-g*d));
      baseTile.setPoint(3,    h*e,    w*e);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[10].getX(0)-tiles[5].getX(0);
      offsets[1] = tiles[10].getY(0)-tiles[5].getY(0);
      offsets[2] = tiles[9].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[9].getY(0)-tiles[0].getY(0);
   }
}
