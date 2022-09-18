package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bi
   extends TilingType
{
   public TilingTypeN5_01bi(){
      super( "N5-1bi", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,1,0, 0},
            {2, 1,0, 1,2,3, 0},
            {1, 4,3, 2,1,2, 0},
            {0, 0,1, 3,1,0, 0},
            {2, 1,0, 4,2,3, 0},

      };
      info = "a=c=e\nd=2a\nB=D\nC=E\nA+B=180\n(C+D+E=360)\n(B=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.18;
      double h = ln * Math.sqrt(3);

      baseTile.setPoint(0,    0, 0);
      baseTile.setPoint(1, 2*h, 0);
      baseTile.setPoint(2, 2*h-ln, h);
      baseTile.setPoint(3,  -ln, h+2*ln);
      baseTile.setPoint(4,  -ln, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(4)-tiles[2].getX(3);
      offsets[1] = tiles[5].getY(4)-tiles[2].getY(3);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(2);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(2);
   }
}
