package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_249
   extends TilingType
{
   public TilingTypeNC5_249(){
      super( "NC5-249", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 4,0, 0,0,1, 1},
            {1, 1,0, 1,0,1, 1},
            {1, 4,1, 2,1,4, 1},
            {0, 0,1, 3,1,0, 1},
            {2, 0,1, 4,4,0, 0},

            {2, 2,3, 0,3,4, 1},
            {0, 4,0, 6,0,1, 0},
            {1, 1,0, 7,0,1, 0},
            {1, 4,1, 8,1,4, 0},
            {0, 0,1, 9,1,0, 0},
            {2, 0,1,10,4,0, 1},
      };
      info = "a=d=3c\nb=6c\nc=e\nB=E\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = .3;
      double c = 1/3.;
      double s = Math.sqrt(1-c*c);
      c*=ln;
      s*=ln;
     
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, 6*ln, 0);
      baseTile.setPoint(2, 6*ln-c, s);
      baseTile.setPoint(3, 3*ln-c, s);
      baseTile.setPoint(4, 3*ln-2*c, s+s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[4].getX(4);
      offsets[1] = tiles[1].getY(3)-tiles[4].getY(4);
      offsets[2] = tiles[5].getX(3)-tiles[11].getX(2);
      offsets[3] = tiles[5].getY(3)-tiles[11].getY(2);
   }
}
