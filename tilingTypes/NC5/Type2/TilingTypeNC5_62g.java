package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_62g
   extends TilingType
{
   public TilingTypeNC5_62g(){
      super( "NC5-62g", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 10};
      paramName = new String[]{"Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 2,4, 1,0,4, 0},
            {1, 4,5, 2,5,4, 0},
            {0, 0,4, 3,2,4, 0},
            {2, 1,0, 4,0,1, 0},

            {2, 4,2, 0,0,4, 1},
            {0, 1,0, 6,0,1, 1},
            {1, 2,4, 7,0,4, 1},
            {1, 4,5, 8,5,4, 1},
            {0, 0,4, 9,2,4, 1},
            {2, 1,0,10,0,1, 1},
      };
      info = "c=d=e=a\nA=36\nB=72\nC=144\nD=72\n(E=216)";
      labels = new int[]{0,-1,1,2,3,4};
   }

   public void recalcBase(double[] paramValues) {
      double c36 = (Math.sqrt(5)+1)/4;
      double s36 = Math.sqrt(1-c36*c36);
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;

      double ln = .5;
      double lnb = ln*(2*c36 + 2*c72);
      double os = lnb * getParam(paramValues, 0)/100;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, os,  0);
      baseTile.setPoint(2, lnb,  0);
      baseTile.setPoint(3, ln*(2*c36 + c72), ln*s72);
      baseTile.setPoint(4, ln*(c36 + c72), ln*(s36 + s72));
      baseTile.setPoint(5, ln*c36, ln*s36);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(4)-tiles[5].getX(0);
      offsets[3] = tiles[11].getY(4)-tiles[5].getY(0);
   }
}
