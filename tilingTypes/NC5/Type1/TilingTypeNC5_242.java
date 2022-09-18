package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_242
   extends TilingType
{
   public TilingTypeNC5_242(){
      super( "NC5-242", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {1, 2,1, 0,2,3, 0},
            {0, 1,0, 1,0,1, 0},
            {0, 2,0, 2,0,2, 0},
            {1, 0,1, 3,1,0, 0},
            {2, 2,3, 4,2,1, 0},

            {2, 3,2, 0,2,1, 1},
            {1, 2,1, 6,2,3, 1},
            {0, 1,0, 7,0,1, 1},
            {0, 2,0, 8,0,2, 1},
            {1, 0,1, 9,1,0, 1},
            {2, 2,3,10,2,1, 1},
      };
      info = "a=d=e=3c\nB=C\nA+E=180\nD+E=360\n(A+B+C=180)";
   }
   
   private double s,c;
   public void initialiseImpl(){
      s = 1/6.;
      c = Math.sqrt(1-s*s);
   }

   public void recalcBase(double[] paramValues) {
      double ln = .7;

      double x4 = ln * c;
      double y4 = ln * s;
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, 3*ln, 0);
      baseTile.setPoint(2, x4 + x4 + ln,  y4 + y4);
      baseTile.setPoint(3, x4 + ln,  y4);
      baseTile.setPoint(4, x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(2)-tiles[0].getX(3);
      offsets[1] = tiles[6].getY(2)-tiles[0].getY(3);
      offsets[2] = tiles[11].getX(2)-tiles[5].getX(3);
      offsets[3] = tiles[11].getY(2)-tiles[5].getY(3);
   }
}
