package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_229b
   extends TilingType
{
   public TilingTypeNC5_229b(){
      super( "NC5-229b", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 0,4, 0,2,3, 0},
            {1, 1,0, 1,1,2, 0},
            {2, 2,1, 0,1,2, 0},
            {0, 0,4, 3,2,3, 0},
            {1, 1,0, 4,1,2, 0},
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
      offsets[0] = tiles[2].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[2].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[2].getX(0)-tiles[4].getX(3);
      offsets[3] = tiles[2].getY(0)-tiles[4].getY(3);
   }
}
