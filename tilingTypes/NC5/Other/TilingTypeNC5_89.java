package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_89
   extends TilingType
{
   public TilingTypeNC5_89(){
      super( "NC5-89", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,3,4, 0},
            {1, 4,0, 1,2,3, 1},
            {0, 3,4, 2,2,1, 1},

            {0, 4,0, 0,0,4, 0},
            {1, 2,1, 4,3,4, 0},
            {1, 4,0, 5,2,3, 1},
            {0, 3,4, 6,2,1, 1},
      };
      info = "b=c\na=d=e\nA=90\nB=90\nE=90\n(C=45)\n(D=225)";
   }
   
   public void recalcBase(double[] paramValues) {
      double w = 0.5;
      double v = w + w*Math.sqrt(2)/2;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  v,  0);
      baseTile.setPoint(2,  v,  v);
      baseTile.setPoint(3,  w,  w);
      baseTile.setPoint(4,  0,  w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[1].getX(1);
      offsets[1] = tiles[0].getY(1)-tiles[1].getY(1);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(4);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(4);
   }
}
