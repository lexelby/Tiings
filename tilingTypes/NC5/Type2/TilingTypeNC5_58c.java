package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_58c
   extends TilingType
{
   public TilingTypeNC5_58c(){
      super( "NC5-58c", 5, SymmetryType.cm );

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
      info = "a=b=e=2d\nA=90*10/7\nB=90*5/7\nC=90\nD=90*18/7\n(E=90*2/7)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 1./3;
      double ln1 = 2./3;
      double d = 180/7.;
      double e = 180+d+d;
      double c = 180-d-d;
      
      double x4 = ln1 * Math.cos(c*DEG2RAD);
      double y4 = ln1 * Math.sin(c*DEG2RAD);
      double x3 = x4 + ln1 * Math.cos((c+d-180)*DEG2RAD);
      double y3 = y4 + ln1 * Math.sin((c+d-180)*DEG2RAD);
      double x2 = x3 + ln2 * Math.cos((c+d+e)*DEG2RAD);
      double y2 = y3 + ln2 * Math.sin((c+d+e)*DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln2*2, 0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(3);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(4);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(4);
   }
}
