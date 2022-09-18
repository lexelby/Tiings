package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_37c
   extends TilingType
{
   public TilingTypeN3_37c(){
      super( "N3-37c", 6, SymmetryType.pgg );
      // params are angle/distance of the other two points relative to first one
      paramMin = new int[]{-100,  0,  0,  0};
      paramMax = new int[]{ 100,100,100,100};
      paramDef = new int[]{  10, 50, 20, 40};
      paramName = new String[]{ "Skew", "Aspect", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,4, 0,4,5, 0},
            {2, 0,3, 1,2,4, 1},
            {3, 5,4, 2,4,5, 1},
            {3, 1,0, 3,0,1, 1},
            {2, 5,4, 4,4,5, 1},
            {1, 0,3, 5,2,4, 0},
            {0, 5,4, 6,4,5, 0},

            {0, 0,3, 0,3,4, 1},
            {1, 5,4, 8,4,5, 1},
            {2, 0,3, 9,2,4, 0},
            {3, 5,4,10,4,5, 0},
            {3, 1,0,11,0,1, 0},
            {2, 5,4,12,4,5, 0},
            {1, 0,3,13,2,4, 1},
            {0, 5,4,14,4,5, 1},
      };
      info = "(A+B+C=180)";
      labels = new int[]{0,-1,-1,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*(1+paramValues[1])/102.;
      double ln2 = 2-ln1;
      double os = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);
      double os1 = ln1* getParam(paramValues,2)/100.;
      double os2 = ln1* getParam(paramValues,3)/100.;

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,     os1,  0);
      baseTile.setPoint(2,     os2,  0);
      baseTile.setPoint(3,   ln1/2,  0);
      baseTile.setPoint(4,     ln1,  0);
      baseTile.setPoint(5,ln1/2+os,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(3)-tiles[15].getX(0);
      offsets[1] = tiles[7].getY(3)-tiles[15].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(0);
   }
}
