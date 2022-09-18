package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_26
   extends TilingType
{
   public TilingTypeP4_26(){
      super( "P4-26: Zipper pattern", 4, SymmetryType.cm);

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 60, 66};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,0, 1},
            };
      info = "b=c+d\nB+C=180\n2A+B=180\n(A+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double t = Math.tan( (90-paramValues[0])* DEG2RAD);
      double f = (paramValues[1]+1)/102./2;  // short diagonal side
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, 1-f, t*(1-f));
      baseTile.setPoint(2,   f,   (2-3*f)*t );
      baseTile.setPoint(3,   0, 2*(1-2*f)*t);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
