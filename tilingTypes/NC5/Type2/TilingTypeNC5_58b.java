package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_58b
   extends TilingType
{
   public TilingTypeNC5_58b(){
      super( "NC5-58b", 5, SymmetryType.pg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {0, 1,0, 1,3,4, 1},
            {1, 1,2, 2,1,2, 0},
      };
      info = "a=d=e\nb=2d\nA=108\nB=54\nC=90\nD=252\n(E=36)";

   }

   public void recalcBase(double[] paramValues) {
      double s18 = (Math.sqrt(5)-1)/4;
      double c18 = Math.sqrt(1-s18*s18);
      double s36 = 2*c18*s18;
      double c36 = c18*c18-s18*s18;
      double s72 = 2*c36*s36;
      double c72 = c36*c36-s36*s36;
      
      double ln = .6;
      double lnAD = 2*ln * s18;
      double xC = (1 + c72)*ln;
      double yC =     s72*ln;
      double xD = lnAD * c36;
      double yD = lnAD * s36;
      double xE = -s18*ln;
      double yE =  c18*ln;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,2*ln,  0);
      baseTile.setPoint(2, xC, yC);
      baseTile.setPoint(3, xD, yD);
      baseTile.setPoint(4, xE, yE);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(3);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(4);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(4);
   }
}
