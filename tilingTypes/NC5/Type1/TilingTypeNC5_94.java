package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_94
   extends TilingType
{
   public TilingTypeNC5_94(){
      super( "NC5-94", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,4,0, 0},
            {1, 0,4, 1,4,0, 0},
            {0, 4,0, 2,1,0, 0},

            {0, 4,3, 0,2,1, 1},
            {1, 1,0, 4,4,0, 1},
            {1, 0,4, 5,4,0, 1},
            {0, 4,0, 6,1,0, 1},
      };
      info = "b=e=2d\nc=d\nA=B\nC+D=360\nA+D=180\n(2A+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .4;
      final double c = (Math.sqrt(21)-3)/4;
      final double s = Math.sqrt(1-c*c);
      final double w1 = ln * 1.5;
      final double w2 = ln * 2;
      final double h = s/c * w1;
      
      baseTile.setPoint(0, 0,     0);
      baseTile.setPoint(1, w2,     0);
      baseTile.setPoint(2, w2-c*ln,   s*ln);
      baseTile.setPoint(3, w1+2*c*ln, h-2*s*ln);
      baseTile.setPoint(4, w1,     h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(2);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(2);
   }
}
