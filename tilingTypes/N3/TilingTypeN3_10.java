package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_10
   extends TilingType
{
   public TilingTypeN3_10(){
      super( "N3-10", 4, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 40};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {1, 0,3, 0,0,3, 1},
            {0, 3,2, 2,2,3, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 3,2, 4,2,3, 0},
            {1, 0,3, 4,0,3, 1},
            {0, 3,2, 6,2,3, 1},
      };
      info = "A=90\n(B+C=90)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5 * paramValues[0] / 100;
      double w = 1.5 - h;
      double os = getParam(paramValues, 1) / 100.;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,os*w,  0);
      baseTile.setPoint(2,  w,  0);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[2].getX(2);
      offsets[1] = tiles[0].getY(2)-tiles[2].getY(2);
      offsets[2] = (tiles[0].getX(3)-tiles[0].getX(0))*2;
      offsets[3] = (tiles[0].getY(3)-tiles[0].getY(0))*2;
   }
}
