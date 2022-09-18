package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_06a
   extends TilingType
{
   public TilingTypeN4_06a(){
      super( "N4-6a", 4, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{240};
      paramDef = new int[]{150};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {1, 1,0, 0,2,3, 0},
            {1, 1,0, 1,2,3, 0},
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
      offsets[0] = tiles[0].getX(0)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(0)-tiles[1].getY(3);
      offsets[2] = tiles[2].getX(0)-tiles[3].getX(3);
      offsets[3] = tiles[2].getY(0)-tiles[3].getY(3);
   }
}
