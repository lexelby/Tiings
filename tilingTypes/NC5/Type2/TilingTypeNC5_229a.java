package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_229a
   extends TilingType
{
   public TilingTypeNC5_229a(){
      super( "NC5-229a", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,4, 0,2,3, 1},
            {1, 4,0, 1,2,3, 0},
            {2, 4,0, 2,2,3, 1},
            {0, 3,4, 3,2,3, 0},
            {1, 4,0, 4,2,3, 1},

            {2, 1,0, 4,0,1, 0},
            {0, 3,4, 6,2,3, 1},
            {1, 4,0, 7,2,3, 0},
            {2, 4,0, 8,2,3, 1},
            {0, 3,4, 9,2,3, 0},
            {1, 4,0,10,2,3, 1},
      };
      info = "b=c\na=d=e\nA=108\nB=36\nC=216\nD=36\n(E=144)";
   }

   public void recalcBase(double[] paramValues) {
      double c36 = (Math.sqrt(5)+1)/4;
      double s36 = Math.sqrt(1-c36*c36);
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;

      double ln1 = .5;
      double ln2 = s72*ln1/s36;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln2,  0);
      baseTile.setPoint(2, ln1*c72, ln1*s72);
      baseTile.setPoint(3, 0, ln1*2*s72);
      baseTile.setPoint(4, -ln1*c72, ln1*s72);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[9].getX(1);
      offsets[1] = tiles[1].getY(0)-tiles[9].getY(1);
      offsets[2] = tiles[5].getX(2)-tiles[0].getX(4);
      offsets[3] = tiles[5].getY(2)-tiles[0].getY(4);
   }
}
