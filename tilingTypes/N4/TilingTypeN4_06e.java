package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_06e
   extends TilingType
{
   public TilingTypeN4_06e(){
      super( "N4-6e", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{240};
      paramDef = new int[]{150};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,0,3, 0},
            {2, 0,1, 1,0,1, 1},
            {2, 3,0, 2,0,3, 1},
            {1, 0,1, 3,0,1, 0},
            {0, 3,0, 4,0,3, 0},

            {0, 0,1, 1,2,3, 1},
            {1, 3,0, 6,0,3, 1},
            {2, 0,1, 7,0,1, 0},
            {2, 3,0, 8,0,3, 0},
            {1, 0,1, 9,0,1, 1},
            {0, 3,0,10,0,3, 1},
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
      offsets[0] = tiles[0].getX(1)-tiles[1].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[1].getY(2);
      offsets[2] = tiles[5].getX(1)-tiles[11].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[11].getY(0);
   }
}
