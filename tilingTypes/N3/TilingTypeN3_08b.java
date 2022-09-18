package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_08b
   extends TilingType
{
   public TilingTypeN3_08b(){
      super( "N3-8b", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 0,3, 1,0,3, 0},
            {1, 0,1, 2,0,1, 1},

            {0, 2,3, 0,1,2, 1},
            {1, 0,1, 4,0,1, 0},
            {0, 0,3, 5,0,3, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "A=90\n(B+C=90)";
      labels = new int[]{0,1,-1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5 * paramValues[0]/100.;
      double w = 1.5-h;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,w/2,  h/2);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(1);
      offsets[2] = tiles[2].getX(1)-tiles[6].getX(2);
      offsets[3] = tiles[2].getY(1)-tiles[6].getY(2);
   }
}
