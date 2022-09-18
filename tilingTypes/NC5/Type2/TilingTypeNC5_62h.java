package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_62h
   extends TilingType
{
   public TilingTypeNC5_62h(){
      super( "NC5-62h", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,1, 0,3,0, 0},
            {1, 1,0, 1,0,1, 0},
            {1, 3,2, 2,2,3, 0},
            {0, 0,1, 3,1,0, 0},
            {2, 3,0, 4,3,1, 0},

            {2, 2,3, 2,3,4, 1},
            {0, 3,1, 6,3,0, 1},
            {1, 1,0, 7,0,1, 1},
            {1, 3,2, 8,2,3, 1},
            {0, 0,1, 9,1,0, 1},
            {2, 3,0,10,3,1, 1},
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
      baseTile.setPoint(1, ln*(2*c36 + 2*c72),  0);
      baseTile.setPoint(2, ln*(2*c36 + c72), ln*s72);
      baseTile.setPoint(3, ln*(c36 + c72), ln*(s36 + s72));
      baseTile.setPoint(4, ln*c36, ln*s36);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[8].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[8].getY(4);
      offsets[2] = tiles[11].getX(1)-tiles[2].getX(1);
      offsets[3] = tiles[11].getY(1)-tiles[2].getY(1);
   }
}
