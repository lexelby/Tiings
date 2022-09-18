package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_55c
   extends TilingType
{
   public TilingTypeNC5_55c(){
      super( "NC5-55c", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,4,3, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 4,0, 2,4,3, 0},
      };
      info = "a=d=e\nb=c+e\nA=90\nB=45\nC=90\nD=270\n(E=45)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double r2 = ln*Math.sqrt(2);

      baseTile.setPoint(0,    0, 0);
      baseTile.setPoint(1,ln+r2, 0);
      baseTile.setPoint(2,   r2, ln);
      baseTile.setPoint(3, r2/2, ln-r2/2);
      baseTile.setPoint(4,    0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(1);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(1);
   }
}
