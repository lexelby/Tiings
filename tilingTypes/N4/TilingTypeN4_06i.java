package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_06i
   extends TilingType
{
   public TilingTypeN4_06i(){
      super( "N4-6i", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{240};
      paramDef = new int[]{150};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,0,3, 0},
            {2, 1,2, 0,2,3, 1},
            {2, 3,0, 2,0,3, 1},
            {0, 2,3, 3,1,2, 0},
            {1, 3,0, 4,0,3, 0},

            {0, 0,1, 3,3,2, 1},
            {1, 3,0, 6,0,3, 1},
            {2, 1,2, 6,2,3, 0},
            {2, 3,0, 8,0,3, 0},
            {0, 2,3, 9,1,2, 1},
            {1, 3,0,10,0,3, 1},

      };
      info = "b=c=d\n2B+C=360\n(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double c = paramValues[0];
      double d = (360-c)/2;

      double ln = .6;
      double dx = ln*Math.cos( d * DEG2RAD);
      double dy = ln*Math.sin( d * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2,ln-dx,dy);
      baseTile.setPoint(3, ln, dy*2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[5].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(1)-tiles[7].getX(0);
      offsets[3] = tiles[4].getY(1)-tiles[7].getY(0);
   }
}
