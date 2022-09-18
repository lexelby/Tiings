package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01x
   extends TilingType
{
   public TilingTypeN5_01x(){
      super( "N5-1x", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 1,2, 2,2,3, 0},

            {0, 4,0, 0,3,4, 1},
            {1, 2,3, 4,1,2, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 1,2, 6,2,3, 1},
      };
      info = "e=2a\nc=d\nA=90\n2B+C=360\nC+D=180\n(B+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];
      double b = 180-a/2;
      
      double h = 2 * Math.sin(b*DEG2RAD);
      double f = 1/(1+h);
      double ln2 = 2 * (1-f);
      double ln3 = h*f;
      double ln4 = Math.sqrt(ln2*ln2-(h-ln3)*(h-ln3));
      double dx = Math.sqrt(1-h*h/4);
      // scale
      double s = 2 / (ln4+dx+h);
      ln4 *= s;
      ln3 *= s;
      dx *= s;
      h *= s;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln4,   0);
      baseTile.setPoint(2, ln4+dx, h/2);
      baseTile.setPoint(3, ln4,   h);
      baseTile.setPoint(4,   0,   ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[2].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[2].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(4);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(4);
   }
}
