package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01v
   extends TilingType
{
   public TilingTypeN5_01v(){
      super( "N5-1v", 5, SymmetryType.pgg );

      paramMin = new int[]{ 99};
      paramMax = new int[]{240};
      paramDef = new int[]{150};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,3,4, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 3,4, 2,3,2, 0},

            {0, 0,1, 2,0,1, 1},
            {1, 3,2, 4,3,4, 1},
            {1, 4,3, 5,3,4, 1},
            {0, 3,4, 6,3,2, 1},
      };
      info = "d=e=2a\nA=90\nB=90\nC=D\n(2D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double a = getParam(paramValues,0);
      double b = 180-a/2;
      double ln1 = .3;
      double ln2 =       2*ln1*(Math.cos((a-90)*DEG2RAD) + Math.cos((a+b-270)*DEG2RAD));
      double ln3 = ln1 + 2*ln1*(Math.sin((a-90)*DEG2RAD) + Math.sin((a+b-270)*DEG2RAD));

      double x3 =       2*ln1 * Math.cos( (a-90) * DEG2RAD);
      double y3 = ln1 + 2*ln1 * Math.sin( (a-90) * DEG2RAD);

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln2,   0);
      baseTile.setPoint(2, ln2, ln3);
      baseTile.setPoint(3,  x3,  y3);
      baseTile.setPoint(4,   0, ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[6].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(2);
   }
}
