package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_239
   extends TilingType
{
   public TilingTypeNC5_239(){
      super( "NC5-239", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {2, 3,4, 0,4,3, 0},
            {0, 3,4, 1,0,4, 0},
            {1, 3,2, 2,4,0, 0},
            {1, 1,2, 3,2,1, 0},
            {0, 4,0, 4,3,2, 0},
      };
      info = "a=c=d=e\nA=90\nB=45\nC=225\nD=45\n(E=135)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = .7;
      double lnb = lna / Math.sqrt(2);
      double h = lna/2;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lna,  0);
      baseTile.setPoint(2,   h,  h);
      baseTile.setPoint(3,   h, h+lnb);
      baseTile.setPoint(4,   0, lnb);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[2].getX(3);
      offsets[1] = tiles[5].getY(2)-tiles[2].getY(3);
      offsets[2] = tiles[5].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(3)-tiles[0].getY(0);
   }
}
