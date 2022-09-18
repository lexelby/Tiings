package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_62e
   extends TilingType
{
   public TilingTypeNC5_62e(){
      super( "NC5-62e", 6, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,4, 0,0,4, 0},
            {0, 3,4, 1,0,5, 0},
            {1, 2,4, 2,0,4, 0},

            {0, 2,3, 3,1,2, 1},
            {1, 2,4, 4,0,4, 1},
            {0, 3,4, 5,0,5, 1},
            {1, 2,4, 6,0,4, 1},
      };
      info = "c=d=e=a\nA=36\nB=72\nC=144\nD=72\n(E=216)";
   }

   public void recalcBase(double[] paramValues) {
      double c36 = (Math.sqrt(5)+1)/4;
      double s36 = Math.sqrt(1-c36*c36);
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;

      double ln = .5;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln*(c36 + c72 - 0.5),  0);
      baseTile.setPoint(2, ln*(2*c36 + 2*c72),  0);
      baseTile.setPoint(3, ln*(2*c36 + c72), ln*s72);
      baseTile.setPoint(4, ln*(c36 + c72), ln*(s36 + s72));
      baseTile.setPoint(5, ln*c36, ln*s36);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[1].getX(1);
      offsets[1] = tiles[4].getY(0)-tiles[1].getY(1);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(2);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(2);
   }
}
