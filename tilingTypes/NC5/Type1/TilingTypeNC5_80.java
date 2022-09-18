package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_80
   extends TilingType
{
   public TilingTypeNC5_80(){
      super( "NC5-80", 5, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,4, 0,0,4, 1},
            {1, 0,1, 1,0,1, 0},
            {0, 0,4, 2,0,4, 1},
            {1, 0,1, 3,0,1, 0},
            {0, 0,4, 4,0,4, 1},
            {1, 0,1, 5,0,1, 0},
            {0, 0,4, 6,0,4, 1},
            {1, 0,1, 7,0,1, 0},
            {0, 0,4, 8,0,4, 1},
            {1, 0,1, 9,0,1, 0},
            {0, 0,4,10,0,4, 1},
      };
      info = "c=d=2e\nA=30\nB=60\nC=120\nE=90\n(D=240)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .06;
      double h = w * Math.sqrt(3);
     
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,16*w,  0);
      baseTile.setPoint(2,14*w,2*h);
      baseTile.setPoint(3,10*w,2*h);
      baseTile.setPoint(4, 9*w,3*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[0].getX(2);
      offsets[1] = tiles[4].getY(2)-tiles[0].getY(2);
      offsets[2] = tiles[8].getX(2)-tiles[0].getX(2);
      offsets[3] = tiles[8].getY(2)-tiles[0].getY(2);
   }
}
