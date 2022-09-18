package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_77b
   extends TilingType
{
   public TilingTypeN4_77b(){
      super( "N4-77b", 4, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 37, 60};
      paramName = new String[]{ "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {2, 1,2, 0,1,0, 0},
            {0, 3,2, 1,2,3, 1},
            {1, 0,3, 3,0,3, 0},
            {2, 1,2, 3,1,0, 1},

            {2, 3,2, 2,2,3, 0},
            {0, 1,0, 6,1,2, 0},
            {1, 0,3, 7,0,3, 1},
            {0, 3,2, 8,2,3, 1},
            {1, 0,3, 9,0,3, 0},
            {2, 1,2, 9,1,0, 1},
      };
      info = "b=c\nA=60\nB=120\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double w = lntotal * getParam(paramValues,0)/100;
      double h = lntotal - w;
      double ln2 = h * getParam(paramValues,1)/100;
      double ln1 = h - ln2;

      double x1 = w * Math.sqrt(3)/2;
      double y1 = w /2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x1, y1+ln2);
      baseTile.setPoint(3,  0, ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[11].getX(2)-tiles[5].getX(3);
      offsets[1] = tiles[11].getY(2)-tiles[5].getY(3);
      offsets[2] = tiles[0].getX(1)-tiles[1].getX(1);
      offsets[3] = tiles[0].getY(1)-tiles[1].getY(1);
   }
}
