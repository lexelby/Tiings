package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_99
   extends TilingType
{
   public TilingTypeNC6_99(){
      super( "NC6-99", 6, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {2, 5,4, 1,1,2, 0},
            {2, 5,0, 2,0,5, 0},
            {1, 1,2, 3,5,4, 0},
            {0, 1,2, 4,1,0, 0},

            {0, 3,4, 3,2,3, 1},
            {1, 1,0, 6,1,2, 1},
            {2, 5,4, 7,1,2, 1},
            {2, 5,0, 8,0,5, 1},
            {1, 1,2, 9,5,4, 1},
            {0, 1,2,10,1,0, 1},
      };
      info = "a=b=c=d=e=f\nA=150\nB=60\nC=210\nD=60\nE=150\n(F=90)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double w = ln/2;
      double h = w * Math.sqrt(3);
      baseTile.setPoint(0,  ln,   0);
      baseTile.setPoint(1,ln+h,   w);
      baseTile.setPoint(2,  ln,  ln);
      baseTile.setPoint(3,   w,ln+h);
      baseTile.setPoint(4,   0,  ln);
      baseTile.setPoint(5,   0,   0);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[9].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[9].getY(2);
      offsets[2] = tiles[0].getX(4)-tiles[5].getX(5);
      offsets[3] = tiles[0].getY(4)-tiles[5].getY(5);
   }
}