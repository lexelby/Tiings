package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bl
   extends TilingType
{
   public TilingTypeN5_01bl(){
      super( "N5-1bl: type 1&8", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 1,2, 1,2,3, 1},
            {1, 3,2, 2,2,3, 1},
            {0, 2,3, 3,1,2, 0},
            {2, 1,2, 4,2,1, 0},

            {2, 0,4, 1,1,0, 1},
            {0, 2,1, 6,1,2, 1},
            {1, 1,2, 7,2,3, 0},
            {1, 3,2, 8,2,3, 0},
            {0, 2,3, 9,1,2, 1},
            {2, 1,2,10,2,1, 1},
      };
      info = "a=c=d=e\nB=D\nB=2A\nA+E=180\n(B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.6;
      double w = ln / 4;
      double h = w * Math.sqrt(15);
      double w2 = Math.sqrt(ln*ln - h*h/4);

      baseTile.setPoint(0,    0, 0);
      baseTile.setPoint(1, w+ln, 0);
      baseTile.setPoint(2, w+ln+w2, h/2);
      baseTile.setPoint(3, w+ln, h);
      baseTile.setPoint(4,    w, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[6].getX(2);
      offsets[1] = tiles[0].getY(0)-tiles[6].getY(2);
      offsets[2] = tiles[5].getX(0)-tiles[11].getX(2);
      offsets[3] = tiles[5].getY(0)-tiles[11].getY(2);
   }
}
