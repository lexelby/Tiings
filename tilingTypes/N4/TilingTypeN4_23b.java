package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_23b
   extends TilingType
{
   public TilingTypeN4_23b(){
      super( "N4-23b", 4, SymmetryType.p6 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 3,2, 2,2,3, 0},

            {0, 1,2, 0,1,0, 0},
            {1, 3,2, 4,2,3, 0},
            {1, 1,0, 5,0,1, 0},
            {0, 3,2, 6,2,3, 0},

            {0, 1,2, 4,1,0, 0},
            {1, 3,2, 8,2,3, 0},
            {1, 1,0, 9,0,1, 0},
            {0, 3,2,10,2,3, 0},
      };
      info = "b=2a+2c\nA=60\nB=120\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .25;
      double h = w*Math.sqrt(3);
      double f = getParam(paramValues,0)/100.;
      double g = 1-f;
    
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,2*h, -2*w);
      baseTile.setPoint(2,2*h+f*h, f*w-2*w);
      baseTile.setPoint(3,g*h,g*w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[7].getX(1);
      offsets[1] = tiles[3].getY(1)-tiles[7].getY(1);
      offsets[2] = tiles[3].getX(1)-tiles[11].getX(1);
      offsets[3] = tiles[3].getY(1)-tiles[11].getY(1);
   }
}
