package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_85
   extends TilingType
{
   public TilingTypeNC5_85(){
      super( "NC5-85", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,4, 1},
            {0, 0,1, 1,4,3, 1},
            {1, 1,0, 2,0,4, 0},

            {0, 2,1, 0,1,2, 0},
            {1, 1,0, 4,0,4, 1},
            {0, 0,1, 5,4,3, 1},
            {1, 1,0, 6,0,4, 0},
      };
      info = "a=b=c\nd=e\nB=90\nC=90\nD=90\n(A=45)\n(E=225)";
   }
   
   public void recalcBase(double[] paramValues) {
      double w = 0.8;
      double v = w*Math.sqrt(2)/2;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w,  w);
      baseTile.setPoint(3,  v,  w);
      baseTile.setPoint(4,  v,  v);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[6].getX(2)-tiles[2].getX(1);
      offsets[3] = tiles[6].getY(2)-tiles[2].getY(1);
   }
}
