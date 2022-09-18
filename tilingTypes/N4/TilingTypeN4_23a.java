package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_23a
   extends TilingType
{
   public TilingTypeN4_23a(){
      super( "N4-23a", 4, SymmetryType.p6 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {0, 1,2, 0,0,3, 0},
            {1, 3,2, 2,2,3, 0},

            {1, 1,2, 0,1,0, 0},
            {0, 3,2, 4,2,3, 0},
            {0, 1,2, 4,0,3, 0},
            {1, 3,2, 6,2,3, 0},

            {1, 1,2, 4,1,0, 0},
            {0, 3,2, 8,2,3, 0},
            {0, 1,2, 8,0,3, 0},
            {1, 3,2,10,2,3, 0},
      };
      info = "2b=a+c\nA=60\nB=120\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .25;
      double h = w*Math.sqrt(3);
      double f = 2*getParam(paramValues,0)/100.;
      double g = 2-f;
    
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  h, -w);
      baseTile.setPoint(2,h+f*h, f*w-w);
      baseTile.setPoint(3,g*h,g*w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[7].getX(1);
      offsets[1] = tiles[3].getY(1)-tiles[7].getY(1);
      offsets[2] = tiles[3].getX(1)-tiles[11].getX(1);
      offsets[3] = tiles[3].getY(1)-tiles[11].getY(1);
   }
}
