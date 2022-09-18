package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_100
   extends TilingType
{
   public TilingTypeNC6_100(){
      super( "NC6-100", 6, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,0,5, 0},
            {2, 0,5, 1,4,5, 0},

            {0, 2,1, 1,0,1, 0},
            {1, 2,3, 3,0,5, 0},
            {2, 0,5, 4,4,5, 0},
      };
      info = "a=d=f\nb=c=e\nA=D\nB=90\nD+E=180\nF=90\n(A+C=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = .5;
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1,  ln,   0);
      baseTile.setPoint(2,  ln,  ln);
      baseTile.setPoint(3,3*ln,   0);
      baseTile.setPoint(4,3*ln,  ln);
      baseTile.setPoint(5,  ln,2*ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[5].getX(2);
      offsets[1] = tiles[2].getY(3)-tiles[5].getY(2);
      offsets[2] = tiles[0].getX(5)-tiles[2].getX(4);
      offsets[3] = tiles[0].getY(5)-tiles[2].getY(4);
   }
}